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
    <link rel="stylesheet" href="../../css/doctor-panel.css">
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
                    
                    pstm = conn.prepareStatement("SELECT username from doctors where email = ?");
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
            <a href="schedule.jsp">
                <div class="icon">📆</div>
                Schedule
            </a>
        </li>
        <li>
            <a href="appointments.jsp">
                <div class="icon">📅</div>
                Appointments
            </a>
        </li>
        <li>
            <a href="patients.jsp">
                <div class="icon">🏥</div>
                Patients
            </a>
        </li>
    </ul>
</aside>
<main>
 <% 
            String success = request.getParameter("success");
            if ("true".equalsIgnoreCase(success)) {
        %>
                <div class="alert alert-success">
                    Operation completed successfully.
                </div>
        <% 
            }
        %>
        <% 
            String error = request.getParameter("error");
            if ("true".equalsIgnoreCase(error)) {
        %>
                <div class="alert alert-danger">
                    An error occurred while processing your request.
                </div>
        <% 
            }
        %>
    <div class="top-heading">
        <h4 class="panel-heading">Patient List</h4>
    </div>
    <div class="container">
        <table class="appointment-table">
            <caption>😷 Recent Patients</caption>
            <thead>
            <tr>
            	<th>Session ID</th>
            	<th>Appointment ID</th>
                <th>Session Name</th>
                <th>Patients Name</th>
                <th>Phone Number</th>
                <th>Patients Email</th>               
                <th>App Status</th>
            </tr>
            </thead>
            <tbody>
              <%
           
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/minorproject";
                    String uid="root";
                    String upass="1234";
                    conn=DriverManager.getConnection(url,uid,upass);
                    pstm = conn.prepareStatement("SELECT "+ 
                    "s.id AS `sessionid`, s.name as `session_name`, " +
                    "a.id AS `appointmentid`, a.status AS `app_status`, " +
                    "p.username AS `patient_name`, p.email AS `patient_email`, p.phno AS `patient_phno` " +
                    "FROM appointments a " +
                	"INNER JOIN " +
            	    "doctors d ON a.doctor_id = d.id " +
            	"INNER JOIN " +
            	    "patients p ON a.patient_id = p.id " +
            	"INNER JOIN " +
            	    "schedule s ON a.schedule = s.id " +
            	"WHERE " +
                    "d.email = ? " +
                "ORDER BY " +
                    "a.id ASC;");
                    
                    pstm.setString(1, doctorEmail);
                    rs = pstm.executeQuery();
                    while (rs.next()) {
                    	
                    	int session_id = rs.getInt("sessionid");
                    	int appointment_id = rs.getInt("appointmentid");
                    	String app_status =  rs.getString("app_status");
                    	String session_name =  rs.getString("session_name");
                    	String patient_name = rs.getString("patient_name");
                    	String patient_phno = rs.getString("patient_phno");
                    	String patient_email = rs.getString("patient_email");
                    	   String statusEmoji;
                         if ("completed".equalsIgnoreCase(app_status)) {
                               statusEmoji = "✅"; // White heavy check mark
                           } else if ("canceled".equalsIgnoreCase(app_status)) {
                               statusEmoji = "❌"; // Cross mark
                           } else {
                               statusEmoji = "❓"; // Question mark for unknown status
                           }
                    	
                   %>    
            <tr>
                <td><%= session_id %></td>
                <td><%= appointment_id %></td>
                <td><%= session_name %></td>
                <td><%= patient_name %></td>
                 <td><%= patient_phno %></td>
                <td><%= patient_email %></td>
                <td><%= statusEmoji %></td>
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