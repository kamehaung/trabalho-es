//package br.es.trabalho.repository;
//
//import br.es.trabalho.model.Restaurante;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@SpringBootTest
//public class RestauranteRepositoryTests{
//
//	@Autowired
//	private RestauranteRepository restRepository;
//	
//	@Test
//	@GetMapping("/cadastrarRestaurante")
//	public String form() {
//		return "restaurante/formRestaurante";
//	}
//	
//	@Test
//	@PostMapping("/cadastrarRestaurante")
//	public String form(Restaurante res) {	
//		try {
//            restRepository.save(res);
//        } catch (DataAccessException ex) {
//            System.out.println(ex.getCause().getMessage());
//        }
//		return "redirect:/cadastrarRestaurante";
//	}
//	
//	@Test
//	@RequestMapping("/restaurantes")
//	public ModelAndView listRestaurantes(){
//		ModelAndView mv = new ModelAndView("index");
//		Iterable<Restaurante> rest = restRepository.findAll();
//		mv.addObject("restaurantes", rest);
//		return mv;
//	}
//	
//	@Test
//	@RequestMapping("/{id}")
//	public ModelAndView detalhesEstabelecimento(@PathVariable("id") Integer id) {
//		Optional<Restaurante> rest = restRepository.findById(id);
//		ModelAndView mv = new ModelAndView("restaurante/detalhesEstabelecimento");
//		mv.addObject("restaurante", rest);
//		System.out.println("restaurante" + rest.toString());
//		return mv;
//	}
//	
//	public void insertRestaurante() {
//		Restaurante r1 = new Restaurante(
//			"Test JUnit",
//			"123.456.789-10"
//		);
//		
//		if()
//		
//		restRepository.save(r1);
//		
//	}
//
//}
