package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import register.Register;

public class RegisterController extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/register.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Come here");
		Register register = new Register(request);
		
		try {
			if(register.validateAllFields()) {
				System.out.println("Come here");
				register.createUser();
			}
			if(register.getErrorMasage()!=null) {
				System.out.println(register.getErrorMasage());
				request.setAttribute("errorMessages", register.getErrorMasage());
				request.setAttribute("register", register);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}
}
