package ch.hearc.beershopfull.catalog.service.impl;

import java.util.ArrayList;
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
		beerRepository.save(beer);
	}
	
	/**
	 * Retourne toute les bières
	 * @return la liste des bières
	 */
	public List<Beer> getAllBeersFromCatalog(){
		List<Beer> result = new ArrayList<Beer>();
		beerRepository.findAll().forEach(result::add);
		return result;
		//return beerRepository.findAll();
	}

	public void deleteBeer(Long id) {
		beerRepository.deleteById(new Long(id));
		
	}
	
	public Beer updateBeer(Beer beer) {
		beerRepository.save(beer);
		return beer;
		
	}
	
	public Beer getBeerById(Integer id) {
		return beerRepository.findById(new Long(id)).get();
		
	}
}
