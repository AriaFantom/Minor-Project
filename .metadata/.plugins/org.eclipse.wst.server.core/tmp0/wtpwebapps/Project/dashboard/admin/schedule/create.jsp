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
    <link rel="stylesheet" href="../../../css/doctor-panel.css">
    
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
                    
                    pstm = conn.prepareStatement("SELECT username from admins where email = ?");
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
      <a href="../panel.jsp">
        <div class="icon">📊</div>
        Dashboard
      </a>
    </li>
    <li>
      <a href="../doctor.jsp">
        <div class="icon">👨‍⚕️</div>
        Doctors
      </a>
    </li>
    <li>
      <a href="../schedule.jsp">
                <div class="icon">📆</div>
                Schedule
            </a>
    </li>
    <li>
      <a href="../appointments.jsp">
        <div class="icon">📅</div>
        Appointments
      </a>
    </li>
    <li>
      <a href="../patient.jsp">
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
        <h4 class="panel-heading">Session Adding</h4>
    </div>
    
    <div class="session-form-container">
    <form action="<%=request.getContextPath()%>/AddSessionServlet" method="post" class="session-form">
    
    
        <div class="form-group">
        <label for="description">Select Doctor:</label>
         <select name="doctor_id" id="doctor_id" required>
        <option value="">-- Select Doctor --</option>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/minorproject";
                String uid = "root";
                String upass = "1234";
                
                conn = DriverManager.getConnection(url, uid, upass);
                String sql = "SELECT email, username FROM doctors ORDER BY username ASC";
                
                pstm = conn.prepareStatement(sql);
                rs = pstm.executeQuery();
                
                while(rs.next()) {
                    String doctorName = rs.getString("username");
                    String dEmail = rs.getString("email");
        %>
                    <option value="<%= dEmail %>"><%= doctorName %></option>
        <%
                }
                rs.close();
                pstm.close();
                conn.close();
            } catch(Exception e) {
                e.printStackTrace();
        %>
                <option value="">Error loading doctors</option>
        <%
            }
        %>
    </select>
        </div>
        
        
        <div class="form-group">
            <label for="name">Session Name:</label>
            <input type="text" id="name" name="name" required 
                   maxlength="100" 
                   placeholder="Enter session name">
        </div>
        
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" 
                      maxlength="500" 
                      placeholder="Enter session description"></textarea>
        </div>
        
        <div class="form-group">
            <label for="start_time">Start Time:</label>
            <input type="time" id="start_time" name="start_time" required>
        </div>
        
        <div class="form-group">
            <label for="end_time">End Time:</label>
            <input type="time" id="end_time" name="end_time" required>
        </div>
        
               <div class="form-group">
            <label for="week">Day of Week:</label>
            <select id="week" name="week" required>
                <option value="">Select a Day</option>
                <option value="1">Monday</option>
                <option value="2">Tuesday</option>
                <option value="3">Wednesday</option>
                <option value="4">Thursday</option>
                <option value="5">Friday</option>
                <option value="6">Saturday</option>
                <option value="7">Sunday</option>
            </select>
        </div>
        
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Add Session</button>
            <button type="reset" class="btn btn-secondary">Reset</button>
        </div>
    </form>
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