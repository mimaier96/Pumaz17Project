package de.dpma.projekt.db;

import java.sql.SQLException;
import java.text.ParseException;

import de.dpma.projekt.models.ReportBook;
import de.dpma.projekt.models.reportBook.ReportBookWeekly;

public interface ReportBookWeeklyDao {

public ReportBook insertReportBookWeekly(ReportBookWeekly rb) throws SQLException;
	
	public ReportBook getReportBookWeekly(ReportBookWeekly rb) throws SQLException;
	
	public boolean updateReportBookWeekly(ReportBookWeekly rb, String update, String change) throws SQLException, ParseException;

	public boolean deleteReportBookWeekly(int apprenticeId, int number) throws SQLException;
	
}
