package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NameServlet
 */
@WebServlet("/name")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("contact.html");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		pw.print("First Name: " + fname + "<br />");
		pw.print("Last Name: " + lname);
//		ServletContext context = getServletContext(); 
//		context.setAttribute("first", fname);
//		context.setAttribute("last", lname);
		HttpSession session = request.getSession();
		session.setAttribute("firstname", fname);
		session.setAttribute("lastname", lname);
		rd.include(request, response);
	}

}
