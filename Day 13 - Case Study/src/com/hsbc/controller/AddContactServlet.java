package com.hsbc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.DuplicateContactException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.business.UserService;
import com.hsbc.model.util.LayerType;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
			UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
			User user = (User) session.getAttribute("userKey");
			int id = user.getUserId();
			String name = request.getParameter("name");
			long contact = Long.parseLong(request.getParameter("contact"));
			Contact newCon = (Contact) service.addContact(id, name, contact);
			List<Contact> contactList = null;
			
			if(session.getAttribute("contactList") == null) {
				contactList = new ArrayList<Contact>();
				contactList.add(newCon);
			}
			else {
				contactList = (List<Contact>) session.getAttribute("contactList");
				contactList.add(newCon);
			}
			session.setAttribute("contactList", contactList);
			
			RequestDispatcher rd = request.getRequestDispatcher("addcontactsuccess.jsp");
			rd.include(request, response);
		} catch(DuplicateContactException d) {
			response.getWriter().print("<p style='color:red;'>Contact already exists. Cannot add duplicates.</p>");
			RequestDispatcher rd = request.getRequestDispatcher("addcontact.jsp");
			rd.include(request, response);
		}
	}

}
