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
    			String user_id = "";
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
                    
                    pstm = conn.prepareStatement("SELECT id, username from patients where email = ?");
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
        <h4 class="panel-heading">Doctors List</h4>
    </div>

     
     <!-- Doctors container  --> 
     
     <div class="doctors-container">
<%
    PreparedStatement pstm2 = null;
    ResultSet rs2 = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/minorproject";
        String uid="root";
        String upass="1234";
        conn=DriverManager.getConnection(url,uid,upass);

        pstm = conn.prepareStatement("SELECT id, username, specialist FROM doctors");
        rs = pstm.executeQuery();

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("username");
            String specialist = rs.getString("specialist");

            pstm2 = conn.prepareStatement("SELECT id, week, start_time, end_time FROM schedule WHERE doctor_id = ?");
            pstm2.setString(1, id);
            rs2 = pstm2.executeQuery();
%>
    <div>
        <div class="doctor-card">
            <div class="doctor-avatar">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" 
                     viewBox="0 0 24 24" fill="none" stroke="currentColor"
                     stroke-width="1" stroke-linecap="round" 
                     stroke-linejoin="round" class="user-avatar">
                    <circle cx="12" cy="8" r="5"/>
                    <path d="M20 21a8 8 0 0 0-16 0"/>
                </svg>
            </div>

            <div class="doctor-info">
                <h2><%= name %></h2>
                <h4><%= specialist %></h4>
                <div class="slots-container">
                    <p class="slots-label">Available Slots:</p>
                    <%
                        if (rs2.next()) {
                    %>
                    <form action="<%=request.getContextPath()%>/BookAppointment" method="post">
                    
                        <input type="hidden" name="doctor_id" value="<%= id %>">
                        <input type="hidden" name="patient_id" value="<%= user_id %>">

                        <select name="session_id" class="slots-select">
                            <%
                                do {
                                    String scheduleId = rs2.getString("id");
                                    int week = rs2.getInt("week");
                                    String startTime = rs2.getString("start_time");
                                    String endTime = rs2.getString("end_time");

                                    String dayName;
                                    switch (week) {
                                        case 1: dayName = "Monday"; break;
                                        case 2: dayName = "Tuesday"; break;
                                        case 3: dayName = "Wednesday"; break;
                                        case 4: dayName = "Thursday"; break;
                                        case 5: dayName = "Friday"; break;
                                        case 6: dayName = "Saturday"; break;
                                        case 7: dayName = "Sunday"; break;
                                        default: dayName = "Unknown"; break;
                                    }
                            %>
                            <option value="<%= scheduleId %>"><%= dayName %> [<%= startTime %> - <%= endTime %>]</option>
                            <%
                                } while (rs2.next());
                            %>
                        </select>
                        <button type="submit" style="margin-top: 20px" class="add-button">Book</button>
                    </form>
                    <%
                        } else {
                    %>
                    <span class="no-schedules">No schedules available.</span>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
<%
        } // end while
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs2 != null) try { rs2.close(); } catch(Exception ignore){}
        if (pstm2 != null) try { pstm2.close(); } catch(Exception ignore){}
        if (rs != null) try { rs.close(); } catch(Exception ignore){}
        if (pstm != null) try { pstm.close(); } catch(Exception ignore){}
        if (conn != null) try { conn.close(); } catch(Exception ignore){}
    }
%>
</div>

<!-- Till here  -->
     
     
</main>
<% } else { %>

 <div class="errordiv">
 	<h1>Login</h1>
 		<a href="<%= request.getContextPath() %>/login.jsp">Go to Login Page</a>
 </div>

<% } %>
</body>
</html>