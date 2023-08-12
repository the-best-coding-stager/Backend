package com.example.demo;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dto.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private UserServiceImpl service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/api/login", "/api/signUp").anonymous()
				// user 접근 허용
				//.antMatchers("/userAccess").hasRole("USER")
				.and()
			.formLogin()
				.loginPage("/api/login")
//				.loginProcessingUrl("/login_proc")
				.defaultSuccessUrl("/api/user_access")
				.failureUrl("/api/access_denied")
				.and()
			.csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
		System.out.println("What happen with you");
	}

}
