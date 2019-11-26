package com.juankevintrujillo.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juankevintr
 */
public class DBConfiguration {

    private String dbName;
    public Connection conn;

    public DBConfiguration(String db) {
	dbName = db;
    }

    public Connection connect() {
	try {
	    // BD params
	    String url = "jdbc:sqlite:"
		    + System.getenv().get("HOME")
		    + "/Documents/src/java-projects/Kata5/src/resources/"
		    + dbName + ".db";

	    // Checking if a file/database doesn't exist
	    if (!new File(url).isFile()) {
		System.out.println("\nThe new database '" + dbName + "' has been created!");
	    }

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
