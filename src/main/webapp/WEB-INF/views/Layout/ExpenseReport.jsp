<script>
	function validateForm() {
		var form = document.DashboardForm;
		var errorMessages = '';
		if (form.type.value == '') {
			errorMessages = 'Please enter Expensetype';
		}

		if (form.fromDate.value == '') {
			errorMessages += '<BR>Please enter FromDate';
		}
		if (form.toDate.value == '') {
			errorMessages += '<BR>Please enter ToDate';
		}
		if (errorMessages != '') {
			//alert(errorMessages);
			var errorTrId = document.getElementById('errorTrId');
			var errorTdId = document.getElementById('errorTdId');
			errorTdId.style.color = 'red';
			errorTdId.innerHTML = errorMessages;
			errorTrId.style.display = '';
		} else {
			submitForm('expenseReport');
		}
	}
</script>


<table align='center' border='1'>

	<tr>
		<td colspan='2' align='center'>ReportExpense</td>
	<tr>
	<tr id='errorTrId' style='display: none;'>
		<td colspan='2' align='center' id='errorTdId'></td>
	<tr>


		<td>Expensetype<font color='red'>*</td>
		<td><input type='text' name='type'></td>
	</tr>

	<tr>
		<td>FromDate<font color='red'>*</td>
		<td><input type='text' name='fromDate'></td>
	</tr>

	<tr>
		<td>ToDate<font color='red'>*</td>
		<td><input type='text' name='toDate'></td>
	</tr>


	<tr>
		<td colspan='2' align='center'><input type='submit'
			value='get report' onclick="javaScript:validateForm()"></td>
	</tr>

</table>


