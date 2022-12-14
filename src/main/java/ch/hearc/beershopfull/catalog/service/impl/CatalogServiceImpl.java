package ch.hearc.beershopfull.catalog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.model.EvaluationBeer;
import ch.hearc.beershopfull.catalog.repository.BeerRepository;
import ch.hearc.beershopfull.catalog.repository.EvaluationBeerRepository;
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
	
	@Autowired
	EvaluationBeerRepository evaluationRepository; //repository d'accès aux données
	
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

	public void deleteBeer(Integer id) {
		Beer bDeleteBeer = beerRepository.findById(new Long(id)).get();
		beerRepository.delete(bDeleteBeer);
		
	}
	
	public Beer updateBeer(Beer beer) {
		beerRepository.save(beer);
		return beer;
		
	}
	
	public Beer getBeerById(Integer id) {
		return beerRepository.findById(new Long(id)).get();
		
	}

	
	public void saveEvaluation(Integer beerId, Integer note) {
		Beer beer = beerRepository.findById(beerId);
		
		EvaluationBeer evaluationBeer =  new EvaluationBeer(note);
		evaluationBeer.setBeer(beer);
		evaluationRepository.save(evaluationBeer);
		
		
	}
}
