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
 * Servlet implementation class UpdateContactServlet
 */
@WebServlet("/UpdateContactServlet")
public class UpdateContactNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			List<Contact> contactList = (List<Contact>) session.getAttribute("contactList");
			UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
			int cid = Integer.parseInt(request.getParameter("id"));
			User temp = (User) session.getAttribute("userKey");
			int uid = temp.getUserId();
			String newName = request.getParameter("name");
			
			Contact updCon = service.updateContactName(uid, cid, newName);
			for(Contact con: contactList) {
				if(con.getContactId() == updCon.getContactId()) {
					contactList.set(contactList.indexOf(con), updCon);
				}
			}
			
			session.setAttribute("updateContact", updCon);
			RequestDispatcher rd = request.getRequestDispatcher("updatecontactnamesuccess.jsp");
			rd.forward(request, response);
	}

}
