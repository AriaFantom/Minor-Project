package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.healthify.dao.UserDaoImpl;
import com.healthify.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserDao userDao = new UserDaoImpl();
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
		
		System.out.println(email);
		System.out.println(password);
		
		
		if(userDao.isValid(email, password) == "p") {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("patient-panel.jsp");
			
		} else if (userDao.isValid(email, password) == "d") {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("doctor-panel.jsp");
		}
		
		else {
			response.sendRedirect("login.jsp?err=notfound");
		}
	}

}
