package com.hsbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.business.UserService;
import com.hsbc.model.util.LayerType;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class FetchUsersServlet
 */
@WebServlet("/FetchContactsServlet")
public class FetchContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
		User user = (User) session.getAttribute("userKey");
		List<Contact> contactList = service.fetchAllContacts(user.getUserId());
		session.setAttribute("contactList", contactList);
		RequestDispatcher rd = request.getRequestDispatcher("fetchcontacts.jsp");
		rd.forward(request, response);
	}

}
