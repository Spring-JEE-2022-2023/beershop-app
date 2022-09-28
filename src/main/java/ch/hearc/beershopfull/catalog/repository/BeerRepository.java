package ch.hearc.beershopfull.catalog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.hearc.beershopfull.catalog.model.Beer;
/**
 * Interface de gestion des données des bières
 * @author seb
 *
 */
public interface BeerRepository extends CrudRepository<Beer, Long>{


	Beer findById(long id);
}
