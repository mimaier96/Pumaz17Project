package de.dpma.projekt.db;

import java.sql.SQLException;
import java.text.ParseException;

import de.dpma.projekt.models.ReportBook;

public interface ReportBookDailyDao {

	public ReportBook insertReportBookDaily(ReportBook rb) throws SQLException;
	
	public ReportBook getReportBookDaily(ReportBook rb) throws SQLException;

	public boolean updateReportBookDaily(ReportBook rb, String update, String change) throws SQLException, ParseException;

	public boolean deleteReportBookDaily(String username) throws SQLException;
	
}
