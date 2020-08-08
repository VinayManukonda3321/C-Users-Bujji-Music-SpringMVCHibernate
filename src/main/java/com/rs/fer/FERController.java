package com.rs.fer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rs.fer.model.Expense;
import com.rs.fer.model.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

@Controller
public class FERController {

	private FERService ferService;

	@Autowired(required = true)
	public void setferService(FERService ps) {
		this.ferService = ps;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Login"; // To invoke another path
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int Id = ferService.login(username, password);

		if (Id > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("Id", Id);
			session.setAttribute("username", username);

			return "Dashboard";
		} else {
			return "Login"; // To invoke another path
		}
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "Registration"; // To invoke another path
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(HttpServletRequest request, HttpServletResponse response) throws IOException {

		FERService ferService = new FERServiceImpl();
		PrintWriter out = response.getWriter();

		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setMiddleName(request.getParameter("middleName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setMobile(request.getParameter("mobile"));
		user.setUsername(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));

		boolean isRegister = ferService.registration(user);

		if (isRegister) {
			out.println("registration done sucessfully");
			return "Login";

		} else {
			out.println("registration failed");
			return "Registration";
		}

	}

	@RequestMapping(value = "/addExpense", method = RequestMethod.GET)
	public String addExpense() {
		return "AddExpense"; // To invoke another path
	}

	@RequestMapping(value = "/addExpense", method = RequestMethod.POST)
	public String addExpense(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		Expense expense = new Expense();
		PrintWriter out = response.getWriter();

		expense.setType(request.getParameter("expensetype"));
		expense.setPrice(Float.parseFloat(request.getParameter("price")));
		expense.setNumberofitems(Integer.parseInt(request.getParameter("noofitems")));
		expense.setDate(request.getParameter("date"));
		expense.setBywhome(request.getParameter("bywhome"));
		expense.setTotal(Integer.parseInt(request.getParameter("total")));

		expense.setUserid(Integer.parseInt(session.getAttribute("Id").toString()));

		boolean isAdded = ferService.addExpense(expense);

		request.getSession().setAttribute("Status", isAdded ? "expenses added sucessfully" : "expenses not added");
		return "Status";

	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public String resetPassword() {
		return "ResetPassword"; // To invoke another path
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public String resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();

		FERService ferService = new FERServiceImpl();
		String currentPassword = request.getParameter("currentpassword");
		String newPassword = request.getParameter("newpassword");
		int Id = Integer.parseInt(session.getAttribute("Id").toString());

		boolean isReset = ferService.resetPassword(Id, currentPassword, newPassword);

		request.getSession().setAttribute("Status", isReset ? "reset password sucessful" : "Password reset failed");
		return "Status";

	}

	@RequestMapping(value = "/deleteExpense", method = RequestMethod.GET)
	public String deleteExpense() {
		return "DeleteExpense"; // To invoke another path
	}

	@RequestMapping(value = "/deleteExpense", method = RequestMethod.POST)
	public String deleteExpense(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int expenseId = Integer.parseInt(request.getParameter("ExpenseId"));

		boolean isDel = ferService.deleteExpense(expenseId);

		request.getSession().setAttribute("Status", isDel ? "deleted sucessfully" : "delete  failed");

		return "Status";

	}
	@RequestMapping(value = "/nameInfo", method = RequestMethod.GET)
	public String nameInfo() {
		return "NameInfo"; // To invoke another path
	}

	@RequestMapping(value = "/contactInfo", method = RequestMethod.POST)
	public String contactInfo() {
		return "ContactInfo"; // To invoke another path
	}

	@RequestMapping(value = "/addressInfo", method = RequestMethod.POST)
	public String addressInfo() {
		return "AddressInfo"; // To invoke another path
	}

	@RequestMapping(value = "/reviewInfo", method = RequestMethod.POST)
	public String reviewInfo() {
		return "ReviewInfo"; // To invoke another path
	}

	@RequestMapping(value = "/updatePersonalInfo", method = RequestMethod.POST)
	public String updatePersonalInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		session.setAttribute("user", user);

		boolean isUpdate = ferService.registration(user);

		request.getSession().setAttribute("Status", isUpdate ? "updated sucessfully" : "update failed");

		return "Status";

	}
	
	@RequestMapping(value = "/expenseReport", method = RequestMethod.GET)
	public String expenseReport() {
		return "ExpenseReport"; // To invoke another path
	}

	@RequestMapping(value = "/expenseReportPost", method = {RequestMethod.POST,RequestMethod.GET})
	public List<Expense> expenseReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String expenseType = request.getParameter("type");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		int Id = Integer.parseInt(session.getAttribute("Id").toString());

		List<Expense> expenseReport = ferService.expenseReport(Id, expenseType, fromDate, toDate);
		Iterator<Expense> iterator = expenseReport.iterator();
		Expense expense = null;
		out.println("<tr>");
		out.println("<td colspan='6' align='center'>ReportExpense</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>type</td>");
		out.println("<td>date</td>");
		out.println("<td>price</td>");
		out.println("<td>numberofItems</td>");
		out.println("<td>total</td>");
		out.println("<td>bywhome</td>");
		out.println("</tr>");

		while (iterator.hasNext()) {

			expense = iterator.next();

			int id = expense.getId();
			String type = expense.getType();
			float price = expense.getPrice();
			int numberofitems = expense.getNumberofitems();
			float total = expense.getTotal();
			String date = expense.getDate();
			String bywhome = expense.getBywhome();
			int userid = expense.getUserid();

			out.println("<tr>");
			out.println("<td>" + type + "</td>");
			out.println("<td>" + price + "</td>");
			out.println("<td>" + numberofitems + "</td>");
			out.println("<td>" + total + "</td>");
			out.println("<td>" + date + "</td>");
			out.println("<td>" + bywhome + "</td>");

			out.println("</tr>");

		}
		return expenseReport;
	}


}
