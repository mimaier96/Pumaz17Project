package de.dpma.projekt.db;

import java.sql.SQLException;
import java.text.ParseException;


public interface JobDao {

	public void insertJob(String job) throws SQLException;
	
	public int getJobId(String job) throws SQLException;
	
	public String getJobName(int jobId) throws SQLException;

	public boolean updateJob(String job, int jobId) throws SQLException, ParseException;

	public boolean deleteJob(int jobId) throws SQLException;
}
