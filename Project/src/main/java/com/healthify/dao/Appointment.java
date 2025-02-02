package com.healthify.dao;
import java.sql.Timestamp;
public class Appointment {
	
	private String patient_id;
	private String doctor_id;
	private String schedule;
	private Timestamp date;
	private String status;
	
	public String isDone() {
		return status;
	}
	public void setDone(String status) {
		this.status = status;
	}
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

	
}
