package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.healthify.dao.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserDao userDao = new UserDaoImpl();
    private static DoctorDao doctorDao = new DoctorDaoImpl();
    private static AdminDao adminDao = new AdminDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		   if(userDao.isValid(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("dashboard/patient/panel.jsp");
			
		} else if (doctorDao.isValid(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("dashboard/doctor/panel.jsp");
		} else if (adminDao.isValid(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("dashboard/admin/panel.jsp");
		} else {
			response.sendRedirect("login.jsp?error=true");
		}
	}

}
