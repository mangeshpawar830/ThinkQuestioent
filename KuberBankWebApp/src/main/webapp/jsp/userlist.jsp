<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.kb.pojo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
List<User> userlist=(List<User>)session.getAttribute("ulist");
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<p class="text-center text-success h3"><%=msg %></p>
<%} %>
<div class="container">
<h1 class="text-primary text-center">User List</h1>
<table class="table">
		
		<tr class="bg-primary text-white">
			<th>User Id</th>
			<th>User name</th>
			<th>User Email</th>
			<th>User Password</th>
			<th>Role</th>
			<th>Status</th>
			<th colspan=2>operation</th>
			
		</tr>
		<%for(User u:userlist) {%>
		<tr>
			<td><%=u.getUser_id() %></td>
			<td><%=u.getUsername() %></td>
			<td><%=u.getEmail() %></td>
			<td><%=u.getPassword() %></td>
			<td><%=u.getRole() %></td>
			<td><%=u.getStatus() %></td>
			<td><a href="/KuberBankWebApp/userc?action=edit&userid=<%=u.getUser_id() %>" class="btn btn-success">update</a></td>
			<td><a href="/KuberBankWebApp/userc?action=delete&userid=<%=u.getUser_id() %>" class="btn btn-danger">delete</a></td>
		</tr>
		<%} %>
</table>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>