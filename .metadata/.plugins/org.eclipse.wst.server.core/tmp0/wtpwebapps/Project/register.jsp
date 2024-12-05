<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<main>
    <div class="aside-form">
        <img src="assets/form-side-vector.png" alt="vector">
    </div>
    <div class="form-section">
        <img src="assets/icons/logo.png" alt="logo">
        <p class="form-heading">Registration Form</p>
        <form method="post" action="RegisterServlet">
            <label for="name">Username</label>
            <input type="text" id="name" name="username" placeholder="Enter your name">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="user@mail.com">
            <label for="phno">Phone No</label>
            <input type="number" id="phno" name="phno" placeholder="+91 0000000">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password">
            <label for="confirm-password">Confirm Password</label>
            <input type="password" id="confirm-password" placeholder="Confirm your password">
            <button>Register</button>
        </form>
        <p class="form-footer">Do have an account?<a href="login.jsp"> Sign in </a></p>
    </div>
</main>
</body>
</html>