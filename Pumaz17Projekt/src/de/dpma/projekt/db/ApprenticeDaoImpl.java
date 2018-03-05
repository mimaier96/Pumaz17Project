package de.dpma.projekt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

import de.dpma.projekt.models.user.Apprentice;

public class ApprenticeDaoImpl implements ApprenticeDao {

	private Connection con = DatabaseConnection.getInstance();
	
	private static final String PREPARED_INSERT = "INSERT INTO berichtsheft.apprentice (UserId, JobId; Instructor, YearOfEmployment, Birthday, Street, House number, PostalCode, City, Location of deployment, Begin of apprenticeship, End of apprenticeship)\r\n" + 
			"VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";


	@Override
	public Apprentice insertApprentice(Apprentice apprentice) throws SQLException {
		String generatedColumns[] = { "ID" };
		ResultSet result = null;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_INSERT, generatedColumns);
		
		prepStat.setInt(1, apprentice.getUser_id());
		prepStat.setInt(2, apprentice.getJob_id());
		prepStat.setString(3, apprentice.getInstructor().getFirstname() + apprentice.getInstructor().getLastname());
		prepStat.setInt(4, apprentice.getYearOfEmployment());
		prepStat.setDate(5, apprentice.getApprenticeBirthday());
		prepStat.setString(6, apprentice.getAdressStreetApprentice());
		prepStat.setInt(7, apprentice.getAdressHouseNumberApprentice());
		prepStat.setInt(8, apprentice.getAdressPostalCode());
		prepStat.setString(9, apprentice.getAdressCity());
		prepStat.setString(10, apprentice.getLocationOfDeployment());
		prepStat.setDate(11, apprentice.getBeginOfApprenticeship());
		prepStat.setDate(12, apprentice.getEndOfApprenticeship());

		prepStat.execute();
		
		result = prepStat.getGeneratedKeys();
		
		if (result.next()) {
			int id = (int) result.getLong(1);
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
	public boolean deleteApprentice(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Apprentice> allApprentices() {
		// TODO Auto-generated method stub
		return null;
	}

}
