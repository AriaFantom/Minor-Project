<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../css/admin-panel.css">
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
        <p>Admin</p>
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
      <a href="patients.jsp">
        <div class="icon">🏥</div>
        Patients
      </a>
    </li>
    </ul>
</aside>
<main>
    <div class="top-heading">
        <h4 class="panel-heading">Doctors List</h4>
        <button class="add-button">+ Add New Doctor</button>
    </div>
    <div class="container">
        <table class="appointment-table">
            <caption>🧑‍⚕️ Current Doctors</caption>
            <thead>
            <tr>
                <th>Doctor Name</th>
                <th>Email</th>
                <th>Specialities</th>
                <th>Actions</th>
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