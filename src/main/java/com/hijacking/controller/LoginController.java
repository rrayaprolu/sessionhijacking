package com.hijacking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hijacking.algorims.PasswordEncryption;
import com.hijacking.dao.VerifyLogin;
import com.hijacking.dao.secured.SecuredVerifyLogin;
import com.hijacking.util.LogMessage;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);

		// Check if user is already logged in or not.
		// Verifying if the session exists , if session is alive, User is alreay
		// logged in
		if (session == null || session.getAttribute("userid") == null) {

			if (request.getParameter("testsqlinj") == null)
				response.sendRedirect(request.getContextPath() + "/login.jsp");

			else
				response.sendRedirect(request.getContextPath() + "/login.jsp?testsqlinj=1");

		} else {

			// Redirecting to the profile page if already logged in
			response.sendRedirect(request.getContextPath() + "/profile.jsp");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LogMessage.logReporter = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		VerifyLogin verifyLogin = new VerifyLogin();
		try {
			int result = verifyLogin.verifyLogin(username, password);
			if (result ==-1) {
				request.setAttribute("error", "Invalid credentials");
				LogMessage.logReporter = true;

				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
			else{
				LogMessage.logReporter = true;

				response.sendRedirect(request.getContextPath() + "/success.jsp");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
