package com.example.demo.dto;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{
	private String user_id;
	private String nickname;
	private String password1;
	private String password2;
	
	private String userAuth;

	
	public User() {
		super();
	}
	
	public String getUserId() {
		return user_id;
	}
	
	public void setUserId(String id) {
		this.user_id = id;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPassword1() {
		return password1;
	}
	
	public void setPassword1(String password) {
		this.password1 = password;
	}
	
	public String getPassword2() {
		return password2;
	}
	
	public void setPassword2(String password) {
		this.password2 = password;
	}
	
	@Override
	public String toString() {
		return "User [id= " + user_id + ", nickname= " + nickname + ", password= " + password1 + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singletonList(new SimpleGrantedAuthority(this.userAuth));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password1;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
