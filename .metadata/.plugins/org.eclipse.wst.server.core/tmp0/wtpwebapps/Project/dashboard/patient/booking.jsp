<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="top-heading">
        <h4 class="panel-heading">Bookings</h4>
    </div>
    <div class="bookings-container">
        <div class="bookings-card">
            <h1>Reference Number : 0C-001</h1>
            <h2>Session Name</h2>
            <h3><span class="highlight-text">Booking Date:</span> 12/1/2024</h3>
            <h3><span class="highlight-text">Doctor:</span> Dr. John Doe</h3>
            <h4><span class="highlight-text">Schedule Date:</span> 13/2/2024</h4>
            <h4><span class="highlight-text">Schedule Time:</span> 10:00 AM</h4>
            <button class="add-button">Cancel Booking</button>
        </div>
    </div>
</main>
</body>
</html>