<%@page import="java.util.*"%>
<%@page import="com.rs.fer.model.*"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<%
	FERService ferService = new FERServiceImpl();
	User user = (User) session.getAttribute("user");
	int id = Integer.parseInt(session.getAttribute("Id").toString());
	session.setAttribute("user", user);
 
	boolean isUpdate = ferService.updateUser(user);

	if (isUpdate) {
		out.println("update done sucessfully");
	} else {
		out.println("update failed");
	}
%>

