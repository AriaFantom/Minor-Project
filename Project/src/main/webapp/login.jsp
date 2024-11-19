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
        <p>Login Form</p>
        <form  method="post" action="LoginServlet">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter your email">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password">
            <button>Login</button>
        </form>
    </div>
</main>
</body>
</html>