package com.healthify.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import com.healthify.dao.InvitationDao;
import com.healthify.dao.InvitationDaoImpl;
import com.healthify.dao.Invitation;


@WebServlet("/InviteDoctor")
public class InviteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static InvitationDao inviteDao = new InvitationDaoImpl();
    private final String SMTP_HOST = "smtp.resend.com";
    private final String SMTP_PORT = "587";
    private final String SMTP_USER = "resend";
    private final String SMTP_PASSWORD = "re_SWsGSg1p_6REP9wDAfhmJ5pUZftocFnP3";
       
 
    public InviteDoctor() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String token = request.getParameter("token");
		 if (token == null || token.isEmpty()) {
			 response.sendRedirect("dashboard/admin/invite.jsp?error=true");
	    }
		 
		 
		 Invitation invite = inviteDao.verifyToken(token);
		 
		 if (invite != null && !invite.isUsed() && invite.getTokenExpiry().isAfter(LocalDateTime.now())) {
				HttpSession session = request.getSession();
				session.setAttribute("token", token);
			    response.sendRedirect("verify.jsp");
			 
			} else {
				response.sendRedirect("verify.jsp?error=true");
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String doctorEmail = request.getParameter("doctor_email");

	        if (doctorEmail == null || doctorEmail.isEmpty()) {
	        	response.sendRedirect("dashboard/admin/invite.jsp?error=true");
	        }
	        
	        try {
	        
	        String token = generateToken();
	        LocalDateTime expiry = LocalDateTime.now().plusHours(24);
	        Invitation invite = new Invitation();
	        invite.setDoctorEmail(doctorEmail);
	        invite.setInviteToken(token);
	        invite.setTokenExpiry(expiry);
	        invite.setUsed(false);
	        
	        inviteDao.sendInvite(invite);
	        
	        sendInvitationEmail(doctorEmail, token, request.getScheme(), request.getServerName(), request.getServerPort());
	        response.sendRedirect("dashboard/admin/invite.jsp?success=true");
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("dashboard/admin/invite.jsp?error=true");
	        }
	        
	      
	}
	
	 private String generateToken() {
	        SecureRandom random = new SecureRandom();
	        byte[] bytes = new byte[24];
	        random.nextBytes(bytes);
	        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
	}
	 
	 private void sendInvitationEmail(String recipientEmail, String token, String scheme, String serverName, int serverPort) {
	        String link = scheme + "://" + serverName + ":" + serverPort + "/Project/InviteDoctor?token=" + token;

	        String subject = "Doctor Invitation to Set Up Account";
	        String content = "<p>Dear Doctor,</p>"
	                       + "<p>You have been invited to join our system. Please click the link below to set up your username and password:</p>"
	                       + "<p><a href=\"" + link + "\">Set Up Account</a></p>"
	                       + "<p>This link will expire in 24 hours.</p>"
	                       + "<p>Best Regards,<br/>Admin Team</p>";

	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", SMTP_HOST);
	        props.put("mail.smtp.port", SMTP_PORT);

	        Session session = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(SMTP_USER, SMTP_PASSWORD);
	            }
	          });

	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("onboarding@resend.dev", "Admin"));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
	            message.setSubject(subject);
	            
	            // Set email content as HTML
	            message.setContent(content, "text/html; charset=utf-8");

	            Transport.send(message);

	            System.out.println("Invitation email sent to " + recipientEmail);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }

}
