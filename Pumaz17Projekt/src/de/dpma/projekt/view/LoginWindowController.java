package de.dpma.projekt.view;

import de.dpma.projekt.MainApp;
import javafx.fxml.FXML;

public class LoginWindowController {

	public static MainApp mainApp;

	@FXML
	private void initialize() {

	}

	public LoginWindowController() {

	}

	@FXML
	private void handleLoginButton() {

		mainApp.loadScene("view/StartViewInstructor.fxml", "Anchor", "Übersicht");
	}

	@FXML
	private void handlePasswordLostButton() {

	}

	public static void setMainApp(MainApp mainApp) {
		LoginWindowController.mainApp = mainApp;

	}
}