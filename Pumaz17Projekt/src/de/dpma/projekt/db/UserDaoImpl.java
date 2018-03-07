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

	@Override
	public User insertUser(User user) throws SQLException {
		String generatedColumns[] = { "ID" };
		ResultSet result = null;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_INSERT, generatedColumns);
		
		prepStat.setString(1, user.getFirstname());
		prepStat.setString(2, user.getLastname());
		prepStat.setString(3, user.getUsername());
		prepStat.setString(4, user.getRole());
		prepStat.setString(5, user.getEmail());

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
		prepStat.setString(1, user.getUsername());
		ResultSet result = prepStat.executeQuery();
		
		while (result.next()) {
		user.setFirstName(result.getString("firstname"));
		user.setLastName(result.getString("lastname"));
		user.setUsername(result.getString("username"));
		user.setRole(result.getString("role"));
		user.setEmail(result.getString("email"));
		}
		
		return user;
	}


	@Override
	public boolean updateUser(User user, String update, String change) throws SQLException {
		boolean success = false;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_UPDATE);
		
		prepStat.setString(1, update);
		prepStat.setString(2, change);
		prepStat.setString(3, user.getUsername());
		
		prepStat.executeUpdate();
		
		return false;
	}


	@Override
	public boolean deleteUser(String username) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
