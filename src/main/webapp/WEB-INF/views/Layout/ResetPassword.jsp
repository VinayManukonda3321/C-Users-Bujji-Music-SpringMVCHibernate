<script>
	function validateForm() {
		var form = document.DashboardForm;
		var errorMessages = '';
		if (form.currentpassword.value == '') {
			errorMessages = 'Please enter CurrentPassword';
		}
		if (form.newpassword.value == '')
			
		{
			errorMessages += '<BR>Please enter NewPassword';
		}
		if (form.confirmnewpassword.value == '') {
			errorMessages += '<BR>Please enter ConfirmNewPassword';
		}

		if (errorMessages != '') {
			//alert(errorMessages);
			var errorTrId = document.getElementById('errorTrId');
			var errorTdId = document.getElementById('errorTdId');
			errorTdId.style.color = 'red';
			errorTdId.innerHTML = errorMessages;
			errorTrId.style.display = '';

		} else {
			submitForm('resetPassword');
		}
	}
</script>

<table align='center' border='1'>

	<tr>
		<td colspan='2' align='center'>ResetPassword</td>
	<tr>
	<tr id='errorTrId' style='display: none;'>
		<td colspan='2' align='center' id='errorTdId'></td>
	<tr>


		<td>CurrentPassword<font color='red'>*</td>
		<td><input type='Password' name='currentpassword'></td>
	</tr>

	<tr>
		<td>NewPassword<font color='red'>*</td>
		<td><input type='Password' name='newpassword'></td>
	</tr>

	<tr>
		<td>ConfirmNewPassword<font color='red'>*</td>
		<td><input type='Password' name='confirmnewpassword'></td>
	</tr>


	<tr>
		<td colspan='2' align='center'><input type='submit' value='save'
			onclick='javaScript: validateForm()'></td>
	</tr>

</table>
