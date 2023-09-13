package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/scs")
	public class SecondCookieServlet extends HttpServlet {
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			out.print("<p>welcome to second page</p>");
			Cookie cks[]=request.getCookies();
			for(Cookie c:cks)
			{
				out.print("inside loop");
				out.print(c.getName()+"  : "+c.getValue());
			}
			out.close();
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	

}
