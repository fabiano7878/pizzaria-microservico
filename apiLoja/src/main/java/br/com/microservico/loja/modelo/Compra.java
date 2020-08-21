package br.com.microservico.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private Long idPedido;
	
	private int tempoDePreparo;
	
	private String EnderecoDestino;
	
	private String itens;
	
	private int quantidadeDeProdutosNaCompra;
	
	private int totalDeItensNaCompra;
	
	@Enumerated(EnumType.STRING)
	private CompraStatus estatus;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public CompraStatus getEstatus() {
		return estatus;
	}

	public void setEstatus(CompraStatus estatus) {
		this.estatus = estatus;
	}

}
