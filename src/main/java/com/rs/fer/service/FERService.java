package com.rs.fer.service;

import java.util.List;

import com.rs.fer.model.Expense;
import com.rs.fer.model.User;


public interface FERService {
	
	boolean resetPassword(int userId, String currentpassword, String newpassword);
	
	int login(String username, String password);
	
	boolean addExpense(Expense expense);
	
	boolean deleteExpense(int expenseId);

}
