package de.dpma.projekt.db;

import java.sql.SQLException;
import java.util.ArrayList;

import de.dpma.projekt.models.user.Apprentice;

public interface ApprenticeDao {

	public Apprentice insertApprentice(Apprentice apprentice) throws SQLException;
	
	public Apprentice getApprentice(Apprentice apprentice) throws SQLException;

	public boolean updateApprentice(Apprentice apprentice, String update, String change) throws SQLException;

	public boolean deleteApprentice(String username);

		
}
