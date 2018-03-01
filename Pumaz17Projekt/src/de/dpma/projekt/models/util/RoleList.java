package de.dpma.projekt.models.util;

import java.util.ArrayList;

import de.dpma.projekt.models.ReportBook;
import de.dpma.projekt.models.User;

public class RoleList {
//DIESE DATEI IST REIN TEMPORÄR UND DIENT ZUM SPEICHERN VON DATEN. SOBALD DIE DATENBANK WIEDER FUNKTIONIERT, WIRD SICH EINIGES ÄNDERN
	private static ArrayList<String> roleList= new ArrayList<String>();

	public static void deleteReportBook(String role) {

		roleList.remove(role);

	}

	

	public static void addRole(String role) {

		roleList.add(role);

	}
	
	public static ArrayList<String> getRoles() {
		
		return roleList;
	}
}
