package br.com.microservice.transportador.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.transportador.dto.EntregaDTO;
import br.com.microservice.transportador.dto.VoucherDTO;
import br.com.microservice.transportador.model.Entrega;
import br.com.microservice.transportador.repository.EntregaRepository;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository repository;
	
	private static final Logger LOG = LoggerFactory.getLogger(EntregaService.class);

	
	public VoucherDTO reservaEntrega(EntregaDTO pedidoDTO) {
		
		LOG.info("Iniciando a geração da Encomenda e voucher ");
		
		Entrega entrega = new Entrega();
		entrega.setDataParaBusca(pedidoDTO.getDataParaEntrega());
		entrega.setPrevisaoParaEntrega(pedidoDTO.getDataParaEntrega());
		entrega.setEnderecoDestino(pedidoDTO.getEnderecoDestino());
		entrega.setEnderecoOrigem(pedidoDTO.getEnderecoOrigem());
		entrega.setPedidoId(pedidoDTO.getPedidoId());
		
		repository.save(entrega);
		
		VoucherDTO voucher = new VoucherDTO();
		voucher.setNumero(entrega.getId());
		voucher.setPrevisaoParaEntrega(entrega.getPrevisaoParaEntrega());
		
		LOG.info("Pedido {}, Voucher gerado! {}", pedidoDTO.getPedidoId(), voucher.getNumero());
		return voucher;
	}

}
