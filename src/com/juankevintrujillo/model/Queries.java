package com.juankevintrujillo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juankevintr
 */
public class Queries {

    private String dbName;
    private DBConnection DBC;
    private Connection conn;

    public Queries(String dbName) {
	this.dbName = dbName;
	DBC = new DBConnection(dbName);
	conn = DBC.connect();
    }

    public void endQueries() {
	DBC.disconnect();
    }

    public void selectAll() {
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

}
