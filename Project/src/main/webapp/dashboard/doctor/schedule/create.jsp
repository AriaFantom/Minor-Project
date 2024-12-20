<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../../css/doctor-panel.css">
    
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
        <p>Doctor</p>
    </div>
    <ul class="siderbar-navlinks">
        <li>
            <a href="../panel.jsp">
                <div class="icon">📊</div>
                Dashboard
            </a>
        </li>
        <li>
            <a href="../schedule.jsp">
                <div class="icon">📆</div>
                Schedule
            </a>
        </li>
        <li>
            <a href="../appointments.jsp">
                <div class="icon">📅</div>
                Appointments
            </a>
        </li>
        <li>
            <a href="../patients.jsp">
                <div class="icon">🏥</div>
                Patients
            </a>
        </li>
    </ul>
</aside>
<main>
    <div class="top-heading">
        <h4 class="panel-heading">Session Adding</h4>
    </div>
    
    <div class="session-form-container">
    <form action="<%=request.getContextPath()%>/AddSessionServlet" method="post" class="session-form">
        <input type="hidden" name="doctor_id" value="${sessionScope.email}">
        
        
        <div class="form-group">
            <label for="name">Session Name:</label>
            <input type="text" id="name" name="name" required 
                   maxlength="100" 
                   placeholder="Enter session name">
        </div>
        
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" 
                      maxlength="500" 
                      placeholder="Enter session description"></textarea>
        </div>
        
        <div class="form-group">
            <label for="start_time">Start Time:</label>
            <input type="time" id="start_time" name="start_time" required>
        </div>
        
        <div class="form-group">
            <label for="end_time">End Time:</label>
            <input type="time" id="end_time" name="end_time" required>
        </div>
        
               <div class="form-group">
            <label for="week">Day of Week:</label>
            <select id="week" name="week" required>
                <option value="">Select a Day</option>
                <option value="1">Monday</option>
                <option value="2">Tuesday</option>
                <option value="3">Wednesday</option>
                <option value="4">Thursday</option>
                <option value="5">Friday</option>
                <option value="6">Saturday</option>
                <option value="7">Sunday</option>
            </select>
        </div>
        
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Add Session</button>
            <button type="reset" class="btn btn-secondary">Reset</button>
        </div>
    </form>
</div>
</main>
</body>
</html>