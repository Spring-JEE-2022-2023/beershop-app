package ch.hearc.beershopfull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Profile(value="secure")
public class SecurityConfiguration {
    
	
	@Bean
	@Profile(value = "secure-admin")
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		http
			.authorizeRequests()
			.antMatchers("/", "/accueil").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().permitAll();
		
		http.logout()
			.logoutSuccessUrl("/admin");
		
		
		return http.build();
		
	}
		

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}

