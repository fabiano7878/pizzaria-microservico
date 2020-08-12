package br.com.microservico.loja.dto;

public class InfoPedidoItemDTO {
	
	private Long id;
	
	private Integer quantidade;
	
	private InfoItensProdutoPedidoDTO produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public InfoItensProdutoPedidoDTO getProduto() {
		return produto;
	}

	public void setProduto(InfoItensProdutoPedidoDTO produto) {
		this.produto = produto;
	}
}
