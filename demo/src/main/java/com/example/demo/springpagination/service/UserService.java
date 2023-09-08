package com.example.demo.springpagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.springpagination.model.User;
import com.example.demo.springpagination.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

    @Override
    public User getCurrentUser() {
    	
        User user = new User();
        user.setId(1L);
        user.setUser_id("Micheal");
                
        return user;
    }

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getOne(id); 
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}
}