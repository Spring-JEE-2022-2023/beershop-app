package ch.hearc.beershopfull.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.repository.BeerRepository;
import ch.hearc.beershopfull.catalog.repository.EvaluationBeerRepository;
import ch.hearc.beershopfull.catalog.repository.impl.EvaluationBeerInMemoryRepository;
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
		beerRepository.saveBeer(beer);
	}
	
	/**
	 * Retourne toute les bières
	 * @return la liste des bières
	 */
	public List<Beer> getAllBeersFromCatalog(){
		
		List<Beer> beers = beerRepository.getAllBeers();
		
		List<Beer> beersWithEval = beers.stream().map(biere -> {
			Beer b = new Beer();
			b.setId(biere.getId());
			b.setName(biere.getName());
			b.setStock(biere.getStock());
			b.setPrice(biere.getPrice());
			b.setEvaluations(evaluationRepository.getAllEvaluationsByBiereId(biere.getId()));
			
			
			return b;
			
		}).collect(Collectors.toList());
		
		return beersWithEval;
	}

	public void deleteBeer(Integer id) {
		beerRepository.deleteBeer(id);
		evaluationRepository.deleteEvaluations(id);
		
	}
	
	public Beer updateBeer(Beer beer) {
		beerRepository.updateBeer(beer);
		return beer;
		
	}
	
	public Beer getBeerById(Integer id) {
		return beerRepository.getById(id);
		
	}

	
	public void saveEvaluation(Integer beerId, Integer note) {
		evaluationRepository.saveEvaluation(beerId, note);
		
	}
}
