
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@page import="com.rs.fer.model.User"%>

<%


		FERService ferService = new FERServiceImpl();
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setMiddleName(request.getParameter("middleName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setMobile(request.getParameter("mobile"));
		user.setUsername(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));

		boolean isRegister = ferService.registration(user);


		String nextPath = null;
		if (isRegister) {
			out.println("registration done sucessfully");
			nextPath = "Login.html";

		} else {
			out.println("registration failed");
			nextPath = "Registration.html";
		}
		
%>
<jsp:include page="<%=nextPath%>"></jsp:include>