package com.kb.controller;

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

import com.kb.Dao.LoginImopl;
import com.kb.pojo.User;

@WebServlet("/loginc")
public class LoginController extends HttpServlet {
	PrintWriter out;
	User user;
	LoginImopl impl=new LoginImopl();
	String action;
	HttpSession session;
	boolean result;
	RequestDispatcher rd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession(false);
		if(session!=null) {
			session.invalidate();//log out
		}
		rd=request.getRequestDispatcher("/jsp/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		session=request.getSession();
		action=request.getParameter("action");
		String username=request.getParameter("username");
		String userpass=request.getParameter("password");
		String userrole=request.getParameter("role");
		try {
			result=impl.check_user(username, userpass,userrole);
			if(result) {
				if(userrole.equals("admin")) {
					System.out.println("welcome to admin");
					session.setAttribute("utype", userrole); //admin
					session.setAttribute("uname", username);
					rd=request.getRequestDispatcher("/jsp/header.jsp");
					rd.forward(request, response);
				}
				else if(userrole.equals("user")) {
					System.out.println("welcome to user");
					session.setAttribute("utype", userrole); //user
					session.setAttribute("uname", username);
					rd=request.getRequestDispatcher("/jsp/header.jsp");
					rd.forward(request, response);
				}
				
			}
			else {
				request.setAttribute("msg", "Invalid user");
				rd=request.getRequestDispatcher("/jsp/login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
