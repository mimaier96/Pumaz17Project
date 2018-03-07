package de.dpma.projekt.view;

import de.dpma.projekt.MainApp;
import javafx.fxml.FXML;

public class AdminViewInstructorController {

	public static MainApp mainApp;

	@FXML
	private void initialize() {

	}

	public AdminViewInstructorController() {

	}

	@FXML
	private void handleAdminPermissionsButton() {

	}

	@FXML
	private void handleAddUser() {
		mainApp.loadScene("view/AdminViewAddUser.fxml", "Benutzer hinzufügen");
	}

	@FXML
	private void backToInstructorView() {
		mainApp.loadScene("view/StartViewInstructor.fxml", "Übersicht");
	}

	public static void setMainApp(MainApp mainApp) {
		AdminViewInstructorController.mainApp = mainApp;

	}
}