package com.example.demo.springpagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.springpagination.model.Preference;
import com.example.demo.springpagination.model.User;
import com.example.demo.springpagination.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepoistory;

    @Override
    public User getCurrentUser() {
        
        Preference preference = new Preference();
        preference.setId(1L);
        preference.setTimezone("Asia/Calcutta");
        
        User user = new User();
        user.setId(1L);
        user.setName("Micheal");
        user.setPreference(preference);
                
        return user;
    }
    
  //회원가입 요청 DAO에 연결
  	@Override
  	public void signUp(User user) {
  		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  		user.setPassword(passwordEncoder.encode(user.getPassword()));
  		user.setUserId(user.getNickname());
  		user.setNickname(user.getNickname());
  		userRepoistory.signUp(user);		
  	}
  	
  	@Override
  	public User loadUserByUsername(String userId) throws UsernameNotFoundException{
  		User user = userRepoistory.signIn(userId);
  		if(user == null) {
  			throw new UsernameNotFoundException("User not authorized.");
  		}
  		return user;
  	}
}