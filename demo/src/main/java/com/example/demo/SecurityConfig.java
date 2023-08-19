package com.example.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
				.antMatchers("/api/login", "/api/signUp").permitAll()
				// user 접근 허용
				//.antMatchers("/userAccess").hasRole("USER")
				.and();
		http
			.formLogin()	// 로그인 기능 적용
				.loginPage("/api/login")	// 커스텀 로그인 페이지
				.loginProcessingUrl("/api/login")	// 실제 로그인 처리
				.defaultSuccessUrl("/api/user_access")
				.failureUrl("/api/login")
				.successHandler(new MyHomeHandler())
//				.usernameParameter("userId")
//				.passwordParameter("passwd")
//				.successHandler((request, response, authentication) -> {
//					System.out.println("authentication: " + authentication.getName());
//					response.sendRedirect("/");
//				})
//				.failureHandler((request, response, exception) -> {
//					System.out.println("exception: " + exception.getMessage());
//				})
//				.permitAll();
				.and()
			.csrf().disable();
		
		http.logout()
			.logoutUrl("/api/logout")	// 로그아웃 처리 URL
			.logoutSuccessUrl("/api/home")	// 로그아웃 성공 후
			.deleteCookies("remenber-me");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
		System.out.println("What happen with you");
	}

}

class MyHomeHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//session.setAttribute(("greeting", session);
		response.sendRedirect("/api/mypage");
	}
	
}
