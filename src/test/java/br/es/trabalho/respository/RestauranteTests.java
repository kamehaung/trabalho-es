package br.es.trabalho.respository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.es.trabalho.TrabalhoApplication;
import br.es.trabalho.model.Restaurante;
import br.es.trabalho.repository.RestauranteRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TrabalhoApplication.class)
public class RestauranteTests {

	@Autowired
	private RestauranteRepository repo;
	
	@Test
	public void testeCriaRestauranteBD() {
	
		Restaurante rest = new Restaurante();
		rest.setNome("Teste1");
		rest.setCnpj("123.253.125-12");
		Restaurante savedRestaurante = repo.save(rest);
		
		Restaurante foundRest = repo.findById(savedRestaurante.getId()).get();
		
		assertNotNull(foundRest);
		assertEquals(savedRestaurante.getId(), foundRest.getId());
		
	}
	
	@Test
	public void testeRetornaListRestauranteBD() {
		
//		Restaurante rest = new Restaurante();
//		rest.setNome("Teste1");
//		rest.setCnpj("123.253.125-01");
//				
//		System.out.println("\n\n\n" + rest.getNome() + " " + rest.getCnpj() + "\n\n\n");
//				
//		Restaurante rest2 = new Restaurante();
//		rest2.setNome("Teste2");
//		rest2.setCnpj("123.253.125-02");
//		
//		System.out.println("\n\n\n" + rest2.getNome() + " " + rest2.getCnpj() + "\n\n\n");
//		
//		List<Restaurante> saved = new ArrayList<Restaurante>();
//		saved.add(repo.save(rest));
//		saved.add(repo.save(rest2));
//				
		List<Restaurante> foundRestList = repo.findAll();
		
		assertNotNull(foundRestList);
//		for(int i = 0; i < saved.size(); i++) {
//			assertEquals(saved.get(0).getCnpj(), foundRestList.get(0).getCnpj());
//		}

	}
	
}
