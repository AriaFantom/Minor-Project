package com.healthify.dao;

public interface AddSessionDao {
	boolean addSession(Session session, String doctorEmail);
	boolean removeSession(int SessionId);
}
