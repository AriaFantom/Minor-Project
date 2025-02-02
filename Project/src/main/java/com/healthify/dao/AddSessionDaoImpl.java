package com.healthify.dao;
import java.sql.Connection;
import com.healthify.util.DBUtil;
import java.sql.*;


public class AddSessionDaoImpl implements AddSessionDao {

	@Override
	public boolean addSession(Session session, String doctorEmail) {        
        int doctorId = -1;
        String selectSql = "SELECT id FROM doctors WHERE email = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement selectPs = conn.prepareStatement(selectSql)) {
            selectPs.setString(1, doctorEmail);
            try (ResultSet rs = selectPs.executeQuery()) {
                if (rs.next()) {
                    doctorId = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
        	
            e.printStackTrace();
            return false; 
        }

        System.out.println(doctorId);
      
        if (doctorId == -1) {
            return false;
        }

       
        // TODO have a check to see start time must be greater than end time
        String insertSql = "INSERT INTO schedule (name, description, start_time, week, doctor_id, end_time) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement insertPs = conn.prepareStatement(insertSql)) {

            insertPs.setString(1, session.getName());
            insertPs.setString(2, session.getDescription());
            insertPs.setString(3, session.getStartTime());
            insertPs.setInt(4, session.getWeek());
            insertPs.setInt(5, doctorId);
            insertPs.setString(6, session.getEndTime());

            int rowsInserted = insertPs.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

	@Override
	public boolean removeSession(int SessionId) {
		  String sql = "DELETE FROM schedule WHERE id = ?";
	        try (Connection conn = DBUtil.getConnection();
	             PreparedStatement pstm  = conn.prepareStatement(sql)) {
	             pstm.setInt(1, SessionId);
	             
	             int rowsAffected = pstm.executeUpdate();
	             return rowsAffected > 0;
	             
	        } catch (SQLException e) {
	        	 e.printStackTrace();
	             return false;
	        } 
	}
}

