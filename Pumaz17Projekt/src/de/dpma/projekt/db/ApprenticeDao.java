package de.dpma.projekt.db;

import java.sql.SQLException;
import java.text.ParseException;

import de.dpma.projekt.models.user.Apprentice;

public interface ApprenticeDao {

	public Apprentice insertApprentice(Apprentice apprentice) throws SQLException;
	
	public Apprentice getApprentice(Apprentice apprentice) throws SQLException;

	public boolean updateApprentice(Apprentice apprentice, String update, String change) throws SQLException, ParseException;

	public boolean deleteApprentice(String username) throws SQLException;
	

		
}
