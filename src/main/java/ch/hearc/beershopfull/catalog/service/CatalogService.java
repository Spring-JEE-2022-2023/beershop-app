package ch.hearc.beershopfull.catalog.service;

import java.util.List;

import ch.hearc.beershopfull.catalog.model.Beer;

public interface CatalogService {

	/**
	 * Sauvegarde une nouvelle bière
	 * @param beer la bière
	 */
	public void addBeerToCatalog(Beer beer);
	
	/**
	 * Retourne toute les bières
	 * @return la liste des bières
	 */
	public List<Beer> getAllBeersFromCatalog();

	public void deleteBeer(Integer id);
	
	public Beer updateBeer(Beer beer);
	
	public Beer getBeerById(Integer id);
	
	public void saveEvaluation(Integer beerId, Integer note);
	
}
