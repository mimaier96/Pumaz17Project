package de.dpma.projekt.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import de.dpma.projekt.models.ReportBook;
import de.dpma.projekt.models.reportBook.ReportBookWeekly;
import de.dpma.projekt.utils4Code.DateUtil;

public class ReportBookWeeklyDaoImpl implements ReportBookWeeklyDao{

	
	private Connection con = DatabaseConnection.getInstance();
	
	private static final String PREPARED_INSERT = "INSERT INTO berichtsheft.reportbookweekly (Apprentice_ID, Job_ID, Number, DateA, DateE, Year, Kind, Department, Text_Week, Text_Note) \r\n" +
			"VALUES (?,?,?,?,?,?,?,?,?,?);";
	private static final String PREPARED_SELECT = "SELECT * FROM berichtsheft.reportbookweekly WHERE Apprentice_ID = ? AND Number = ?;";
	private static final String PREPARED_UPDATE = "UPDATE berichtsheft.reportbookweekly SET ? = ? WHERE Apprentice_ID = ? AND Id = ?;";
	private static final String PREPARED_DELETE = "DELETE FROM berichtsheft.reportbookweekly WHERE Apprentice_ID = ? AND Number = ?;";
	

	@Override
	public ReportBook insertReportBookWeekly(ReportBookWeekly rb) throws SQLException {
		String generatedColumns[] = { "ID" };
		ResultSet result = null;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_INSERT, generatedColumns);
		
		prepStat.setInt(1, rb.getIdApprentice());
		//prepStat.setInt(2, rb.getJob());
		prepStat.setInt(3, rb.getNumber());
		prepStat.setDate(4, rb.getDateA());
		prepStat.setDate(5, rb.getDateE());
		prepStat.setInt(6, rb.getYear());
		prepStat.setString(7, rb.getKindOfApprentice());
		prepStat.setString(8, rb.getDepartment());
		prepStat.setString(9, rb.getTextWeek());
		prepStat.setString(10, rb.getTextNote());


		prepStat.execute();
		
		result = prepStat.getGeneratedKeys();
		
		if (result.next()) {
			int id = (int) result.getLong(1);
			rb.setId(id);
		}
		
		return rb;
	}
	
	@Override
	public ReportBook getReportBookWeekly(ReportBookWeekly rb) throws SQLException {
		PreparedStatement prepStat = con.prepareStatement(PREPARED_SELECT);
		
		prepStat.setInt(1, rb.getIdApprentice());
		prepStat.setInt(2, rb.getNumber());
		
		ResultSet result = prepStat.executeQuery();
		
		while (result.next()) {
			rb.setId(result.getInt("Id"));
			rb.setIdApprentice(result.getInt("Apprentice_ID"));
			//rb.setJob(result.getInt("Job_ID"));
			rb.setNumber(result.getInt("Number"));
			rb.setDateA(result.getDate("DateA"));
			rb.setDateE(result.getDate("DateE"));
			rb.setYear(result.getInt("Year"));
			rb.setKindOfApprentice(result.getString("Kind"));
			rb.setDepartment(result.getString("Department"));
			rb.setTextWeek(result.getString("Text_Week"));
			rb.setTextNote(result.getString("Text_Note"));	
		}
		return rb;
	}

	@Override
	public boolean updateReportBookWeekly(ReportBookWeekly rb, String update, String change)
			throws SQLException, ParseException {
		
		boolean success = false;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_UPDATE);

		prepStat.setString(1, update);
		
		switch (update.toLowerCase()) {
		case "job_id":
		case "number":
		case "year":
			try {
			int changeInt = Integer.parseInt(change);
			prepStat.setInt(2, changeInt);
			success = true;
			} catch (Exception e) {
			success = false;
			}
		break;
		
		case "datea":
		case "datee":
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
		
		prepStat.setInt(3, rb.getIdApprentice());
		prepStat.setInt(4, rb.getId());

		prepStat.executeUpdate();
		
		getReportBookWeekly(rb);
		
		if (success == true) {
		return true;
		} else {
		return false;
		}
	}

	@Override
	public boolean deleteReportBookWeekly(int apprenticeId, int number) throws SQLException {
		
		PreparedStatement prepStat = con.prepareStatement(PREPARED_DELETE);
		prepStat.setInt(1, apprenticeId);
		prepStat.setInt(2, number);
		
		prepStat.executeUpdate();
		
		return true;
	}


}
