<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.healthify.dao.Doctor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Search Result</title>
    <link rel="stylesheet" href="css/search.css">
</head>
<body>
    <!-- Header Section with Landscape Image -->
    <div class="header">
        <div class="header-overlay"></div>
        <div class="header-title">Doctor Search Results</div>
    </div>

    <!-- Main Content Section -->
    <div class="content">
        <div class="result-container">
            <%
                Doctor doctor = (Doctor)request.getAttribute("doctor");
                if (doctor != null) {
            %>
                <h2 style="text-align:center; color:#28a745;">Doctor Found</h2>
                <div class="doctor-card">
                    <div class="doctor-image" style="background-image: url('<%=request.getContextPath()%>/images/doctor-placeholder.png');"></div>
                    <div class="doctor-info">
                        <p class="doctor-name"><%= doctor.getUsername() %></p>
                        <p class="doctor-specialist"><strong>Specialization:</strong> <%= doctor.getSpecialist() %></p>
                    </div>
                </div>
                <a href="<%=request.getContextPath()%>/login.jsp" class="back-button">Book Now</a>
            <%
                } else {
            %>
                <h2 class="not-found">Doctor Not Found</h2>
                <p class="not-found">No doctor found with the provided username.</p>
                <a href="<%=request.getContextPath()%>/index.jsp" class="back-button">Back to Home</a>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>
