package br.com.microservico.loja.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CompraDTO {
	
	@JsonIgnore
	private Long compraId;
	
	private List<ItensCompraDTO>itens;
	
	private EnderecoDTO endereco;


	public Long getCompraId() {
		return compraId;
	}

	public void setCompraId(Long compraId) {
		this.compraId = compraId;
	}

	public List<ItensCompraDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItensCompraDTO> itens) {
		this.itens = itens;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

}
