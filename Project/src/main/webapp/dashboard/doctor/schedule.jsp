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
            String success = request.getParameter("sucess");
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
        <h4 class="panel-heading">Session Manager</h4>
        <a href="schedule/create.jsp"><button class="add-button">+ Add Session</button></a>
    </div>
    <div class="container">
        <table class="appointment-table">
            <caption>📱 All Sessions</caption>
            <thead>
            <tr>
                <th>Session Name</th>
                <th>Description</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Week</th>
                <th>Action</th>
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
                    
                    pstm = conn.prepareStatement("SELECT s.id, s.name, s.description, s.start_time, s.end_time, s.week " +
                            "FROM schedule s " +
                            "JOIN doctors d ON s.doctor_id = d.id " +
                            "WHERE d.email = ?");
             
                    pstm.setString(1, doctorEmail);
                    rs = pstm.executeQuery();
                    
                    while (rs.next()) {
                    	int sessionId = rs.getInt("id");
                        String sessionName = rs.getString("name");
                        String description = rs.getString("description");
                        String startTime = rs.getString("start_time");
                        String endTime = rs.getString("end_time");
                        String formattedStartTime = startTime.substring(0, 5);
                        String formattedEndTime = endTime.substring(0, 5);
                        int week = rs.getInt("week");
                        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                        String dayName = (week >= 1 && week <= 7) ? days[week - 1] : "Unknown Day";
                    %>
                    <tr>
                    <td><%= sessionName %></td>
                    <td><%= (description != null) ? description : "" %></td>
                     <td><%= formattedStartTime %></td>
                    <td><%= formattedEndTime %></td>
                    <td><%= dayName %></td>
                    <td>
                        <!-- <button class="edit-button">Edit</button>  -->
                        <form action="<%=request.getContextPath()%>/RemoveSessionServlet" method="post">
                          <input type="hidden" name="session_id" value="<%= sessionId %>"/>
                          <button type="submit" class="delete-button">Delete</button>
                        </form>
                    </td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                  %>
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