package br.com.microservico.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Compra {
	
	@Id
	private Long idPedido;
	
	private int tempoDePreparo;
	
	private String EnderecoDestino;
	
	private String itens;
	
	private int quantidadeDeProdutosNaCompra;
	
	private int totalDeItensNaCompra;
	
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

	public String getItens() {
		return itens;
	}

	public void setItens(String itens) {
		this.itens = itens;
	}

	public int getQuantidadeDeProdutosNaCompra() {
		return quantidadeDeProdutosNaCompra;
	}

	public void setQuantidadeDeProdutosNaCompra(int quantidadeDeProdutosNaCompra) {
		this.quantidadeDeProdutosNaCompra = quantidadeDeProdutosNaCompra;
	}

	public int getTotalDeItensNaCompra() {
		return totalDeItensNaCompra;
	}

	public void setTotalDeItensNaCompra(int totalDeItensNaCompra) {
		this.totalDeItensNaCompra = totalDeItensNaCompra;
	}

}
