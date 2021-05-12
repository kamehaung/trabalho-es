package br.es.trabalho.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.es.trabalho.model.Cardapio;
import br.es.trabalho.model.Prato;
import br.es.trabalho.repository.CardapioRepository;
import br.es.trabalho.repository.PratoRepository;

public class PratoController {
	
	@Autowired
	private PratoRepository pratoRepository;
	
	@Autowired
	private CardapioRepository cardRepository;
	
	@PostMapping("/cardapio/{id}")
	public String detalhesCardapioPost(@PathVariable("id") Integer id, Prato prato) {
		Optional<Cardapio> card = cardRepository.findById(id);

		Prato novo = new Prato();
		novo.setNome(prato.getNome());
		novo.setPreco(prato.getPreco());
		novo.setCardapio(card.get());		
		
		System.out.println("\n\n Pratos dados: " + novo.getId() +  " " + novo.getNome() + " " + novo + " " + novo.getCardapio().getId() + " " + "\n\n\n");
		
		pratoRepository.save(novo);
		
		return "redirect:/cardapio/{id}";
	}
	
//	@GetMapping("/prato/deletar/{id}")
//	public String excluirPrato(@PathVariable("id") Integer id) {
//		Prato prato = pratoRepository.findById(id).get();		
//
//		System.out.println("\n\n Cardapio dados: " + prato.getPreco() +  " " + prato.getNome() + " " + "\n\n\n");				
////		pratoRepository.deleteById(id);
//		return "redirect:/restaurantes";
//	}
		
}