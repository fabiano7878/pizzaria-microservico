package br.com.microservico.fornecedor.controller;

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
	
	//private List<InfoFornecedor> listaForncedores;
	
	@RequestMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
		/* listaForncedores = ;
		InfoFornecedor forncedorPreferencial = new InfoFornecedor();
				
		for (InfoFornecedor infoFornecedor : listaForncedores) {
			if("Pizzaria Mestre Fabiann".equals(infoFornecedor.getNome()));
			forncedorPreferencial = infoFornecedor;
		} */
		
		return infoService.getInfoPorEstado(estado);
	}


	/*
	 * public List<InfoFornecedor> getListaForncedores() { return listaForncedores;
	 * }
	 * 
	 * public void setListaForncedores(List<InfoFornecedor> listaForncedores) {
	 * this.listaForncedores = listaForncedores; } }
	 */
}
