package ch.hearc.beershopfull.catalog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.model.EvaluationBeer;

public interface EvaluationBeerRepository extends CrudRepository<EvaluationBeer, Long>{}
