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

	
	
}
