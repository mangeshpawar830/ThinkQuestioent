<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.tqbank.pojo.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>www.tqbank.com</title>
    <style type="text/css">
        body {
            background-image: url('/TQ_Bank/Images/registration.jpg');
            background-repeat: no-repeat;
            background-size: cover;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            max-width: 1000px;
            margin: 0 auto;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #3366cc; /* Blue header text color */
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #bd8399; /* Header background color */
            color: white; /* Header text color */
        }

        tr:nth-child(even) td {
            background-color: #eaeaf3; /* Even rows background color */
        }

        tr:nth-child(odd) td {
            background-color: #f1f1f8; /* Odd rows background color */
        }

        .btn {
            display: inline-block;
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            background-color: #3366cc; /* Button background color */
            color: white; /* Button text color */
            cursor: pointer;
        }

        .btn-success {
            background-color: #4caf50; /* Success button background color */
        }

        .btn-danger {
            background-color: #f44336; /* Danger button background color */
        }

        .btn:hover {
            background-color: #2e60b0; /* Darker background on hover */
        }

        .text-success {
            color: #4caf50; /* Success text color */
        }
    </style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container">
    <h1>User List</h1>
    <%
        List<User> userlist = (List<User>) session.getAttribute("ulist");
        String msg = (String) request.getAttribute("msg");
        if (msg != null) {
    %>
    <p class="text-center text-success h3"><%= msg %></p>
    <%
        }
    %>
    <table>
        <tr>
            <th>User Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone No</th>
            <th>Role</th>
            <th>Password</th>
            <th colspan="2">Operation</th>
        </tr>
        <% for (User u : userlist) { %>
        <tr>
            <td><%= u.getUser_id() %></td>
            <td><%= u.getName() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getPhoneNo() %></td>
            <td><%= u.getPassword() %></td>
            <td><%= u.getRole() %></td>
            <td><a href="/TQ_Bank/userc?action=edit&userid=<%= u.getUser_id() %>" class="btn btn-success">Update</a></td>
            <td><a href="/TQ_Bank/userc?action=delete&userid=<%= u.getUser_id() %>" class="btn btn-danger">Delete</a></td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
