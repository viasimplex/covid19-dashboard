package com.viasimplex.covid19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Helper class needed to create direct database JDBC connection. Instantiate
 * using constructor with arguments and call getConnection() method
 * 
 * @author Sreeharsha Venkatapuram
 * @version 2.0
 * @since 2nd April 2020
 */
public class DBConnection {

	private String jdbcUri = null;
	private String dbPword = null;
	private String dbUname = null;

	public DBConnection() {

	}

	/**
	 * Constructor to instantiate the DBConnection class with all arguments
	 * needed to open a connection
	 * 
	 * @param jdbcUri
	 *            - JDBC URI to connect to
	 * @param dbUname
	 *            - Database username
	 * @param dbPword
	 *            - Database password
	 */
	public DBConnection(String jdbcUri, String dbUname, String dbPword) {
		super();
		this.jdbcUri = jdbcUri;
		this.dbPword = dbPword;
		this.dbUname = dbUname;
	}

	/**
	 * 
	 * @return Connection object which can be used to connect to database
	 *         instantiated on DBConnection object
	 */
	public Connection getConnection() {
		Connection con = null;
		Connection con1 = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(jdbcUri, dbUname, dbPword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}
}
