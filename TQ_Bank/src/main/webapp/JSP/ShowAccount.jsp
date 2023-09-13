<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tqbank.pojo.Account"%>
<<!-- JSP/ShowAccount.jsp -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #007bff;
            color: white;
            text-align: center;
            padding: 20px;
        }

        h1 {
            margin-top: 20px;
            text-align: center;
        }

        table {
            border-collapse: collapse;
            margin: 0 auto;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        p {
            text-align: center;
        }
    </style>
</head>
<body>
    <header>
        <h1>Account Details</h1>
    </header>
    <div class="container">
        <%
            com.tqbank.pojo.Account acc = (com.tqbank.pojo.Account) session.getAttribute("accdetails");
            String msg = (String) request.getAttribute("msg");
            if (acc != null) {
        %>
        <table>
            <tr>
                <td>Account Number:</td>
                <td><%= acc.getAcc_no() %></td>
            </tr>
            <tr>
                <td>Account Holder Name:</td>
                <td><%= acc.getUser_id() %></td>
            </tr>
            <tr>
                <td>Account Type:</td>
                <td><%= acc.getAcc_type() %></td>
            </tr>
            <tr>
                <td>Account Balance:</td>
                <td><%= acc.getBalance() %></td>
            </tr>
            
        </table>
                 <td><a href="/TQ_Bank/accountc?action=deposit&userid=<%= acc.getUser_id() %>" class="btn btn-success">Deposit</a></td>
        
        <%
            } else if (msg != null) {
        %>
        <p><%= msg %></p>
        <%
            }
        %>
    </div>
</body>
</html>
