package com.healthify.dao;

public interface DoctorDao {

	boolean isValid(String email, String password);
	
	boolean addDoctor(Doctor doctor);
	
	Doctor searchDoctor(Doctor doctor);

}
