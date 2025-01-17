package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.healthify.dao.AppointmentDao;
import com.healthify.dao.AppointmentDaoImpl;
import com.healthify.dao.Appointment;

/**
 * Servlet implementation class BookAppointment
 */
@WebServlet("/BookAppointment")
public class BookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AppointmentDao appointmentDao = new AppointmentDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String doctor_id  = request.getParameter("doctor_id");
	    String patient_id = request.getParameter("patient_id");
	    String session_id = request.getParameter("session_id");
	    
	    Appointment appointment = new Appointment();
	    appointment.setDoctor_id(doctor_id);
	    appointment.setPatient_id(patient_id);
	    appointment.setSchedule(session_id);
	    
	    if(appointmentDao.addBooking(appointment)) {
	    	response.sendRedirect("dashboard/patient/booking.jsp?success=true");
	    } else {
	    	response.sendRedirect("dashboard/patient/booking.jsp?error=true");
	    }
	    
	}

}
