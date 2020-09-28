package com.hsbc.items;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("items.html");
		HttpSession session = request.getSession();
		List<String> itemsList = null;
		
		String itemName = (String) request.getParameter("item");
		if(session.getAttribute("itemsList") == null) {
			itemsList = new ArrayList<String>();
			itemsList.add(itemName);
		}
		else {
			itemsList = (List<String>) session.getAttribute("itemsList");
			itemsList.add(itemName);
		}
		
		session.setAttribute("itemsList", itemsList);
		session.setAttribute("count", itemsList.size());
		pw.print("Items Count: " + session.getAttribute("count"));
		
		rd.include(request, response);
	}

}
