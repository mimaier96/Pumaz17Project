package de.dpma.projekt.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DatabaseConnection {
	
	static final Logger log = LogManager.getLogger(DatabaseConnection.class.getName());

		private static Connection instance;

		public static Connection getInstance() {
			log.info("-->Starte: getInstance");
			
			if (DatabaseConnection.instance == null) {
				try {
					instance = DriverManager
							.getConnection("jdbc:mysql://192.168.111.108:3306/berichtsheft?veryServerCertificate=false&useSSL=false&" + "user=mysql&password=mysql");
					log.info("Datenbankverbindung gestartet !");
				} catch (SQLException e) {
					e.printStackTrace();
					log.info("Datenbankverbindung fehgeschlagen!");
				}
			}
			
			log.info("-->Beende: getInstance");
			return DatabaseConnection.instance;
		}
	}
