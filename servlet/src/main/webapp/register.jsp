<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="register.Register" %>

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
</head>
<body>
	<%if(request.getAttribute("errorMessages")!=null){%>
	<h2><%=request.getAttribute("errorMessages") %></h2>
	<%		
	}
	%>
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