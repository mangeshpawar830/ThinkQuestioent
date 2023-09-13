package com.tqbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tqbank.dao.UserImpl;
import com.tqbank.pojo.User;

@WebServlet("/userc")
public class UserController extends HttpServlet{
	
	private int user_id;
	private String name;
	private String email;
	private String phoneNo;
	private String role;
	private String password;
	
	PrintWriter out; 
	User user;
	UserImpl impl=new UserImpl();
	String action;
	HttpSession session;
	boolean result;
	RequestDispatcher rd;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out=resp.getWriter();
		resp.setContentType("text/html");
		session=req.getSession();
		action=req.getParameter("action");
		
		if(action!=null && action.equals("profile")) {
			String uname=req.getParameter("uname");
			user=impl.showUserByEmail(uname);
			session.setAttribute("udetails", user);
			rd=req.getRequestDispatcher("/JSP/ProfileUser.jsp");
			rd.forward(req, resp);
			
		}else if(action!=null && action.equals("edit")) {
			int userid=Integer.parseInt(req.getParameter("userid"));
			user=impl.showUserById(userid);
			out.print("update:"+user);
			session.setAttribute("udetails", user);
			rd=req.getRequestDispatcher("/JSP/UpdateUser.jsp");
			rd.forward(req, resp);
		}else if(action!=null && action.equals("delete")){
			int userid=Integer.parseInt(req.getParameter("userid"));
			try {
				boolean result=impl.deleteUser(userid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(result) {
				List<User>userlist=impl.showAllUsers("user");
				session.setAttribute("ulist", userlist);
				req.setAttribute("msg", "user deleted successfully");
				rd=req.getRequestDispatcher("/JSP/UserList.jsp");
				rd.forward(req, resp);
			}else{
				req.setAttribute("msg", "user not deleted");
				rd=req.getRequestDispatcher("/JSP/UserList.jsp");
				rd.forward(req, resp);
			}
			
		}else {
			List<User> userlist=impl.showAllUsers("user");
			session.setAttribute("ulist", userlist);
			rd=req.getRequestDispatcher("/JSP/UserList.jsp");
			rd.forward(req, resp);
		}
			
		
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		out=resp.getWriter();
		resp.setContentType("text/html");
		session=req.getSession();
		action=req.getParameter("action");
		
		
		
        //user_id = Integer.parseInt(req.getParameter("userid"));
		name=req.getParameter("name");
		email=req.getParameter("email");
		phoneNo=req.getParameter("phone");
		role=req.getParameter("role");
		password=req.getParameter("password");
		if(action !=null && action.equals("adduser")) {
			user=new User(user_id, name, email, phoneNo, role, password);
			try {
				result=impl.registration(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(result) {
				out.print("<script>alert('registration done succssfully')</script>");
				String usertype=(String) session.getAttribute("utype");
				if(usertype !=null && usertype.equals("admin")) {
					List<User>userlist=impl.showAllUsers("user");
					session.setAttribute("ulist", userlist);
					rd=req.getRequestDispatcher("/JSP/UserList.jsp");
					rd.forward(req, resp);
				}
				rd=req.getRequestDispatcher("/JSP/Login.jsp");
				rd.forward(req, resp);
			}else {
				req.setAttribute("msg", "registration failed");
				rd=req.getRequestDispatcher("/JSP/Register.jsp");
				rd.forward(req, resp);
			}
			if(action!=null && action.equals("update")) {
				user_id=Integer.parseInt(req.getParameter("userid"));
				user=new User(user_id, name, email, phoneNo, role, password);
				try {
					result=impl.updateUser(user);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(result) {
					session.setAttribute("udetails", user);
					rd=req.getRequestDispatcher("/JSP/ProfileUser.jsp");
					rd.forward(req, resp);
					
				}else {
					session.setAttribute("udetails", user);
					rd=req.getRequestDispatcher("JSP/UpdateUser.jsp");
					rd.forward(req, resp);
							
				}
				
				
			}
		}
		
	}
	
	

}
