package br.com.microservico.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservico.loja.dto.CompraDTO;
import br.com.microservico.loja.modelo.Compra;
import br.com.microservico.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Compra realizaCompra(@RequestBody CompraDTO compra) {		
		return compraService.realizaCompra(compra);
	}
	
	@RequestMapping("/{id}")
	public Compra getById(@PathVariable("id") Long id ) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return compraService.getById(id);
	}
}
