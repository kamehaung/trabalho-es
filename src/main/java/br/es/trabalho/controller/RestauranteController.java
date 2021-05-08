package br.es.trabalho.controller;

import br.es.trabalho.model.Restaurante;
import br.es.trabalho.repository.RestauranteRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
	
	private final RestauranteRepository restRepository;

	public RestauranteController(RestauranteRepository restRepository){
		this.restRepository = restRepository;
	}
	
	public List<Restaurante> findall(){
		var rest = restRepository.findAll();
		return null;
	}
	
}

