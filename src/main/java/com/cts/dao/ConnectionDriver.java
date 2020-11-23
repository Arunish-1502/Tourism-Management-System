package com.cts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConnectionDriver {
	public static Connection getConn() throws SQLException
	{
		Driver driver=new com.mysql.jdbc.Driver();
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/tourist_management","root","root");
	}
}
