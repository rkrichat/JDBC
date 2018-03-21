<%@ page import="controller.dao.LoginDao"%>
<jsp:useBean id="loginDao" class="controller.dao.LoginDao" scope="request"></jsp:useBean>
<html>
	<head>
		<script>
			function submitRegisterForm(){
				register.submit();
			}
		</script>
		<style>
			h3.error{
				color:red;
				border-style:solid;
				boder-color:red;
			}
		</style>
	</head>
	
<body>
<%if(request.getAttribute("errorMessage")!=null) {%>
 <h3 class="error"><%=request.getAttribute("errorMessage") %></h3>
<% }%>
<form  action="login" method="post">
	Username : <input type="text" name="id" <%if(loginDao.getId()!=null){%> value=<%=loginDao.getId() %> <%} %>><br>
	Password : <input type="password" name ="pwd" <%if(loginDao.getPwd()!=null){%> value=<%= loginDao.getPwd()%><%} %>><br>
	<input type="submit"> <input type="button" value="register" onclick="submitRegisterForm();">
</form>

<form name="register" action="register.jsp" method="post"></form>

</body>
</html>
