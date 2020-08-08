
<%@page import="java.util.*"%>
<%@page import="com.rs.fer.model.*"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<script>
	function validateForm() {
		var form = document.DashboardForm;
		var errorMessages = '';
		if (form.mobile.value == '') {
			errorMessages = 'Please enter Mobile';
		}
		if (form.email.value == '') {
			errorMessages += '<BR>Please enter Email';
		}
				
		if (errorMessages != '') {
			//alert(errorMessages);
			var errorTrId1 = document.getElementById('errorTrId');
			var errorTdId1 = document.getElementById('errorTdId');
			errorTdId.style.color = 'red';
			errorTdId.innerHTML = errorMessages;
			errorTrId.style.display = '';
		} else {
			submitForm('addressInfo');
		}
	}
</script>



<%
	FERService ferService = new FERServiceImpl();
		User user = (User) session.getAttribute("user");

		user.setFirstName(request.getParameter("firstName"));
		user.setMiddleName(request.getParameter("middleName"));
		user.setLastName(request.getParameter("lastName"));

		session.setAttribute("user",user);

		out.println("<table align='center' border='1'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Contact</td>");
		out.println("<tr>");
		
		out.println("<tr id='errorTrId' style='display: none;'>");
		out.println("<td colspan='2' align='center' id='errorTdId'></td>");
		out.println("</tr>");

		
		
		out.println("<td>Email<font color='red'>*</td>");
		out.println("<td>");
		out.println("<input type='text' name='email' value='" + user.getEmail() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Mobile<font color='red'>*</td>");
		out.println("<td>");
		out.println("<input type='text' name='mobile' value='" + user.getMobile() + "'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type ='submit' value ='next' onclick='javaScript: validateForm()'>");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");

%>
