<html>
<head>
<title>FER-Registration</title>
<script>
	function validateForm() {
		var form = document.RegistrationForm;

		var errorMessages = '';

		if (form.firstName.value == 'src/main/webapp/WEB-INF/views/Registration.jsp') {
			errorMessages = 'please enter firstName';
		}
		if (form.lastName.value == '') {
			errorMessages += '<br> please enter lastName';
		}
		if (form.email.value == '') {
			errorMessages += '<br> please enter email';
		}
		if (form.mobile.value == '') {
			errorMessages += '<br> please enter mobile';
		}	
		if (form.username.value == '') {
			errorMessages += '<br> please enter userName';
		}
		if (form.password.value == '') {
			errorMessages += '<br> please enter password';
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
	<form action='registration' method='post'
		name='RegistrationForm'>

		<table align='center' border='1'>

			<tr>
				<td colspan='2' align='center'>Registration</td>
			</tr>
			<tr id='errorTrId' style='display: none;'>
				<td colspan='2' align='center' id ='errorTdId'></td>
			</tr>
			<tr>	
			<td>firstName<font color='red'>*</font></td>
			<td><input type='text' name='firstName'></td>
			</tr>
			<tr>
				<td>middleName</td>
				<td><input type='text' name='middleName'></td>
			</tr>

			<tr>
				<td>lastName<font color='red'>*</font></td>
				<td><input type='text' name='lastName'></td>
			</tr>

			<tr>
				<td>email<font color='red'>*</font></td>
				<td><input type='text' name='email'></td>
			</tr>

			<tr>
				<td>userName<font color='red'>*</font></td>
				<td><input type='text' name='username'></td>
			</tr>

			<tr>
				<td>password<font color='red'>*</font></td>
				<td><input type='password' name='password'></td>
			</tr>

			<tr>
				<td>mobile<font color='red'>*</font></td>
				<td><input type='text' name='mobile'></td>
			</tr>


			<tr>
				<td colspan='2' align='center'><input type='button'
					value='Register' onclick="javascript:validateForm()"></td>
			</tr>

		</table>
		</form>
</body>
</html>