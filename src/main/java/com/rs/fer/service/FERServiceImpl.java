package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.rs.fer.util.DBUtil;

@Service
public class FERServiceImpl implements FERService {

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
