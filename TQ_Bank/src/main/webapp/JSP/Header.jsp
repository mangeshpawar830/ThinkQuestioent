<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.tqbank.com</title>
<style>
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-size: cover;
}

#header {
    background-color: #333;
    color: #fff;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    padding: 10px 0;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.logo {
    font-size: 24px;
    font-weight: bold;
}

.nav-menu {
    list-style: none;
    margin: 0;
    padding: 0;
    display: flex;
}

.nav-menu li {
    margin-right: 20px;
}

.nav-menu li:last-child {
    margin-right: 0;
}

.nav-menu a {
    text-decoration: none;
    color: #fff;
    font-size: 16px;
    transition: color 0.3s;
}

.nav-menu a:hover {
    color: #ff6600; /* Change to your desired hover color */
}

.user-info {
    color: #ff6600; /* Change to your desired text color */
    font-size: 16px;
}
</style>

</head>
<body>
<%
String utype=(String)session.getAttribute("utype");
String uname=(String)session.getAttribute("uname");
%>
<div id="header">
    <div class="container">
        <div class="logo">www.tqbank.com</div>
        <ul class="nav-menu">
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact Us</a></li>
            <li><a href="#">Services</a></li>
            <% if (utype == null) { %>
                <li><a href="JSP/Login.jsp">Login Here</a></li>
            <% } if (utype != null) { %>
                <li><a href="/TQ_Bank/loginc">Logout</a></li>
            <% } if (utype != null && utype.equals("admin")) { %>
                <li><a href="/TQ_Bank/userc">Customer List</a></li>
                <li><a href="JSP/Register.jsp">Add User</a></li>
                <li><a href="#">View Transaction</a></li>
            <% } if (utype != null && utype.equals("user")) { %>
                <li><a href="/TQ_Bank/userc?action=profile&uname=<%=uname%>">Profile</a></li>
                <li><a href="/TQ_Bank/JSP/transcation.jsp">Transaction</a></li>
                <li><a href="#">Payee</a></li>
                <li><a href="/TQ_Bank/accountc">Account</a></li>
            <% } %>
        </ul>
        <% if (uname != null) { %>
            <div class="user-info"><%= uname %></div>
        <% } %>
    </div>
</div>
</body>
</html>
