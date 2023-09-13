package com.javaServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet implements Servlet{
	ServletConfig config;
	
	@Override
	public void  init(ServletConfig config) {
		System.out.println("object initilized..this is servlet interfece");
		
	}
	@Override
	public void service(ServletRequest req,ServletResponse resp) throws IOException {
		System.out.println("request coming..");
		resp.setContentType("text");
		PrintWriter wo= resp.getWriter();
		wo.println("hii mangesh....");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}
	
	@Override
	public String getServletInfo() {
		return "return by mangesh";
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy....");
	}

}
