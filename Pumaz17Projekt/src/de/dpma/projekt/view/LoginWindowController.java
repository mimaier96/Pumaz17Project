package de.dpma.projekt.view;



import de.dpma.projekt.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginWindowController {
	
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	public static MainApp mainApp;

	@FXML
	private void initialize() {

	}

	public LoginWindowController() {

	}

	@FXML
	private void handleLoginButton() {
		if(username.getText().equals("Admin")) {
			mainApp.loadScene("view/StartViewInstructor.fxml", "Anchor", "Übersicht");
		} else {
			mainApp.loadScene("view/StartViewInstructor.fxml", "Anchor", "Übersicht");
			System.out.println("Falsch");
		}
	}

	@FXML
	private void handlePasswordLostButton() {

	}

	public static void setMainApp(MainApp mainApp) {
		LoginWindowController.mainApp = mainApp;

	}
}