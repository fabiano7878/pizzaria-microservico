package br.com.microservico.loja.dto;

import java.time.LocalDateTime;

public class InfoEntregaDTO {
	
	private Long pedidoId;
	
	private LocalDateTime dataParaEntrega;
	
	private String enderecoOrigem;
	
	private String enderecoDestino;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDateTime getDataParaEntrega() {
		return dataParaEntrega;
	}

	public void setDataParaEntrega(LocalDateTime dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}

	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}

	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}
	
	
}
