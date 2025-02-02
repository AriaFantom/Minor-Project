package com.healthify.dao;

public interface InvitationDao {
	
	boolean sendInvite(Invitation invitation);
	Invitation verifyToken(String token);
	boolean setTokenUsed(String token);
	boolean validToken(Invitation invitation);
}
