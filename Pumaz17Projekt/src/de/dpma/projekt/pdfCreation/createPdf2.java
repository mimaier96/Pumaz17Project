package de.dpma.projekt.pdfCreation;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import de.dpma.projekt.models.User;

public class createPdf2 {

	static String s = System.getProperty("user.name");
	static String filename = "Ausbildungsverbund S�d T�glich";

	static String dateA = "00.00.0000";
	static String dateE = "00.00.0000";

	static String date1 = "00.00.0000";
	static String date2 = "00.00.0000";
	static String date3 = "00.00.0000";
	static String date4 = "00.00.0000";
	static String date5 = "00.00.0000";
	static String date6 = "00.00.0000";

	static String text1 = "";
	static String text2 = "";
	static String text3 = "";
	static String text4 = "";
	static String text5 = "";
	static String text6 = "";

	static String saveFile = "C:\\Users\\" + s + "\\Downloads\\";
	static String saveFile2 = "C:\\Users\\Admin\\Downloads\\";

	private static User firstname;
	private static User lastname;

	public static void BerichtsheftBetrieblichT�glich() {

		Document AusbildungsverbundS�dT�glich = new Document();

		try {
			// Speichern

			try {
				PdfWriter.getInstance(AusbildungsverbundS�dT�glich, new FileOutputStream(saveFile + filename + ".pdf"));
			} catch (Exception e) {
				// TODO: handle exception
				PdfWriter.getInstance(AusbildungsverbundS�dT�glich,
						new FileOutputStream(saveFile2 + filename + ".pdf"));
			}
			AusbildungsverbundS�dT�glich.open();

			// Tabelle

			PdfPTable table = new PdfPTable(1);
			// Name und Nachname
			table.addCell("Name, Vorname");

			table.addCell(firstname + " " + lastname);
			// Titel
			PdfPCell cell1 = new PdfPCell(new Paragraph("Ausbildungsnachweis f�r den Ausbildungsverbund S�d:"));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(cell1);
			// Datum Woche von bis
			PdfPCell cell2 = new PdfPCell(new Paragraph("f�r den Zeitraum\nvom " + dateA + " bis " + dateE));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell2);
			// Erster Tag (Datum)
			table.addCell("Montag " + date1);
			table.addCell(text1);
			// Zweiter Tag (Datum)
			table.addCell("Dienstag " + date2);
			table.addCell(text2);
			// Dritter Tag (Datum)
			table.addCell("Mittwoch " + date3);
			table.addCell(text3);
			// Vierter Tag (Datum)
			table.addCell("Donnerstag " + date4);
			table.addCell(text4);
			// F�nfter Tag (Datum)
			table.addCell("Freitag " + date5);
			table.addCell(text5);
			// Sechster Tag (Datum)
			table.addCell("Samstag " + date6);
			table.addCell(text6);

			AusbildungsverbundS�dT�glich.add(table);

			AusbildungsverbundS�dT�glich.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
