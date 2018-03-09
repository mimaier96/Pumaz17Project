package de.dpma.projekt.db;



import java.sql.SQLException;
import java.text.ParseException;

import de.dpma.projekt.models.User;

public interface UserDao {
	
	public static User insertUser(User user) throws SQLException {
		return null;
	}
	
	public static User getUser(User user) throws SQLException {
		return null;
	}

	public static boolean updateUser(User user, String update, String change)  throws SQLException, ParseException {
		return false;
	}

	public static boolean deleteUser(String username) throws SQLException {
		return false;
	}

	public static User getUserID(User user) throws SQLException {
		return null;
	}

}
