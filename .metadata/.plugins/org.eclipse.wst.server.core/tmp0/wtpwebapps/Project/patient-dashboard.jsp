<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/panel.css">
</head>
<body>
<div class="container">
    <aside class="sidebar">
        <div class="admin-info">
            <img src="https://placehold.co/400" alt="avatar">
            <p class="admin-name">Patient</p>
            <p class="admin-email">admin@edoc.com</p>
            <button class="logout-button">Log out</button>
        </div>
        <hr style="margin: 20px 0"/>
        <nav class="nav-menu">
            <ul>
                <li><a href="patient-panel.html"><img src="assets/icons/text-select.svg" alt="dash"> Dashboard</a></li>
                <li><a href="patient-doctor.html"><img src="assets/icons/clipboard-plus.svg" alt="dash">Booking</a></li>
                <li><a href="#"><img src="assets/icons/file-clock.svg" alt="dash">Reports</a></li>
            </ul>
        </nav>
    </aside>
    <main class="main-content">
        <header class="header">
            <button class="back-button"><img src="assets/icons/move-left.svg" alt="back">Back</button>
            <p class="date">Today's Date <span id="date" ></span></p>
        </header>
        <div class="doctor-panel-bg">
            <img
                    src="assets/bg-patient-panel.jpg"
                    alt="doctor-panel"
                    class=""
            >
            <div class="doctor-panel-bg-text">
                <h1 class="doctor-panel-bg-text-heading">Welcome</h1>
                <h2 class="doctor-panel-bg-text-heading">Jhon Doe.</h2>
                <div>
                    <p>You can manage your details and appointments from this dashboard</p>
                    <p>Track your past session and details from the sidebar</p>
                </div>
            </div>
        </div>
        <h1 class="patient-card-heading">Upcoming Appointments</h1>
        <div class="patient-appointment-container">
            <div class="patient-appointment-cards">
                <h1>Doctors Name</h1>
                <h3>Time <span>11:00 - 12:00</span></h3>
                <h3>Date <span>12/12/2024</span></h3>
                <h3>Location <span>Kolkata</span></h3>
            </div>
        </div>
    </main>
</div>
<script src="js/panel.js"></script>
</body>
</html>