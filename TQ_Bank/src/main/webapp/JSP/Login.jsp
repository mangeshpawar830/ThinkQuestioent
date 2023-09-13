<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TQ Bank</title>
    <style>
        body {
            background-image: url('<%= request.getContextPath() %>/Images/login.jpg'); 
            background-repeat: no-repeat;
            background-size: 100% 100%;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
        }




        h1 {
            color: red;
        }

        .form-floating {
            margin-bottom: 20px;
        }

        .form-control {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
      

        .form-check-input {
            margin-right: 5px;
        }

        .btn-primary {
            background-color: #007BFF;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn-primary:hover {
            background-color: #FF0000;
        }

        .link {
            margin-right: 10px;
            text-decoration: none;
            color: #FFFFFF;
        }

        .link:hover {
            text-decoration: underline;
        }

        @media (max-width: 768px) {
            .container {
                max-width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login Form</h1>
        <form action="/TQ_Bank/loginc" method="post">
            <div class="form-floating">
                <input type="email" name="username" class="form-control" id="floatingInput" placeholder="Enter email" required>
            </div>
            <div class="form-floating">
                <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password" required>
            </div>
            <div class="mt-2">
                <label for="rdbAdmin" class="form-check-label" style="color: red;">
                    <input type="radio"  value="admin" class="form-check-input" name="role" id="rdbAdmin">Admin
                </label>
                <label for="rdbUser" class="form-check-label" style="color: red;"0.
                >
                    <input type="radio" value="user" class="form-check-input" name="role" id="rdbUser">User
                </label>
            </div>
            <a href="#" class="link">Forgot Password</a>
            <a href="Register.jsp" class="link">New User</a>
            <button class="btn btn-primary">Log in</button>
        </form>
    </div>
</body>
</html>
