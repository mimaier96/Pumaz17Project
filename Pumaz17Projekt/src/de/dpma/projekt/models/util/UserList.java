package de.dpma.projekt.models.util;

import java.util.ArrayList;

import de.dpma.projekt.models.User;

public class UserList {

	private static ArrayList<User> userList;

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

		userList.add(user);

	}
}
