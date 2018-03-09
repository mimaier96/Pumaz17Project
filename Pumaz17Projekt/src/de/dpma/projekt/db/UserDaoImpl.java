package de.dpma.projekt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import de.dpma.projekt.models.User;
import de.dpma.projekt.models.util.UserList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class UserDaoImpl implements UserDao {
	
	public static ObservableList<User> usersList = FXCollections.observableArrayList();
	public static ObservableList<String> instructorList = FXCollections.observableArrayList(); 
	
	private static Connection con = DatabaseConnection.getInstance();
	
	private final static String PREPARED_INSERT = "INSERT INTO berichtsheft.user (Firstname, Lastname, Username, Password, Role, Email) VALUES (?,?,?,'Anfang12',?,?)";
	private final static String PREPARED_SELECT = "SELECT * FROM berichtsheft.user WHERE Username = ?";
	private final static String PREPARED_SELECT_USERID = "SELECT ID FROM berichtsheft.user WHERE Username = ?";
	private final static String PREPARED_SELECT_ALLUSERS = "SELECT * FROM berichtsheft.user";
	private final static String PREPARED_SELECT_ALLINSTRUCTORS = "SELECT * FROM berichtsheft.user WHERE Role = 'Instructor'";
	private static final String PREPARED_DELETE = "DELETE FROM berichtsheft.user WHERE Username = ?";

	
	public static User insertUser(User user) throws SQLException {
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
		getUserID(user);
		usersList.add(user);
		return user;
	}


	
	public static User getUser(User user) throws SQLException {
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

	public static User getUserID(User user) throws SQLException {
		PreparedStatement prepStat = con.prepareStatement(PREPARED_SELECT_USERID);
		prepStat.setString(1, user.getUsernameS());
		ResultSet result = prepStat.executeQuery();
		
		while (result.next()) {
		user.setId(result.getInt("Id"));
		}
		
		return user;
	}
	
	public static ObservableList<User> getUsersList() throws SQLException {
		PreparedStatement prepStat = con.prepareStatement(PREPARED_SELECT_ALLUSERS);
		ResultSet resSet = prepStat.executeQuery();
		usersList.clear();
		while (resSet.next()) {
		User user = new User();
	
		user.setFirstName(resSet.getString("Firstname"));
		user.setPassword(resSet.getString("Password"));
		user.setLastName(resSet.getString("Lastname"));
		user.setUsername(resSet.getString("Username"));
		user.setRole(resSet.getString("Role"));
		user.setEmail(resSet.getString("Email"));
		getUserID(user);
		
		usersList.add(user);
			
		}
		return usersList;
	}

	public static ObservableList<String> getInstructorsList() throws SQLException {
		PreparedStatement prepStat = con.prepareStatement(PREPARED_SELECT_ALLINSTRUCTORS);
		ResultSet resSet = prepStat.executeQuery();
		instructorList.clear();
		while (resSet.next()) {
		User user = new User();
	
		user.setFirstName(resSet.getString("Firstname"));
		user.setPassword(resSet.getString("Password"));
		user.setLastName(resSet.getString("Lastname"));
		user.setUsername(resSet.getString("Username"));
		user.setRole(resSet.getString("Role"));
		user.setEmail(resSet.getString("Email"));

		instructorList.add(user.getFirstname() + " "+ user.getLastname());
			
		}
		System.out.println(instructorList.get(0));
		return instructorList;
	}
	
	public static boolean updateUser(User user, String update, String change) throws SQLException {
		boolean success = true;
		String PREPARED_UPDATE = "UPDATE berichtsheft.user SET " + update + " = ? WHERE Username = ?;";
		PreparedStatement prepStat = con.prepareStatement(PREPARED_UPDATE);

		try {
			prepStat.setString(1, change);
			prepStat.setString(2, user.getUsername());
			
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


	
	public static boolean deleteUser(String username) throws SQLException {
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
