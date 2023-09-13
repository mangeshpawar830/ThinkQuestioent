<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.kuberbank.com</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<%
String utype=(String)session.getAttribute("utype");
String uname=(String)session.getAttribute("uname");
%>
<nav class="navbar navbar-expand-sm bg-warning	 text-light">

        <div class="container-fluid text-light" >
          <!-- Links -->
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link text-light" href="#">HOME</a>
            </li>
            <li class="nav-item" >
              <a class="nav-link text-light" href="#">ABOUT US</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-light" href="#">CONTACT US</a>  
            </li>
            <%if(utype!=null && utype.equals("admin")){ %>
             <li class="nav-item">
              <a class="nav-link text-light" href="/KuberBankWebApp/userc">CUSTOMER LIST</a>
              
            </li>
             <li class="nav-item">
              <a class="nav-link text-light" href="/KuberBankWebApp/jsp/register.jsp">ADD USER</a>
            </li>
             <li class="nav-item">
              <a class="nav-link text-light" href="#">ACCOUNT</a>    
             </li>
             <li class="nav-item">
              <a class="nav-link text-light" href="#">VIEW TRANSACTION</a>    
             </li>
             
             <%}if(utype!=null && utype.equals("user")){ %>
            <li class="nav-item">
              <a class="nav-link text-light" href="/KuberBankWebApp/userc?action=profile&uname=<%=uname%>">PROFILE</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-light" href="/KuberBankWebApp/accountc">ACCOUNT</a>
            </li>
             <li class="nav-item">
              <a class="nav-link text-light" href="/KuberBankWebApp/jsp/transaction.jsp">TRANSACTION</a>
            </li>
              <li class="nav-item">
              <a class="nav-link text-light" href="/KuberBankWebApp/jsp/payee.jsp">PAYEE</a>
            </li>
            <%}if(utype==null) {%>
             <li class="nav-item">
              <a class="nav-link text-light" href="/KuberBankWebApp/jsp/login.jsp">LOGIN</a>
            </li>
           
            <%} if(utype!=null){%>
            <li class="nav-item">
              <a class="nav-link text-light" href="/KuberBankWebApp/loginc">LOGOUT</a>
            </li>
            <%} %>
            <%if(uname!=null) {%>
            <li class="nav-item ">
            	
              <b class="nav-link text-light "><%=uname %></b>
             
            </li>
            <%} %>
          </ul>
        </div>
      
      </nav>
</body>
</html>>