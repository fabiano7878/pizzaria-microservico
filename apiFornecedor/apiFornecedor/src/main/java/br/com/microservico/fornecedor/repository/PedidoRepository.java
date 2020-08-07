package br.com.microservico.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.microservico.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
