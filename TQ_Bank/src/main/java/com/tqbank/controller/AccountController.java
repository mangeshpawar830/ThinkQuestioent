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

import com.tqbank.dao.AccountImpl;
import com.tqbank.dao.UserImpl;
import com.tqbank.pojo.Account;
import com.tqbank.pojo.User;

@WebServlet("/accountc")
public class AccountController extends HttpServlet{
	PrintWriter out;
	User user;
	Account acc;
	AccountImpl aci=new AccountImpl();
	UserImpl usi=new UserImpl();
	String action;
	HttpSession session;
	boolean result;
	RequestDispatcher rd;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out=resp.getWriter();
		resp.setContentType("text/html");
		session=req.getSession(false);
		action=req.getParameter("action");
		String uname=(String) session.getAttribute("uname");
		try {
			String status=aci.getStatus(uname);
			if(status!=null && status.equals("active")) {
				acc=aci.showAccountDetails(uname);
				session.setAttribute("accdetails", acc);
				rd=req.getRequestDispatcher("/JSP/ShowAccount.jsp");
				rd.forward(req, resp);
			}else {
				req.setAttribute("msg", "your account is not active");
				rd=req.getRequestDispatcher("/JSP/ShowAccount.jsp");
				rd.forward(req, resp);
			}
			if(action!=null && action.equals("deposit")) {
				int amt=Integer.parseInt(req.getParameter("amt"));
				int account=Integer.parseInt(req.getParameter("accountno"));
				int ans=aci.deposit(account, amt);
				
				if(ans==1) {
					req.setAttribute("msg", "deposit completd please check account details");
					acc=aci.showAccountDetails(uname);
					session.setAttribute("accdetails", acc);
					rd=req.getRequestDispatcher("/JSP/ShowAccount.jsp");
					rd.forward(req, resp);
				}else {
					req.setAttribute("msg", "invalid account details");
					rd=req.getRequestDispatcher("/JSP/ShowAccount.jsp");
					rd.forward(req, resp);

				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
	
	
	
	

}
