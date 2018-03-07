package de.dpma.projekt.view;

import de.dpma.projekt.MainApp;
import javafx.fxml.FXML;

public class ReportBookWeeklyController {

	public static MainApp mainApp;

	@FXML
	private void backToApprenticeView() {
		mainApp.loadBorder("view/MenuPart3", "title");
		mainApp.loadScene("view/StartViewApprentice.fxml", "Übersicht");
	}

	public static void setMainApp(MainApp mainApp) {
		ReportBookWeeklyController.mainApp = mainApp;

	}

}
