

<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.rs.fer.model.Expense"%>
<%@page import="java.util.List"%>
<%
	FERService ferService = new FERServiceImpl();

	int userId = Integer.parseInt(session.getAttribute("Id").toString());

	List<Expense> expenses = ferService.getExpenses(userId);
	Iterator<Expense> iterator = expenses.iterator();
	Expense expense = null;
%>

<script>
	function validateForm() {
		var form = document.Dashboardform;

		var errorMessages = '';

		if (form.ExpenseId.value == 0) {

			//alert(errorMessages);

			errorMessages = 'no expenses to delete'

			var errorTrId = document.getElementById('errorTrId');
			var errorTdId = document.getElementById('errorTdId');

			errorTdId.style.color = 'red';

			errorTdId.innerHTML = errorMessages;
			errorTrId.style.display = '';

		} else {
			submitForm('deleteExpense');
		}

	}
</script>

<table align='center'>
	<tr>
		<id ='errorTrId' style='display: none;'>
		<td colspan='2' align='center' id='errorTdId'></td>
	</tr>
</table>


<%
		out.println("ID  <font color='red'>*</font>:<select name=ExpenseId>");
		out.println("<option value='0'>please select/option");

	while (iterator.hasNext()) {

		expense = iterator.next();

		int id = expense.getId();

		String type = expense.getType();
		float price = expense.getPrice();
		int numberofitems = expense.getNumberofitems();
		float total = expense.getTotal();
		String date = expense.getDate();
		String bywhome = expense.getBywhome();

		out.println("<option value='" + id + "'>" + type + "," + price + "," + numberofitems + "," + total + ","
				+ date + "," + bywhome + "</option>");

	}

	out.println(
			"<input type ='button' value ='next' onclick=\"javaScript:validateForm()\">");
%>

