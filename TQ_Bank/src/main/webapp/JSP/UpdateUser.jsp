<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.tqbank.pojo.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update User Details</title>
    <style>
        body {
            background-color: #f0f5fc; /* Light blue background color */
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        #user-container {
            background-color: #e3eaf8; /* Light blue-gray container background color */
            margin: 50px auto;
            max-width: 400px;
            padding: 20px;
            border: 1px solid rgb(107, 148, 230);
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .btn-save {
            background-color: #4caf50; /* Green button color */
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-save:hover {
            background-color: #45a049; /* Darker green on hover */
        }
    </style>
</head>
<body>
<%
User u=(User)session.getAttribute("udetails");
%>
<jsp:include page="Header.jsp"></jsp:include>
<div id="user-container">
    <h1>User Details</h1>
    <form action="/TQ_Bank/userc" method="post">
        <input type="hidden" name="action" value="update">
        <div class="form-group">
            <label for="userid">ID</label>
            <input type="text" id="userid" name="userid" value="<%= u.getUser_id() %>" readonly>
        </div>
        <div class="form-group">
            <label for="username">Name</label>
            <input type="text" id="username" name="username" value="<%= u.getName() %>">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" value="<%= u.getEmail() %>">
        </div>
        <div class="form-group">
            <label for="phoneNo">Phone No</label>
            <input type="text" id="phoneNo" name="phoneNo" value="<%= u.getPhoneNo() %>">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="text" id="password" name="password" value="<%= u.getPassword() %>">
        </div>
        <div class="form-group">
            <label for="role">Role</label>
            <input type="text" id="role" name="role" value="<%= u.getRole() %>" readonly>
        </div>
        
        
        <div class="text-center">
            <button type="submit" class="btn-save">Save</button>
        </div>
    </form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
