package de.dpma.projekt.pdfCreation;

import java.io.FileOutputStream;

import org.w3c.dom.css.Rect;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import de.dpma.projekt.models.User;

public class createPdf0 {

	static String s = System.getProperty("user.name");
	static String filename = "Berichtsheft Wöchentlich";

	static String dateA = "00.00.0000";
	static String dateE = "00.00.0000";
	static String nr = "0";
	static String year = "0";

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
	static String apptrentice = "null";

	public static void BerichtsheftBetrieblichTäglich() {

		Document berichtsheftWöchentlich = new Document();

		try {
			// Speichern

			try {
				PdfWriter.getInstance(berichtsheftWöchentlich, new FileOutputStream(saveFile + filename + ".pdf"));
			} catch (Exception e) {
				PdfWriter.getInstance(berichtsheftWöchentlich, new FileOutputStream(saveFile2 + filename + ".pdf"));
			}
			berichtsheftWöchentlich.open();
//Logo
			Image logo = Image.getInstance("resource\\logo_dpma.png");
			logo.scaleToFit(107, 49);
			berichtsheftWöchentlich.add(logo);
//Tabelle
			PdfPTable table = new PdfPTable(2);
			table.getDefaultCell().setBorder(0);table.getDefaultCell().setBorder(0);
			table.addCell("");
			table.addCell("Name: " + firstname + " " + lastname);
			table.addCell("");
			table.addCell("Ausbildungsreferat: " + apptrentice);
			berichtsheftWöchentlich.add(table);

			PdfPTable table1 = new PdfPTable(5);

			//table1.Border = Rectangle.ALIGN_LEFT | Rectangle.RIGHT | Rectangle.BOTTOM | Rectangle.TOP;

			table1.addCell("Ausbildungsnachweis");
			table1.addCell(nr);
			table1.addCell(dateA);
			table1.addCell(dateE);
			table1.addCell(year);

			// PdfPCell cell0 = new PdfPCell(new Phrase(nr));
			// PdfPCell cell1 = new PdfPCell(new Phrase(dateA));
			// PdfPCell cell2 = new PdfPCell(new Phrase(year));

			// cell0.setBorder(Rectangle.BOTTOM);
			// cell1.setBorder(Rectangle.BOTTOM);
			// cell2.setBorder(Rectangle.BOTTOM);

			table1.addCell("");
			table1.addCell("Nr.");
			table1.addCell("Ausbildungswoche vom");
			table1.addCell("bis");
			table1.addCell("Ausbildungsjahr");

			berichtsheftWöchentlich.add(table1);

			PdfPTable table2 = new PdfPTable(1);

			table2.addCell("Betriebliche Tätigkeiten");
			table2.addCell("");

			table2.addCell("Unterweisungen, Lehrgespräche, betrieblicher Unterricht, sonstige Schulungen");
			table2.addCell("");

			table2.addCell("Berufsschule (Unterrichtsthemen)");
			table2.addCell("");

			berichtsheftWöchentlich.add(table2);

			PdfPTable table3 = new PdfPTable(1);

			table3.addCell(
					"Durch die nachfolgenden Unterschriften wird die Richtigkeit und Vollständigkeit der obigen Angaben bestätigt.");

			berichtsheftWöchentlich.add(table3);

			berichtsheftWöchentlich.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
