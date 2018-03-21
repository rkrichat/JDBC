package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import configuration.ConnectionDB;

public class UserMaintenanceDao {
	private String id;
	private String pwd;
	private String errorMessage;
	private String name;
	private String lastName;
	private String email;
	
	
	public UserMaintenanceDao() {
		
	}

	public UserMaintenanceDao(HttpServletRequest request) {
		if(null!=request.getParameter("id") && request.getParameter("id").length()>0) {
			id = request.getParameter("id");
		}
		if(null!=request.getParameter("pwd") && request.getParameter("pwd").length()>0) {
			pwd = request.getParameter("pwd");
		}
		if(null!=request.getParameter("name") && request.getParameter("name").length()>0) {
			name = request.getParameter("name");
		}
		if(null!=request.getParameter("lastName") && request.getParameter("lastName").length()>0) {
			lastName = request.getParameter("lastName");
		}
		if(null!=request.getParameter("email") && request.getParameter("email").length()>0) {
			email = request.getParameter("email");
		}
	}
	
	public boolean updateUserDetail() throws SQLException {
		if(!validateAllFields()) return false;
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			con = ConnectionDB.getConnection();
			ps = con.prepareStatement("UPDATE user_detail SET fname = ?, lname = ?, email = ? WHERE id = ?");
			ps.setString(1, name);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				con.commit();
				return true;
			}
		}catch(Exception exception) {
			System.out.println(exception);
			if(con!=null) con.rollback();
		}finally {
			ConnectionDB.closeConnection(con, ps, rs);
		}
		
		return false;
	}
	
	public boolean changePassword() {
		return false;

	}

	
	public boolean validateAllFields() throws SQLException {
		if(id==null) {
			errorMessage = "Id is requeired";
			return false;
		}else if(pwd==null) {
			errorMessage = "Password is requeired";
			return false;
		}else if(name==null) {
			errorMessage = "Name is requeired";
			return false;
		}else if(lastName==null) {
			errorMessage = "Last Name is requeired";
			return false;
		}else if(email==null) {
			errorMessage = "Email is requeired";
			return false;
		}
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
