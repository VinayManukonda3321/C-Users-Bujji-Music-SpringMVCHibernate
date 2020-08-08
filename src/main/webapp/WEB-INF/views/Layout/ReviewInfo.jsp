<%@page import="java.util.*"%>
<%@page import="com.rs.fer.model.*"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<%
	FERService ferService = new FERServiceImpl();
	User user = (User) session.getAttribute("user");

	Address address = user.getAddress();

	address.setLineOne(request.getParameter("lineOne"));
	address.setLineTwo(request.getParameter("lineTwo"));
	address.setCity(request.getParameter("city"));
	address.setState(request.getParameter("state"));
	address.setCountry(request.getParameter("country"));
	address.setPostal(request.getParameter("Postal"));

	session.setAttribute("user", user);

	out.println("<table align='center' border='1'>");

	out.println("<tr>");
	out.println("<td colspan='2' align='center'>Review</td>");

	out.println("<tr>");
	out.println("<td>FirstName</td>");
	out.println("<td>");
	out.println("<input type='text' name='firstName' value='" + user.getFirstName() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>MiddleName</td>");
	out.println("<td>");
	out.println("<input type='text' name='middleName' value='" + user.getMiddleName() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>LastName</td>");
	out.println("<td>");
	out.println("<input type='text' name='lastName' value='" + user.getLastName() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Email</td>");
	out.println("<td>");
	out.println("<input type='text' name='email' value='" + user.getEmail() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Mobile</td>");
	out.println("<td>");
	out.println("<input type='text' name='mobile' value='" + user.getMobile() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Line1</td>");
	out.println("<td>");
	out.println("<input type='text' name='lineOne' value='" + address.getLineOne() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Line2</td>");
	out.println("<td>");
	out.println("<input type='text' name='lineTwo' value='" + address.getLineTwo() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>City</td>");
	out.println("<td>");
	out.println("<input type='text' name='city' value='" + address.getCity() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>State</td>");
	out.println("<td>");
	out.println("<input type='text' name='state' value='" + address.getState() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Country</td>");
	out.println("<td>");
	out.println("<input type='text' name='country' value='" + address.getCountry() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td>Postal</td>");
	out.println("<td>");
	out.println("<input type='text' name='Postal' value='" + address.getPostal() + "'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td colspan='2' align='center'>");
	out.println(
			"<input type ='submit' value ='next' onclick=\"javaScript: submitForm('UpdatePersonalInfo')\">");
	out.println("</td>");
	out.println("</tr>");

	out.println("</table>");
%>
