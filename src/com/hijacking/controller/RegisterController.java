package com.hijacking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detectsqlinj.algorithms.BruteForceStringMatch;
import com.detectsqlinj.algorithms.MysqlEscapeString;
import com.detectsqlinj.algorithms.PasswordEncryption;
import com.detectsqlinj.database.UserRegistration;
import com.detectsqlinj.util.Constants;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		String email = request.getParameter("email");

		// They escapes if user inputs quoted strings,other dangerous
		// special characters
	
		username = MysqlEscapeString.mysql_real_escape_string(username);
		password = MysqlEscapeString.mysql_real_escape_string(password);
		name = MysqlEscapeString.mysql_real_escape_string(name);
		email = MysqlEscapeString.mysql_real_escape_string(email);

		UserRegistration userRegistration = new UserRegistration();
		
		// Hashing the password using Md5 algorithm

		password = PasswordEncryption.md5Password(password);
		
		//Save the user in database
		userRegistration.addUser(username, password, name,email);

		
		
		request.getRequestDispatcher("/success.jsp").forward(request, response);

	}

}
