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

import com.hsbc.model.beans.User;
import com.hsbc.model.business.UserService;
import com.hsbc.model.util.LayerType;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class FetchUsersServlet
 */
@WebServlet("/FetchUsersServlet")
public class FetchUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
		List<User> usersList = service.fetchAllUsers();
		session.setAttribute("usersList", usersList);
		RequestDispatcher rd = request.getRequestDispatcher("fetchusers.jsp");
		rd.forward(request, response);
//		if(currUser.getName().equals("admin") && currUser.getUserId() == 1001) {
//			UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
//			List<User> usersList = service.fetchAllUsers();
//			session.setAttribute("usersList", usersList);
//			RequestDispatcher rd = request.getRequestDispatcher("fetchusers.jsp");
//			rd.forward(request, response);
//		}
//		else {
//			response.getWriter().print("<p style='color:red'>Only ADMIN Users has access to this. You are not an Admin.</p>");
//			RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
//			rd.include(request, response);
//		}
	}

}
