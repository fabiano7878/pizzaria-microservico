package br.com.microservice.transportador.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long pedidoId;
	
	private LocalDateTime dataParaBusca;
	
	private LocalDateTime previsaoParaEntrega;
	
	private String enderecoOrigem;
	
	private String enderecoDestino;

	public LocalDateTime getDataParaBusca() {
		return dataParaBusca;
	}

	public void setDataParaBusca(LocalDateTime dataParaBusca) {
		this.dataParaBusca = dataParaBusca;
	}

	public LocalDateTime getPrevisaoParaEntrega() {
		return previsaoParaEntrega;
	}

	public void setPrevisaoParaEntrega(LocalDateTime previsaoParaEntrega) {
		this.previsaoParaEntrega = previsaoParaEntrega;
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

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
