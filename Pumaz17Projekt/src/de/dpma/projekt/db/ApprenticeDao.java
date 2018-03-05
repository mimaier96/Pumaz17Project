package de.dpma.projekt.db;

import java.sql.SQLException;
import java.util.ArrayList;

import de.dpma.projekt.models.user.Apprentice;

public interface ApprenticeDao {

public Apprentice insertApprentice(Apprentice apprentice) throws SQLException;
	

	public ArrayList<Apprentice> insertApprentice(ArrayList<Apprentice> apprentices);

	public boolean updateApprentice(Apprentice apprentice);

	
	public boolean deleteApprentice(String username);
	
	public ArrayList<Apprentice> allApprentices();
	
}
