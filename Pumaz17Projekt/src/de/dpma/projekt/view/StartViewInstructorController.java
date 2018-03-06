package de.dpma.projekt.view;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StartViewInstructorController {
	
	@FXML
	private Label nameTag;
	
	private static String firstName;
	private static String lastName;
	

	public static MainApp mainApp;

	@FXML
	private void menuChangePasword() {
		
	}

	@FXML
	private void menuItemLogout() {
		mainApp.loadBorder("view/MenuPart4.fxml", "title");
		mainApp.loadScene("view/LoginWindow.fxml",  "Login");
	}

	@FXML
	private void initialize() {
		nameTag.setText(firstName + " " + lastName);
	}

	public StartViewInstructorController() {

	}

	@FXML
	private void handleAdminButton() {
		mainApp.loadBorder("view/MenuPart3.fxml", "title");
		mainApp.loadScene("view/AdminViewInstructor.fxml", "Administrator");
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

	public static void setNameTag(String userFirstName, String userLastName) {
		firstName = userFirstName;
		lastName = userLastName;
		
	}
}