package br.com.microservico.fornecedor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservico.fornecedor.model.InfoFornecedor;

@Service
public class InfoService {
	
	@Autowired
	private InfoRepository infoRepository;
	
	private List <InfoFornecedor> listaFornecedores;
	
	public InfoFornecedor getInfoPorEstado(String estado) {
		listaFornecedores = new ArrayList<InfoFornecedor>();
		listaFornecedores.add(infoRepository.findByEstado(estado));
		InfoFornecedor fornecedorPrincipal = new InfoFornecedor();
		for (InfoFornecedor infoFornecedor : listaFornecedores) {
			if("Pizzaria Mestre Fabiann".equals(infoFornecedor.getNome())) {
				fornecedorPrincipal = infoFornecedor;
			}
		}
		return fornecedorPrincipal;
	}

	public List<InfoFornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<InfoFornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}
}
