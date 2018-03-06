package de.dpma.projekt.models.reportBook;

import java.sql.Date;

import de.dpma.projekt.models.ReportBook;

public class ReportBookDaily extends ReportBook {

	private String textMon;
	private String textTue;
	private String textWed;
	private String textThu;
	private String textFri;
	private String textSat;

	public ReportBookDaily(int id, int idApprentice, String job, Date dateA, Date dateE) {
		super(id, idApprentice, job, dateA, dateE);
		// TODO Auto-generated constructor stub
	}


	public String getTextMon() {
		return textMon;
	}

	public void setTextMon(String textMon) {
		this.textMon = textMon;
	}

	public String getTextTue() {
		return textTue;
	}

	public void setTextTue(String textTue) {
		this.textTue = textTue;
	}

	public String getTextWed() {
		return textWed;
	}

	public void setTextWed(String textWed) {
		this.textWed = textWed;
	}

	public String getTextThu() {
		return textThu;
	}

	public void setTextThu(String textThu) {
		this.textThu = textThu;
	}

	public String getTextFri() {
		return textFri;
	}

	public void setTextFri(String textFri) {
		this.textFri = textFri;
	}

	public String getTextSat() {
		return textSat;
	}

	public void setTextSat(String textSat) {
		this.textSat = textSat;
	}

	
	
	
}
