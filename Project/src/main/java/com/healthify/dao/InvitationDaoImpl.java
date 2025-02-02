package com.healthify.dao;

import com.healthify.util.DBUtil;
import java.sql.*;
public class InvitationDaoImpl implements InvitationDao {

	@Override
	public boolean sendInvite(Invitation invite) {
		String query = "INSERT INTO doctor_invites (doctor_email, invite_token, token_expiry, is_used) VALUES (?, ?, ?, ?);";
		
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 preparedStatement.setString(1, invite.getDoctorEmail());
	            preparedStatement.setString(2, invite.getInviteToken());
	            preparedStatement.setTimestamp(3, Timestamp.valueOf(invite.getTokenExpiry()));
	            preparedStatement.setBoolean(4, invite.isUsed());
			
			    int rows = preparedStatement.executeUpdate();
				return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Invitation verifyToken(String token) {
		String query = "SELECT * FROM doctor_invites WHERE invite_token = ?;";
		Invitation invite = null;
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, token);
				ResultSet rs = preparedStatement.executeQuery();
				
				 if (rs.next()) {
		                invite = new Invitation();
		                invite.setDoctorEmail(rs.getString("doctor_email"));
		                invite.setInviteToken(rs.getString("invite_token"));
		                invite.setTokenExpiry(rs.getTimestamp("token_expiry").toLocalDateTime());
		                invite.setUsed(rs.getBoolean("is_used"));
		            }
				 return invite;
				
		} catch (SQLException e) {
			e.printStackTrace();
			return invite;
		}
		
	}
		
	

	@Override
	public boolean setTokenUsed(String token) {
		String query = "UPDATE doctor_invites SET is_used = ? WHERE invite_token = ?;";
		
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setBoolean(1, true);
				preparedStatement.setString(2, token);
	           
			
			    int rows = preparedStatement.executeUpdate();
				return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean validToken(Invitation invite) {
		 String query = "SELECT * FROM doctor_invites " +
                 "WHERE invite_token = ? " +
                 "AND is_used = FALSE " +
                 "AND doctor_email = ? " +
                 "AND token_expiry > NOW();";
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, invite.getInviteToken());
				preparedStatement.setString(2, invite.getDoctorEmail());
				ResultSet resultSet = preparedStatement.executeQuery();
				
				return resultSet.next();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}

}
