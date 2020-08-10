package br.com.microservico.fornecedor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservico.fornecedor.model.Produto;
import br.com.microservico.fornecedor.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	private static final Logger LOG = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/{estado}")
	public List<Produto> getProdutosPorEstado(@PathVariable("estado") String estado) {
		LOG.info("Buscando produtos por estado: {}", estado);
		return produtoService.getProdutosPorEstado(estado);
	}
}
