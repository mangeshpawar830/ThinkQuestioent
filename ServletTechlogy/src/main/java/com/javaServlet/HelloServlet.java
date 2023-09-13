package com.javaServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>This is hello</h1>");
		out.println("<form>");
		out.println("<input type='text'>");
		out.println("</form>");
		out.close();

		
	}

}
