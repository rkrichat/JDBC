<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="controller.dao.UserMaintenanceDao" %>
    <jsp:useBean id="userMaintenanceDao" class="controller.dao.UserMaintenanceDao" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update User detail</title>
<script>
	function userDetail(){
		userdetail.submit();
	}
</script>
<style>
	h3.success{
		border-style:solid;
		boder-color:green;
		color:green;
	}
	h3.error{
		border-style:solid;
		border-color:red;
		color:red;
	}
</style>
</head>
<body>
	<%
		if(request.getAttribute("errorMessage")!=null){%>
			<h3 class="error"><%=request.getAttribute("errorMessage") %></h3>
		<%}else if(request.getAttribute("successMessage")!=null){%>
			<h3 class="success"><%=request.getAttribute("successMessage") %></h3>
		<% }
	%>
	<form action="maintenance" method="post">
		<table>
			<tr>
				<td>Name : </td>
				<td><input type="text" name="name" value="<%=userMaintenanceDao.getName() %>"></td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><input type="text" name="lastName" value="<%=userMaintenanceDao.getLastName() %>"></td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><input type="text" name="email" value="<%=userMaintenanceDao.getEmail() %>"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
				<td><input type="button" value="Back" onclick="userDetail();"></td>
			</tr>
		</table>
		<input type="hidden" name="id" value="<%=userMaintenanceDao.getId() %>">
		<input type="hidden" name="pwd" value="<%=userMaintenanceDao.getPwd() %>">
	</form> 
	
	<form name="userdetail" action="login" method="post">
		<input type="hidden" name="id" value="<%=userMaintenanceDao.getId() %>">
		<input type="hidden" name="pwd" value="<%=userMaintenanceDao.getPwd() %>">
	</form>
</body>
</html>