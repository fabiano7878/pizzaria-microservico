package br.com.microservice.transportador.dto;

import java.time.LocalDateTime;

public class VoucherDTO {

	private Long numero;
	
	private LocalDateTime previsaoParaEntrega;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDateTime getPrevisaoParaEntrega() {
		return previsaoParaEntrega;
	}

	public void setPrevisaoParaEntrega(LocalDateTime previsaoParaEntrega) {
		this.previsaoParaEntrega = previsaoParaEntrega;
	}
}
