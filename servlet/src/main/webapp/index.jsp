<html>
	<head>
		<script>
			function submitRegisterForm(){
				register.submit();
			}
		</script>
	</head>

<body>

<form name="tt" action="login" method="get">
	Username : <input type="text" name="user"><br>
	Password : <input type="password" name ="pwd"><br>
	<input type="submit"> <input type="button" value="register" onclick="submitRegisterForm();">
</form>

<form name="register" action="register.jsp" method="get"></form>

</body>
</html>
