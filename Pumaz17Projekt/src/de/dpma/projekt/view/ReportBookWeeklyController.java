package de.dpma.projekt.view;

import de.dpma.projekt.MainApp;
import javafx.fxml.FXML;

public class ReportBookWeeklyController {

	public static MainApp mainApp;

	@FXML
	private void backToApprenticeView() {
		mainApp.loadScene("view/StartViewApprentice.fxml", "�bersicht");
	}

	public static void setMainApp(MainApp mainApp) {
		AdminViewInstructorController.mainApp = mainApp;

	}

}
