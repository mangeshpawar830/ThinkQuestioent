<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.tqbank.pojo.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>www.tqbank.com</title>
    <style>
        body {
            background-image: url('/TQ_Bank/Images/registration.jpg');
            background-repeat: no-repeat;
            background-size: 100% 1100px;
        }

        #user-details-container {
            background-color: white;
            width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid rgb(107, 148, 230);
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid rgb(107, 148, 230);
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<% 
    User u = (User) session.getAttribute("udetails");
%>
<jsp:include page="Header.jsp"></jsp:include>
<div id="user-details-container">
    <h1 align="center">User Details</h1>
    <table>
      
        <tr>
            <th>Name</th>
            <td><%= u.getName() %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%= u.getEmail() %></td>
        </tr>
        <tr>
            <th>Phone Number</th>
            <td><%= u.getPhoneNo() %></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><%= u.getPassword() %></td>
        </tr>
        <tr>
            <th>Role</th>
            <td><%= u.getRole() %></td>
        </tr>
    </table>
</div>
</body>
</html>
