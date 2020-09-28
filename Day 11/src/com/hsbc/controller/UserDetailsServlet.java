package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDetailsServlet
 */
@WebServlet("/contact")
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String fname = (String) session.getAttribute("firstname");
		String lname = (String) session.getAttribute("lastname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("mail");
//		ServletContext context = getServletContext();  
//		pw.println("First Name: " + context.getAttribute("first") + "<br />");
//		pw.println("Last Name: " + context.getAttribute("last") + "<br />");
		pw.print("First Name: " + fname + "<br />");
		pw.print("Last Name: " + lname + "<br />");
		pw.print("Phone No: " + phone + "<br />");
		pw.print("Email ID: " + email);
	}

}
