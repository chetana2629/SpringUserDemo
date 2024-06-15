package com.org.example.service;

import java.util.List;

public interface CrudService<T,K> {
	//add user
	T create(T t);
	
	//get all user
	List<T> fetchAll();
	
	//get user by id
	T fetchById(K k);
	
	//update user
	T update(T t1,T t2);
	
	//delete by id
	String delete(T t);

}
