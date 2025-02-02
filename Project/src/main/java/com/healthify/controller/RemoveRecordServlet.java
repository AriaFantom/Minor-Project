package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.healthify.dao.DoctorDao;
import com.healthify.dao.DoctorDaoImpl;
import com.healthify.dao.UserDao;
import com.healthify.dao.UserDaoImpl;

/**
 * Servlet implementation class RemoveRecordServlet
 */
@WebServlet("/RemoveRecordServlet")
public class RemoveRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserDao userDao = new UserDaoImpl();
    private static DoctorDao doctorDao = new DoctorDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	String recordType = request.getParameter("type");
	        String recordIdStr = request.getParameter("session_id");
	        
	        if (recordType == null || recordType.isEmpty() || recordIdStr == null || recordIdStr.isEmpty()) {
	            
	        }
	        boolean isDeleted = false;
	        if (recordType.equalsIgnoreCase("doctor")) {
	        	isDeleted = doctorDao.deleteDoctor(recordIdStr);
	        	if(isDeleted) {
	        		response.sendRedirect("dashboard/admin/doctor.jsp?success=true");
	        	} else {
	        		response.sendRedirect("dashboard/admin/doctor.jsp?error=true");
	        	}
	        	
	        } else if (recordType.equalsIgnoreCase("patient")) {
	        	
	        	isDeleted = userDao.deletePatient(recordIdStr);
	        	if(isDeleted) {
	        		response.sendRedirect("dashboard/admin/patient.jsp?success=true");
	        	} else {
	        		response.sendRedirect("dashboard/admin/patient.jsp?error=true");
	        	}
	        	
	        } else {
	        	isDeleted = false;
	        }
	        

	        
	        
	}

}
