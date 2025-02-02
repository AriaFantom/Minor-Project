package com.healthify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthify.util.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean isValid(String email, String password) {
String query = "Select * from admins where email = ? and password = ?";
		
		try(Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			return resultSet.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
