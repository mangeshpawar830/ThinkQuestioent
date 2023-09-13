package com.javaServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String contact=req.getParameter("contact");
        String gender=req.getParameter("gender");
        String[] languages=req.getParameterValues("languages");

        out.println("<html><body>");
        out.println("<h2>Registration Details:</h2>");
        out.println("<p>Name: "+name+"</p>");
        out.println("<p>Email: "+email+"</p>");
        out.println("<p>Contact: "+contact+"</p>");
        out.println("<p>Gender: "+gender+"</p>");
        
        if(languages!=null&&languages.length>0) {
            out.println("<p>Languages:</p>");
            out.println("<ul>");
            for (String lang:languages) {
                out.println("<li>"+lang+"</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No languages selected.</p>");
        }

        out.println("</body></html>");
    }
}
