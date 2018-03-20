package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import configuration.ConnectionDB;

public class LoginDao {
	private String id;
	private String pwd;
	private String errorMessage;
	private String name;
	private String lastName;
	private String email;
	
	public LoginDao() {}
	public LoginDao(HttpServletRequest request) {
		if(request.getParameter("id")!=null) {
			id = request.getParameter("id");
		}
		if(request.getParameter("pwd")!=null) {
			pwd = request.getParameter("pwd");
		}
	}
	
	public boolean login() throws SQLException {
		if(!validateAllField()) return false;
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionDB.getConnection();
			ps= con.prepareStatement("SELECT * FROM user_detail WHERE id = ? AND pwd = ?");
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("fname");
				lastName = rs.getString("lname");
				email = rs.getString("email");
				return true;
			}else {
				errorMessage = "ID or Password is invalid";
				return false;
			}
		}catch(Exception exception) {
			System.out.println(exception);
			exception.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(con, ps, rs);
		}
		return false;
	}
	
	public boolean validateAllField() throws SQLException {
		if(id==null || id.length()==0) {
			errorMessage = "Id is required";
			return false;
		}else if(pwd==null || pwd.length()==0) {
			errorMessage = "Password is required";
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
