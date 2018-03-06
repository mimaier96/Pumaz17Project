package de.dpma.projekt.models.reportBook;

import java.sql.Date;

import de.dpma.projekt.models.ReportBook;

public class ReportBookWeekly extends ReportBook {
	
	private String textWeek;
	private String textNote;
	
	public ReportBookWeekly(int id, int idApprentice, String job, Date dateA, Date dateE) {
		super(id, idApprentice, job, dateA, dateE);
		// TODO Auto-generated constructor stub
	}

	public String getTextWeek() {
		return textWeek;
	}

	public void setTextWeek(String textWeek) {
		this.textWeek = textWeek;
	}

	public String getTextNote() {
		return textNote;
	}

	public void setTextNote(String textNote) {
		this.textNote = textNote;
	}
	
	
	
}
