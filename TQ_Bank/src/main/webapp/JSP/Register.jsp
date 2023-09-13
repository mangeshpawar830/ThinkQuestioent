<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>www.tqbank.com</title>
<style>

        .banner{
            height:500px;
            background-image: url('<%= request.getContextPath() %>/Images/registration.jpg');
            background-size: 100% 500px;
        }
         body{
       background-image: url('/TQ_Bank/Images/registration.jpg');
       // bgcolor:secondary;
       background-repeat:no-repeat;
       background-size: 100% 700px;
       //background-image-opacity:1;
        }
        #Id1{
         background-color:rgb(227, 234, 248);
  
        }
  
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body >

<%
String msg=(String)request.getAttribute("msg");
%>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="h-100 d-flex align-items-center justify-content-center mb-5 mt-5">
    <div id="Id1" class="container-fluid shadow m-1 p-5 rounded" style="width: 500px; opacity:1;">
        <h1 class="text-primary">Registration Form</h1>
        <form action="/TQ_Bank/userc"  method="post">
              <input type="hidden" name="action" value="adduser">
              
              <div class="form-floating mb-3">
                <input type="text" class="form-control" name="name"id="floatingInput" placeholder="enter username">
                <label for="floatingInput">Enter name</label>
              </div>
              <div class="form-floating mb-3">
                <input type="text" class="form-control" name="email" id="floatingInput" placeholder="enter email">
                <label for="floatingInput">Enter email</label>
              </div>
              <div class="form-floating mb-3">
                <input type="text" class="form-control" name="phone" id="floatingInput" placeholder="enter phone number">
                <label for="floatingInput">Enter phone number</label>
              </div>
              
              <div class="form-floating">
                <input type="password" class="form-control" name="password" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Enter Password</label>
              </div>
              
              <div class="mt-2">
                <input type="radio" value="user"class="form-check-input m-1" name="role" id="rdb1">user
                
              </div>
                <button class="btn btn-primary w-100 mt-3">sign up</button>
                <%if(msg!=null){ %>
					<p style="color:red"><%=msg %></p>
				<%} %>
        </form>
    </div>
    </div>
    	<jsp:include page="Footer.jsp"></jsp:include>
   
    </body>
</html>
