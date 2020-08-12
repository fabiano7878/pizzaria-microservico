package br.com.microservico.loja.dto;

import java.util.List;

public class InfoPedidoDTO {
	
	private Long id;
	
	private Integer tempoDePreparo;
	
	private String status;
	
	public Long getId() {
		return id;
	}

	private List<InfoPedidoItemDTO> itens;
	
	public void setId(Long id) {
		this.id = id;
	}

	public int getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(int tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<InfoPedidoItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<InfoPedidoItemDTO> itens) {
		this.itens = itens;
	}
	
}
