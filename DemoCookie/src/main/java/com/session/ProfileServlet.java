package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/profiles")
public class ProfileServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out= response.getWriter();
	response.setContentType("text/html");
	out.print("Profile Servlet");
	
	HttpSession session= request.getSession();
	String name= (String) session.getAttribute("name");
	
	out.print("Name:"+ name);
	
//	response.sendRedirect("tservlet");
	
	out.print("<a href='tservlet'>click</a>");
	

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
