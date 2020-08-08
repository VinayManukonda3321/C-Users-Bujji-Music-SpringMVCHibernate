package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.rs.fer.model.Expense;
import com.rs.fer.model.User;
import com.rs.fer.util.DBUtil;

@Service
public class FERServiceImpl implements FERService {

	final static Loader logger = Logger.getLogger(FERServiceImpl.class);

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
	public boolean registration(User user) {
		Connection connection = null;
		PreparedStatement statement = null;

		logger.info("registration:: user:" + user);
		logger.debug("registration:: password: " + user.getPassword());

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO user (firstName,middleName,lastName,email,mobile,userName,password) VALUES(?,?,?,?,?,?,?);");
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getMiddleName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getMobile());
			statement.setString(6, user.getUsername());
			statement.setString(7, user.getPassword());

			int numOfRecsIns = statement.executeUpdate();

			logger.info("registration:: numOfRecsIns:" + numOfRecsIns);

			return numOfRecsIns > 0;

		}

		catch (SQLException e) {

			logger.error("registration:: SQLException:" + e.getMessage());

		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
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

	@Override
	public User getuser(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		User user = new User();
		Address address = new Address();

		logger.info("getuser:: id:" + id);

		try {

			connection = DBUtil.getConnection();

			statement = connection
					.prepareStatement("select u.*,a.* from user u left join address a on u.id=a.userid where u.id=?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setMiddleName(resultSet.getString("middlename"));
				user.setLastName(resultSet.getString("lastname"));
				user.setEmail(resultSet.getString("email"));
				user.setMobile(resultSet.getString("mobile"));
				user.setUserName(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));

				address.setId(resultSet.getInt("id"));
				address.setLineOne(resultSet.getString("lineone"));
				address.setLineTwo(resultSet.getString("linetwo"));
				address.setCity(resultSet.getString("city"));
				address.setCountry(resultSet.getString("country"));
				address.setState(resultSet.getString("state"));
				address.setPostal(resultSet.getString("postal"));
				user.setAddress(address);
			}
		} catch (SQLException e) {
			logger.error("registration:: SQLException:" + e.getMessage());
		} finally {

			DBUtil.closeConnection(connection);
		}

		return user;
	}

	@Override
	public boolean updateUser(User user) {
		Connection connection = null;
		PreparedStatement statement = null;

		logger.info("updateUser:: user:" + user);

		logger.debug("updateUser:: password: " + user.getPassword());

		try {

			connection = DBUtil.getConnection();

			connection.setAutoCommit(false);

			statement = connection.prepareStatement(
					"UPDATE USER SET firstname=?,middlename=?,lastname=?,email=?,mobile=? WHERE id=?");
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getMiddleName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getMobile());

			int userUpdate = statement.executeUpdate();

			statement = connection.prepareStatement(
					"insert int adress(lineone,linetwo,city,state,country,postal) values(?,?,?,?,?,?)");
			statement.setString(6, user.getAddress().getLineOne());
			statement.setString(7, user.getAddress().getLineTwo());
			statement.setString(8, user.getAddress().getCity());
			statement.setString(9, user.getAddress().getState());
			statement.setString(10, user.getAddress().getPostal());
			statement.setString(11, user.getAddress().getCountry());

			if (userUpdate > 0) {
				return true;
			}

		}

		catch (SQLException e) {
			logger.error("registration:: SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}
	
	@Override
	public List<Expense> getExpenses(int userid) {
		List<Expense> expenses = new ArrayList<Expense>();
		Expense expense = null;
		Connection connection = null;
		PreparedStatement statement = null;

		logger.info("getExpenses:: userid:" + userid);

		try {
			connection = DBUtil.getConnection();

			statement = connection.prepareStatement("SELECT * FROM expense where userid=?");
			statement.setInt(1, userid);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				expense = new Expense();

				expense.setId(resultset.getInt("id"));
				expense.setType(resultset.getString("type"));
				expense.setPrice(resultset.getFloat("price"));
				expense.setNumberofitems(resultset.getInt("numberofitems"));
				expense.setTotal(resultset.getInt("total"));
				expense.setDate(resultset.getString("date"));
				expense.setUserid(resultset.getInt("userid"));

				expenses.add(expense);
			}
		}

		catch (SQLException e) {
			logger.error("registration:: SQLException:" + e.getMessage());
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;
	}

	@Override
	public List<Expense> expenseReport(int userId, String type, String fromDate, String toDate) {
		List<Expense> expenses = new ArrayList<Expense>();
		Connection connection = null;
		PreparedStatement statement = null;
		Expense expense = null;

		logger.info("expenseReport:: userId:" + userId);
		logger.info("expenseReport:: type:" + type);
		logger.info("expenseReport:: fromDate:" + fromDate);
		logger.info("expenseReport:: toDate:" + toDate);

		try {

			connection = DBUtil.getConnection();

			statement = connection
					.prepareStatement("SELECT * FROM expense WHERE userid=? and type=? and date between ? and ?");
			statement.setInt(1, userId);
			statement.setString(2, type);
			statement.setString(3, fromDate);
			statement.setString(4, toDate);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {

				expense = new Expense();

				expense = new Expense();
				expense.setId(resultset.getInt("id"));
				expense.setType(resultset.getString("type"));
				expense.setPrice(resultset.getFloat("price"));
				expense.setNumberofitems(resultset.getInt("numberofitems"));
				expense.setTotal(resultset.getInt("total"));
				expense.setDate(resultset.getString("date"));
				expense.setUserid(resultset.getInt("userid"));
				expense.setBywhome(resultset.getString("bywhome"));

				expenses.add(expense);

			}
		}

		catch (SQLException e) {
			logger.error("registration:: SQLException:" + e.getMessage());
		} finally {

			DBUtil.closeConnection(connection);
		}

		return expenses;
	}

}
