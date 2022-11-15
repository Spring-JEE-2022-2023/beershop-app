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

	private static List<Beer> BEER_TABLE = new ArrayList<>();
	private Integer pk = 0;
	
	/**
	 * Sauvegarde d'une bière
	 * @param beer
	 */
	public void saveBeer(Beer beer) {
		//beer.setId(pk);
		BEER_TABLE.add(beer);
		//pk++;
	}
	
	/**
	 * Update d'une bière
	 * @param beer
	 */
	public void updateBeer(Beer beer) {
		BEER_TABLE.remove(beer);
		BEER_TABLE.add(beer);
		
	}
	
	/**
	 * Retourne toutes les bières
	 * @return
	 */
	public List<Beer> getAllBeers(){
		return BEER_TABLE;
	}

	/**
	 * Suppression d'une bière via son id
	 * @param id
	 */
	public void deleteBeer(Integer id) {
		
		Beer beerToDelete = getById(id);
		
		BEER_TABLE.remove(beerToDelete);
	}
	
	public Beer getById(Integer id) {
		
		Beer c = BEER_TABLE.stream().filter(b -> {
			return b.getId().equals(id);
		}).findFirst().get();
		
		return c;
	}
	
	
}
