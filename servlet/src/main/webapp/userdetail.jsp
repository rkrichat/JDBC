<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.dao.LoginDao"%>
<jsp:useBean id="loginDao" class="controller.dao.LoginDao" scope="request"></jsp:useBean>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function home(){
		index.submit();
	}
</script>
</head>
<body>
 	<form action="maintenance" method="post">
		<table>
			<tr>
				<td>ID : </td>
				<td><%=loginDao.getId() %></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><%=loginDao.getName() %></td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><%=loginDao.getLastName() %></td>
			</tr>
			<tr>
				<td> email : </td>
				<td><%=loginDao.getEmail() %></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit"/></td>
				<td><input type="button" value="Back" onclick="home();"></td>
			</tr>		
		</table>
		<input type="hidden" name="id" value="<%=loginDao.getId() %>">
		<input type="hidden" name="pwd" value="<%=loginDao.getPwd() %>">
		<input type="hidden" name="name" value="<%=loginDao.getName() %>">
		<input type="hidden" name="lastName" value="<%=loginDao.getLastName() %>">
		<input type="hidden" name="email"  value="<%=loginDao.getEmail() %>">
		<input type="hidden" name="userdetail">
	</form>
	
	<form name="index" action="index.jsp" method="get"></form>
</body>
</html>