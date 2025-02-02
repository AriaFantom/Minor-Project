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
 * Servlet implementation class UpdateStatusServlet
 */
@WebServlet("/UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AppointmentDao appointmentDao = new AppointmentDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatusServlet() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String appointmentIdStr = request.getParameter("appointment_id");
	        String newStatus = request.getParameter("new_status");

	        // Basic validation
	        if (appointmentIdStr == null || appointmentIdStr.isEmpty() || newStatus == null || newStatus.isEmpty()) {
	        	response.sendRedirect("dashboard/admin/appointments.jsp?error=true");
	            return;
	        }

	        int appointmentId;
	        try {
	            appointmentId = Integer.parseInt(appointmentIdStr);
	        } catch (NumberFormatException e) {
	        	response.sendRedirect("dashboard/admin/appointments.jsp?error=true");
	            return;
	        }

	        // Validate newStatus against allowed values
	        if (!newStatus.equalsIgnoreCase("booked") && 
	            !newStatus.equalsIgnoreCase("completed") && 
	            !newStatus.equalsIgnoreCase("canceled")) {
	        	response.sendRedirect("dashboard/admin/appointments.jsp?error=true");
	            return;
	        }

	        try {
	            boolean isUpdated = appointmentDao.updateAppointmentStatus(appointmentId, newStatus);
	            if (isUpdated) {
	            	response.sendRedirect("dashboard/admin/appointments.jsp?success=true");
	            } else {
	                response.sendRedirect("dashboard/admin/appointments.jsp?error=true");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("dashboard/admin/appointments.jsp?error=true");
	        }
	}

}
