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
  <link rel="stylesheet" href="../../css/admin-panel.css">
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
    
    pstm = conn.prepareStatement("SELECT id, username from admins where email = ?");
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
      <a href="doctor.jsp">
        <div class="icon">👨‍⚕️</div>
        Doctors
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
      <a href="patient.jsp">
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

        <!-- Error Message -->
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
    <h4 class="panel-heading">Appointments Viewer</h4>
  </div>
  <div class="container">
    <table class="appointment-table">
      <caption>📱 Appointment Summary</caption>
      <thead>
      <tr>
        <th>Session Name</th>
        <th>Doctor</th>
        <th>Date</th>
        <th>Time</th>
        <th>Patient Name</th>
        <th>Status</th>
        <th>Action</th>
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
          pstm = conn.prepareStatement("SELECT " + 
        		    "s.name AS session_name, " +
        		    "d.username AS doctor_name, " +
        		    "s.end_time, s.start_time, " +
        		    "p.username AS patient_name, " +
        		    "a.status, a.date, a.id AS `appointment_id` " + 
        		    "FROM " +
        		    "appointments a " +
        		"INNER JOIN " +
        		    "schedule s ON a.schedule = s.id " +
        		"INNER JOIN " +
        		    "doctors d ON a.doctor_id = d.id " +
        		"INNER JOIN " +
        		    "patients p ON a.patient_id = p.id " +
        		"ORDER BY " +
        		    "a.date ASC; "		
        		  );     
               	rs = pstm.executeQuery();
                  
                  while (rs.next()) {
                	  String appointment_id = rs.getString("appointment_id");
                      String sessionName = rs.getString("session_name");
                      String doctorName = rs.getString("doctor_name");
                      Timestamp appDateTimestamp = rs.getTimestamp("date");
                      String formattedDate = sdf.format(appDateTimestamp);
                      String startTime = rs.getString("start_time").substring(0, 5);
                      String endTime = rs.getString("end_time").substring(0, 5);
                      String patientName = rs.getString("patient_name");
                      String appStatus = rs.getString("status");
                      
                      // Convert appointment status to corresponding emoji
                      String statusEmoji;
                      if(appStatus.equalsIgnoreCase("booked")) {
                          statusEmoji = "📅"; // Calendar emoji for booked
                      } else if(appStatus.equalsIgnoreCase("completed")) {
                          statusEmoji = "✅"; // Check mark for completed
                      } else if(appStatus.equalsIgnoreCase("canceled")) {
                          statusEmoji = "❌"; // Cross mark for canceled
                      } else {
                          statusEmoji = appStatus; // Fallback to text if status is unrecognized
                      }
          %>
              <tr>
                  <td><%= sessionName %></td>
                  <td><%= doctorName %></td>
                  <td><%= formattedDate %></td>
                  <td><%= startTime %> - <%= endTime %></td>
                  <td><%= patientName %></td>
                  <td><%= statusEmoji %></td>
                  <td>
                     <div class="session-form">
                     <form action="<%=request.getContextPath()%>/UpdateStatusServlet" method="post" class="form-group">
                         <input type="hidden" name="appointment_id" value="<%= appointment_id %>">
                         <select name="new_status" onchange="this.form.submit()" required>
                             <option value="">--Select Status--</option>
                             <option value="booked" <%= "booked".equalsIgnoreCase(appStatus) ? "selected" : "" %>>Booked 📅</option>
                             <option value="completed" <%= "completed".equalsIgnoreCase(appStatus) ? "selected" : "" %>>Completed ✅</option>
                             <option value="canceled" <%= "canceled".equalsIgnoreCase(appStatus) ? "selected" : "" %>>Canceled ❌</option>
                         </select>
                     </form>
                     </div>
                      </td>
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