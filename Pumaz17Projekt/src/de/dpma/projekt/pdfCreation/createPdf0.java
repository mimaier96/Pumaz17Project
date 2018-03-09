package de.dpma.projekt.pdfCreation;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import de.dpma.projekt.models.User;

public class createPdf0 {

	static String s = System.getProperty("user.name");
	static String filename = "Berichtsheft W�chentlich";

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

		Document berichtsheftW�chentlich = new Document();

		try {
			// Speichern

			try {
				PdfWriter.getInstance(berichtsheftW�chentlich, new FileOutputStream(saveFile + filename + ".pdf"));
			} catch (Exception e) {
				PdfWriter.getInstance(berichtsheftW�chentlich, new FileOutputStream(saveFile2 + filename + ".pdf"));
			}
			berichtsheftW�chentlich.open();

			// Tabelle

			PdfPTable table = new PdfPTable(1);

			// DPMA Logo
			Image logo = Image.getInstance("resource\\logo_dpma.png");
			logo.getScaledHeight();
			logo.getScaledWidth();
			berichtsheftW�chentlich.add(logo);
			berichtsheftW�chentlich.add(table);
			berichtsheftW�chentlich.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
