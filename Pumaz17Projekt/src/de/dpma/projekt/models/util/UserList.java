package de.dpma.projekt.models.util;

import java.util.ArrayList;

import de.dpma.projekt.models.User;
import de.dpma.projekt.models.user.Instructor;

public class UserList {

	public static ArrayList<User> userList=new ArrayList<User>();

	public static void deleteUser(User user) {

		userList.remove(user);

	}

	public static void deleteUserById(int id) {

		userList.remove(searchUserByID(id));

	}

	public static User searchUserByID(int id) {

		for (User user : userList) {

			if (user.getId() == id) {

				return user;

			}

		}
		return null;
	}

	public static void addUser(User user) {
		System.out.println("USER ERSTELLT");
		userList.add(user);

	}

	public static ArrayList<String> getInstructors() {
		ArrayList<String> instructors = new ArrayList<String>();
		
		for (User user : UserList.userList) {

			if (user.getRole().equals("Instructor")) {

				instructors.add(user.getFirstname() + " " + user.getLastname());

			}

		}
		return instructors;
	}
}
