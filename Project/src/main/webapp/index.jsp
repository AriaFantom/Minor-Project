<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Clinic</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<nav>
    <div class="nav-icon">
        <img class="navlogo" src="assets/icons/logo.png" alt="logo">
        <h2 style="font-size: 40px">Healthify</h2>
    </div>
    <ul>
        <li>Home</li>
        <li>Services</li>
        <li>Doctors</li>
        <li class="btn-nav">
            <a href="register.jsp">
                <button class="btn-signup">Register</button>
            </a>
            <a href="login.jsp">
                <button class="btn-login">Login</button>
            </a>
        </li>
    </ul>
</nav>
<section class="hero">
    <div class="heading">
        <h1>
            Caring for You
            <br>
            Every Step of the Way
        </h1>
        <button class="hero-button">Book an Appointment</button>
    </div>
    <div class="hero-image">
        <img class="images-inside" src="assets/hero.png" alt="hero">
    </div>
</section>
<section class="search-section">
    <form action="SearchDoctor" method="post" class="inner-search">
        <label for="search">Search Doctors</label>
        <input  name="name"  id="search" placeholder="Search here" type="text">
        <button>Search</button>
    </form>
</section>
<section class="function-section">
    <h1>What we Provide</h1>
    <div class="card-container">
        <div class="card">
            <img src="assets/icons/user-round.svg" alt="Experienced Doctors">
            <h3>Experienced Doctors</h3>
            <p>Our team consists of highly trained professionals with years of medical experience.</p>
        </div>

        <div class="card">
            <img src="assets/icons/ambulance.svg" alt="24/7 Emergency Care">
            <h3>24/7 Emergency Care</h3>
            <p>We provide round-the-clock emergency services to ensure you receive immediate care.</p>
        </div>
        <div class="card">
            <img src="assets/icons/hospital.svg" alt="Modern Facilities">
            <h3>Modern Facilities</h3>
            <p>Our clinic is equipped with state-of-the-art medical technology for top-notch care.</p>
        </div>
    </div>
</section>
<section class="doctor-section">
    <h1>Our Doctors</h1>
    <div class="doctor-container">
        <div class="doctor-card shadow">
            <img src="assets/doctor1.png" alt="Doctor 1">
            <h3>Dr. John Doe</h3>
            <p>General Practitioner</p>
        </div>
        <div class="doctor-card shadow">
            <img src="assets/doctor2.jpg" alt="Doctor 2">
            <h3>Dr. Jane Smith</h3>
            <p>Cardiologist</p>
        </div>
        <div class="doctor-card shadow">
            <img src="assets/doctor3.png" alt="Doctor 3">
            <h3>Dr. Michael Johnson</h3>
            <p>Neurologist</p>
        </div>
    </div>
</section>
<footer>
    <div class="footer-top">
        <h2 style="font-size: 30px">Healthify</h2>
    </div>
</footer>
<script src="js/index.js"></script>
</body>
</html>