package pdfCreation;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {
	
	static String filename = "Betrieblich T�glich";
	static String saveFile = "C:\\Users\\Daniel Lindinger\\Desktop\\Test\\";
	static String name = "Lindinger";
	static String lastname = "Daniel";

	public static void main(String [] args) {

	Document betrieblichT�glich = new Document();
	
	try {
		//Speichern
		
		PdfWriter.getInstance(betrieblichT�glich, new FileOutputStream(saveFile + filename + ".pdf"));
		betrieblichT�glich.open();
		
		//Tabelle
		
		PdfPTable table = new PdfPTable(1);
		table.addCell("Name, Vorname");
		
		table.addCell(name + " " + lastname);
		
		PdfPCell cell1 = new PdfPCell(new Paragraph("Ausbildungsnachweis f�r ander Ausbildungsmapnahmen\nf�r den Zeitraum:"));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell1);
		
		
		
		betrieblichT�glich.add(table);
		
		
		
		
		
		
		betrieblichT�glich.close();
	}catch (Exception e)
	{
		e.printStackTrace();
		

	}
	
}
}