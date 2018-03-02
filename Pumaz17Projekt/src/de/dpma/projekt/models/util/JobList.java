package de.dpma.projekt.models.util;

import java.util.ArrayList;

import de.dpma.projekt.models.ReportBook;
import de.dpma.projekt.models.User;

public class JobList {
//DIESE DATEI IST REIN TEMPORÄR UND DIENT ZUM SPEICHERN VON DATEN. SOBALD DIE DATENBANK WIEDER FUNKTIONIERT, WIRD SICH EINIGES ÄNDERN
	private static ArrayList<String> jobList= new ArrayList<String>();

	public static void deleteReportBook(String job) {

		jobList.remove(job);

	}

	public static void addJob(String job) {

		jobList.add(job);

	}
	
	public static ArrayList<String> getJobs() {
		
		return jobList;
		
}}
