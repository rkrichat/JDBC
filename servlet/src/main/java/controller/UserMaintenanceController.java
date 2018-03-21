package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.dao.UserMaintenanceDao;

public class UserMaintenanceController extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("do get");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getParameter("userdetail")!=null) {
			UserMaintenanceDao userMaintenance = new UserMaintenanceDao(request);
			request.setAttribute("userMaintenanceDao", userMaintenance);
			request.getRequestDispatcher("/editform.jsp").forward(request,response);
		}else {
			UserMaintenanceDao userMaintenance = new UserMaintenanceDao(request);
			try {
				boolean isUpdateSuccessfully = userMaintenance.updateUserDetail();
				request.setAttribute("userMaintenanceDao", userMaintenance);
				if(isUpdateSuccessfully) {
					request.setAttribute("successMessage", "Update user detail Successfully");
				}else {
					request.setAttribute("errorMessage", userMaintenance.getErrorMessage());
				}
				request.getRequestDispatcher("/editform.jsp").forward(request,response);
			}catch(Exception excetpion) {
				System.out.println(excetpion);
			}
		}
	}
	
}
