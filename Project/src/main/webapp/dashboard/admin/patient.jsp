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
        <h4 class="panel-heading">Patient List</h4>
    </div>
    <div class="container">
        <table class="appointment-table">
            <caption>😷 Patients</caption>
            <thead>
            <tr>
            	<th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Ph No</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
                  <%   try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url="jdbc:mysql://localhost:3306/minorproject";
           String uid="root";
           String upass="1234";
           conn=DriverManager.getConnection(url,uid,upass);
           pstm = conn.prepareStatement("SELECT id, username, email, phno FROM patients;");
           rs = pstm.executeQuery();          
           while (rs.next()) {
        	   int patient_id = rs.getInt("id");
               String patient_username = rs.getString("username");
               String patient_email = rs.getString("email");
               String phno = rs.getString("phno");
              
   				 %>
            <tr>
                <td><%= patient_id %></td>
                <td><%= patient_username %></td>
                <td><%= patient_email %></td>
                <td><%= phno %></td>
                <td><form action="<%=request.getContextPath()%>/RemoveRecordServlet" method="post">
                	<input type="hidden" name="type" value="patient"/>
                     <input type="hidden" name="session_id" value="<%= patient_id %>"/>
                   <button type="submit" class="delete-button">Delete</button>
                  </form></td>
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