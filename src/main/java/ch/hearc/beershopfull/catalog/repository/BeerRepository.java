package ch.hearc.beershopfull.catalog.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ch.hearc.beershopfull.catalog.model.Beer;

/**
 * Classe gérant l'accès aux données
 * @author Seb
 *
 */
@Repository
public class BeerRepository {

	private static List<Beer> beerInMemoryDb = new ArrayList<>();
	
	/**
	 * Sauvegarde d'une bière
	 * @param beer
	 */
	public void saveBeer(Beer beer) {
		beerInMemoryDb.add(beer);
	}
	
	/**
	 * Retourne toutes les bières
	 * @return
	 */
	public List<Beer> getAllBeers(){
		return beerInMemoryDb;
	}
	
	
}
