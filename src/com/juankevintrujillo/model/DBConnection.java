package com.juankevintrujillo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juankevintr
 */
public class DBConnection {

    private String dbName;
    private Connection conn;

    public DBConnection(String db) {
	dbName = db;
    }

    public Connection connect() {
	try {
	    // BD params
	    String url = "jdbc:sqlite:"
		    + System.getenv().get("HOME")
		    + "/Documents/src/java-projects/Kata5/src/resources/"
		    + dbName + ".db";

	    // Creating the connetion to the DataBase
	    conn = DriverManager.getConnection(url);

	    System.out.println("Connection to DB '" + dbName + "' is enabled!\n");
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
	return conn;
    }

    public void disconnect() {
	try {
	    if (conn != null) {
		conn.close();
		System.out.println("\nConnection to DB '" + dbName + "' is disabled!");
	    }
	} catch (SQLException ex) {
	    System.out.println(ex.getMessage());
	}
    }

}
