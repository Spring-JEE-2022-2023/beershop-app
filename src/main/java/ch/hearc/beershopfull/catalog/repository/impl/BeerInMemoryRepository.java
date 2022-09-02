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
	
	/**
	 * Sauvegarde d'une bière
	 * @param beer
	 */
	public void saveBeer(Beer beer) {
		BEER_TABLE.add(beer);
	}
	
	/**
	 * Retourne toutes les bières
	 * @return
	 */
	public List<Beer> getAllBeers(){
		return BEER_TABLE;
	}
	
	
}
