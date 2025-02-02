package com.healthify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthify.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
    public boolean isValid(String email, String password) {
		
		String query = "Select * from patients where email = ? and password = ?";
		
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

	@Override
	public boolean addUser(User user) {
		
		String query = "INSERT INTO patients (username, email, phno, password) values (?, ?, ?, ?);";
		
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			    preparedStatement.setString(1, user.getUsername());
			    preparedStatement.setString(2, user.getEmail());
			    preparedStatement.setString(3, user.getPhno());
			    preparedStatement.setString(4, user.getPassword());
			
			    int rows = preparedStatement.executeUpdate();
				return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deletePatient(String patientId) {

			String query = "DELETE FROM patients WHERE id = ?;";
			
			try(Connection connection = DBUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				    preparedStatement.setString(1, patientId);
				
				    int rows = preparedStatement.executeUpdate();
					return rows > 0;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}

}
