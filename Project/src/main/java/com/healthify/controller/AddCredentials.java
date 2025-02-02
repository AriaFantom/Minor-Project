package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.healthify.dao.Invitation;
import com.healthify.dao.Doctor;

import com.healthify.dao.DoctorDao;
import com.healthify.dao.DoctorDaoImpl;
import com.healthify.dao.InvitationDao;
import com.healthify.dao.InvitationDaoImpl;

/**
 * Servlet implementation class AddCredentials
 */
@WebServlet("/AddCredentials")
public class AddCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static InvitationDao inviteDao = new InvitationDaoImpl();
	private static DoctorDao doctorDao = new DoctorDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCredentials() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String token = request.getParameter("token");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String specialist = request.getParameter("specialist");
		String password = request.getParameter("password");
		
		System.out.print(token);
		System.out.print(email);
		System.out.print(username);
		System.out.print(specialist);
		System.out.print(password);
		
		 if (token == null || token.isEmpty() || email == null || email.isEmpty() || username == null || username.isEmpty() ||
		            specialist == null || specialist.isEmpty() || password == null || password.isEmpty()) {

			 response.sendRedirect("verify.jsp?error=true");
		} 
		 
		 Invitation invitation = new Invitation();
		 invitation.setDoctorEmail(email);
		 invitation.setInviteToken(token);
		 
		 if(inviteDao.validToken(invitation)) {
			 Doctor doctor = new Doctor();
			 doctor.setEmail(email);
			 doctor.setUsername(username);
			 doctor.setSpecialist(specialist);
			 doctor.setPassword(password);
			 
			 if(doctorDao.addDoctor(doctor)) {
				 if(inviteDao.setTokenUsed(token)) {
					 response.sendRedirect("login.jsp?success=true"); 
				 }
				 
			 }
			 
		 }
		
		
	}

}
