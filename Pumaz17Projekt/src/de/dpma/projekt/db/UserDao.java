package de.dpma.projekt.db;



import java.sql.SQLException;
import java.text.ParseException;

import de.dpma.projekt.models.User;

public interface UserDao {
	
	public User insertUser(User user) throws SQLException;
	
	public User getUser(User user) throws SQLException;

	public boolean updateUser(User user, String update, String change)  throws SQLException, ParseException;

	public boolean deleteUser(String username) throws SQLException;

	public User getUserID(User user) throws SQLException;

}
