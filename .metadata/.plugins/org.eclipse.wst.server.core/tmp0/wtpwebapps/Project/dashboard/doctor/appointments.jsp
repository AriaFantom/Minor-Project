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
<aside class="side-bar">
    <div class="user-info">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
             stroke="currentColor"
             stroke-width="1" stroke-linecap="round" stroke-linejoin="round" class="user-avatar">
            <circle cx="12" cy="8" r="5"/>
            <path d="M20 21a8 8 0 0 0-16 0"/>
        </svg>
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
            %>
                    		
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
                <th>Max booking</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Shirt</td>
                <td>$20</td>
                <td>10</td>
                <td>$200</td>
                <td>10</td>
                <td>
                    <button class="edit-button">Done</button>
                    <button class="delete-button">Cancel</button>
                </td>
            </tr>
            <tr>
                <td>Pants</td>
                <td>$30</td>
                <td>5</td>
                <td>$150</td>
                <td>10</td>
                <td>
                    <button class="edit-button">Done</button>
                    <button class="delete-button">Cancel</button>
                </td>
            </tr>
            <tr>
                <td>Shoes</td>
                <td>$50</td>
                <td>2</td>
                <td>$100</td>
                <td>10</td>
                <td>
                    <button class="edit-button">Done</button>
                    <button class="delete-button">Cancel</button>
                </td>
            </tr>
            <tr>
                <td>Shoes</td>
                <td>$50</td>
                <td>2</td>
                <td>$100</td>
                <td>10</td>
                <td>
                    <button class="edit-button">Done</button>
                    <button class="delete-button">Cancel</button>
                </td>
            </tr>
            <tr>
                <td>Shoes</td>
                <td>$50</td>
                <td>2</td>
                <td>$100</td>
                <td>10</td>
                <td>
                    <button class="edit-button">Done</button>
                    <button class="delete-button">Cancel</button>
                </td>
            </tr>
            <tr>
                <td>Shoes</td>
                <td>$50</td>
                <td>2</td>
                <td>$100</td>
                <td>10</td>
                <td>
                    <button class="edit-button">Done</button>
                    <button class="delete-button">Cancel</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>