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

import com.kb.Dao.AccountImpl;
import com.kb.Dao.LoginImopl;
import com.kb.pojo.Account;
import com.kb.pojo.User;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/accountc")
public class AccountController extends HttpServlet {
	PrintWriter out;
	User user;
	Account acc;
	AccountImpl impl=new AccountImpl();
	LoginImopl impl1=new LoginImopl();
	String action;
	HttpSession session;
	boolean result;
	RequestDispatcher rd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside account controller");
		out=response.getWriter();
		response.setContentType("text/html");
		session=request.getSession(false);
		action=request.getParameter("action");
		String uname=(String)session.getAttribute("uname");
		String status=impl1.getStatus(uname);
		String btnname=request.getParameter("btn1");
		if(btnname!=null && btnname.equals("deposit")) {
			
			int amt=Integer.parseInt(request.getParameter("amt"));
			String account=request.getParameter("accountno");
			System.out.println("amt:"+amt);
			try {
				int ans=impl.deposit(account,amt);
				if(ans==1) {
				System.out.println("deposit completed");
				request.setAttribute("msg", "deposit completd please check account details");
				acc=impl.showAccountDetails(uname);
				session.setAttribute("accdetails", acc);
				rd=request.getRequestDispatcher("/jsp/showaccount.jsp");
				rd.forward(request, response);
				}
				else {
					request.setAttribute("msg", "invalid account details");
					rd=request.getRequestDispatcher("/jsp/showaccount.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//withdraw if()
		else
		{
		if(status!=null && status.equals("active")) {
		try {
			acc=impl.showAccountDetails(uname);
			session.setAttribute("accdetails", acc);
			rd=request.getRequestDispatcher("/jsp/showaccount.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			request.setAttribute("msg", "your account is not active");
			rd=request.getRequestDispatcher("/jsp/showaccount.jsp");
			rd.forward(request, response);
		}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
