package de.dpma.projekt.models.user;


//import java.util.Date;
import java.sql.Date;

import de.dpma.projekt.models.User;

public class Apprentice extends User {

	private String job; //Ausbildungsberuf
	private int user_id;
	private User instructor; //Ausbildungsleiter/in
	
	private int yearOfEmployment; //Ausbildungsjahr, in dem sich der Azubi befindet
	private Date apprenticeBirthday; //Geburtstag
	private String adressStreetApprentice; //Adresse: Straße
	private int adressHouseNumberApprentice; //Adresse: Hausnummer
	private int adressPostalCode; //Adresse: Postleitzahl
	private String adressCity; //Adresse: Stadt zur Postleitzahl
	private String locationOfDeployment; //ausbildende Behörde (München/Jena)
	private Date beginOfApprenticeship; //Ausbildungsbeginn
	private Date endOfApprenticeship; //Ausbildungsende


	public Apprentice( String firstname, String lastname, String username, String password, String role,
			String email, String job, User instructor, int yearOfEmployment, Date apprenticeBirthday,
			String adressStreetApprentice, int adressHouseNumberApprentice, int adressPostalCode, String adressCity,
			String locationOfDeployment, Date beginOfApprenticeship, Date endOfApprenticeship) {
		super( firstname, lastname, username, password, role, email);
		this.job = job;
		this.instructor = instructor;
		this.yearOfEmployment = yearOfEmployment;
		this.apprenticeBirthday = apprenticeBirthday;
		this.adressStreetApprentice = adressStreetApprentice;
		this.adressHouseNumberApprentice = adressHouseNumberApprentice;
		this.adressPostalCode = adressPostalCode;
		this.adressCity = adressCity;
		this.locationOfDeployment = locationOfDeployment;
		this.beginOfApprenticeship = beginOfApprenticeship;
		this.endOfApprenticeship = endOfApprenticeship;
	}


	public Apprentice(int id, String firstname, String lastname, String username, String password, String role,
			String email, String job, User instructor, int yearOfEmployment, Date apprenticeBirthday,
			String adressStreetApprentice, int adressHouseNumberApprentice, int adressPostalCode, String adressCity,
			String locationOfDeployment, Date beginOfApprenticeship, Date endOfApprenticeship) {
		super(id, firstname, lastname, username, password, role, email);
		this.job = job;
		this.user_id = id;
		this.instructor = instructor;
		this.yearOfEmployment = yearOfEmployment;
		this.apprenticeBirthday = apprenticeBirthday;
		this.adressStreetApprentice = adressStreetApprentice;
		this.adressHouseNumberApprentice = adressHouseNumberApprentice;
		this.adressPostalCode = adressPostalCode;
		this.adressCity = adressCity;
		this.locationOfDeployment = locationOfDeployment;
		this.beginOfApprenticeship = beginOfApprenticeship;
		this.endOfApprenticeship = endOfApprenticeship;
	}
	


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public User getInstructor() {
		return instructor;
	}


	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}


	public int getYearOfEmployment() {
		return yearOfEmployment;
	}


	public void setYearOfEmployment(int yearOfEmployment) {
		this.yearOfEmployment = yearOfEmployment;
	}


	public Date getApprenticeBirthday() {
		return apprenticeBirthday;
	}


	public void setApprenticeBirthday(Date apprenticeBirthday) {
		this.apprenticeBirthday = apprenticeBirthday;
	}


	public String getAdressStreetApprentice() {
		return adressStreetApprentice;
	}


	public void setAdressStreetApprentice(String adressStreetApprentice) {
		this.adressStreetApprentice = adressStreetApprentice;
	}


	public int getAdressHouseNumberApprentice() {
		return adressHouseNumberApprentice;
	}


	public void setAdressHouseNumberApprentice(int adressHouseNumberApprentice) {
		this.adressHouseNumberApprentice = adressHouseNumberApprentice;
	}


	public int getAdressPostalCode() {
		return adressPostalCode;
	}


	public void setAdressPostalCode(int adressPostalCode) {
		this.adressPostalCode = adressPostalCode;
	}


	public String getAdressCity() {
		return adressCity;
	}


	public void setAdressCity(String adressCity) {
		this.adressCity = adressCity;
	}


	public String getLocationOfDeployment() {
		return locationOfDeployment;
	}


	public void setLocationOfDeployment(String locationOfDeployment) {
		this.locationOfDeployment = locationOfDeployment;
	}


	public Date getBeginOfApprenticeship() {
		return beginOfApprenticeship;
	}


	public void setBeginOfApprenticeship(Date beginOfApprenticeship) {
		beginOfApprenticeship = beginOfApprenticeship;
	}


	public Date getEndOfApprenticeship() {
		return endOfApprenticeship;
	}


	public void setEndOfApprenticeship(Date endOfApprenticeship) {
		endOfApprenticeship = endOfApprenticeship;
	}
}
