package br.com.microservico.fornecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservico.fornecedor.model.InfoFornecedor;
import br.com.microservico.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	private InfoService infoService;
	
	@RequestMapping("/{estado}")
	public List <InfoFornecedor> getInfoPorEstado(@PathVariable("estado") String estado) {
		
		return infoService.getInfoPorEstado(estado);
	}
}
