package br.es.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.es.trabalho.model.Prato;

public interface PratoRepository extends JpaRepository<Prato, Integer>{
	
}
