package br.com.microservice.transportador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.transportador.model.Entrega;

@Repository
public interface EntregaRepository extends CrudRepository<Entrega, Long>{

}
