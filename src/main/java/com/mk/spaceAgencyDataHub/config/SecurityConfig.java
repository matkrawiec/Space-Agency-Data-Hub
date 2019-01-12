package com.mk.spaceAgencyDataHub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//used for demo app, not recommened for production
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("manager").password("password").roles("MANAGER"))
			//not in use
			.withUser(users.username("customer").password("password").roles("CUSTOMER"));
	}
		
//		

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/h2/**").hasRole("MANAGER")
		.antMatchers("/console/**").hasRole("MANAGER")
		.antMatchers(HttpMethod.GET, "/missions").hasRole("MANAGER")
		.antMatchers(HttpMethod.GET, "/missions/**").hasRole("MANAGER")
		.antMatchers(HttpMethod.POST, "/missions").hasAnyRole("MANAGER")
		.antMatchers(HttpMethod.PUT, "/missions/**").hasAnyRole("MANAGER")
		.antMatchers(HttpMethod.DELETE, "/missions/**").hasRole("MANAGER")
		.antMatchers(HttpMethod.GET, "/products").hasRole("MANAGER")
		.antMatchers(HttpMethod.POST, "/products/**").hasRole("MANAGER")
		.antMatchers(HttpMethod.DELETE, "/products/**").hasRole("MANAGER")
		.and()
		.httpBasic()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().headers().frameOptions().disable();
	
	}

	
	


}













