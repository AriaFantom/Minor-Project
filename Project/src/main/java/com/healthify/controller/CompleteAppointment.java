package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.healthify.dao.AppointmentDao;
import com.healthify.dao.AppointmentDaoImpl;

/**
 * Servlet implementation class CompleteAppointment
 */
@WebServlet("/CompleteAppointment")
public class CompleteAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AppointmentDao appointmentDao = new AppointmentDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String appointmentId = request.getParameter("appointment_id");

	        // Validate the appointment ID
	        if (appointmentId == null || appointmentId.trim().isEmpty()) {
	        	response.sendRedirect("dashboard/doctor/appointments.jsp?success=false");
	        }

	        // Attempt to complete the booking
	        boolean isCompleted = appointmentDao.completeBooking(appointmentId);

	        if (isCompleted) {
	        	response.sendRedirect("dashboard/doctor/appointments.jsp?success=true");
	        } else {
	        	response.sendRedirect("dashboard/doctor/appointments.jsp?error=true");
	        }
	}

}
