package com.healthify.dao;

public interface UserDao {

	boolean isValid(String email, String password);

	boolean addUser(User user);

}