package de.dpma.projekt.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.sql.ResultSet;

import java.util.ArrayList;

import de.dpma.projekt.models.user.Apprentice;
import de.dpma.projekt.utils4Code.DateUtil;

public class ApprenticeDaoImpl implements ApprenticeDao {

	private Connection con = DatabaseConnection.getInstance();
	
	private static final String PREPARED_INSERT = "INSERT INTO berichtsheft.apprentice (UserId, JobId; Instructor, YearOfEmployment, Birthday, Street, House number, PostalCode, City, Location of deployment, Begin of apprenticeship, End of apprenticeship)\r\n" + 
			"VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
	
	private static final String PREPARED_SELECT = "SELECT * FROM berichtsheft.apprentice WHERE username = ?;";

	private static final String PREPARED_UPDATE = "UPDATE berichtsheft.apprentice SET ? = ? WHERE username = ?";

	@Override
	public Apprentice insertApprentice(Apprentice apprentice) throws SQLException {
		String generatedColumns[] = { "ID" };
		ResultSet result = null;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_INSERT, generatedColumns);
		
		prepStat.setInt(1, apprentice.getUser_id());
		prepStat.setInt(2, apprentice.getJob_id());
		prepStat.setString(3, apprentice.getInstructor());
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
	public Apprentice getApprentice(Apprentice apprentice) throws SQLException {
			PreparedStatement prepStat = con.prepareStatement(PREPARED_SELECT);
			prepStat.setString(1, apprentice.getUsername());
			ResultSet result = prepStat.executeQuery();
			
			while (result.next()) {
				apprentice.setId(result.getInt("Id"));
				apprentice.setUser_id(result.getInt("UserId"));
				apprentice.setJob_id(result.getInt("JobId"));
				apprentice.setInstructor(result.getString("Instructor"));
				apprentice.setYearOfEmployment(result.getInt("YearOfEmployment"));
				apprentice.setApprenticeBirthday(result.getDate("Birthday"));
				apprentice.setAdressStreetApprentice(result.getString("Street"));
				apprentice.setAdressHouseNumberApprentice(result.getInt("House number"));
				apprentice.setAdressPostalCode(result.getInt("PostalCode"));
				apprentice.setAdressCity(result.getString("City"));
				apprentice.setLocationOfDeployment(result.getString("Location of Deployment"));
				apprentice.setBeginOfApprenticeship(result.getDate("Begin of apprenticeship"));
				apprentice.setEndOfApprenticeship(result.getDate("End of apprenticeship"));
			}
		return apprentice;
	}


	@Override
	public boolean updateApprentice(Apprentice apprentice, String update , String change) throws SQLException, ParseException {
		boolean success = false;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_UPDATE);

		prepStat.setString(1, update);
		
		switch (update.toLowerCase()) {
		case "userid":
		case "jobid":
		case "yearofemployment":
		case "house number":
		case "postalcode":
			try {
			int changeYear = Integer.parseInt(change);
			prepStat.setInt(2, changeYear);
			success = true;
			} catch (Exception e) {
			success = false;
			}
		break;
		
		case "birthday":
		case "begin of apprenticeship":
		case "end of apprenticeship":
			try {
			Date changeDate = (Date) DateUtil.formatDate(change);
			prepStat.setDate(2, changeDate);
			success = true;
			} catch (Exception e) {
			success = false;
			}
		break;
		
		default:
			prepStat.setString(2, change);
			break;
		}
		
		prepStat.setString(3, apprentice.getUsername());
		
		prepStat.execute();
		
		getApprentice(apprentice);
		
		return false;
	}

	@Override
	public boolean deleteApprentice(String username) {

		return false;
	}




}
