package com.org.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.example.dao.userRef;
import com.org.example.entity.User;
import com.org.example.exception.UserNotFoundException;

@Service
public class UserService implements CrudService<User, Integer> {

	@Autowired
	private userRef userRepo;

	@Override
	public User create(User user) {
		User createdUser = userRepo.save(user);
		return createdUser;
	}

	@Override
	public List<User> fetchAll() {
		return userRepo.findAll();
	}

	@Override
	public User fetchById(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Invalid id"));
	}

	@Override
	public User update(User updatedUser, User existingUser) {
		existingUser.setUserName(updatedUser.getUserName());
		existingUser.setPassword(updatedUser.getPassword());
		existingUser.setName(updatedUser.getName());
		return userRepo.save(existingUser);
	}

	@Override
	public String delete(User user) {
		userRepo.delete(user);
		return user.getId()+" deleted. ";
	}
	
	
	public User fetchUserByUserName(String name) {
		return userRepo.findByUserName(name);
	}
	

	
	
}
