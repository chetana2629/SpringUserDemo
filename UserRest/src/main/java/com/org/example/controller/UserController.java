package com.org.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.example.dto.ErrorResponse;
import com.org.example.entity.User;
import com.org.example.exception.UserNotFoundException;
import com.org.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
//	@PostMapping("/add")
//	public User registerUser(@RequestBody User user) {
//		return userService.create(user);
//	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		User createdUser = userService.create(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>  fetchAll() {
		List<User> AllUser = userService.fetchAll();
		try {
			return new ResponseEntity<>(AllUser,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(new ErrorResponse("user fetching failed",e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@GetMapping("/{id1}")
	public ResponseEntity<?>  fetchById(@PathVariable("id1")Integer id) {
		try {
			User getUser=userService.fetchById(id);
			return new ResponseEntity<>(getUser, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(new ErrorResponse("not found",e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable int id, @RequestBody User updatedUser){
		try {
			User existingUser = userService.fetchById(id);
			return ResponseEntity.ok(userService.update(updatedUser, existingUser));
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("User updation failed.", e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Integer id){
		try {
			User existingUser = userService.fetchById(id);
			return ResponseEntity.ok(userService.delete(existingUser));
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("User deletion failed.", e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<?> getUserByUserName(@PathVariable String name){
		try {
			ResponseEntity res = null;
			User foundUser = userService.fetchUserByUserName(name);
			if(foundUser != null) {
				res.ok(foundUser);
			}else {
				throw new UserNotFoundException("Invalid Username..");
			}
			return res;
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("fetching user by username failed.", e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
}
