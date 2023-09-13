package com.javaServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd;
		String username=request.getParameter("uname");
		String userpass=request.getParameter("upass");
		
		//uname- admin upass-admin@123
		if( userpass.equals("admin@123")) {
			rd=request.getRequestDispatcher("ps");
			request.setAttribute("msg", "admin login");
			rd.forward(request, response);
			
			//response.sendRedirect("https://www.gmail.com");
			//response.sendRedirect("ps");
		}
		else {
			out.print("<p style='color:red;text-align:center'>Please check username or password</p>");
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
