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
	 * Update d'une bière
	 * @param beer
	 */
	public void updateBeer(Beer beer);

	
	/**
	 * Retourne toutes les bières
	 * @return
	 */
	public List<Beer> getAllBeers();

	/**
	 * Suppression d'une bière via son id
	 * @param id
	 */
	public void deleteBeer(Integer id);
	
	public Beer getById(Integer id);
	
	
	

}
