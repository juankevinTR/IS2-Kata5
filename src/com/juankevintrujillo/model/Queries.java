package com.juankevintrujillo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juankevintr
 */
public class Queries {

    private String dbName;
    private DBConfiguration DBC;
    private Connection conn;

    public Queries(String dbName) {
	this.dbName = dbName;
	DBC = new DBConfiguration(dbName);
	conn = DBC.connect();
    }

    public Queries(DBConfiguration DBC) {
	this.DBC = DBC;
	this.conn = DBC.conn;
    }

    public void endQueries() {
	DBC.disconnect();
    }

    public void selectAllPersons() {
	String sql = "SELECT * FROM Person";

	try (Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql)) {
	    // Loop for all data
	    while (rs.next()) {
		System.out.println(rs.getInt("PersonID") + "\t"
			+ rs.getString("Name") + "\t"
			+ rs.getString("Surnames") + "\t"
			+ rs.getString("Department") + "\t");
	    }
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
    }

    public void createNewTable() {
	String sql = "CREATE TABLE IF NOT EXISTS direcc_email (\n"
		+ " id integer PRIMARY KEY AUTOINCREMENT,\n"
		+ " direccion text NOT NULL);";

	try (Statement stmt = conn.createStatement()) {
	    stmt.execute(sql);

	    System.out.println("Table was created successfully");
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
    }

    public void insertEmail(String email) {
	String sql = "INSERT INTO direcc_email(direccion) VALUES(?)";

	try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    pstmt.setString(1, email);
	    pstmt.executeUpdate();

	    System.out.println("The email '" + email + "' was inserted successfully");
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
    }
}
