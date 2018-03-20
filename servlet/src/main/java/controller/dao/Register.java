package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import configuration.ConnectionDB;

public class Register {
	private String id;
	private String pwd;
	private String rePwd;
	private String name;
	private String lastName;
	private String email;
	private String errorMasage;
	
	public Register() {}
	public Register(HttpServletRequest request) {
		if(null!=request.getParameter("id") && request.getParameter("id").length()>0) {
			id = request.getParameter("id");
		}
		if(null!=request.getParameter("password") && request.getParameter("password").length()>0) {
			pwd = request.getParameter("password");
		}
		if(null!=request.getParameter("rePassword")  && request.getParameter("rePassword").length()>0) {
			rePwd = request.getParameter("rePassword");
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
	
	public boolean createUser() throws SQLException {
		if(!validateAllFields()) return false;
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionDB.getConnection();
			String sql="INSERT INTO user_detail (id, pwd, fname, lname, email) VALUES (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);
			ps.setString(4, lastName);
			ps.setString(5, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				con.commit();
				return true;
			}
		}catch(Exception exception) {
			System.out.println(exception);
			if(con!=null) con.rollback();
		}finally{
			ConnectionDB.closeConnection(con, ps, rs);
		}
		return false;
	}
	
	public boolean validateAllFields() throws SQLException {
		if(id==null) {
			errorMasage = "Id is requeired";
			return false;
		}else if(pwd==null) {
			errorMasage = "Password is requeired";
			return false;
		}else if(rePwd==null) {
			errorMasage = "Re-Password is requeired";
			return false;
		}else if(!pwd.equals(rePwd)) {
			errorMasage = "Password and Re-Password should be same";
			return false;
		}else if(name==null) {
			errorMasage = "Name is requeired";
			return false;
		}else if(lastName==null) {
			errorMasage = "Last Name is requeired";
			return false;
		}else if(email==null) {
			errorMasage = "Email is requeired";
			return false;
		}else {
			Connection con = null;
			PreparedStatement ps =null;
			ResultSet rs = null;
			try {
				con = ConnectionDB.getConnection();
				ps = con.prepareStatement("SELECT id FROM user_detail WHERE id = ?");
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()) {
					errorMasage = "ID already exist";
					return false;
				}
			}catch(Exception exception) {
				System.out.println(exception);
			}finally{
				ConnectionDB.closeConnection(con, ps, rs);
			}
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
	public String getRePwd() {
		return rePwd;
	}
	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
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
	public String getErrorMasage() {
		return errorMasage;
	}
	public void setErrorMasage(String errorMasage) {
		this.errorMasage = errorMasage;
	}
}
