package de.dpma.projekt.models;

import java.sql.SQLException;

import de.dpma.projekt.db.UserDaoImpl;
import javafx.beans.property.StringProperty;

public class User {

	private StringProperty firstname, lastname, username, password, role, email;
	private String firstnameS, lastnameS, usernameS, passwordS, roleS, emailS;
	private int id;
	//Dieser Konstruktor wird aus der Datenbank ausgeführt
	public User(int id, String firstname, String lastname, String username, String password, String role,
			String email) {
		this.firstname.set(firstname);
		this.lastname.set(lastname);
		this.username.set(username);
		this.password.set(password);
		this.role.set(role);
		this.email.set(email);
		this.id = id;
		this.firstnameS=firstname;
		this.lastnameS=lastname;
		this.usernameS=username;
		this.passwordS=password;
		this.roleS=role;
		this.emailS=email;
	}
	//Dieser Konstruktor wird aus der Datenbank ausgeführt - keine ID wird erzeugt, da diese in der DB automatisch hinzugefügt wird
	public User(String firstname, String lastname, String username, String password, String role,
			String email) {
//		this.lastname.set(firstname);
//		this.lastname.set(lastname);
//		this.username.set(username);
//		this.password.set(password);
//		this.role.set(role);
//		this.email.set(email);
		System.out.println("awdawd");
		this.firstnameS=firstname;
		this.lastnameS=lastname;
		this.usernameS=username;
		this.passwordS=password;
		this.roleS=role;
		this.emailS=email;

		
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstnameS() {
		return firstnameS;
	}
	public void setFirstnameS(String firstnameS) {
		this.firstnameS = firstnameS;
	}
	public String getLastnameS() {
		return lastnameS;
	}
	public void setLastnameS(String lastnameS) {
		this.lastnameS = lastnameS;
	}
	public String getUsernameS() {
		return usernameS;
	}
	public void setUsernameS(String usernameS) {
		this.usernameS = usernameS;
	}
	public String getPasswordS() {
		return passwordS;
	}
	public void setPasswordS(String passwordS) {
		this.passwordS = passwordS;
	}
	public String getRoleS() {
		return roleS;
	}
	public void setRoleS(String roleS) {
		this.roleS = roleS;
	}
	public String getEmailS() {
		return emailS;
	}
	public void setEmailS(String emailS) {
		this.emailS = emailS;
	}
	
}
