package de.dpma.projekt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import java.sql.Date;

import de.dpma.projekt.models.user.Apprentice;
import de.dpma.projekt.models.user.Instructor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;;

public class UserDaoImplementation implements UserDao {

	private Connection con = DatabaseConnection.getInstance();



	/**
	 * SQL Statement Strings
	 * 
	 * @author MaSpecter
	 */

	private final static String PREPARED_INSERT_USER = "INSERT INTO user (firstname, lastname, username, password, role, email) VALUES (?,?,?,Anfang12,?,?)";
	private final static String PREPARED_SELECT_USER = "SELECT id, firstname, lastname, username, password, role, email FROM user WHERE id = ?";
	private final static String PREPARED_INSERT_APPRENTICE = "INSERT INTO user (firstname, lastname, username, password, role, email) VALUES (?,?,?,Anfang12,?,?); INSERT INTO apprentice (job, instructor, YearOfEmployment, birthday, street, house number, postal code, city, location of deployment, Begin of apprenticeship, End of apprenticeship) VALUES(?,?,?,?,?,?,?,?,?,?,?);";

	@Override
	public Apprentice insertApprentice(Apprentice apprentice) throws SQLException {

		/**
		 * Daten in Datenbank schreiben Reihenfolge: firstname, lastname, username,
		 * password, role, email 
		 * 
		 * @author MaSpecter
		 */

		String generatedColumns[] = { "ID" };
		PreparedStatement preparedApprenticeInsert = con.prepareStatement(PREPARED_INSERT_USER, generatedColumns);

		try {

			preparedApprenticeInsert.setString(1, apprentice.getFirstname());
			preparedApprenticeInsert.setString(2, apprentice.getLastname());
			preparedApprenticeInsert.setString(3, apprentice.getUsername());
			// preparedApprenticeInsert.setString(4, apprentice.getPassword());
			preparedApprenticeInsert.setString(5, apprentice.getRole());
			preparedApprenticeInsert.setString(6, apprentice.getEmail());
		} catch (Exception e) {
			preparedApprenticeInsert.setString(1, null);
			preparedApprenticeInsert.setString(2, null);
			preparedApprenticeInsert.setString(3, null);
			// preparedApprenticeInsert.setString(4, null);
			preparedApprenticeInsert.setString(5, null);
			preparedApprenticeInsert.setString(6, null);
		}

		// NUR bei Azubi

		/**
		 * Reihenfolge: job, instructor, YearOfEmployment, birthday, street, house
		 * number, postal code, city, location of deployment, Begin of apprenticeship,
		 * End of apprenticeship
		 * 
		 * @author MaSpecter
		 */

	

			try {

				preparedApprenticeInsert.setString(7, apprentice.getJob());
				preparedApprenticeInsert.setString(8,
						(apprentice.getInstructor().getFirstname() + " " + apprentice.getInstructor().getLastname()));
				preparedApprenticeInsert.setInt(9, apprentice.getYearOfEmployment());
				preparedApprenticeInsert.setDate(10, apprentice.getApprenticeBirthday());
				preparedApprenticeInsert.setString(11, apprentice.getAdressStreetApprentice());
				preparedApprenticeInsert.setInt(12, apprentice.getAdressHouseNumberApprentice());
				preparedApprenticeInsert.setInt(13, apprentice.getAdressPostalCode());
				preparedApprenticeInsert.setString(14, apprentice.getAdressCity());
				preparedApprenticeInsert.setDate(15, apprentice.getBeginOfApprenticeship());
				preparedApprenticeInsert.setDate(15, apprentice.getEndOfApprenticeship());
			} catch (Exception e) {
				preparedApprenticeInsert.setString(7, null);
				preparedApprenticeInsert.setString(8, null);
				preparedApprenticeInsert.setInt(9, (Integer) null);
				preparedApprenticeInsert.setDate(10, null);
				preparedApprenticeInsert.setString(11, null);
				preparedApprenticeInsert.setInt(12, (Integer) null);
				preparedApprenticeInsert.setInt(13, (Integer) null);
				preparedApprenticeInsert.setString(14, null);
				preparedApprenticeInsert.setDate(15, null);
				preparedApprenticeInsert.setDate(15, null);
			}
		

		preparedApprenticeInsert.execute();

		ResultSet resSet = preparedApprenticeInsert.getGeneratedKeys();

		if (resSet.next()) {
			int id = (int) resSet.getLong(1);
			apprentice.setId(id);
		}

		return apprentice;
	}

	

	

	

	public Instructor getInstructor(int id) {
		// TODO ausbessern
		return null;
	}

	@Override
	public ArrayList<Apprentice> insertApprentice(ArrayList<Apprentice> apprentices) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateApprentice(Apprentice apprentice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteApprentice(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Apprentice> allApprentices() {
		// TODO Auto-generated method stub
		return null;
	}

}
