package com.assessment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assessment.entity.MyEntity;
import com.assessment.service.MyService;
import com.assessment.service.MyServiceInterface;


public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("em");
		String password =request.getParameter("pass");
		
		MyEntity m=new MyEntity();
		m.setEmail(email);
		m.setPassword(password);
		
		MyServiceInterface ms=new MyService();
		boolean b=ms.loginProfile(m);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
		if(b) {
			
			HttpSession s=request.getSession(true);
			s.setAttribute("id", email);
			
			out.println("Welcome "+email);
			out.println("<button><a href=ViewProfileServlet>View Profile</a></button>");
			out.println("<button><a href=DeleteProfileServlet>Delete Profile</a></button>");
			out.println("<button><a href=ViewAllProfileServlet>View All Profile</a></button>");
		}
		else {
			out.println("Invalid Id and Password <a href=login.jsp>Try Again</a>");
			
		}
	out.println("</center></body></html>");
	}

}
