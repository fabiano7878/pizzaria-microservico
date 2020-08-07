package br.com.microservico.loja.dto;

public class InfoPedidoDTO {
	
	private Long id;
	
	private int tempoDePreparo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(int tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

}
