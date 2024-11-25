package com.healthify.dao;

public interface UserDao {

	String isValid(String email, String password);

	boolean addUser(User user);

}
