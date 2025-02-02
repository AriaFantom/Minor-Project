package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.healthify.dao.AddSessionDao;
import com.healthify.dao.AddSessionDaoImpl;

/**
 * Servlet implementation class RemoveSessionServlet
 */
@WebServlet("/RemoveSessionServlet")
public class RemoveSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AddSessionDao addsessionDao = new AddSessionDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		    String sessionIdParam = request.getParameter("session_id");
		    String referrer = request.getHeader("referer");
		    String prefix = "http://localhost:8080/Project/";
		    String trimmedUrl = referrer.replace(prefix, "");

	        int sessionId;
	        try {
	            sessionId = Integer.parseInt(sessionIdParam);
	        } catch (NumberFormatException e) {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid session_id format");
	            return;
	        }

	        try {
	            boolean deleted = addsessionDao.removeSession(sessionId);
	            if (deleted) {
	                response.sendRedirect(trimmedUrl + "?success=true");
	            } else {
	                response.sendRedirect(trimmedUrl + "?error=true");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred.");
	        }
	}

}
