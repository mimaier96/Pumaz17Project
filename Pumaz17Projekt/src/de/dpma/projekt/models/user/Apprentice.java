package de.dpma.projekt.models.user;

import de.dpma.projekt.models.User;

public class Apprentice extends User {

	private String job;
	private int user_id;
	private User instructor;


	public Apprentice(int id, String firstname, String lastname, String username, String password, String role, String email, User instructor) {
		super(id, firstname, lastname, username, password, role, email);
		this.user_id = id;
		this.instructor = instructor;
	}

}
