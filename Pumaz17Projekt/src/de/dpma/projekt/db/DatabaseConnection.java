package de.dpma.projekt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnection {

		private static Connection instance;

		public static Connection getInstance() {
			if (DatabaseConnection.instance == null) {
				try {
					instance = DriverManager
							.getConnection("jdbc:mysql://192.168.137.79:3306/berichtsheft?verifyServerCertificate=false&useSSL=false&" + "user=mysql&password=mysql");
//					System.out.println("Klappt");
				} catch (SQLException e) {
//					System.out.println("Klappt nicht");
					e.printStackTrace();
				}
			}
			
			return DatabaseConnection.instance;
		}
	}
