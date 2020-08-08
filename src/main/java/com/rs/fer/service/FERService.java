package com.rs.fer.service;

import java.util.List;

import com.rs.fer.model.Expense;
import com.rs.fer.model.User;


public interface FERService {
	
	boolean registration(User user);
	
	boolean resetPassword(int userId, String currentpassword, String newpassword);
	
	int login(String username, String password);
	
	boolean addExpense(Expense expense);
	
	boolean deleteExpense(int expenseId);

	User getuser(int id);
	
	boolean updateUser(User user);
	
	List<Expense> expenseReport(int userId, String type, String fromDate, String toDate);
	
	List<Expense> getExpenses(int userid);

}
