package de.dpma.projekt.models.util;

import java.io.File;
import java.util.ArrayList;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.models.ReportBook;
import javafx.stage.FileChooser;

public class ReportBookList {

	public static MainApp mainApp;

	private static ArrayList<ReportBook> reportBookList;

	public static void deleteReportBook(ReportBook reportBook) {

		reportBookList.remove(reportBook);

	}

	public static void deleteReportBookbyId(int id) {

		reportBookList.remove(searchReportBookbyId(id));

	}

	public static ReportBook searchReportBookbyId(int id) {

		for (ReportBook reportBook : reportBookList) {

			if (reportBook.getId() == id) {

				return reportBook;

			}

		}
		return null;
	}

	public static void addReportBook(ReportBook reportBook) {

		reportBookList.add(reportBook);

	}

	public static void createPdf() {

		FileChooser chooser = new FileChooser();
		chooser.setTitle("Berichtsheft speichern");
		chooser.showSaveDialog(null);

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
		chooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File file = chooser.showSaveDialog(mainApp.getPrimaryStage());

	}

	public static void setMainApp(MainApp mainApp) {
		ReportBookList.mainApp = mainApp;

	}

}
