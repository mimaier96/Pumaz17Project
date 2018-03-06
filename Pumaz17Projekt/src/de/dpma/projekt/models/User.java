package models;

import javafx.beans.property.StringProperty;

public class User {

	private StringProperty firstname, lastname, username, password, role, email;
	private int id;

	//Dieser Konstruktor wird aus der Datenbank ausgeführt
	public User(int id, String firstname, String lastname, String username, String password, String role,
			String email) {
		super();
		this.firstname.set(firstname);
		this.lastname.set(lastname);
		this.username.set(username);
		this.password.set(password);
		this.role.set(role);
		this.email.set(email);
		this.id = id;
	}
	//Dieser Konstruktor wird aus der Datenbank ausgeführt - keine ID wird erzeugt, da diese in der DB automatisch hinzugefügt wird
	public User(String firstname, String lastname, String username, String password, String role,
			String email) {
		super();
		this.firstname.set(firstname);
		this.lastname.set(lastname);
		this.username.set(username);
		this.password.set(password);
		this.role.set(role);
		this.email.set(email);
	}
	public StringProperty userFirstNameProperty() {
		return firstname;
	}
	
	public String getFirstname(){
		return firstname.get();
	}
	public void setFirstName(String firstName) {
		this.firstname.set(firstName);
	}
	
	public StringProperty userLastNameProperty() {
		return lastname;
	}
	
	public String getLastname(){
		return firstname.get();
	}
	public void setLastName(String lastname) {
		this.lastname.set(lastname);
	}
	public StringProperty userUsernameProperty() {
		return username;
	}
	
	public String getUsername(){
		return username.get();
	}
	public void setUsername(String username) {
		this.username.set(username);
	}
	public StringProperty userPasswordProperty() {
		return password;
	}
	
	public String getPassword(){
		return password.get();
	}
	public void setPassword(String password) {
		this.password.set(password);
	}
	public StringProperty userRoleProperty() {
		return role;
	}
	
	public String getRole(){
		return role.get();
	}
	public void setRole(String role) {
		this.role.set(role);
	}
	public StringProperty userEmailProperty() {
		return email;
	}
	
	public String getEmail(){
		return email.get();
	}
	public void setEmail(String email) {
		this.email.set(email);
	}

}
