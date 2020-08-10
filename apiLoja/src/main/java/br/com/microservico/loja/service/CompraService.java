package br.com.microservico.loja.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservico.loja.client.FornecedorClient;
import br.com.microservico.loja.dto.CompraDTO;
import br.com.microservico.loja.dto.InfoFornecedorDTO;
import br.com.microservico.loja.dto.InfoPedidoDTO;
import br.com.microservico.loja.modelo.Compra;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	public Compra realizaCompra(CompraDTO compra) {
		
		LOG.info("Buscando informações do fornecedor do Estado: {}", compra.getEndereco().getEstado());
		List <InfoFornecedorDTO> listaInfo = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("Realizando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		Compra compraSalva =  new Compra();
		
		compraSalva.setIdPedido(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		for(InfoFornecedorDTO fornecedor :listaInfo) {			
			System.out.println(fornecedor.toString());			
		}
		
		LOG.info("Compra Salva id da compra: {}", compraSalva.getIdPedido());
		return compraSalva;
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
