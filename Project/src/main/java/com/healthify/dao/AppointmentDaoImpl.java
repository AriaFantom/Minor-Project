package com.healthify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.sql.Timestamp;
import java.sql.Time;
import java.sql.ResultSet;


import com.healthify.util.DBUtil;

public class AppointmentDaoImpl implements AppointmentDao {

	@Override
	public boolean addBooking(Appointment appointment) {
		
		String insertSql = "INSERT INTO appointments (patient_id, doctor_id, schedule, date, status) VALUES (?, ?, ?, ?, 'booked')";
		String scheduleSql = "SELECT week, start_time FROM schedule WHERE id = ?";
		
		 try (Connection connection = DBUtil.getConnection();
		         PreparedStatement scheduleStmt = connection.prepareStatement(scheduleSql)) {

		        scheduleStmt.setString(1, appointment.getSchedule());
		        ResultSet rs = scheduleStmt.executeQuery();
		        
		        if (rs.next()) {
		            int weekNumber = rs.getInt("week");
		            Time startTime = rs.getTime("start_time");

		            LocalDate today = LocalDate.now();
		            DayOfWeek desiredDay = DayOfWeek.of(weekNumber);
		            
		            LocalDate appointmentDate = today.with(TemporalAdjusters.next(desiredDay));
		            LocalDateTime appointmentDateTime = appointmentDate.atTime(startTime.toLocalTime());
		            Timestamp appointmentTimestamp = Timestamp.valueOf(appointmentDateTime);

		            try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
		                insertStmt.setString(1, appointment.getPatient_id());
		                insertStmt.setString(2, appointment.getDoctor_id());
		                insertStmt.setString(3, appointment.getSchedule());
		                insertStmt.setTimestamp(4, appointmentTimestamp);

		                int rowsInserted = insertStmt.executeUpdate();
		                return rowsInserted > 0;
		            }
		        } else {
		            System.err.println("Schedule ID not found: " + appointment.getSchedule());
		            return false;
		        }
		            
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

	@Override
	public boolean cancelBooking(String id) {
		 String sql = "UPDATE appointments SET status = 'canceled' WHERE id = ?";
		    try (Connection connection = DBUtil.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		        preparedStatement.setString(1, id);
		        int rowsUpdated = preparedStatement.executeUpdate();
		        return rowsUpdated > 0;
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
	}

	@Override
	public boolean completeBooking(String id) {
		 String sql = "UPDATE appointments SET status = 'completed' WHERE id = ?";
		    try (Connection connection = DBUtil.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		        preparedStatement.setString(1, id);
		        int rowsUpdated = preparedStatement.executeUpdate();
		        return rowsUpdated > 0;
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
	}

	@Override
	public boolean updateAppointmentStatus(int appointmentId, String newStatus) {
		 
		 String sql = "UPDATE appointments SET status = ? WHERE id = ?;";
		    try (Connection connection = DBUtil.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		    	preparedStatement.setString(1, newStatus.toLowerCase());
		    	preparedStatement.setInt(2, appointmentId);
		    	 int rowsAffected = preparedStatement.executeUpdate();
		         return rowsAffected > 0;    
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
	}
	
	
}
