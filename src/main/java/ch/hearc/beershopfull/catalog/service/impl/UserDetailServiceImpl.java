package ch.hearc.beershopfull.catalog.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ch.hearc.beershopfull.catalog.model.User;
import ch.hearc.beershopfull.catalog.repository.UserRepository;


public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;


	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return user;
     }
}