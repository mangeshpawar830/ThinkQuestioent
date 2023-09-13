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
%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container" style="width:500px">
<h1>User Details</h1>
<form action="/KuberBankWebApp/userc" method="post">
<input type="hidden" name="action" value="update">
	<table class="table">
		<tr>
			<td>Id</td>
			<td><input type="text" name="userid" value="<%=u.getUser_id()%>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="username" value="<%=u.getUsername()%>"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="<%=u.getEmail()%>"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="password" value="<%=u.getPassword()%>"></td>
		</tr>
		<tr>
			<td>Role</td>
			<td><input type="text" name="role" value="<%=u.getRole()%>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Status</td>
			<td>
				<select name="status">
					<option value=""><%=u.getStatus() %></option>
					<%if(u.getStatus().equals("inactive")) {%>
					<option value="active">active</option>
					<%}else{ %>
					<option value="inactive">inactive</option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan=2><button class="btn btn-success">save</button></a></td>
		</tr>
		
	</table>
	</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>