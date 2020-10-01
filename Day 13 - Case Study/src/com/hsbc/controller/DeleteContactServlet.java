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
 * Servlet implementation class DeleteContactServlet
 */
@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
		User user = (User) session.getAttribute("userKey");
		service.deleteContact(user.getUserId(), Integer.parseInt(request.getParameter("id")));
		session.invalidate();
		response.getWriter().print("<h3 style='color:green'>Contact has been deleted successfully.</h3>");
		RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
		rd.include(request, response);
	}

}
