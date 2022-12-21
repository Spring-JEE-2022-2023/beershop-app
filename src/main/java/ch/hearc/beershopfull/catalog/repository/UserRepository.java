package ch.hearc.beershopfull.catalog.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ch.hearc.beershopfull.catalog.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	public User getUserByUsername(@Param("username") String username);
	
}
