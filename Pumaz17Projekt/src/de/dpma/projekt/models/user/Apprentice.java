package de.dpma.projekt.models.user;

import de.dpma.projekt.models.User;

import java.util.Date;


public class Apprentice extends User {
	
	private int user_id;
	private String job;
	private User instructor;
	private byte yearOfEmployment;
	private Date birthday;
	private int postalCode;
	private String street;
	private short housenumber;
	private String cityPostalCode;
	private Date employmentBegin;
	private Date employmentEnd;
	private String placeOfEmployment;
	

	
	public Apprentice(int user_id, User instructor) {
		this.user_id = user_id;
		this.instructor = instructor;
	}
	
	

}
