package ch.hearc.beershopfull.catalog.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.model.EvaluationBeer;
import ch.hearc.beershopfull.catalog.repository.EvaluationBeerRepository;

//@Repository
public class EvaluationBeerInMemoryRepository {

	/**
	private static List<EvaluationBeer> EVALUATION_TABLE = new ArrayList<>();
	private Integer evalPk = 0;
	
	@Override
	public void saveEvaluation(Integer beerId, Integer note) {
		
		EvaluationBeer eval = new EvaluationBeer();
		eval.setBeerId(beerId);
		eval.setNote(note);
		eval.setId(evalPk);
		evalPk++;
		EVALUATION_TABLE.add(eval);
	}
	
	
	public List<EvaluationBeer> getAllEvaluations(){
		return EVALUATION_TABLE;
	}
	
	
	public List<EvaluationBeer> getAllEvaluationsByBiereId(Integer id){
		return EVALUATION_TABLE.stream().filter(biere -> {
			return biere.getBeerId().equals(id);
		}).toList();
	}

	@Override
	public void deleteEvaluations(Integer id) {
		
		EVALUATION_TABLE = EVALUATION_TABLE.stream().filter(e -> {
			return !e.getBeerId().equals(id);
		}).collect(Collectors.toList());
		
	}
	
	*/

}
