package com.healthify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.healthify.util.DBUtil;

public class AppointmentDaoImpl implements AppointmentDao {

	@Override
	public boolean addBooking(Appointment appointment) {
		
		String sql = "INSERT INTO appointments (patient_id, doctor_id, schedule) VALUES (?, ?, ?)";
		
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				    preparedStatement.setString(1, appointment.getPatient_id());
				    preparedStatement.setString(2, appointment.getDoctor_id());
				    preparedStatement.setString(3, appointment.getSchedule());
				    
		            int rowsInserted = preparedStatement.executeUpdate();
		            return rowsInserted > 0;
		            
		} catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean removeBooking(String id) {
		String sql = "DELETE FROM appointments WHERE id = ?";
		try(Connection connection = DBUtil.getConnection();			
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				    preparedStatement.setString(1, id);
		            int rowsInserted = preparedStatement.executeUpdate();
		            return rowsInserted > 0;
		            
		} catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

}
