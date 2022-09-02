package ch.hearc.beershopfull.catalog.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.repository.BeerRepository;

/**
 * Classe gérant l'accès aux données
 * @author Seb
 *
 */
@Repository
public class BeerInMemoryRepository implements BeerRepository{

	private static List<Beer> beerInMemoryDb = new ArrayList<>();
	private Integer pk = 0;
	
	/**
	 * Sauvegarde d'une bière
	 * @param beer
	 */
	public void saveBeer(Beer beer) {
		beer.setId(pk);
		beerInMemoryDb.add(beer);
		pk++;
	}
	
	/**
	 * Update d'une bière
	 * @param beer
	 */
	public void updateBeer(Beer beer) {
		beerInMemoryDb.remove(beer);
		beerInMemoryDb.add(beer);
		
	}
	
	/**
	 * Retourne toutes les bières
	 * @return
	 */
	public List<Beer> getAllBeers(){
		return beerInMemoryDb;
	}

	/**
	 * Suppression d'une bière via son id
	 * @param id
	 */
	public void deleteBeer(Integer id) {
		
		Beer beerToDelete = getById(id);
		
		beerInMemoryDb.remove(beerToDelete);
	}
	
	public Beer getById(Integer id) {
		
		Beer c = beerInMemoryDb.stream().filter(b -> {
			return b.getId().equals(id);
		}).findFirst().get();
		
		return c;
	}
	
	
}
