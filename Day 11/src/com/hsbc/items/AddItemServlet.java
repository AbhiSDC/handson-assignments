package com.hsbc.items;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/items")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> itemsList = new ArrayList<String>();
	String item;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		
		item = (String) session.getAttribute("item");
		itemsList.add(item);
		
		session.setAttribute("list", itemsList);
		session.setAttribute("count", itemsList.size());
		
		RequestDispatcher rd = request.getRequestDispatcher("items.html");
		pw.print("Items Count: " + session.getAttribute("count"));
		
		rd.include(request, response);
	}

}
