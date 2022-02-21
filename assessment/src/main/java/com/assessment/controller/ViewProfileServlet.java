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

/**
 * Servlet implementation class ViewProfileServlet    
 */
public class ViewProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		Object oo=s.getAttribute("id");
		String email=oo.toString();
		
		MyEntity m=new MyEntity();
		m.setEmail(email);
		
		MyServiceInterface ms=new MyService();
		MyEntity mm=ms.viewprofile(m);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
				if(mm!=null) {
					out.println("Name is "+mm.getName());
					out.println("<br>Password is "+mm.getPassword());
					out.println("<br>Email is "+mm.getEmail());
					out.println("<br>Address is "+mm.getAddress());
				}
				else {
					out.println("no record found");
				}
		out.println("</center></body></html>");
	}

}
