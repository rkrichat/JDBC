package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.dao.LoginDao;

public class LoginController extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse responde) throws ServletException, IOException{
		request.getRequestDispatcher("index.jsp").forward(request, responde);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse responde) {
		LoginDao loginDao = new LoginDao(request);
		try {
			boolean isLoginPass = loginDao.login();
			request.setAttribute("loginDao", loginDao);
			if(isLoginPass) {
				request.getRequestDispatcher("/userdetail.jsp").forward(request, responde);
			}else {
				request.setAttribute("errorMessage", loginDao.getErrorMessage());
				request.getRequestDispatcher("index.jsp").forward(request, responde);
			}
		}catch(Exception exception) {
			System.out.println(exception);
		}
	}
}
