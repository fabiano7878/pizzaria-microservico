package br.com.microservico.loja.service;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservico.loja.client.FornecedorClient;
import br.com.microservico.loja.client.TransportadorClient;
import br.com.microservico.loja.dto.CompraDTO;
import br.com.microservico.loja.dto.InfoEntregaDTO;
import br.com.microservico.loja.dto.InfoFornecedorDTO;
import br.com.microservico.loja.dto.InfoPedidoDTO;
import br.com.microservico.loja.dto.InfoPedidoItemDTO;
import br.com.microservico.loja.dto.InfoVoucherDTO;
import br.com.microservico.loja.modelo.Compra;
import br.com.microservico.loja.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private TransportadorClient transportadorClient; 
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@HystrixCommand(fallbackMethod = "realizaCompraFallBack", threadPoolKey = "realizaCompraThreadPòol")
	public Compra realizaCompra(CompraDTO compra) {
		
		//Para entendimento e testes do circuit break e usando mertodo para o Fallback com o Hystrix
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // 
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		LOG.info("Buscando informações do fornecedor do Estado: {}", compra.getEndereco().getEstado());
		InfoFornecedorDTO infoFornecedor = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("Compra, criando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
				
		Compra compraSalva = new Compra();
		compraSalva.setIdPedido(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		compraSalva.setItens(compra.getItens().stream().map(Object::toString).reduce("", String::concat));
		compraSalva.setQuantidadeDeProdutosNaCompra(compra.getItens().size());
		compraSalva.setTotalDeItensNaCompra(pedido.getItens().stream().mapToInt(InfoPedidoItemDTO::getQuantidade).sum());
				
		LOG.info("Compra Salva id da compra: {}", compraSalva.getIdPedido());
		
		LOG.info("Compra, inicializando dados da Entrega");
		
		InfoEntregaDTO encomenda = new InfoEntregaDTO();
		encomenda.setPedidoId(pedido.getId());
		encomenda.setEnderecoOrigem(infoFornecedor.getEndereco());
		encomenda.setEnderecoDestino(compra.getEndereco().toString());		
		encomenda.setDataParaEntrega(converterDataDeEntrega(pedido.getTempoDePreparo()));
		
		//buildByMinutes(10);
		
		InfoVoucherDTO voucherDTO =  transportadorClient.reservaEntrega(encomenda);
		
		LOG.info("Voucher gerado numero: {}", voucherDTO.getNumero());
		
		//Salvando a compra na base de dados
		compraRepository.save(compraSalva);
		return compraSalva;
	}

	private LocalDateTime converterDataDeEntrega(int tempoDePreparo) {
		
		LocalDateTime minutos;
		LocalDateTime novoMinuto;
		minutos = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		
		//Adiciona minutos a hora corrente
		novoMinuto = minutos.plusMinutes(tempoDePreparo);		
		return novoMinuto;
	}

	/**
	 * Para consultar compras cadastradas, pelo id do pedido
	 * @param id
	 * @return
	 */
	@HystrixCommand(threadPoolKey = "getByIdThreadPool")
	public Compra getById(Long id) {
		return compraRepository.findById(id).orElse(new Compra());
	}
	
	/**
	 * 
	 * Para entendimento e testes do circuit break e usando mertodo para o Fallback com o Hystrix
	 * 
	 */
	public Compra realizaCompraFallBack(CompraDTO compra) {
		
		LOG.info("Estamos armazenando sua compra e faremos o processo de conclusão após nossas dificuldades tecnicas!");
		
		Compra compraSalvaFallBack =  new Compra();		
		compraSalvaFallBack.setEnderecoDestino(compra.getEndereco().toString());
		
		LOG.info("Compra guardada com sucesso, em breve informaremos o resumo da compra!");
		return compraSalvaFallBack;
	}
	
	
	/**
	 * Estas 2 instancias são utilizadas somente no metodo comentado abaixo
	 * caso pretenda utilizad-lo, precisa usar elas também.
	 * 
	 * @Autowired private RestTemplate client;
	 * @Autowired private DiscoveryClient eurekaClient;
	 *
	 *
	 * Este metodo é uma forma de estudo, mas utilizando o Feign do netflix, que já
	 * usa o Ribbon A implementação da chamada a outro microserviço via rest fica
	 * muito mais simples o Feign e usaremos a implementação do RestTemplate através
	 * do Feign implicidamente.
	 */
	/**
	 public void realizaCompra(CompraDTO compra) {
	 
	 	 ResponseEntity<InfoFornecedorDTO> exchange =
	 	 client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(),
	 	 HttpMethod.GET, null, InfoFornecedorDTO.class);
	  
	 
		 * Aqui para entendermos como Ribbon funciona, fazendo o trabalho do client-side
		 * load balancer ele consegue identificar quantas instacias e portas estão
		 * trabalhando e faz um controle para que a proxima requisição acesse uma
		 * instancia disponivel, neste caso criei em duplicidade uma instancia do meu
		 * microserviço de fornecedor e coloquei pra rodar na porta 8082, consegui ver
		 * que ele consegue mostrar todas as instancia que estão em execução.	 
		 
		 eurekaClient.getInstances("fornecedor").stream().forEach(fornecedor ->
		  {System.out.println("localhost:"+fornecedor.getPort());});
	  
	 	 * Mostramos o endereço do fornecedor disponivel na região atrvés da consulta ao
	 	 * microserviço de fornecedor 
	  	 
	  	  System.out.println(exchange.getBody().getEndereco()); }
	 */
	
	

}
