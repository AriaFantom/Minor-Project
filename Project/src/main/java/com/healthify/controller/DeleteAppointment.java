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
 * Servlet implementation class DeleteAppointment
 */
@WebServlet("/DeleteAppointment")
public class DeleteAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AppointmentDao appointmentDao = new AppointmentDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String appointment_id = request.getParameter("appointment_id");
		
		if(appointmentDao.removeBooking(appointment_id)) {
			response.sendRedirect("dashboard/patient/booking.jsp?success=true");
		} else {
			response.sendRedirect("dashboard/patient/booking.jsp?error=true");
		}
	}

}
