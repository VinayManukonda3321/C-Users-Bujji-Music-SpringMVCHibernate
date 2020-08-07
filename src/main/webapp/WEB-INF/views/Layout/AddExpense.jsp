
<script>
	function validateForm() {
		var form = document.Dashboardform;

		var errorMessages = '';

		if (form.expensetype.value == '') {
			errorMessages = 'please enter Expensetype';
		}
		if (form.date.value == '') {
			errorMessages += '<br> please enter Date';
		}
		if (form.price.value == '') {
			errorMessages += '<br> please enter Price';
		}
		if (form.noofitems.value == '') {
			errorMessages += '<br> please enter NoOfItems';
		}
		if (form.total.value == '') {
			errorMessages += '<br> please enter Total';
		}
		if (form.bywhome.value == '') {
			errorMessages += '<br> please enter ByWhome';
		}

		if (errorMessages != '') {
			//alert(errorMessages);

			var errorTrId = document.getElementById('errorTrId');
			var errorTdId = document.getElementById('errorTdId');

			errorTdId.style.color = 'red';

			errorTdId.innerHTML = errorMessages;
			errorTrId.style.display = '';

		} else {
			submitForm('addExpense');
		}
	}
</script>



<table align='center' border='1'>

	<tr>
		<td colspan='2' align='center'>AddExpense</td>
	</tr>
	<tr id='errorTrId' style='display: none;'>
		<td colspan='2' align='center' id='errorTdId'></td>
	</tr>
	<tr>
		<td>Expensetype <font color='red'>*</font></td>
		<td><input type='text' name='expensetype'></td>
	</tr>

	<tr>
		<td>Date <font color='red'>*</font></td>
		<td><input type='text' name='date'></td>
	</tr>

	<tr>
		<td>Price <font color='red'>*</font></td>
		<td><input type='text' name='price'></td>
	</tr>



	<tr>
		<td>NoOfItems<font color='red'>*</font></td>
		<td><input type='text' name='noofitems'></td>
	</tr>


	<tr>
		<td>Total<font color='red'>*</font></td>
		<td><input type='text' name='total'></td>
	</tr>

	<tr>
		<td>ByWhome<font color='red'>*</font></td>
		<td><input type='text' name='bywhome'></td>
	</tr>

	<tr>
		<td colspan='2' align='center'><input type='button'
			value='submit' onclick="javascript:validateForm()"></td>
	</tr>

</table>

