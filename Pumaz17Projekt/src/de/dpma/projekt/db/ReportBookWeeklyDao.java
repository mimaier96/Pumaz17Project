package de.dpma.projekt.db;

import java.sql.SQLException;
import java.text.ParseException;

import de.dpma.projekt.models.ReportBook;

public interface ReportBookWeeklyDao {

public ReportBook insertReportBookWeekly(ReportBook rb) throws SQLException;
	
	public ReportBook getReportBookWeekly(ReportBook rb) throws SQLException;

	public boolean updateReportBookWeekly(ReportBook rb, String update, String change) throws SQLException, ParseException;

	public boolean deleteReportBookWeekly(String username) throws SQLException;
	
}
