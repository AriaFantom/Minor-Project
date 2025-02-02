<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<%
	String doctorEmail = "";
	String token = (String) session.getAttribute("token");
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/minorproject";
    String uid="root";
    String upass="1234";
    conn=DriverManager.getConnection(url,uid,upass);
    
    pstm = conn.prepareStatement("SELECT doctor_email from doctor_invites where invite_token = ?");
    pstm.setString(1, token);
    rs = pstm.executeQuery();
    if (rs.next()) {
    	doctorEmail = rs.getString("doctor_email");
        
    }
		} catch (Exception e) {
    		e.printStackTrace();
	} 
	
		if(doctorEmail != null && !doctorEmail.trim().isEmpty()) {
			
	%>
<main>
    <div class="aside-form">
        <img src="assets/form-side-vector.png" alt="vector">
    </div>
    <div class="form-section">
        <img src="assets/icons/logo.png" alt="logo">
        <p>Doctors Registration</p>
        <form  method="post" action="<%=request.getContextPath()%>/AddCredentials">
         <input type="hidden" name="token" value="${token}">
        
        	<label for="email">Email Address</label>
            <input type="email" id="email" name="email" value="<%= doctorEmail %>"  placeholder="Enter your username">
            
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter your username">
            <label for="specialist">Specialist</label>
            <input type="text" id="specialist" name="specialist" placeholder="Enter your specialization">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password">
            <button>Register</button>
        </form>
    </div>
</main>
<% } else { %>

 <div class="errordiv">
 	<h1>Not a valid token</h1>
 		<a href="<%= request.getContextPath() %>/index.jsp">Go to Home Page</a>
 </div>

<% } %>
</body>
</html>