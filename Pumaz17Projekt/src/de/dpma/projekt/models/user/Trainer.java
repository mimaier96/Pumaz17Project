package de.dpma.projekt.models.user;

import java.sql.SQLException;

import de.dpma.projekt.db.UserDaoImpl;
import de.dpma.projekt.models.User;

public class Trainer extends User{

	
	
	public Trainer(String firstname, String lastname, String username, String password, String role, String email) {
		
		super(firstname, lastname, username, password, role, email);
		
		UserDaoImpl i = new UserDaoImpl();
		try {
			i.insertUser(this);
			i.getUserID(this);
		} catch (SQLException e) {
			System.out.println("LARL");
			e.printStackTrace();
		}
	}

	
	
}
