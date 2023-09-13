<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.kb.pojo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.kb.com</title>
</head>
<body>
<%
User u=(User)session.getAttribute("udetails");
String msg=(String)request.getAttribute("msg");

%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container" style="width:500px">
<%if(msg!=null){ %>
<h2 class="text-success"><%=msg %></h2>
<%} %>
<h3>User Details</h3>

	<table class="table">
		<tr>
			<td>Id</td>
			<td><%=u.getUser_id() %></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><%=u.getUsername()%></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><%=u.getEmail()%></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><%=u.getPassword()%></td>
		</tr>
		<tr>
			<td>Role</td>
			<td><%=u.getRole()%></td>
		</tr>
		<tr>
			<td>status</td>
			<td><%=u.getStatus()%></td>
		</tr>
		<tr>
			<td colspan=2><a class="btn btn-success" href="/KuberBankWebApp/userc?action=edit&uname=<%=u.getEmail()%>">update</a></td>
		</tr>
		
	</table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>