package br.es.trabalho.controller;

import br.es.trabalho.model.Cardapio;
import br.es.trabalho.model.Prato;
import br.es.trabalho.model.Restaurante;
import br.es.trabalho.repository.RestauranteRepository;
import br.es.trabalho.repository.CardapioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CardapioController {

	@Autowired
	private RestauranteRepository restRepository;
	
	@Autowired
	private CardapioRepository cardRepository;
	
	
	@PostMapping("/{id}")
	public String detalhesEstabelecimentoPost(@PathVariable("id") Integer id, Cardapio card) {
		Optional<Restaurante> rest = restRepository.findById(id);
		
		Cardapio novo = new Cardapio();
		novo.setTipo(card.getTipo());
		novo.setRest(rest.get());
		
		System.out.println("\n\n Cardapio dados: " + novo.getId() +  " " + novo.getTipo() + " " + novo + " " + novo.getRest().getNome() + " " + "\n\n\n");
		
		cardRepository.save(novo);
		
		return "redirect:/{id}";
	}
	
	@GetMapping("/cardapio/{id}")
	public ModelAndView detalhesCardapio(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("restaurante/detalhesCardapio");
		Optional<Cardapio> card = cardRepository.findById(id);
		mv.addObject("cardapio", card.get());
		
		System.out.println("\n\nViewName " + mv.getViewName() + 
				"\ngetmodel" + mv.getModel() + "\n\n\n");
		
		List<Prato> pratos = card.get().getPratos();
		
		mv.addObject("pratos", pratos);
		
		System.out.println("\n\nViewName " + mv.getViewName() + 
					"\ngetmodel" + mv.getModel() + "\n\n\n");	
		return mv;
	}
	
//	@GetMapping("/cardapio/deletar/{id}")
//	public String excluirCardapio(@PathVariable("id") Integer id) {
//		Cardapio card = cardRepository.findById(id).get();		
//		int rest_id = card.getRest().getId();
//		cardRepository.deleteById(id);
//		return "redirect:/{" + rest_id + "}";
//	}
	
}
