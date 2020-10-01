package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.model.business.UserService;
import com.hsbc.model.util.LayerType;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("user"));
		String password = request.getParameter("pass");
		UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
		try {
			User user = service.login(userid, password);
			
			HttpSession session = request.getSession();
			session.setAttribute("userKey", user);
			RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
			rd.forward(request, response);
			
		} catch(AuthenticationException a) {
			RequestDispatcher rd = request.getRequestDispatcher("loginfailure.jsp");
			rd.forward(request, response);
		}
	}

}
