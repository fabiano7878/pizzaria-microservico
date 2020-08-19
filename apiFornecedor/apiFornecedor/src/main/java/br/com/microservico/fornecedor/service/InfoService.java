package br.com.microservico.fornecedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservico.fornecedor.model.InfoFornecedor;
import br.com.microservico.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;

	public InfoFornecedor getInfoPorEstado(String estado) {

		List<InfoFornecedor> listaFornecedores = infoRepository.findByEstado(estado);

		return melhorFornecedor(listaFornecedores);
	}

	private InfoFornecedor melhorFornecedor(List<InfoFornecedor> listaFornecedores) {
		InfoFornecedor fornecedor = new InfoFornecedor();

		for (InfoFornecedor f : listaFornecedores) {
			// Chama algum metodo que verifica qual o melhor fornecedor
			switch (f.getEstado()) {
			case "SP":
				if ("Pizzaria Mestre Fabiann".equals(f.getNome())) {
					fornecedor = f;
					System.out.println(f.toString());
				}
				break;
			case "RJ":
				if ("Pizzaria Constantine".equals(f.getNome())) {
					fornecedor = f;
					System.out.println(f.toString());
				}
				break;
			default:
				if ("Pizzaria Pappito Mio".equals(f.getNome())) {
					fornecedor = f;
					System.out.println(f.toString());
				}
				break;
			}
		}
		return fornecedor;
	}

}
