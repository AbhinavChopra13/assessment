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


public class DeleteProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		Object oo=s.getAttribute("id");
		String email=oo.toString();
		
		MyEntity m=new MyEntity();
		m.setEmail(email);
		
		MyServiceInterface ms=new MyService();
		int mm=ms.deleteprofile(m);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
				if(mm>0) {
					out.println("profile deleted  ");
					
				}
				else {
					out.println("could not delete record");
				}
		out.println("</center></body></html>");
	}

}
