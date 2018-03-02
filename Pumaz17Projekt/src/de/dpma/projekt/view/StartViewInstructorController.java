package de.dpma.projekt.view;

import de.dpma.projekt.MainApp;
import javafx.fxml.FXML;

public class StartViewInstructorController {

	public static MainApp mainApp;

	@FXML
	private void menuChangePasword() {
		
	}

	@FXML
	private void menuItemLogout() {
		mainApp.loadScene("view/LoginWindow.fxml",  "Anmledung");
	}

	@FXML
	private void initialize() {

	}

	public StartViewInstructorController() {

	}

	@FXML
	private void handleAdminButton() {
		mainApp.loadScene("view/AdminViewInstructor.fxml", "Admin");
	}

	@FXML
	private void handleCommitButton() {

	}

	@FXML
	private void handleRevertButton() {

	}

	@FXML
	private void handleAddNoticeButton() {

	}

	@FXML
	private void handleGenPDFButton() {

	}

	public static void setMainApp(MainApp mainApp) {
		StartViewInstructorController.mainApp = mainApp;

	}
}