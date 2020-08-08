<%@page import="java.util.*"%>
<%@page import="com.rs.fer.model.*"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>


<script>
	function validateForm() {
		var form = document.DashboardForm;
		var errorMessages = '';
		if (form.firstName.value == '') {
			errorMessages = 'Please enter Firstname';
		}
		if (form.middleName.value == '') {
			errorMessages += '<BR>Please enter MiddleName';
		}
				if (form.lastName.value == '') {
			errorMessages += '<BR>Please enter lastname';
		}

		if (errorMessages != '') {
			//alert(errorMessages);
			var errorTrId1 = document.getElementById('errorTrId');
			var errorTdId1 = document.getElementById('errorTdId');
			errorTdId.style.color = 'red';
			errorTdId.innerHTML = errorMessages;
			errorTrId.style.display = '';
		} else {
			submitForm('contactInfo');
		}
	}
</script>

<%
	FERService ferService = new FERServiceImpl();

	User user = ferService.getuser(Integer.parseInt(session.getAttribute("Id").toString()));

	session.setAttribute("user", user);
%>
<%
	out.println("<table align='center' border='1'>");

	out.println("<tr>");
	out.println("<td colspan='2' align='center'>PersonalName</td>");
	out.println("</tr>");
	
	out.println("<tr id='errorTrId' style='display: none;'>");
	out.println("<td colspan='2' align='center' id='errorTdId'></td>");
	out.println("</tr>");


	out.println("<td>FirstName<font color='red'>*</td>");
	out.println("<td>");
	out.println("<input type='text' name='firstName' value='" + user.getFirstName() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>MiddleName<font color='red'>*</td>");
	out.println("<td>");
	out.println("<input type='text' name='middleName' value='" + user.getMiddleName() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>LastName<font color='red'>*</td>");
	out.println("<td>");
	out.println("<input type='text' name='lastName' value='" + user.getLastName() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td colspan='2' align='center'>");
	out.println("<input type='submit' value='next' onclick='javaScript:validateForm()'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("</table>");
%>
