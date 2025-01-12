<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="../../css/patient-panel.css">
</head>
<body>
    <%
                String username = "";
                String doctorEmail = (String) session.getAttribute("email");
                Connection conn = null;
                PreparedStatement pstm = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/minorproject";
                    String uid="root";
                    String upass="1234";
                    conn=DriverManager.getConnection(url,uid,upass);
                    
                    pstm = conn.prepareStatement("SELECT username from patients where email = ?");
                    pstm.setString(1, doctorEmail);
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        username = rs.getString("username");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } 
                
                if(username != null && !username.trim().isEmpty()) {
            %>
<aside class="side-bar">
  <div class="user-info">
    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
         stroke="currentColor"
         stroke-width="1" stroke-linecap="round" stroke-linejoin="round" class="user-avatar">
      <circle cx="12" cy="8" r="5"/>
      <path d="M20 21a8 8 0 0 0-16 0"/>
    </svg>
        <p><%= username != null && !username.trim().isEmpty() ? username : "Not Logged In" %></p>
  </div>
  <ul class="siderbar-navlinks">
    <li>
      <a href="panel.jsp">
        <div class="icon">📊</div>
        Dashboard
      </a>
    </li>
    <li>
      <a href="doctor.jsp">
        <div class="icon">👨‍⚕️</div>
        Doctors
      </a>
    </li>
    <li>
      <a href="booking.jsp">
        <div class="icon">📆</div>
        Bookings
      </a>
    </li>
    <li>
      <a href="appointments.jsp">
        <div class="icon">📅</div>
        Appointments
      </a>
    </li>
  </ul>
</aside>
<main>
  <div class="top-heading">
    <h4 class="panel-heading">Completed Appointments</h4>
  </div>
  <div class="container">
    <table class="appointment-table">
      <caption>📱 Appointment Summary</caption>
      <thead>
      <tr>
                <th>Session ID</th>
                <th>Appointment ID</th>
                <th>Specialist</th>
                <th>Doctor Name</th> 
                <th>Doctor Mail</th>
                <th>Date</th>
      </tr>
      </thead>
      <tbody>
    <%
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/minorproject";
        String uid="root";
        String upass="1234";
        conn=DriverManager.getConnection(url,uid,upass);
        pstm = conn.prepareStatement("SELECT "+ 
        "s.id AS `sessionid`, s.name as `session_name`, " +
        "a.id AS `appointmentid`, a.date AS `app_date`, " +
        "d.username AS `doctor_name`, d.email AS `doctor_email` " +
        "FROM appointments a " +
    	"INNER JOIN " +
	    "doctors d ON a.doctor_id = d.id " +
	"INNER JOIN " +
	    "patients p ON a.patient_id = p.id " +
	"INNER JOIN " +
	    "schedule s ON a.schedule = s.id " +
	"WHERE " +
        "p.email = ? AND a.status = 'completed'" +
    "ORDER BY " +
        "a.id ASC;");
        
        pstm.setString(1, doctorEmail);
        rs = pstm.executeQuery();
        while (rs.next()) {
        	
        	int session_id = rs.getInt("sessionid");
        	int appointment_id = rs.getInt("appointmentid");
        	String session_name =  rs.getString("session_name");
        	String doctor_name = rs.getString("doctor_name");
        	String doctor_email = rs.getString("doctor_email");  
        	Timestamp app_date = rs.getTimestamp("app_date");
        	 String formattedDate = sdf.format(app_date);
    %>
      <tr>
           <td><%= session_id %></td>
                <td><%= appointment_id %></td>
                <td><%= session_name %></td>
                <td><%= doctor_name %></td>
                <td><%= doctor_email %></td>
                <td><%= formattedDate %></td>
      </tr>
       <% } 
                    } catch (Exception e) {
                 e.printStackTrace(); %>
                 <tr>
                    <td colspan="7" style="color:red;">Error retrieving sessions</td>
                </tr>
            <% } %>
      </tbody>
    </table>
  </div>
</main>
<% } else { %>

 <div class="errordiv">
 	<h1>Login</h1>
 		<a href="<%= request.getContextPath() %>/login.jsp">Go to Login Page</a>
 </div>

<% } %>
</body>
</html>