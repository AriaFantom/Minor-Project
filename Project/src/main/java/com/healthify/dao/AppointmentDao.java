package com.healthify.dao;

public interface AppointmentDao {
	
	boolean addBooking(Appointment appointment);
	boolean removeBooking(String id);
}
