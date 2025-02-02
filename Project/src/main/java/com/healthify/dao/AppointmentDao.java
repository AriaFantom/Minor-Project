package com.healthify.dao;

public interface AppointmentDao {
	
	boolean addBooking(Appointment appointment);
	boolean removeBooking(String id);
	boolean cancelBooking(String id);
	boolean completeBooking(String id);
	boolean updateAppointmentStatus(int appointmentId, String newStatus);
}
