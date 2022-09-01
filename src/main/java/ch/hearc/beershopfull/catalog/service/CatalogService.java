package ch.hearc.beershopfull.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.repository.BeerRepository;

import org.springframework.stereotype.Service;

/**
 * Service de gestion du catalogue de bières
 * @author Seb
 *
 */
@Service
public class CatalogService {
	
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
}
