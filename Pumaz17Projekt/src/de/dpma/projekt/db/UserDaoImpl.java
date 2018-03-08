package de.dpma.projekt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.dpma.projekt.models.User;



public class UserDaoImpl implements UserDao {
	
	private Connection con = DatabaseConnection.getInstance();

	private final static String PREPARED_INSERT = "INSERT INTO berichtsheft.user (firstname, lastname, username, password, role, email) VALUES (?,?,?,Anfang12,?,?)";
	private final static String PREPARED_SELECT = "SELECT * FROM berichtsheft.user WHERE username = ?";
	private final static String PREPARED_UPDATE = "UPDATE berichtsheft.user SET ? = ? WHERE username = ?;";
	private static final String PREPARED_DELETE = "DELETE FROM berichtsheft.user WHERE username = ?";

	@Override
	public User insertUser(User user) throws SQLException {
		String generatedColumns[] = { "ID" };
		ResultSet result = null;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_INSERT, generatedColumns);
		
		prepStat.setString(1, user.getFirstnameS());
		prepStat.setString(2, user.getLastnameS());
		prepStat.setString(3, user.getUsernameS());
		prepStat.setString(4, user.getRoleS());
		prepStat.setString(5, user.getEmailS());

		prepStat.execute();
		
		result = prepStat.getGeneratedKeys();
		
		if (result.next()) {
			int id = (int) result.getLong(1);
			user.setId(id);
		}
		return user;
	}


	@Override
	public User getUser(User user) throws SQLException {
		PreparedStatement prepStat = con.prepareStatement(PREPARED_SELECT);
		prepStat.setString(1, user.getUsernameS());
		ResultSet result = prepStat.executeQuery();
		
		while (result.next()) {
		user.setFirstnameS(result.getString("firstname"));
		user.setLastnameS(result.getString("lastname"));
		user.setUsernameS(result.getString("username"));
		user.setRoleS(result.getString("role"));
		user.setEmailS(result.getString("email"));
		}
		
		return user;
	}


	@Override
	public boolean updateUser(User user, String update, String change) throws SQLException {
		boolean success = true;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_UPDATE);

		try {
			prepStat.setString(1, update);
			prepStat.setString(2, change);
			prepStat.setString(3, user.getUsernameS());
			
			prepStat.executeUpdate();
		} catch (Exception e) {
			success = false;
		}

		if (success == false) {
		return false;
		} else {
		return true;
		}
	}


	@Override
	public boolean deleteUser(String username) throws SQLException {
		boolean success = true;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_DELETE);
		
		try {
			prepStat.setString(1, username);
			
			prepStat.executeUpdate();
		} catch (Exception e) {
			success = false;
		}
		
		if (success == false) {
			return false;
		} else {
			return true;
		}
	}

}
