package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.model.beans.User;
import com.hsbc.model.business.UserService;
import com.hsbc.model.util.LayerType;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class UpdateDetails
 */
@WebServlet("/UpdatePhoneNo")
public class UpdatePhoneNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userKey");
		int id = user.getUserId();
		long phone = Long.valueOf(request.getParameter("newphone"));
		user.setPhone(phone);
		service.updatePhone(id, phone);
		RequestDispatcher rd = request.getRequestDispatcher("updatephone.jsp");
		rd.forward(request, response);
	}

}
