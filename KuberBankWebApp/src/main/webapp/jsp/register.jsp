<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.kuberbank.com</title>
    <style>

        .banner{
            height:500px;
            background-image: url('images/kbank.jpg');
            background-size: 100% 500px;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
%>
	<jsp:include page="header.jsp"></jsp:include>
    <div class="container-fluid shadow m-1 p-5 rounded" style="width: 500px;">
        <h1 class="text-primary">ADD USER HERE!!</h1>
        <form action="/KuberBankWebApp/userc" method="post">
              <input type="hidden" name="action" value="adduser">
              <div class="form-floating mb-3">
                <input type="text" class="form-control" name="username"id="floatingInput" placeholder="enter username">
                <label for="floatingInput">Enter name</label>
              </div>
              <div class="form-floating mb-3">
                <input type="text" class="form-control" name="email" id="floatingInput" placeholder="enter email">
                <label for="floatingInput">Enter email</label>
              </div>
              
              <div class="form-floating">
                <input type="password" class="form-control" name="password" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Enter Password</label>
              </div>
              <div>
              	<label class="mt-1">select role</label>
              </div>
              <div class="mt-2">
                <input type="radio" value="admin" class="form-check-input m-1" name="role" id="rdb1">admin
                <input type="radio" value="user"class="form-check-input m-1" name="role" id="rdb1">user
                
              </div>
                <button class="btn btn-primary w-100 mt-3">sign up</button>
                <%if(msg!=null){ %>
					<p style="color:red"><%=msg %></p>
				<%} %>
        </form>
    </div>
    	<jsp:include page="footer.jsp"></jsp:include>
    
    </body>
</html>