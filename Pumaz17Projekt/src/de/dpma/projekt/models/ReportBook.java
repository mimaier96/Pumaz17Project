package de.dpma.projekt.models;

import java.sql.Date;

public class ReportBook {

	private int id;
	private int idApprentice;
	private int number;
	private int year;
	private String job;
	private String department;
	private String KindOfApprentice;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getKindOfApprentice() {
		return KindOfApprentice;
	}
	public void setKindOfApprentice(String kindOfApprentice) {
		KindOfApprentice = kindOfApprentice;
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
