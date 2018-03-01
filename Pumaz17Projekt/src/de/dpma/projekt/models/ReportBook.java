package de.dpma.projekt.models;

import java.util.Date;

public class ReportBook {

	private int id;
	private int idApprentice;
	private String job;
	private Date dateA;
	private Date dateE;

	public ReportBook(int id, int idApprentice, String job, Date dateA, Date dateE) {
		this.id = id;
		this.idApprentice = idApprentice;
		this.job = job;
		this.dateA = dateA;
		this.dateE = dateE;
	}
	public ReportBook(int idApprentice, String job, Date dateA, Date dateE) {
		this.idApprentice = idApprentice;
		this.job = job;
		this.dateA = dateA;
		this.dateE = dateE;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdApprentice() {
		return idApprentice;
	}

	public void setIdApprentice(int idApprentice) {
		this.idApprentice = idApprentice;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getDateA() {
		return dateA;
	}

	public void setDateA(Date dateA) {
		this.dateA = dateA;
	}

	public Date getDateE() {
		return dateE;
	}

	public void setDateE(Date dateE) {
		this.dateE = dateE;
	}

}
