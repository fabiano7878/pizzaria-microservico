package br.com.microservico.loja.dto;

public class InfoFornecedorDTO {
	
	private Long id;
	
	private String nome;
	
	private String endereco;
	
	private String estado;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", estado=" + estado;
	}
	
}
