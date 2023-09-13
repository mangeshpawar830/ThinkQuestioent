<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Kuber Bank</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h1 class="text-primary">Login Form</h1>
                    </div>
                    <div class="card-body">
                        <form action="/KuberBankWebApp/loginc" method="post">
                            <div class="mb-3">
                                <label for="username" class="form-label">Email address</label>
                                <input type="email" name="username" class="form-control" id="username" placeholder="Enter email" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" name="password" class="form-control" id="password" placeholder="Password" required>
                            </div>
                            <div class="mb-3">
                                <label>Select role</label>
                                <div class="form-check">
                                    <input type="radio" name="role" value="admin" class="form-check-input" id="adminRole">
                                    <label class="form-check-label" for="adminRole">Admin</label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" name="role" value="user" class="form-check-input" id="userRole">
                                    <label class="form-check-label" for="userRole">User</label>
                                </div>
                            </div>
                            <div class="mb-3">
                                <a href="#" class="me-4">Forgot password?</a>
                                <a href="register.jsp" class="me-4">New User?</a>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Log In</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Include your footer.jsp here -->
    <%@ include file="footer.jsp" %>
</body>
</html>
