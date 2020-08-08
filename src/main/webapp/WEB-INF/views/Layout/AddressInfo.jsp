<%@page import="java.util.*"%>
<%@page import="com.rs.fer.model.*"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<script>
	function validateForm() {
		var form = document.DashboardForm;
		var errorMessages = '';
		if (form.lineOne.value == '') {
			errorMessages = 'Please enter Line1';
		}
		if (form.lineTwo.value == '') {
			errorMessages += '<BR>Please enter Line2';
		}
		if (form.city.value == '') {
			errorMessages = 'Please enter City';
		}
		if (form.state.value == '') {
			errorMessages += '<BR>Please enter State';
		}
		if (form.country.value == '') {
			errorMessages = 'Please enter Country';
		}
		if (form.Postal.value == '') {
			errorMessages += '<BR>Please enter Postal';
		}
				
		if (errorMessages != '') {
			//alert(errorMessages);
			var errorTrId1 = document.getElementById('errorTrId');
			var errorTdId1 = document.getElementById('errorTdId');
			errorTdId.style.color = 'red';
			errorTdId.innerHTML = errorMessages;
			errorTrId.style.display = '';
		} else {
			submitForm('reviewInfo');
		}
	}
</script>

<%
	FERService ferService = new FERServiceImpl();
	User user = (User) session.getAttribute("user");
	Address address = user.getAddress();
	user.setEmail(request.getParameter("email"));
	user.setMobile(request.getParameter("mobile"));
	session.setAttribute("user", user);

	out.println("<table align='center' border='1'>");
	out.println("<tr>");
	out.println("<td colspan='2' align='center'>Address</td>");
	out.println("</tr>");
	
	out.println("<tr id='errorTrId' style='display: none;'>");
	out.println("<td colspan='2' align='center' id='errorTdId'></td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Line1<font color='red'>*</td>");
	out.println("<td>");
	out.println("<input type='text' name='lineOne' value='" + address.getLineOne() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Line2<font color='red'>*</td>");
	out.println("<td>");
	out.println("<input type='text' name='lineTwo' value='" + address.getLineTwo() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>City<font color='red'>*</td>");
	out.println("<td>");
	out.println("<input type='text' name='city' value='" + address.getCity() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>State<font color='red'>*</td>");
	out.println("<td>");
	out.println("<input type='text' name='state' value='" + address.getState() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Country<font color='red'>*</td>");
	out.println("<td>");
	out.println("<input type='text' name='country' value='" + address.getCountry() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Postal<font color='red'>*</td>");
	out.println("<td>");
	out.println("<input type='text' name='Postal' value='" + address.getPostal() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td colspan='2' align='center'>");
	out.println("<input type ='submit' value ='next' onclick='javaScript: validateForm()'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("</table>");
%>
