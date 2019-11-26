package com.juankevintrujillo.main;

import com.juankevintrujillo.model.*;

/**
 *
 * @author juankevintr
 */
public class Main {

    public static void main(String[] args) {
	// Examples 1 and 2
	Queries query = new Queries("People");
	query.selectAllPersons();
	query.endQueries();

	// Example 3 - DBConnection creates the database if it doesn't exist
	//  when enabling the connection
	DBConfiguration mail = new DBConfiguration("mail");
	mail.connect();

	// Example 4
	Queries fourExample = new Queries(mail);
	fourExample.createNewTable();

	// Example 5
	Queries fifthExample = new Queries(mail);
	fifthExample.insertEmail("me@juankevintrujillo.com");
	fifthExample.insertEmail("me@ulpgc.es");
	fifthExample.insertEmail("me@gmail.com");

	mail.disconnect();
    }
}
