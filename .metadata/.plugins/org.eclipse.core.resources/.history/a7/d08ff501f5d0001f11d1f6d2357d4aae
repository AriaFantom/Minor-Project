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
  	String user_id = "";
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
                    
                    pstm = conn.prepareStatement("SELECT id, username from doctors where email = ?");
                    pstm.setString(1, doctorEmail);
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                    	user_id = rs.getString("id");
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
    <h4 class="panel-heading">Status</h4>
    <div class="stats-container">
           <% 
    
    int Doctors = 0;
    int Patient = 0;
    int Bookings = 0;
    int Appointments = 0;
    
    try {
   	 Class.forName("com.mysql.cj.jdbc.Driver");
   		String url="jdbc:mysql://localhost:3306/minorproject";
   		String uid="root";
   		String upass="1234";
   		conn=DriverManager.getConnection(url,uid,upass);
     
       pstm = conn.prepareStatement("select count(*) from patients");
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Patient = rs.getInt(1);
       }
       pstm = conn.prepareStatement("select count(*) from doctors");
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Doctors = rs.getInt(1);
       }
       pstm = conn.prepareStatement("select count(*) from schedule where doctor_id = ?");
       pstm.setString(1, user_id);
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Bookings = rs.getInt(1);
       }
       pstm = conn.prepareStatement("select count(*) from appointments where doctor_id = ?");
       pstm.setString(1, user_id);
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Appointments = rs.getInt(1);
       }
       
      
    %>
          <div class="stats-card doctors">
            <div class="stats-icon">👩‍⚕️</div>
            <div class="stats-number"><%= Doctors %></div>
            <div class="stats-label">Doctors</div>
        </div>

        <div class="stats-card patients">
            <div class="stats-icon">🏥</div>
            <div class="stats-number"><%= Patient %></div>
            <div class="stats-label">Patients</div>
        </div>

        <div class="stats-card bookings">
            <div class="stats-icon">📅</div>
            <div class="stats-number"><%= Bookings %></div>
            <div class="stats-label">Total Schedules</div>
        </div>

        <div class="stats-card sessions">
            <div class="stats-icon">🩺</div>
            <div class="stats-number"><%= Appointments %></div>
            <div class="stats-label">Total Sessions</div>
        </div>
                <%

} catch (Exception e) {
	System.out.println(e);
}

%>
    </div>

    <div class="container">
        <table class="appointment-table">
            <caption>📋 Upcoming Appointments</caption>
            <thead>
            <tr>
                <th>Appointment No</th>
                <th>Time</th>
                <th>Patient Name</th>
                <th>Session</th>
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
        	        "a.id AS `appointmentid`, " +
        	        "d.username AS `doctor_name`, d.specialist AS `doctor_specialist`, " +
        	        "a.date AS `app_date` " +
        	        "FROM appointments a " +
        	    	"INNER JOIN " +
        		    "doctors d ON a.doctor_id = d.id " +
        		"INNER JOIN " +
        		    "patients p ON a.patient_id = p.id " +
        		"INNER JOIN " +
        		    "schedule s ON a.schedule = s.id " +
        		"WHERE " +
        	        "d.email = ? AND a.status = 'booked'" +
        	    "ORDER BY " +
        	        "a.id ASC LIMIT 5;");
           pstm.setString(1, doctorEmail);
           rs = pstm.executeQuery();
           
           while (rs.next()) {
        	   int appointment_id = rs.getInt("appointmentid");
            String doctor_name = rs.getString("doctor_name");
            String doctor_specialist = rs.getString("doctor_specialist");
            Timestamp app_date = rs.getTimestamp("app_date");
            java.time.LocalDate appointmentLocalDate = app_date.toLocalDateTime().toLocalDate();
            java.time.LocalDate today = java.time.LocalDate.now();
            long daysLeft = java.time.temporal.ChronoUnit.DAYS.between(today, appointmentLocalDate);
            
            String daysLeftStr;
            if (daysLeft > 0) {
                daysLeftStr = daysLeft + " day(s) left";
            } else if (daysLeft == 0) {
                daysLeftStr = "Today";
            } else {
                daysLeftStr = "Past Appointment";
            }
       %>
            <tr>
                <td><%= appointment_id %></td>
                <td><%= doctor_name %></td>
                <td><%= doctor_specialist %></td>
                <td><%= daysLeftStr  %></td>
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