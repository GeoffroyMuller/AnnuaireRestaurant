package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton DataBase Connexion
 * permet la connexion a la base
 * @author Geoff-Portable
 *
 */
public class DataBase {
	private static Connection instance;

	private DataBase() { }
	
	public static Connection getInstance() {
		try {
			if(DataBase.instance == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String urlBDD = "jdbc:mysql://localhost:3306/annuaire_resto?serverTimezone=UTC";
				DataBase.instance = DriverManager.getConnection(urlBDD, "root", "");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return DataBase.instance;
	}
}
