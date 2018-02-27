package de.dpma.projekt.models.user;

import de.dpma.projekt.models.User;

public class Apprentice extends User {
	
	private String job;
	private int user_id;
	private User instructor;
	
	public Apprentice(int user_id, User instructor) {
		this.user_id = user_id;
		this.instructor = instructor;
	}
	
	

}
