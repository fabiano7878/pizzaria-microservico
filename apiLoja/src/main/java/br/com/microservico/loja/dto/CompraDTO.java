package br.com.microservico.loja.DTO;

import java.util.List;

public class CompraDTO {
	
	private List<ItensCompraDTO>itens;
	
	private EnderecoDTO endereco;

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
