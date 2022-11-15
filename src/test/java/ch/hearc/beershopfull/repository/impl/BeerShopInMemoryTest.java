package ch.hearc.beershopfull.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.repository.BeerRepository;
import ch.hearc.beershopfull.catalog.repository.impl.BeerInMemoryRepository;

@SpringBootTest
public class BeerShopInMemoryTest {

	@Autowired
	BeerInMemoryRepository repository;
	
	@Test
	public void testSaveBeer() {
		
		clearDB ();
		
		Beer beer = new Beer();
		repository.saveBeer(beer);
		
		List<Beer> beers = repository.getAllBeers();
		
		assertEquals(beers.size(), 1, "One beer in the list");
		
	}
	
	@Test
	public void TestGetById() {
		clearDB ();
		
		Beer beer1 = new Beer();
		beer1.setId(1);
		beer1.setName("beer 1");
		repository.saveBeer(beer1);
		
		Beer beer2 = new Beer();
		beer2.setId(2);
		beer2.setName("beer 2");
		repository.saveBeer(beer2);
		
		List<Beer> beers = repository.getAllBeers();
		assertEquals(beers.size(), 2, "Two beer in the list");
		
		Beer beer1_toCheckBeer = repository.getById(1);
		assertEquals(beer1, beer1_toCheckBeer,"Beer1 present and equals");
		
		Beer beer2_toCheckBeer = repository.getById(2);
		assertEquals(beer2, beer2_toCheckBeer, "Beer2 present and equals");
		
	}
	
	@Test
	public void testUpdateBeer () {
		clearDB ();
		
		Beer beer1 = new Beer();
		beer1.setId(1);
		beer1.setName("beer 1");
		beer1.setStock(10);
		repository.saveBeer(beer1);
		
		List<Beer> beers = repository.getAllBeers();
		assertEquals(beers.size(), 1, "One beer in the list");
		
		Beer beer1_toUpdate = repository.getById(1);
		beer1_toUpdate.setName("beer 1 - updated");
		repository.updateBeer(beer1_toUpdate);
		
		beers = repository.getAllBeers();
		assertEquals(beers.size(), 1, "Always beer in the list");
		
		
		Beer beer1_updated = repository.getById(1);
		assertEquals(beer1.getStock(), beer1_updated.getStock(),"Stock muss be the same");
		assertEquals(beer1.getName(), "beer 1 - updated","Name muss to be the different");
		
		
		
	}
	
	@Test
	public void testDeleteBeer () {
		clearDB ();
		
		Beer beer1 = new Beer();
		beer1.setId(1);
		beer1.setName("beer 1");
		beer1.setStock(10);
		repository.saveBeer(beer1);
		
		List<Beer> beers = repository.getAllBeers();
		assertEquals(beers.size(), 1, "One beer in the list");
		
		
		repository.deleteBeer(beer1.getId());
		
		beers = repository.getAllBeers();
		assertEquals(beers.size(), 0, "Beer removed");
		
		
	}
	
	
	
	private void clearDB () {
		
		repository.getAllBeers().clear();
		
	}
	
	
	
}
