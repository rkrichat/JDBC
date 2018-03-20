<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="controller.dao.Register" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
 <%
	 Register register = new Register();
	 if(request.getAttribute("register")!=null){
		 register = (Register)request.getAttribute("register");
	 }
 %>
 <script>
 	function home(){
 		index.submit();
 	}
 
 </script>
 <style type="text/css">
	 h3.error {
	 	color:red;
	 	border-style: solid;
   		border-color: red;
	 }
	 h3.success{
	 	color:green;
	 	border-style: solid;
   		border-color: green;
	 }
 </style>
</head>
<body>
	<%if(request.getAttribute("errorMessage")!=null){%>
		<h3 class="error"><%=request.getAttribute("errorMessage") %></h3>
	<%		
	}else if(request.getAttribute("successMessage")!=null){%>
		<h3 class="success"><%=request.getAttribute("successMessage") %></h3>
	<%}%>
	<form action="register" method="post">
		<table>
			<tr>
				<td>ID :</td>
				<th><input type="text" name="id" <%if(null!=register.getId()) {%>value=<%=register.getId() %> <%}%>></th>
			</tr>
			<tr>
				<td>Password :</td>
				<th><input type="password" name="password" <%if(register.getPwd()!=null) {%>value=<%=register.getPwd() %> <%}%>></th>
			</tr>
			<tr>
				<td>Re-Password :</td>
				<th><input type="password" name="rePassword" <%if(register.getRePwd()!=null) {%>value=<%=register.getRePwd() %> <%}%>></th>
			</tr>
			<tr>
				<td>Name :</td>
				<th><input type="text" name="name" <%if(register.getName()!=null) {%>value=<%=register.getName() %> <%}%>></th>
			</tr>
			<tr>
				<td>Last Name :</td>
				<th><input type="text" name="lastName" <%if(register.getLastName()!=null) {%>value=<%=register.getLastName() %> <%}%>></th>
			</tr>
			<tr>
				<td>email :</td>
				<th><input type="text" name="email"  <%if(register.getEmail()!=null) {%>value=<%=register.getEmail() %> <%}%>></th>
			</tr>
		</table>
		<input type="submit"> <input type="button" value="back" onclick="home();">
	</form>
	
	<form name="index" action="index.jsp" method="get"></form>
</body>
</html>