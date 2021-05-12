package br.es.trabalho.controller;

import org.springframework.stereotype.Controller;

import br.es.trabalho.model.Restaurante;
import br.es.trabalho.model.Cardapio;
import br.es.trabalho.repository.RestauranteRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RestauranteController {
	
	@Autowired //<-mesma coisa que o construtor
	private RestauranteRepository restRepository;
			
	@RequestMapping("/")
	public String index() {
		return "redirect:/restaurantes";
	}
	
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
	
	@GetMapping("/{id}")
	public ModelAndView detalhesEstabelecimento(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("restaurante/detalhesEstabelecimento");
		Optional<Restaurante> rest = restRepository.findById(id);
		mv.addObject("restaurante", rest.get());
		
		List<Cardapio> cardapio = rest.get().getCardapios();
		
		mv.addObject("cardapios", cardapio);
		
		System.out.println("\n\nViewName " + mv.getViewName() + 
					"\ngetmodel" + mv.getModel() + "\n\n\n");	
		return mv;
	}
		
//	@GetMapping("/restaurante/deletar/{id}")
//	public String excluirEstabelecimento(@PathVariable("id") Integer id) {
//		Restaurante rest = restRepository.findById(id).get();		
//		restRepository.deleteById(id);
//		return "redirect:/restaurantes";
//	}
//		
}

