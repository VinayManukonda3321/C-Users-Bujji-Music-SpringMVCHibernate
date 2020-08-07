<html>
	<head>
		<title>FER-Login</title>
	<script>
	function validateForm() {
		var form = document.LoginForm;

		var errorMessages = '';

		if (form.username.value == "src/main/webapp/WEB-INF/views/Login.jsp") {
			errorMessages = 'please enter Username';
		}
		if (form.password.value == '') {
			errorMessages += '<br> please enter Password';
		}
			if (errorMessages != '') {
				//alert(errorMessages);

				var errorTrId = document.getElementById('errorTrId');
				var errorTdId = document.getElementById('errorTdId');

				errorTdId.style.color = 'red';
				
				errorTdId.innerHTML = errorMessages;
				errorTrId.style.display = '';

			} else {
				form.submit();
			}
		}
	</script>
		
	</head>
	<body>
	<form action='login' method='post' name='LoginForm'>
	
	
			<table align='center' border='1'>
		
			<tr>
			<td colspan='2' align='center'>login</td>
			</tr>
			<tr id='errorTrId' style='display: none;'>
				<td colspan='2' align='center' id ='errorTdId'></td>
			</tr>	
			
				<tr>
					<td>Username<font color='red'>*</font></td>
					<td>
					<input type='text' name='username'>
					</td>
				</tr>
				
				<tr>
					<td>Password<font color='red'>*</font></td>
					<td>
					<input type='password' name='password'>
					</td>
				</tr>
				
				<tr>
					<td colspan='2' align='center'>
					<input type='button' value='Login'  onclick="javascript:validateForm()">
					&nbsp
					<a href='registration'>registration
					</td>
				</tr>

</table>
</body>
</html>