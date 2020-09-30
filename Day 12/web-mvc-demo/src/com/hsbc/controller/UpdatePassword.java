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

import com.hsbc.model.beans.User;
import com.hsbc.model.business.UserService;
import com.hsbc.model.util.LayerType;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		
		String currPassword = request.getParameter("currpwd");
		String newPassword = request.getParameter("newpwd");
		User user = (User) session.getAttribute("userKey");
		String oldPwd = user.getPassword();
		int id = user.getUserId();
		
		
		if(currPassword.equals(newPassword)) {
			pw.print("New Password is same as Current Password. Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("updatepwdinitial.jsp");
			rd.include(request, response);
		}
		else if(!currPassword.equals(oldPwd)) {
			pw.print("Current Password does not match with the password in our records.");
			RequestDispatcher rd = request.getRequestDispatcher("updatepwdinitial.jsp");
			rd.include(request, response);
		}
		else {
		
			user.setPassword(newPassword);
			service.updatePassword(id, newPassword);
			RequestDispatcher rd = request.getRequestDispatcher("updatepwd.jsp");
			rd.include(request, response);
		}
		
	}

}
