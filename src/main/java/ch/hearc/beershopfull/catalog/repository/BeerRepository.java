package ch.hearc.beershopfull.catalog.repository;

import java.util.List;

import ch.hearc.beershopfull.catalog.model.Beer;
/**
 * Interface de gestion des données des bières
 * @author seb
 *
 */
public interface BeerRepository {

	/**
	 * Sauvegarde d'une bière
	 * @param beer
	 */
	public void saveBeer(Beer beer);
	
	
	/**
	 * Retourne toutes les bières
	 * @return
	 */
	public List<Beer> getAllBeers();
}
