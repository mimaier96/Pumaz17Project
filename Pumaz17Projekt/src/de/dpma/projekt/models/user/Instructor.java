package de.dpma.projekt.models.user;

import de.dpma.projekt.models.User;
import de.dpma.projekt.models.util.UserList;

public class Instructor extends User{

	
	
	public Instructor(int id, String firstname, String lastname, String username, String password, String role, String email) {
		
		super(id, firstname, lastname, username, password, role, email);
		
	}

	
	public User createApprentice(int id, String firstname, String lastname, String username, String password, String role, String email) {
		Apprentice a = new Apprentice( id,  firstname, lastname, username, password, role, email, this);
		UserList.addUser(a);
		return a;
		
	}
	
	
	
	public User createTrainer(int id, String firstname, String lastname, String username, String password, String role, String email) {
		Trainer a = new Trainer( id,  firstname, lastname, username, password, role, email);
		UserList.addUser(a);
		return a;
		
	}
	
public User deleteUser(int id) {
		
		UserList.deleteUserById(id);
		return UserList.searchUserByID(id);
	}
}
