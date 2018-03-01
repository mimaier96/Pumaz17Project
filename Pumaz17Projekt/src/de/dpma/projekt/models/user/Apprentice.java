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
	private Date BeginOfApprenticeship; //Ausbildungsbeginn
	private Date EndOfApprenticeship; //Ausbildungsende


	public Apprentice(String firstname, String lastname, String username, String password, String email, String role, Instructor/*User*/ instructor) {
		super(firstname, lastname, username, password, role, email);
		this.instructor = instructor;
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
		return BeginOfApprenticeship;
	}


	public void setBeginOfApprenticeship(Date beginOfApprenticeship) {
		BeginOfApprenticeship = beginOfApprenticeship;
	}


	public Date getEndOfApprenticeship() {
		return EndOfApprenticeship;
	}


	public void setEndOfApprenticeship(Date endOfApprenticeship) {
		EndOfApprenticeship = endOfApprenticeship;
	}
}
