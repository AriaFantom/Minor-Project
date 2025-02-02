package com.healthify.dao;

public interface DoctorDao {

	boolean isValid(String email, String password);
	
	boolean addDoctor(Doctor doctor);
	
	boolean deleteDoctor(String doctorId);
	
	Doctor searchDoctor(Doctor doctor);
	
	

}
