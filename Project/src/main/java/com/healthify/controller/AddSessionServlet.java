package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.healthify.dao.AddSessionDao;
import com.healthify.dao.AddSessionDaoImpl;
import com.healthify.dao.Session;

/**
 * Servlet implementation class AddSchedule
 */
@WebServlet("/AddSessionServlet")
public class AddSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AddSessionDao addsessionDao = new AddSessionDaoImpl();
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    String doctorId = request.getParameter("doctor_id");
	        String name = request.getParameter("name");
	        String description = request.getParameter("description");
	        String startTime = request.getParameter("start_time");
	        String endTime = request.getParameter("end_time");
	        int dayOfWeek = Integer.parseInt(request.getParameter("week"));
		    String referrer = request.getHeader("referer");
		    String prefix = "http://localhost:8080/Project/";
		    String trimmedUrl = referrer.replace(prefix, "");
	        
	        
	        Session sessionData = new Session();
	        sessionData.setName(name);
	        sessionData.setDescription(description);
	        sessionData.setStartTime(startTime);
	        sessionData.setEndTime(endTime);
	        sessionData.setWeek(dayOfWeek);
	        
	        if(addsessionDao.addSession(sessionData, doctorId)) {
	        	response.sendRedirect(trimmedUrl + "?success=true");
	        } else {
	        	response.sendRedirect(trimmedUrl + "?error=true");
	        }
	        

		
	}

}
