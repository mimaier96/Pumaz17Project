package de.dpma.projekt.view;

import de.dpma.projekt.MainApp;
import javafx.fxml.FXML;

public class ReportBookWeeklyController {

	public static MainApp mainApp;

	@FXML
	private void backButton() {
		mainApp.loadBorder("view/MenuPart3.fxml", "title");
		mainApp.loadScene("view/StartViewApprentice.fxml", "�bersicht");
	}
	
	@FXML
	private void handleAbort() {

	}

	public static void setMainApp(MainApp mainApp) {

		ReportBookWeeklyController.mainApp = mainApp;

	}

}
