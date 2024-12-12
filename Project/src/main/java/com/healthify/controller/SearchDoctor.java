package com.healthify.controller;

import jakarta.servlet.ServletException;
import com.healthify.dao.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SearchDoctor
 */
@WebServlet("/SearchDoctor")
public class SearchDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static DoctorDao doctorDao = new DoctorDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String doctors_name = request.getParameter("name");
	        
	  
	        Doctor searchDoctor = new Doctor();
	        searchDoctor.setUsername(doctors_name);

	        Doctor foundDoctor = doctorDao.searchDoctor(searchDoctor);

	        request.setAttribute("doctor", foundDoctor);
	        
	        // Forward to the JSP
	        request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
	}

}
