package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginser")
public class LoginServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		HttpSession session= request.getSession();  // get session true and false
String name = request.getParameter("username");
String pass = request.getParameter("password");

RequestDispatcher rd;

if(pass.equals("1234")) {
	rd=request.getRequestDispatcher("profiles");
	session.setAttribute("name",name);
	rd.forward(request, response);
	
}
else {
	rd=request.getRequestDispatcher("index.html");
	rd.include(request, response);
}



	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}