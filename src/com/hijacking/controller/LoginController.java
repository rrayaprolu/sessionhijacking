package com.hijacking.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import com.detectsqlinj.algorithms.BruteForceStringMatch;
import com.detectsqlinj.algorithms.LongestCmnSequence;
import com.detectsqlinj.algorithms.MysqlEscapeString;
import com.detectsqlinj.algorithms.PasswordEncryption;
import com.detectsqlinj.database.VerifyLogin;
import com.detectsqlinj.util.Constants;

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
		// TODO Auto-generated method stub

		// Read the parameters username and password from the user
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Hashing the password using Md5 algorithm
		password = PasswordEncryption.md5Password(password);

		// This parameters gives if we need to take care of sql injection or
		// not.if 1 apply algorithms on the input
		String checkinjection = request.getParameter("checkinjection");

		String rememberme = request.getParameter("rememberme");

		boolean foundsqlinjection = false;

		if (checkinjection != null && checkinjection.equals("1")) {

		}

	}
}
