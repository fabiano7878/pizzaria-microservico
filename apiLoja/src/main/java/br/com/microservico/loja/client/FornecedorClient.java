package br.com.microservico.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.microservico.loja.dto.InfoFornecedorDTO;
import br.com.microservico.loja.dto.InfoPedidoDTO;
import br.com.microservico.loja.dto.ItensCompraDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@RequestMapping("/info/{estado}")
	List <InfoFornecedorDTO> getInfoPorEstado(@PathVariable String estado);
	
	@RequestMapping(method = RequestMethod.POST, value="/pedido")
	InfoPedidoDTO realizaPedido(List<ItensCompraDTO> itens);
}
