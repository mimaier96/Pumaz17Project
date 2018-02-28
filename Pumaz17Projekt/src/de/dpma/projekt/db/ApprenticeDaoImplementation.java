package de.dpma.projekt.db;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.dpma.projekt.models.user.Apprentice;

public class ApprenticeDaoImplementation implements ApprenticeDao {

	private Connection con = DatabaseConnection.getInstance();

	private final static String PREPARED_INSERT = "INSERT INTO user (firstname, lastname, username, password, role, email) VALUES (?,?,?,Anfang12,?,?)";
	private final static String PREPARED_SELECT_APPRENTICE = "SELECT id, firstname, lastname, username, password, role, email FROM user WHERE id = ?";

	@Override
	public Apprentice insertApprentice(Apprentice apprentice) throws SQLException {
		
		/**
		 * Daten in Datenbank schreiben
		 * Reihenfolge: firstname, lastname, username, password, role, email
		 * 
		 * @author MaSpecter
		 */
		
		String generatedColumns[] = { "ID" };
		PreparedStatement preparedApprenticeInsert = con.prepareStatement(PREPARED_INSERT, generatedColumns);
		
		preparedApprenticeInsert.setString(1, apprentice.getFirstname());
		preparedApprenticeInsert.setString(2, apprentice.getLastname());
		preparedApprenticeInsert.setString(3, apprentice.getUsername());
//		preparedApprenticeInsert.setString(4, apprentice.getPassword());
		preparedApprenticeInsert.setString(5, apprentice.getRole());
		preparedApprenticeInsert.setString(6, apprentice.getEmail());

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
