package com.aman.dbTransaction;

import java.sql.*;
import java.util.*;
import org.apache.log4j.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import org.apache.log4j.*;

public class DBConnection {
	int id;
	String nameoncard;
	String CardNumber;
	String cardtype;
	double UnitPrice;
	int Quantity;
	double TotalPrice;
	String ExpDate;
	String CreatedOn;
	String CreatedBy;

	final static Logger logger = Logger.getLogger(DBConnection.class);
	// Step 1
	// create a JDBCSingleton class.
	// static member holds only one instance of the JDBCSingleton class.

	private static DBConnection jdbc;

	// JDBCSingleton prevents the instantiation from any other class.
	private DBConnection() {
	}

	// Now we are providing gloabal point of access.
	public static DBConnection getInstance() {
		if (jdbc == null) {
			jdbc = new DBConnection();
		}
		return jdbc;
	}

	// to get the connection from methods like insert, view etc.
	private static Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassignment2", "root", "1234");
		return con;

	}
//-----------------------------------------------------------------------------------------------------------------------------------

	// to insert the record into the database
	public boolean createTransaction(Transaction t) throws SQLException {
		Connection conn = null;
		// PreparedStatement ps = null;
		// int recordCounter = 0;

		int flag = 2;
		int t_id = t.getId();
		String t_name = t.getNameoncard();
		String t_cardtype = t.getCardtype();
		String t_CardNumber = t.getCardNumber();
		double t_UnitPrice = t.getUnitPrice();
		float t_Quantity = t.getQuantity();
		double t_TotalPrice = t.getTotalPrice();
		String t_ExpDate = t.getExpDate();
		String t_CreatedOn = t.getCreatedOn();
		String t_CreatedBy = t.getCreatedBy();

		try {
			String validation = t_name + t_CardNumber + t_ExpDate + t_CreatedOn + t_CreatedBy;
			if (!((validation.contains(";")) || (validation.contains("!")) || (validation.contains("@"))
					|| (validation.contains("#")) || (validation.contains("$")) || (validation.contains("%"))
					|| (validation.contains("^")) || (validation.contains("*")) || (validation.contains("+"))
					|| (validation.contains("?")) || (validation.contains("<")) || (validation.contains(">")))) {

				// conn = this.getConnection();
				conn = DBConnection.getConnection();

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from Transaction");// tofire query
				while (rs.next()) {
					if (t_id == rs.getInt(1)) {
						flag = 0;
					}
					// logger.info(rs.getInt(4));
					// logger.info(rs.getInt(1));
					// logger.info(rs.getString(2));
					// logger.info(rs.getString(3));
				}
				if (!(flag == 0)) {
					// int result =
					stmt.executeUpdate("INSERT INTO  Transaction VALUES (" + t_id + ",'" + t_name + "','" + t_cardtype
							+ "','" + t_CardNumber + "', " + t_UnitPrice + "," + t_Quantity + "," + t_TotalPrice + ",'"
							+ t_ExpDate + "','" + t_CreatedOn + "','" + t_CreatedBy + "')");
					// logger.info(result);
					flag = 1;

				}

			} else {
				logger.info("Please remove ; : ! @ # $ % ^ * + ? < > characters (if any) from the input");// to add data
																											// to
																											// logfile
			}

		} catch (MysqlDataTruncation e) {

			logger.info("Please provide correct date with format ie: Y-M-D H:M:S");

			// TODO: handle exception
		}

		catch (SQLException e) {
			e.printStackTrace();
			logger.info("Uable to save object");

			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Uable to save object");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

		if (flag == 1) {
			logger.info("Record Created Success");
			return true;
		} else if (flag == 0) {
			logger.info("ID already exists. Please use update method");
			return false;
		} else {
			logger.info("Connection Issue/Format Issue");
			return false;
		}

	}

	// -----------------------------------------------------------------------------------------------------------------------------------

	// to update details for the given ID
	public boolean updateTransaction(Transaction t) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		// PreparedStatement ps = null;

		int flag = 2;
		int flag1 = 0;
		int t_id = t.getId();
		String t_name = t.getNameoncard();
		String t_cardtype = t.getCardtype();
		String t_CardNumber = t.getCardNumber();
		double t_UnitPrice = t.getUnitPrice();
		float t_Quantity = t.getQuantity();
		double t_TotalPrice = t.getTotalPrice();
		String t_ExpDate = t.getExpDate();
		String t_CreatedOn = t.getCreatedOn();
		String t_CreatedBy = t.getCreatedBy();

		// int recordCounter = 0;
		try {
			conn = DBConnection.getConnection();

			Statement stmt = conn.createStatement();

			System.out.println("Please enter ID you want to update!");

			ResultSet rs = stmt.executeQuery("Select * from transaction");
			while (rs.next()) {
				if (t_id == rs.getInt(1)) {
					flag = 0;
				}
			}
			if ((flag == 0)) {
				// ID, NameOnCard, cardtype, CardNumber, UnitPrice, Quantity, TotalPrice,
				// ExpDate, CreatedOn, CreatedBy
				// int result =
				stmt.executeUpdate("UPDATE Transaction SET " + " NameOnCard" + "='" + t_name + "', cardtype" + "='"
						+ t_cardtype + "', CardNumber" + "='" + t_CardNumber + "', UnitPrice" + "=" + t_UnitPrice
						+ ", Quantity" + "=" + t_Quantity + ", TotalPrice" + "=" + t_TotalPrice + ", ExpDate" + "='"
						+ t_ExpDate + "', CreatedOn" + "='" + t_CreatedOn + "', CreatedBy" + "='" + t_CreatedBy
						+ "' where ID=" + t_id);
				flag = 1;
				flag1 = 1;

			}

		}

//		catch (MySQLIntegrityConstraintViolationException e) {
//
//			logger.info("Unable to save object");
//
//			// TODO: handle exception
//		} 
		catch (SQLException e) {
			e.printStackTrace();
			logger.info("Unable to save object");

			// TODO: handle exception
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

		if (flag == 2) {
			logger.info("ID not exists. Please use create method");
			return false;
		}
		if (flag == 1 && flag1 == 1) {
			logger.info("Update Success");
			return true;
		}

		else {
			logger.info("Connection Issue");
			return false;

		}
	}

	// -----------------------------------------------------------------------------------------------------------------------------------

	// to view the data from the database
	public Transaction getTransaction(int id) throws SQLException {
		Transaction t1 = new Transaction(id, nameoncard, cardtype, CardNumber, UnitPrice, Quantity, TotalPrice, ExpDate,
				CreatedOn, CreatedBy);
		int flag = 2;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from transaction where ID=" + id);
			while (rs.next()) {
				// logger.info(rs.getInt(1));
				t1.id = rs.getInt(1);
				t1.nameoncard = rs.getString(2);
				t1.cardtype = rs.getString(3);
				t1.CardNumber = rs.getString(4);
				t1.UnitPrice = rs.getDouble(5);
				t1.Quantity = rs.getInt(6);
				t1.TotalPrice = rs.getDouble(7);
				t1.ExpDate = rs.getString(8);
				t1.CreatedOn = rs.getString(9);
				t1.CreatedBy = rs.getString(10);
				flag = 1;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("Unable to get object");

			// TODO: handle exception
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		if (flag == 1) {
			logger.info("Success");
			return t1;
		}

		else {
			logger.info("Connection Issue");
			return t1;

		}
	}

	// -----------------------------------------------------------------------------------------------------------------------------------

	// to delete the data from the database
	public boolean removeTransaction(int id) throws SQLException {
		int flag = 2;
		int flag1 = 2;
		Connection conn = null;
		PreparedStatement ps = null;
		// int recordCounter = 0;

		try {
			conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("Select * from transaction");
			while (rs.next()) {
				if (id == rs.getInt(1)) {
					flag = 0;
					flag1 = 0;
				}

			}
			if (flag == 0) {
				stmt.executeUpdate("DELETE FROM transaction where ID=" + id);
				flag = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("Unable to get object");

			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		if (flag == 1) {
			logger.info("Row Deletion Succesfull");
			return true;
		}

		else if (flag1 == 2) {
			logger.info("ID Not Exists");
			return false;
		}

		else {
			logger.info("Connection Issue");
			return false;

		}
	}

	// Main

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		FileReader reader = null;
		try {
			reader = new FileReader("db.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Created_by = p.getProperty("user");
		logger.info(p.getProperty("user"));

		// DateFormat dateFormat = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
		// Calendar cal = Calendar.getInstance();
		// logger.info(dateFormat.format(cal)); //2016/11/16 12:08:43

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		logger.info(dtf.format(now));
		String date_today = dtf.format(now);

		BasicConfigurator.configure();
		DBConnection a = new DBConnection();

		logger.info("Operations you can perform on Database");
		logger.info("1. Create");
		logger.info("2. Update");
		logger.info("3. Retrive");
		logger.info("4. Delete");

		int user_input;
		int user_id;
		String user_name;
		String user_cardtype = "q";
		String user_cardnumber = "";
		Double user_unitprice;
		int user_quantity;
		Double user_totalprice;
		String user_expdate = "";
		int t = 0;
		int v = 0;

		Scanner scanner = new Scanner(System.in);

		logger.info("");
		// Get what the user types.
		int casebreaker = 0;
		do {
			System.out.print("Select Your Opertation you want to perform on Database: ");
			user_input = scanner.nextInt();
			switch (user_input) {
			case 1:
				logger.info("Please enter ID: ");
				user_id = scanner.nextInt();
				logger.info("Please Enter Name: ");
				user_name = scanner.next();
				logger.info("Please Select Your Card Type: ");
				logger.info("1. Mastercard");
				logger.info("2. Visa");
				logger.info("3. American Express");
				user_cardtype = scanner.next();

				while (t != 1) {
					logger.info("Please Enter Card Number: ");
					user_cardnumber = scanner.next();

					switch (user_cardtype) {
					case "mastercard":

						char[] ch = user_cardnumber.toCharArray();

						if (user_cardnumber.length() == 16) {
							if (ch[0] == '5' && ch[1] == '1' || ch[1] == '2' || ch[1] == '3' || ch[1] == '4'
									|| ch[1] == '5') {
								t = 1;

							}
						}
						break;

					case "visa":

						char[] ch1 = user_cardnumber.toCharArray();

						if (user_cardnumber.length() == 16) {
							if (ch1[0] == '4') {
								t = 1;

							}
						}
						break;

					case "american express":

						char[] ch2 = user_cardnumber.toCharArray();
						if (user_cardnumber.length() == 15) {
							if (ch2[0] == 3) {
								if (ch2[1] == 4 || ch2[1] == 7) {
									t = 1;

								}
							}
						}
						break;

					}
					if (t != 1) {
						logger.info("Please Enter Correct Card Number of " + user_cardtype + " Type!!!");
					}

				}
				t = 0;

				logger.info("Please Enter Unit Price: ");
				user_unitprice = scanner.nextDouble();
				logger.info("Please Enter Quantity: ");
				user_quantity = scanner.nextInt();
				user_totalprice = user_unitprice * user_quantity;
				int tempdate = 0;

				while (tempdate != 1) {
					logger.info(
							"Please enter valid expiry date in the format MM/YYYY with year ranges from 2016 to 2031");
					user_expdate = scanner.next();

					int yearmapper = Integer.parseInt(user_expdate.substring(user_expdate.length() - 4));
					int monthmapper = Integer.parseInt(user_expdate.substring(0, 2));
					int lengthmapper = user_expdate.length();

					if (lengthmapper == 7) {
						for (int i = 2016; i <= 2031; i++) {
							if (yearmapper == i) {
								logger.info(i);
								for (int j = 01; j <= 12; j++) {

									if (monthmapper == j) {
										if (user_expdate.substring(2, 3).equals("/")) {
											tempdate = 1;
										}
									}
								}

							}
						}

					}

					else {
						logger.info("Please Provide Valid Expiry Date With Complete Format!!!");
					}

				}

				logger.info("");
				// To Create a transaction
				logger.info("-----------Create transaction  Method--------------------");

				Transaction t11 = new Transaction(user_id, user_name, user_cardtype, user_cardnumber, user_unitprice,
						user_quantity, user_totalprice, user_expdate, date_today, Created_by);
				boolean r = a.createTransaction(t11);
				logger.info(r);

				logger.info(
						"Operation Completed!!!! If you want to exit press '1' else if you want to perform other operation press '0': ");
				casebreaker = scanner.nextInt();

				break; // optional

			case 2:
				// code to be executed;
				// To update one or many fields of a transaction on the basis of id

				logger.info("Please Enter ID: ");
				user_id = scanner.nextInt();
				logger.info("Please Enter Name: ");
				user_name = scanner.next();
				logger.info("Please Select Your Card Type: ");
				logger.info("1. Mastercard");
				logger.info("2. Visa");
				logger.info("3. American Express");
				user_cardtype = scanner.next();

				while (v != 1) {
					logger.info("Please Enter Card Number: ");
					user_cardnumber = scanner.next();

					switch (user_cardtype) {
					case "mastercard":

						char[] ch = user_cardnumber.toCharArray();

						if (user_cardnumber.length() == 16) {
							if (ch[0] == '5' && ch[1] == '1' || ch[1] == '2' || ch[1] == '3' || ch[1] == '4'
									|| ch[1] == '5') {
								v = 1;

							}
						}
						break;

					case "visa":

						char[] ch1 = user_cardnumber.toCharArray();

						if (user_cardnumber.length() == 16) {
							if (ch1[0] == '4') {
								v = 1;

							}
						}

					case "american express":

						char[] ch2 = user_cardnumber.toCharArray();
						if (user_cardnumber.length() == 15) {
							if (ch2[0] == 3) {
								if (ch2[1] == 4 || ch2[1] == 7) {
									v = 1;

								}
							}
						}
						break;

					}
					if (v != 1) {
						logger.info("Please enter correct card number of " + user_cardtype + " type");
					}

				}

				v = 0;

				logger.info("Please enter Unit Price: ");
				user_unitprice = scanner.nextDouble();
				logger.info("Please Enter Quantity: ");
				user_quantity = scanner.nextInt();
				user_totalprice = user_unitprice * user_quantity;
				int tempdate1 = 0;

				while (tempdate1 != 1) {
					logger.info(
							"Please enter valid expiry date in the format MM/YYYY with year ranges from 2016 to 2031");
					user_expdate = scanner.next();

					int yearmapper = Integer.parseInt(user_expdate.substring(user_expdate.length() - 4));
					int monthmapper = Integer.parseInt(user_expdate.substring(0, 2));
					int lengthmapper = user_expdate.length();

					if (lengthmapper == 7) {
						for (int i = 2016; i <= 2031; i++) {
							if (yearmapper == i) {
								logger.info(i);
								for (int j = 01; j <= 12; j++) {

									if (monthmapper == j) {
										if (user_expdate.substring(2, 3).equals("/")) {
											tempdate1 = 1;
										}
									}
								}

							}
						}

					}

					else {
						logger.info("Please Provide Valid Expiry Date With Complete Format!!! ");
					}

				}
				logger.info("");
				logger.info("");
				logger.info("");
				logger.info("----------- Update Transaction Method--------------------");
				Transaction t2 = new Transaction(user_id, user_name, user_cardtype, user_cardnumber, user_unitprice,
						user_quantity, user_totalprice, user_expdate, date_today, Created_by);
				boolean q = a.updateTransaction(t2);
				logger.info(q);

				logger.info(
						"Operation Completed!!!! if you want to exit press '1' else if you want to perform other operation press '0': ");
				casebreaker = scanner.nextInt();

				break; // optional

			case 3:
				// To retrieve a record from DB on the basis of ID
				logger.info("");
				logger.info("");
				logger.info("");
				logger.info("-----------Get Transaction Method--------------------");
				logger.info("Please Enter ID");
				user_id = scanner.nextInt();
				Transaction t1 = a.getTransaction(user_id);
				logger.info(t1);

				logger.info(
						"Operation Completed!!!! If you want to exit press '1' else if you want to perform other operation press '0': ");
				casebreaker = scanner.nextInt();

				break; // optional

			case 4:
				// On the basis of transaction ID deletes a Transaction row from the DB
				logger.info("");
				logger.info("");
				logger.info("");
				logger.info("-----------Remove Transaction Method--------------------");
				logger.info("Please Enter ID: ");
				user_id = scanner.nextInt();
				boolean x = a.removeTransaction(user_id);

				logger.info(
						"Operation Completed!!!! if you want to exit press 1 else if you want to perform other operation press 0");
				casebreaker = scanner.nextInt();

				break; // optional

			default:
				logger.info("Please Enter Valid Input!!!");
				logger.info(
						"Operation Failed!!!! If you want to exit press '1' else if you want to perform  operation press '0': ");
				casebreaker = scanner.nextInt();
			}

		} while (casebreaker != 1);

	}
}