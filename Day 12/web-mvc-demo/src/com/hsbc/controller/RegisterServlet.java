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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = new User();
		user.setUserId(Integer.parseInt(request.getParameter("user")));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("pass"));
		user.setPhone(Long.parseLong(request.getParameter("phone")));
		UserService service = (UserService) UserFactory.getInstance(LayerType.SERVICE);
		User newUser = service.createUser(user);
		session.setAttribute(newUser.getName() , newUser);

		RequestDispatcher rd = request.getRequestDispatcher("registersuccess.jsp");
		rd.include(request, response);
	}

}
