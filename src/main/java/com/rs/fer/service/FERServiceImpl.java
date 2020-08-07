package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.rs.fer.model.Expense;
import com.rs.fer.util.DBUtil;

@Service
public class FERServiceImpl implements FERService {

	@Override
	public int login(String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;

		logger.info("login:: username:" + username);
		logger.debug("login:: password: " + password);

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("select * from user where username=? and password=?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultset = statement.executeQuery();
			int id = 0;
			while (resultset.next()) {

				id = resultset.getInt(1);
			}
			return id;

		}

		catch (SQLException e) {
			logger.error("registration:: SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}

		return 0;
	}

	@Override
	public boolean addExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement statement = null;

		logger.info("addExpense:: expense:" + expense);

		logger.debug("addExpense:: date: " + expense.getDate());

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO expense (type,price,numberofitems,total,date,bywhome,userid) VALUES(?,?,?,?,?,?,?)");
			statement.setString(1, expense.getType());
			statement.setFloat(2, expense.getPrice());
			statement.setInt(3, expense.getNumberofitems());
			statement.setInt(4, expense.getTotal());
			statement.setString(5, expense.getDate());
			statement.setString(6, expense.getBywhome());
			statement.setInt(7, expense.getUserid());

			int numOfRecsAdd = statement.executeUpdate();

			logger.info("addExpense:: numOfRecsIns:" + numOfRecsAdd);

			return numOfRecsAdd > 0;
		}

		catch (SQLException e) {
			logger.error("registration:: SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}


	@Override
	public boolean resetPassword(int Id, String currentpassword, String newpassword) {
		Connection connection = null;
		PreparedStatement statement = null;

		logger.info("resetPassword:: Id:" + Id);

		logger.debug("resetPassword:: currentpassword: " + currentpassword);
		logger.debug("resetPassword:: newpassword: " + newpassword);

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("UPDATE user SET password=? WHERE password=? and id=?");

			statement.setString(1, newpassword);
			statement.setString(2, currentpassword);
			statement.setInt(3, Id);

			int resetPassword = statement.executeUpdate();

			logger.info("resetPassword:: numOfRecsIns:" + resetPassword);

			return resetPassword > 0;
		}

		catch (SQLException e) {
			logger.error("registration:: SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}


	@Override
	public boolean deleteExpense(int expenseId) {
		Connection connection = null;
		PreparedStatement statement = null;

		logger.info("deleteExpense:: expenseId:" + expenseId);

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("DELETE FROM expense WHERE id=?");

			statement.setInt(1, expenseId);

			int numOfRecsDel = statement.executeUpdate();

			logger.info("deleteExpense:: numOfRecsIns:" + numOfRecsDel);

			return numOfRecsDel > 0;

		}

		catch (SQLException e) {
			logger.error("registration:: SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}


}
