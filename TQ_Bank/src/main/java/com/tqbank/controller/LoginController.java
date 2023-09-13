package com.tqbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tqbank.dao.UserImpl;
import com.tqbank.pojo.User;

@WebServlet("/loginc")
public class LoginController extends HttpServlet{
	
	PrintWriter out;
	User user;
	UserImpl impl=new UserImpl();
	String action;
	HttpSession session;
	boolean result;
	RequestDispatcher rd;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session=req.getSession();
		if(session!=null) {
			session.invalidate();
		}
		rd=req.getRequestDispatcher("/JSP/index.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out=resp.getWriter();
		resp.setContentType("text/html");
		session=req.getSession();
		action=req.getParameter("action");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		
		try {
			result=impl.login(username, password, role);
			System.out.println(result);
			
			if(result) {
				if(role.equals("admin")) {
					session.setAttribute("utype", role);
					session.setAttribute("uname", username);
					rd=req.getRequestDispatcher("/JSP/Header.jsp");
					rd.forward(req, resp);
				}else if(role.equals("user")) {
					session.setAttribute("utype", role);
					session.setAttribute("uname", username);
					rd=req.getRequestDispatcher("/JSP/Header.jsp");
					rd.forward(req, resp);
				}
			}else {
				req.setAttribute("msg", "Invalid user");
				rd=req.getRequestDispatcher("/JSP/Login.jsp");
				rd.forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
