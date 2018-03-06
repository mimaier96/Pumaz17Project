package de.dpma.projekt.db;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;

import de.dpma.projekt.models.ReportBook;
import de.dpma.projekt.models.reportBook.ReportBookDaily;

public interface ReportBookDailyDao {

	public ReportBook insertReportBookDaily(ReportBookDaily rb) throws SQLException, FileNotFoundException;
	
	public ReportBook getReportBookDaily(ReportBookDaily rb) throws SQLException;
	
	public boolean updateReportBookDaily(ReportBookDaily rb, String update, String change) throws SQLException, ParseException;

	public boolean deleteReportBookDaily(int apprenticeId, int number) throws SQLException;
	
}
