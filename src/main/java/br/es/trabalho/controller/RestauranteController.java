package br.es.trabalho.controller;

import org.springframework.stereotype.Controller;

import br.es.trabalho.model.Cardapio;
import br.es.trabalho.model.Restaurante;
import br.es.trabalho.repository.CardapioRepository;
import br.es.trabalho.repository.RestauranteRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RestauranteController {
	
	@Autowired //<-mesma coisa que o contrutor
	private RestauranteRepository restRepository;
	private CardapioRepository cardRepository;
	
	@GetMapping("/cadastrarRestaurante")
	public String form() {
		return "restaurante/formRestaurante";
	}
	
	@PostMapping("/cadastrarRestaurante")
	public String form(Restaurante res) {		
		restRepository.save(res);
		return "redirect:/cadastrarRestaurante";
	}
	
	@RequestMapping("/restaurantes")
	public ModelAndView listRestaurantes(){
		ModelAndView mv = new ModelAndView("index");
		Iterable<Restaurante> rest = restRepository.findAll();
		mv.addObject("restaurantes", rest);
		System.out.println("\n\nViewName " + mv.getViewName() + 
				"\ngetmodel" + mv.getModel() + "\n\n\n");
		return mv;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView detalhesEstabelecimento(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("restaurante/detalhesEstabelecimento");
		Optional<Restaurante> rest = restRepository.findById(id);
		mv.addObject("restaurante", rest.get());
		System.out.println("\n\nViewName " + mv.getViewName() + 
						"\ngetmodel" + mv.getModel() + "\n\n\n");
		
		Iterable<Cardapio> cardapio = cardRepository.findAll();
		mv.addObject("cardapios", cardapio);
		return mv;
	}
	
	@PostMapping("/{id}")
	public String detalhesEstabelecimentoPost(@PathVariable("id") Integer id, Cardapio card) {
		ModelAndView mv = new ModelAndView("restaurante/detalhesEstabelecimento");
		Optional<Restaurante> rest = restRepository.findById(id);
		card.setRest(rest.get());
		
		System.out.println("\n\n Cardapio dados: " + card.getId() +  " " + card.getTipo() + "\n\n\n");
		
		cardRepository.save(card);
		Iterable<Cardapio> cardapio = cardRepository.findAll();
		mv.addObject("cardapios", cardapio);
		
		System.out.println("\n\nViewName " + mv.getViewName() + 
				"\ngetmodel" + mv.getModel() + "\n\n\n");

		return "redirect:/{id}";
	}
	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//	public void deleteRestaurante(@PathVariable("id") Integer id) {
//		restService.deleteRestauranteById(id);
//	}
//	
//	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//	public void updateRestaurante(@RequestBody Restaurante rest, @PathVariable("id") Integer id) {
//		restService.updateRestauranteById(id, rest);
//	}
	
}

