package br.com.microservico.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservico.fornecedor.dto.ItemDoPedidoDTO;
import br.com.microservico.fornecedor.model.Pedido;
import br.com.microservico.fornecedor.model.PedidoItem;
import br.com.microservico.fornecedor.model.Produto;
import br.com.microservico.fornecedor.repository.PedidoRepository;
import br.com.microservico.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {
		
		if(itens == null) {
			return null;
		}
		
		LOG.info("Criando e Salvando o pedido");
		List<PedidoItem> pedidoItens = toPedidoItem(itens);
		Pedido pedido = new Pedido(pedidoItens);
		pedido.setTempoDePreparo(calculoTempoPreparo(itens.size()));
		return pedidoRepository.save(pedido);
	}
	
	private Integer calculoTempoPreparo(int size) {
		if(size >= 1) {
			return size = (size * 30);
		}
			return size = 30;
	}

	public Pedido getPedidoPorId(Long id) {
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

	private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {
		
		List<Long> idsProdutos = itens
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);
		
		List<PedidoItem> pedidoItens = itens
			.stream()
			.map(item -> {
				Produto produto = produtosDoPedido
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				PedidoItem pedidoItem = new PedidoItem();
				pedidoItem.setProduto(produto);
				pedidoItem.setQuantidade(item.getQuantidade());
				return pedidoItem;
			})
			.collect(Collectors.toList());
		return pedidoItens;
	}
}
