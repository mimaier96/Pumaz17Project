package de.dpma.projekt.db;

import java.sql.SQLException;

import de.dpma.projekt.models.user.Apprentice;
import de.dpma.projekt.models.user.Instructor;

public class UserInsertImplementation {
	
	/**
	 * Database insert test
	 * @author MaSpecter
	 */
	UserDaoImplementation userImpl = new UserDaoImplementation();
	
	Apprentice apprenticeInsert;
	
	public void insertUser() {
	
		
	Instructor instructor = userImpl.getInstructor(1);
	/*
	 * firstname, lastname, username,
	 * password, role, email, instructor
	 * */
	
	try {
		apprenticeInsert = userImpl.insertApprentice(new Apprentice("Max", "Müller", "mamuelle", "", "Fachinformatiker/in Systemintegration", "max.mueller@dpma.de", instructor));
		System.out.println(apprenticeInsert.getFirstname());
		System.out.println(apprenticeInsert.getLastname());
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	/**
	 * Database insert Test Ende
	 */
	
	}

}
