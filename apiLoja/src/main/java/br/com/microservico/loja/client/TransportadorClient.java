package br.com.microservico.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.microservico.loja.dto.InfoEntregaDTO;
import br.com.microservico.loja.dto.InfoVoucherDTO;


@FeignClient("transportador")
public interface TransportadorClient {

	@RequestMapping(method = RequestMethod.POST, value="/entrega")
	InfoVoucherDTO reservaEntrega(@RequestBody InfoEntregaDTO pedidoDTO);
}
