package com.mcds5510.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.mcds5510.connect.ConnectionSingleton;
import com.mcds5510.entity.Transaction;

public class MySqlAccess {

	public static Logger logger;

	public MySqlAccess() {
		initLogger();
	}

	private void initLogger() {
		logger = Logger.getLogger("myLog");
		FileHandler fh;
		try {
			fh = new FileHandler("/home/student_2018_fall/a_sharma/A00429273_MCDA5510/Assignment3_A00429273/logs/db.log");

			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Transaction resetTrxn(Transaction trxn) {
		trxn.setNewTotalPrice(trxn.getUnitPrice(), trxn.getQuantity());
		trxn.setNewCreatedOn();
		trxn.setNewCreatedBy();
		return trxn;
	}

	public Connection dbConnection() throws Exception {

		Connection connection = null;
		try {
			connection = ConnectionSingleton.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Exception: " + e.getMessage());
		} finally {

		}
		return connection;
	}

	public Collection<Transaction> getAllTransactions(Connection connection) {
		Statement statement = null;
		ResultSet resultSet = null;
		Collection<Transaction> results = new ArrayList<Transaction>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM a_sharma.Transaction");
			results = readTrxns(resultSet);

			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			statement = null;
			resultSet = null;
		}
		return results;
	}

	public void getSingleTrxn(String id, Connection connection) {
		System.out.println(id);
		System.out.println(connection);
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Transaction WHERE ID = " + id);

			if (resultSet.next()) {
				Transaction trxn = new Transaction();
				trxn.setId(resultSet.getString("ID"));
				trxn.setNameOnCard(resultSet.getString("NameOnCard"));
				trxn.setCardNumber(resultSet.getString("CardNumber"));
				trxn.setCardType(resultSet.getString("CardType"));
				trxn.setExpDate(resultSet.getString("ExpDate"));
				trxn.setUnitPrice(resultSet.getDouble("UnitPrice"));
				trxn.setQuantity(resultSet.getInt("Quantity"));
				trxn.setTotalPrice(resultSet.getDouble("TotalPrice"));
				trxn.setCreatedOn(resultSet.getString("CreatedOn"));
				trxn.setCreatedBy(resultSet.getString("CreatedBy"));
				System.out.println(trxn.toString());
				logger.log(Level.INFO, trxn.toString());

				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
			}

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Exception: " + e.getMessage());
			e.printStackTrace();
		}

	}

	private Boolean checkTrxn(String id, Connection connection) {
		Statement statement = null;
		ResultSet resultSet = null;
		Boolean is_exist = false;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Transaction WHERE ID = " + id);

			if (resultSet.next()) {
				is_exist = true;

				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
			}

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return is_exist;

	}

	public void createTrxns(Transaction trxn, Connection connection) {
		if (checkTrxn(trxn.getId(), connection)) {
			logger.log(Level.WARNING, trxn.getId() + " is already existed");
			return;
		}
		PreparedStatement statement = null;
		try {
			String insertSql = "INSERT INTO Transaction(ID, NameOnCard, cardtype, "
					+ "CardNumber, UnitPrice, Quantity, TotalPrice, ExpDate," + " CreatedOn, CreatedBy)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(insertSql);
			statement.setString(1, trxn.getId());
			statement.setString(2, trxn.getNameOnCard());
			statement.setString(3, trxn.getCardType());
			statement.setString(4, trxn.getCardNumber());
			statement.setDouble(5, trxn.getUnitPrice());
			statement.setInt(6, trxn.getQuantity());
			statement.setDouble(7, trxn.getTotalPrice());
			statement.setString(8, trxn.getExpDate());
			statement.setString(9, trxn.getCreatedOn());
			statement.setString(10, trxn.getCreatedBy());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				logger.log(Level.INFO, "User Inserted!");

				System.out.println("User Inserted!");
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void updateTrxns(Transaction trxn, Connection connection) {
		if (!checkTrxn(trxn.getId(), connection)) {
			logger.log(Level.WARNING, trxn.getId() + " is already existed");
			return;
		}
		PreparedStatement statement = null;
		try {
			String updateSql = "UPDATE Transaction SET NameOnCard=?, CardType=?,"
					+ "CardNumber=?, UnitPrice=?, Quantity=?, TotalPrice=?,"
					+ "ExpDate=?, CreatedOn=?, CreatedBy=? WHERE ID =?";
			statement = connection.prepareStatement(updateSql);
			statement.setString(10, trxn.getId());
			statement.setString(1, trxn.getNameOnCard());
			statement.setString(2, trxn.getCardType());
			statement.setString(3, trxn.getCardNumber());
			statement.setDouble(4, trxn.getUnitPrice());
			statement.setInt(5, trxn.getQuantity());
			statement.setDouble(6, trxn.getTotalPrice());
			statement.setString(7, trxn.getExpDate());
			statement.setString(8, trxn.getCreatedOn());
			statement.setString(9, trxn.getCreatedBy());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				logger.log(Level.INFO, "Updated successfully!");

				System.out.println("Updated successfully!");
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void removeTrxns(String id, Connection connection) {
		PreparedStatement statement = null;
		try {
			String deleteSql = "DELETE FROM Transaction WHERE ID = " + id;
			statement = connection.prepareStatement(deleteSql);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("User Deleted!");
				logger.log(Level.INFO, "User Deleted!");
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private Collection<Transaction> readTrxns(ResultSet resultSet) throws SQLException {
		Collection<Transaction> results = new ArrayList<Transaction>();

		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			Transaction trxn = new Transaction();
			trxn.setId(resultSet.getString("ID"));
			trxn.setNameOnCard(resultSet.getString("NameOnCard"));
			trxn.setCardType(resultSet.getString("cardtype"));
			trxn.setCardNumber(resultSet.getString("CardNumber"));
			trxn.setUnitPrice(resultSet.getDouble("UnitPrice"));
			trxn.setQuantity(resultSet.getInt("Quantity"));
			trxn.setTotalPrice(resultSet.getDouble("TotalPrice"));
			trxn.setExpDate(resultSet.getString("ExpDate"));
			trxn.setCreatedOn(resultSet.getString("CreatedOn"));
			trxn.setCreatedBy(resultSet.getString("CreatedBy"));

			results.add(trxn);
		}
		return results;
	}

	public void test() {
		logger.log(Level.INFO, "123");
		logger.log(Level.SEVERE, "1234");
	}
}
