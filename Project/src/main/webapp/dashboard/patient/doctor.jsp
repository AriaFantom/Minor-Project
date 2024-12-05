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
            <a href="panel.html">
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
        <h4 class="panel-heading">Doctors List</h4>
        <button class="add-button">Book Appointment</button>
    </div>
    <div class="searchbar-header">
        <from>
            <input type="text" placeholder="Search for doctors">
            <button>Search</button>
        </from>
    </div>
    <div class="doctors-container">
        <div>
            <div class="doctor-card">
                <div class="doctor-avatar">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                         stroke="currentColor"
                         stroke-width="1" stroke-linecap="round" stroke-linejoin="round" class="user-avatar">
                        <circle cx="12" cy="8" r="5"/>
                        <path d="M20 21a8 8 0 0 0-16 0"/>
                    </svg>
                </div>
                <div class="doctor-info">
                    <h2>Dr. John Doe</h2>
                    <h4>Cardiologist</h4>
                    <p>Available: 9:00 AM - 5:00 PM</p>
                </div>
                <button style="margin-top: 20px" class="add-button">Book</button>
            </div>
        </div>
    </div>
</main>
</body>
</html>