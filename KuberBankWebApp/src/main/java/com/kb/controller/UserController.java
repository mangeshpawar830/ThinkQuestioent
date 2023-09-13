package com.kb.controller;

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

import com.kb.Dao.LoginImopl;
import com.kb.pojo.User;

@WebServlet("/userc")
public class UserController extends HttpServlet {
	
	private int user_id;
	private String username;
	private String email;
	private String password;
	private String role;
	private String status;
	PrintWriter out;
	User user;
	LoginImopl impl=new LoginImopl();
	String action;
	HttpSession session;
	boolean result;
	RequestDispatcher rd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		session=request.getSession();
		action=request.getParameter("action");
		//profile
		if(action!=null && action.equals("profile")) {
			String uname=(String)request.getParameter("uname");
			user=impl.showUserByEmail(uname);
			//out.print(user);
			session.setAttribute("udetails", user);
			rd=request.getRequestDispatcher("/jsp/profileUser.jsp");
			rd.forward(request, response);
		}
		if(action!=null && action.equals("edit")) {
			//String uname=(String)request.getParameter("uname");
			int userid=Integer.parseInt(request.getParameter("userid"));
			user=impl.showUserById(userid);
			out.print("update:"+user);
			session.setAttribute("udetails", user);
			rd=request.getRequestDispatcher("/jsp/updateUser.jsp");
			rd.forward(request, response);
		}
		if(action!=null &&action.equals("delete")) {
			int userid=Integer.parseInt(request.getParameter("userid"));
			boolean result=impl.deleteUser(userid);
			if(result) {
				List<User>userlist=impl.showAllUsers("user");
				session.setAttribute("ulist", userlist);
				request.setAttribute("msg", "user deleted successfully");
				rd=request.getRequestDispatcher("/jsp/userlist.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "user not deleted");
				rd=request.getRequestDispatcher("/jsp/userlist.jsp");
				rd.forward(request, response);
			}
		}
		else 
		{
		//fetch all users from db
		List<User>userlist=impl.showAllUsers("user");
		session.setAttribute("ulist", userlist);
		rd=request.getRequestDispatcher("/jsp/userlist.jsp");
		rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside usercontroller post");
		out=response.getWriter();
		response.setContentType("text/html");
		session=request.getSession();
		action=request.getParameter("action");
		username=request.getParameter("username");
		email=request.getParameter("email");
		password=request.getParameter("password");
		role=request.getParameter("role");
		
		if(action!=null && action.equals("adduser")) {
		user=new User( username, email, password, role);
		try {
			result=impl.addUser(user);
			if(result) {
				out.print("<script>alert('registration done succssfully')</script>");
				String usertype=(String)session.getAttribute("utype");
				if(usertype!=null && usertype.equals("admin")) {
					
					//fetch all users from db
					List<User>userlist=impl.showAllUsers("user");
					session.setAttribute("ulist", userlist);
					rd=request.getRequestDispatcher("/jsp/userlist.jsp");
					rd.forward(request, response);
				
				}
				else {
					rd=request.getRequestDispatcher("/jsp/login.jsp");
					rd.forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "registration failed");
				rd=request.getRequestDispatcher("/jsp/register.jsp");
				rd.forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}//add user end
		
		if(action!=null && action.equals("update")) {
			user_id=Integer.parseInt(request.getParameter("userid"));
			status=request.getParameter("status");
			user=new User(user_id, username, email, password, role,status);
			result=impl.updateUser(user);
			if(result) {
				request.setAttribute("msg", "user details updated");
				session.setAttribute("udetails", user);
				rd=request.getRequestDispatcher("/jsp/profileUser.jsp");
				rd.forward(request, response);
			}
			else {
				session.setAttribute("udetails", user);
				rd=request.getRequestDispatcher("/jsp/updateUser.jsp");
				rd.forward(request, response);	
			}
		}
		
	}

}
