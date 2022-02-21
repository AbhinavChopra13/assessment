package com.assessment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assessment.entity.MyEntity;
import com.assessment.service.MyService;
import com.assessment.service.MyServiceInterface;


/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		MyEntity w=new MyEntity();
		w.setAddress(address);
		w.setEmail(email);
		w.setPassword(password);
		w.setName(name);
		
		MyServiceInterface ms=new MyService();
		int i=ms.createProfileService(w);
		
		if(i>0) {
			request.setAttribute("result", "Profile created <a href=login.jsp>Sign In</a>");
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("result","could not create profile");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
		}
		
	}

}
