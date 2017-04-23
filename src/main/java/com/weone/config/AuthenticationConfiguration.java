/**
 * 
 */
package com.weone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.weone.service.UserAccountService;
import com.weone.util.ASPasswordEncoder;

/**
 * custom authentication.
 * 
 * @author YoungMin
 *
 */
@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
	@Autowired
	private UserAccountService userAccountService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new ASPasswordEncoder(); 
	}
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userAccountService).passwordEncoder(passwordEncoder());
	}
	

}
