package com.javaServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ThirdServlet extends GenericServlet{
	
	public void service(ServletRequest req,ServletResponse resp) throws IOException {
		System.out.println("generic servlet....");
		resp.setContentType("txt");
		PrintWriter po=resp.getWriter();
		po.println("hii generic...");
	}

}
