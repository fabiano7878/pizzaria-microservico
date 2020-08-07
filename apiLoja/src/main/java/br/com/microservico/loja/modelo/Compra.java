package br.com.microservico.loja.modelo;

public class Compra {
	
	private Long idPedido;
	
	private int tempoDePreparo;
	
	private String EnderecoDestino;
	
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public int getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(int tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getEnderecoDestino() {
		return EnderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		EnderecoDestino = enderecoDestino;
	}

}
