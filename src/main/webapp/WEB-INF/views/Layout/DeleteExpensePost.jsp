
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService ferService = new FERServiceImpl();

	int expenseId = Integer.parseInt(request.getParameter("ExpenseId"));

	boolean isDel = ferService.deleteExpense(expenseId);
%>
<jsp:include page="Layout/HeaderAndLeftFrame.jsp"></jsp:include>

<%
	if (isDel) {
		out.println("deleted sucessfully");
	} else {
		out.println("delete  failed");
	}
%>
<jsp:include page="Layout/Footer.html"></jsp:include>

