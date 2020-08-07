package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

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

	
	

}
