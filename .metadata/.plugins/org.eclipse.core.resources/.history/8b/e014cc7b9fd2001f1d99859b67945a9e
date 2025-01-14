package com.healthify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthify.util.DBUtil;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public boolean isValid(String email, String password) {
    String query = "Select * from doctors where email = ? and password = ?";
		
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
    public boolean addDoctor(Doctor doctor) {
		
		String query = "INSERT INTO doctors (username, password, specialist, email) values (?, ?, ?, ?);";
		
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			    preparedStatement.setString(1, doctor.getUsername());
			    preparedStatement.setString(2, doctor.getPassword());
			    preparedStatement.setString(3, doctor.getSpecialist());
			    preparedStatement.setString(4, doctor.getEmail());
			
			    int rows = preparedStatement.executeUpdate();
				return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

  	}

	@Override
	public Doctor searchDoctor(Doctor doctor) {
		
		
		 String query = "SELECT username, specialist FROM doctors WHERE username = ?";
	        
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, doctor.getUsername());
	            
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    Doctor foundDoctor = new Doctor();
	                    foundDoctor.setUsername(resultSet.getString("username"));
	                    foundDoctor.setSpecialist(resultSet.getString("specialist"));
	                    
	                    return foundDoctor;
	                } else {
	     
	                    return null;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
