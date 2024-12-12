<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../css/patient-panel.css">
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
        <p>Patient</p>
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
            <a href="bookings.jsp">
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
    <h4 class="panel-heading">Status</h4>
        <% 
    
    int Doctors = 0;
    int Patient = 0;
    int Bookings = 0;
    int Appointments = 0;
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
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
       pstm = conn.prepareStatement("select count(*) from schedule");
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Bookings = rs.getInt(1);
       }
       pstm = conn.prepareStatement("select count(*) from appointments");
       rs = pstm.executeQuery();
       while (rs.next()) {
    	   Appointments = rs.getInt(1);
       }
       
      
    %>
    <div class="stats-container">
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
            <div class="stats-label">New Bookings</div>
        </div>

        <div class="stats-card sessions">
            <div class="stats-icon">🩺</div>
            <div class="stats-number"><%= Appointments %></div>
            <div class="stats-label">Total Sessions</div>
        </div>
    </div>
        <%

} catch (Exception e) {
	System.out.println(e);
}

%>

    <div class="container">
        <table class="appointment-table">
            <caption>📋 Upcoming Appointments</caption>
            <thead>
            <tr>
                <th>Appointment No</th>
                <th>Doctor Name</th>
                <th>Sepcialist</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Shirt</td>
                <td>$20</td>
                <td>10</td>
                <td>$200</td>
            </tr>
            <tr>
                <td>Pants</td>
                <td>$30</td>
                <td>5</td>
                <td>$150</td>
            </tr>
            <tr>
                <td>Shoes</td>
                <td>$50</td>
                <td>2</td>
                <td>$100</td>
            </tr>
            <tr>
                <td>Shoes</td>
                <td>$50</td>
                <td>2</td>
                <td>$100</td>
            </tr>
            <tr>
                <td>Shoes</td>
                <td>$50</td>
                <td>2</td>
                <td>$100</td>
            </tr>
            <tr>
                <td>Shoes</td>
                <td>$50</td>
                <td>2</td>
                <td>$100</td>
            </tr>
            </tbody>
        </table>

    </div>
</main>
</body>
</html>