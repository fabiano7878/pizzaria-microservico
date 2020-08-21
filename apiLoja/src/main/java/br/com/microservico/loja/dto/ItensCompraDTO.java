package br.com.microservico.loja.dto;

public class ItensCompraDTO {
	
	private long id;
	
	private int quantidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "id=" + id + ", quantidade=" + quantidade+" ";
	}	
	
}
