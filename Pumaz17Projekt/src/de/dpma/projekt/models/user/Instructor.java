package de.dpma.projekt.models.user;

import java.sql.Date;

import de.dpma.projekt.models.User;
import de.dpma.projekt.models.util.UserList;

public class Instructor extends User {

	public Instructor(String firstname, String lastname, String username, String password, String role, String email) {

		super(firstname, lastname, username, password, role, email);

	}

	/*public User createApprentice(String firstname, String lastname, String username, String password, String role,
			String email, String job, User instructor, int yearOfEmployment, Date apprenticeBirthday,
			String adressStreetApprentice, int adressHouseNumberApprentice, int adressPostalCode, String adressCity,
			String locationOfDeployment, Date beginOfApprenticeship, Date endOfApprenticeship) {
		Apprentice a = new Apprentice(firstname, lastname, username, password, role, email, job, yearOfEmployment,
				apprenticeBirthday, adressStreetApprentice, adressHouseNumberApprentice, adressPostalCode, adressCity,
				locationOfDeployment, beginOfApprenticeship, endOfApprenticeship);
		UserList.addUser(a);
		return a;

	}*/

	public User createTrainer(int id, String firstname, String lastname, String username, String password, String role,
			String email) {
		Trainer a = new Trainer(id, firstname, lastname, username, password, role, email);
		UserList.addUser(a);
		return a;

	}

	public User deleteUser(int id) {

		UserList.deleteUserById(id);
		return UserList.searchUserByID(id);
	}
}
