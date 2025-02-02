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
        <h4 class="panel-heading">Bookings</h4>
    </div>
    <div class="bookings-container">

    <%
    
    
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/minorproject";
        String uid="root";
        String upass="1234";
        conn=DriverManager.getConnection(url,uid,upass);

        pstm = conn.prepareStatement("SELECT a.id AS appointment_id, " +
        	       "d.username AS doctor_username, " +
        	       "d.specialist, " +
        	       "s.start_time, " +
        	       "s.end_time, " +
        	       "s.week " +
        	"FROM appointments a " +
        	"JOIN patients p ON a.patient_id = p.id " +
        	"JOIN doctors d ON a.doctor_id = d.id " +
        	"JOIN schedule s ON a.schedule = s.id " +
        	"WHERE p.email = ? AND a.status = 'booked'; ");
        
        pstm.setString(1, doctorEmail);
        rs = pstm.executeQuery();
        
        while(rs.next()) {
        	String appointment_id = rs.getString("appointment_id");
        	String doctor_name = rs.getString("doctor_username");
            String specialist = rs.getString("specialist");
            String start_time = rs.getString("start_time");
            String end_time = rs.getString("end_time");
            int week = rs.getInt("week");
            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            String dayName = (week >= 1 && week <= 7) ? days[week - 1] : "Unknown Day";
    
    %>
        <div class="bookings-card">
            <h1>Reference Number : <%= appointment_id %></h1>
            <h2>Session Name</h2>
            <h3><span class="highlight-text">Doctor:</span> <%= doctor_name %></h3>
            <h3><span class="highlight-text">Specialist:</span> <%= specialist %></h3>
            <h3><span class="highlight-text">Day:</span> <%= dayName %></h3>
            <h4><span class="highlight-text">Time Slot:</span>[ <%= start_time %> - <%= end_time %>]</h4>     
            <form method="post" action="<%=request.getContextPath()%>/DeleteAppointment">
            <input type="hidden" name="appointment_id" value="<%= appointment_id %>">
            <button type="submit" class="add-button">Cancel Booking</button>
            </form>
        </div>
        <% } 
        
    }catch (Exception e) {
            e.printStackTrace(); 
            }

%>
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