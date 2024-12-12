<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.healthify.dao.Doctor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Search Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        .result-container {
            background-color: #f4f4f4;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .not-found {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="result-container">
        <%
            Doctor doctor = (Doctor)request.getAttribute("doctor");
            if (doctor != null) {
        %>
            <h2>Doctor Found</h2>
            <p><strong>Username:</strong> <%= doctor.getUsername() %></p>
            <p><strong>Specialist:</strong> <%= doctor.getSpecialist() %></p>
        <%
            } else {
        %>
            <h2 class="not-found">Doctor Not Found</h2>
            <p class="not-found">No doctor found with the provided username.</p>
        <%
            }
        %>
    </div>
</body>
</html>