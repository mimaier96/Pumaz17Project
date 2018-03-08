package de.dpma.projekt.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class JobDaoImpl implements JobDao {
	private Connection con = DatabaseConnection.getInstance();

	private final static String PREPARED_INSERT = "INSERT INTO berichtsheft.job (job) VALUES (?)";
	private final static String PREPARED_SELECT_ID = "SELECT Id FROM berichtsheft.job WHERE job = ?";
	private final static String PREPARED_SELECT_NAME = "SELECT job FROM berichtsheft.job WHERE Id = ?";
	private final static String PREPARED_UPDATE = "UPDATE berichtsheft.job SET job = ? WHERE Id = ?;";
	private static final String PREPARED_DELETE = "DELETE FROM berichtsheft.job WHERE iD = ?";
	

	@Override
	public void insertJob(String job) throws SQLException {
		String generatedColumns[] = { "ID" };
		PreparedStatement prepStat = con.prepareStatement(PREPARED_INSERT, generatedColumns);
		
		prepStat.setString(1, job);
		
		prepStat.execute();

		
	}
	
	@Override
	public int getJobId(String job) throws SQLException {
		PreparedStatement prepStat = con.prepareStatement(PREPARED_SELECT_ID);
		prepStat.setString(1, job);
		ResultSet result = prepStat.executeQuery();
		int jobId = 0;
		
		while(result.next()) {
			jobId = result.getInt("Id");
		}
				
		return jobId;
	}

	@Override
	public String getJobName(int jobId) throws SQLException {
		PreparedStatement prepStat = con.prepareStatement(PREPARED_SELECT_NAME);
		prepStat.setInt(1, jobId);
		ResultSet result = prepStat.executeQuery();
		String job = null;
		
		while(result.next()) {
			job = result.getString("job");
		}
		
		return job;
	}

	@Override
	public boolean updateJob(String job, int jobId) throws SQLException, ParseException {
		boolean success = true;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_UPDATE);
		
		try {	
			prepStat.setString(1, job);
			prepStat.setInt(2, jobId);
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

	@Override
	public boolean deleteJob(int jobId) throws SQLException {
		boolean success = true;
		PreparedStatement prepStat = con.prepareStatement(PREPARED_UPDATE);
		
		try {	
			prepStat.setInt(1, jobId);
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
