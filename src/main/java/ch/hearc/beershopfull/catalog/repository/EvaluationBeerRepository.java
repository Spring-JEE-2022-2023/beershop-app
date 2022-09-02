package ch.hearc.beershopfull.catalog.repository;

import java.util.List;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.model.EvaluationBeer;

public interface EvaluationBeerRepository {

	/**
	 * Sauvegarde d'une évaluation
	 * 
	 * @param beerId
	 * @param note
	 */
	public void saveEvaluation(Integer beerId, Integer note);
	
	/**
	 * Retourne toutes les évaluations pour une bière
	 * @return
	 */
	public List<EvaluationBeer> getAllEvaluationsByBiereId(Integer id);

	public void deleteEvaluations(Integer id);
}
