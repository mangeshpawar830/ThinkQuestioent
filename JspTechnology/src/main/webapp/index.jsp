<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is Jsp File</h1>
<!--  scriplet tag -->
<b>
<% 
String name="pawar";
out.print("Mangesh Patil");
out.println();
out.print("name: "+name);
%>
<br>
</b>
<!--  expression tag -->
<%= "thank you malak.." %>

<!--  declaration tag -->
<br>
<%!
int a=10;
public int square(){
	return a*a;
}
%>
<%= "square: "+square() %>
</body>
</html>