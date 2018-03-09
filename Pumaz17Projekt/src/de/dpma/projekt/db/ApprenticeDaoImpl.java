package de.dpma.projekt.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.sql.ResultSet;

import de.dpma.projekt.models.user.Apprentice;
import de.dpma.projekt.utils4Code.DateUtil;

public class ApprenticeDaoImpl implements ApprenticeDao {
	

	private Connection con = DatabaseConnection.getInstance();
	
	private static final String PREPARED_INSERT = "INSERT INTO berichtsheft.apprentice (UserId, JobID, Instructor, YearOfEmployment, Birthday, Street, HouseNumber, PostalCode, City, LocationOfDeployment, BeginOfApprenticeship, EndOfApprenticeship) " + 
			"VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
	
	private static final String PREPARED_SELECT = "SELECT * FROM berichtsheft.apprentice WHERE UserId = ?;";
	
	private static final String PREPARED_UPDATE = "UPDATE berichtsheft.apprentice SET ? = ? WHERE UserId = ?";
	
	private static final String PREPARED_DELETE = "DELETE FROM berichtsheft.apprentice WHERE UserId = ?";

	@Override
	public Apprentice insertApprentice(Apprentice apprentice) throws SQLException {
		PreparedStatement prepStat = con.prepareStatement(PREPARED_INSERT);
		
		prepStat.setInt(1, apprentice.getId());
		prepStat.setInt(2, 5);
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
				apprentice.setAdressHouseNumberApprentice(result.getInt("HouseNumber"));
				apprentice.setAdressPostalCode(result.getInt("PostalCode"));
				apprentice.setAdressCity(result.getString("City"));
				apprentice.setLocationOfDeployment(result.getString("LocationOfDeployment"));
				apprentice.setBeginOfApprenticeship(result.getDate("BeginOfApprenticeship"));
				apprentice.setEndOfApprenticeship(result.getDate("EndOfApprenticeship"));
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
			int changeInt = Integer.parseInt(change);
			prepStat.setInt(2, changeInt);
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
			success = true;
			break;
		}
		
		prepStat.setString(3, apprentice.getUsername());
		
		prepStat.executeUpdate();
		
		getApprentice(apprentice);
		
		if (success == true) {
		return true;
		} else {
		return false;
		}
	}

	@Override
	public boolean deleteApprentice(int id) throws SQLException {
		boolean success = true;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_DELETE);
		
		try {
			prepStat.setInt(1, id);
			
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
