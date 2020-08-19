package br.com.microservice.transportador.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.transportador.dto.EntregaDTO;
import br.com.microservice.transportador.dto.VoucherDTO;
import br.com.microservice.transportador.service.EntregaService;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;
	
	private static final Logger LOG = LoggerFactory.getLogger(EntregaController.class);

	@RequestMapping(method = RequestMethod.POST)
	public VoucherDTO reservaEntrega(@RequestBody EntregaDTO pedidoDTO) {
		LOG.info("Gereando a Entrega: {}", pedidoDTO.getPedidoId());
		return entregaService.reservaEntrega(pedidoDTO);
	}
}
