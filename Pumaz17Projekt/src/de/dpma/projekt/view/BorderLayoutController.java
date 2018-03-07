package de.dpma.projekt.view;

import java.io.IOException;

import de.dpma.projekt.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BorderLayoutController {

	public static MainApp mainApp;

	@FXML
	private MenuBar menubar;

	@FXML
	private Menu menu;
	@FXML
	private Menu viewJobs;
	@FXML
	private Menu viewRoles;
	@FXML
	private Menu options;

	@FXML
	private void initialize() {
		// hidePartsBut(menu);
	}

	public static void setMainApp(MainApp mainApp) {
		BorderLayoutController.mainApp = mainApp;

	}

	public void hidePartsBut(Menu... men) {

		menubar.getMenus().clear();
		for (Menu m : men) {
			menubar.getMenus().addAll(m);
		}

	}

	@FXML
	public void changePw() {
		mainApp.loadBorder("view/MenuPart2.fxml", "title");
		mainApp.loadScene("view/CHangePassword.fxml", "Passwort ändern");
	}

	@FXML
	private void help() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/HelpView.fxml"));
		AnchorPane page = (AnchorPane) loader.load();

		Stage dialogStage = new Stage();
		dialogStage.setTitle("Programmhilfe");
		dialogStage.initModality(Modality.WINDOW_MODAL);

		Scene scene = new Scene(page);
		dialogStage.setScene(scene);

		// Show the dialog and wait until the user closes it
		dialogStage.showAndWait();
	}

	@FXML
	private void about() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/About.fxml"));
		AnchorPane page = (AnchorPane) loader.load();

		Stage dialogStage = new Stage();
		dialogStage.setTitle("Programminformationen");
		dialogStage.initModality(Modality.WINDOW_MODAL);

		Scene scene = new Scene(page);
		dialogStage.setScene(scene);

		// Show the dialog and wait until the user closes it
		dialogStage.showAndWait();
	}

	@FXML
	private void logout() {
		mainApp.loadBorder("view/MenuPart2.fxml", "title");
		mainApp.loadScene("view/LoginWindow.fxml", "Login");
	}

}
