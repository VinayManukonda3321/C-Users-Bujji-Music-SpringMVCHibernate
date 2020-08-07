
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<%
	FERService ferService = new FERServiceImpl();

	String username = request.getParameter("username");
	String password = request.getParameter("password");

	int Id = ferService.login(username, password);


	if (Id > 0) {

		session.setAttribute("Id", Id);
		session.setAttribute("username", username);
%>
<jsp:include page="Layout/HeaderAndLeftFrame.jsp"></jsp:include>
<%
		out.println("logged in  user" + username);
	%>
<jsp:include page="Layout/Footer.html"></jsp:include>
<%
	} else {
		out.println("log in  failed");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
	}
		%>
	