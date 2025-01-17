package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.healthify.dao.UserDaoImpl;
import com.healthify.dao.User;
import com.healthify.dao.UserDao;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phno = request.getParameter("phno");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPhno(phno);
		user.setPassword(password);
		
		if(userDao.addUser(user)) {
			response.sendRedirect("login.jsp?success=true");
		} else {
			response.sendRedirect("register.jsp?error=true");
		}
		
		
	}

}
