package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.dao.RegisterDao;

public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("register")!=null) {
			request.setAttribute("register", request.getParameter("register"));
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else {
			RegisterDao register = new RegisterDao(request);
			try {
				register.createUser();
				if(register.getErrorMasage()!=null) {
					request.setAttribute("errorMessage", register.getErrorMasage());
					request.setAttribute("register", register);
				}else {
					request.setAttribute("successMessage", "Register Successfully");
				}
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			} catch (SQLException exception) {
				System.out.println(exception);
			}
		}
	}
}
