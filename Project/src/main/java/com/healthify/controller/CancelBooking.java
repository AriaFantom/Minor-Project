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
 * Servlet implementation class CancelBooking
 */
@WebServlet("/CancelBooking")
public class CancelBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AppointmentDao appointmentDao = new AppointmentDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Retrieve the appointment ID from the request parameter
        String appointmentId = request.getParameter("appointment_id");

        // Validate the appointment ID
        if (appointmentId == null || appointmentId.trim().isEmpty()) {
        	response.sendRedirect("dashboard/doctor/appointments.jsp?error=true");
        }

        // Attempt to cancel the booking
        boolean isCanceled = appointmentDao.cancelBooking(appointmentId);

        if (isCanceled) {
        	response.sendRedirect("dashboard/doctor/appointments.jsp?success=true");
        } else {
        	response.sendRedirect("dashboard/doctor/appointments.jsp?error=true");
        }
	}

}
