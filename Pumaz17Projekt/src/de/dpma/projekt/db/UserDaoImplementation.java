package de.dpma.projekt.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.dpma.projekt.models.user.Apprentice;;

public class UserDaoImplementation implements UserDao {

	private Connection con = DatabaseConnection.getInstance();

	/* Dieser Boolean wird dazu benutzt, ob zusätzliche Felder für den Azubi
	 angezeigt werden und somit ausgefüllt werden müssen, oder nicht */
	boolean userIsApprentice = false;

	/**
	 * SQL Statement Strings
	 * 
	 * @author MaSpecter
	 */

	private final static String PREPARED_INSERT_USER = "INSERT INTO user (firstname, lastname, username, password, role, email) VALUES (?,?,?,Anfang12,?,?)";
	private final static String PREPARED_SELECT_USER = "SELECT id, firstname, lastname, username, password, role, email FROM user WHERE id = ?";
	private final static String PREPARED_INSERT_APPRENTICEDATA = "INSERT INTO apprentice (job, instructor, YearOfEmployment, birthday, street, house number, postal code, city, location of deployment, Begin of apprenticeship, End of apprenticeship) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

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

		preparedApprenticeInsert.setString(1, apprentice.getFirstname());
		preparedApprenticeInsert.setString(2, apprentice.getLastname());
		preparedApprenticeInsert.setString(3, apprentice.getUsername());
		// preparedApprenticeInsert.setString(4, apprentice.getPassword());
		preparedApprenticeInsert.setString(5, apprentice.getRole());
		preparedApprenticeInsert.setString(6, apprentice.getEmail());
		
		//	NUR bei Azubi
		
		preparedApprenticeInsert.setString(7, apprentice.getJob());
		preparedApprenticeInsert.setString(8, (apprentice.getInstructor().getFirstname()+" "+apprentice.getInstructor().getLastname()));
		preparedApprenticeInsert.setString(9, x);
		

		preparedApprenticeInsert.execute();

		ResultSet resSet = preparedApprenticeInsert.getGeneratedKeys();

		if (resSet.next()) {
			int id = (int) resSet.getLong(1);
			apprentice.setId(id);
		}

		return apprentice;
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
