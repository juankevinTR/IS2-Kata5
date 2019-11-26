package com.juankevintrujillo.main;

import com.juankevintrujillo.model.Queries;

/**
 *
 * @author juankevintr
 */
public class Main {

    public static void main(String[] args) {
	Queries query = new Queries("People");
	query.selectAll();
	query.endQueries();
    }

}
