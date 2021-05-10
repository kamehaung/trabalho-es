package br.es.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.es.trabalho.model.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Integer>{
	
}
