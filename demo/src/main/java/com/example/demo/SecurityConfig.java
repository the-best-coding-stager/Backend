package com.example.demo;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.springpagination.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private UserService service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/login", "/signUp").permitAll()
				// user 접근 허용
				.antMatchers("/userAccess").hasRole("USER")
				.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login_proc")
				.defaultSuccessUrl("/user_access")
				.failureUrl("/access_denied")
				.and()
			.csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}

}
