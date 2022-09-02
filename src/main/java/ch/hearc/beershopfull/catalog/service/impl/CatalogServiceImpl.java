package ch.hearc.beershopfull.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.repository.BeerRepository;
import ch.hearc.beershopfull.catalog.service.CatalogService;


/**
 * Service de gestion du catalogue de bières
 * @author Seb
 *
 */
@Service
public class CatalogServiceImpl implements CatalogService{
	
	@Autowired
	BeerRepository beerRepository; //repository d'accès aux données
	
	/**
	 * Sauvegarde une nouvelle bière
	 * @param beer la bière
	 */
	public void addBeerToCatalog(Beer beer) {
		beerRepository.saveBeer(beer);
	}
	
	/**
	 * Retourne toute les bières
	 * @return la liste des bières
	 */
	public List<Beer> getAllBeersFromCatalog(){
		return beerRepository.getAllBeers();
	}

	public void deleteBeer(Integer id) {
		beerRepository.deleteBeer(id);
		
	}
	
	public Beer updateBeer(Beer beer) {
		beerRepository.updateBeer(beer);
		return beer;
		
	}
	
	public Beer getBeerById(Integer id) {
		return beerRepository.getById(id);
		
	}
}
