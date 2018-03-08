package de.dpma.projekt.view;

import java.io.File;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.models.ReportBook;
import de.dpma.projekt.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class StartViewInstructorController {

	// static final Logger log =
	// LogManager.getLogger(LoginWindowController.class.getName());

	@FXML
	private Label nameTag;

	private static String firstName;
	private static String lastName;

	@FXML
	private TableView<ReportBook> reportBookTableInstructor;
	@FXML
	private TableColumn<ReportBook, Image> statusColumn;
	@FXML
	private TableColumn<ReportBook, Integer> numberColumn;
	@FXML
	private TableColumn<ReportBook, String> nameColumn;
	@FXML
	private TableColumn<ReportBook, String> weekColumn;
	@FXML
	private TableColumn<ReportBook, Integer> yearColumn;
	@FXML
	private TableColumn<ReportBook, String> jobColumn;
	@FXML
	private TableColumn<ReportBook, String> noteColumn;

	public static MainApp mainApp;

	@FXML
	private void menuChangePasword() {

	}

	@FXML
	private void menuItemLogout() {
		mainApp.loadScene("view/LoginWindow.fxml", "Login");
	}

	@FXML
	private void initialize() {
		nameTag.setText(firstName + " " + lastName);
	}

	public StartViewInstructorController() {

	}

	@FXML
	private void handleAdminButton() {
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
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Berichtsheft speichern");
		chooser.showSaveDialog(null);

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
		chooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File file = chooser.showSaveDialog(mainApp.getPrimaryStage());
	}

	public static void setMainApp(MainApp mainApp) {
		StartViewInstructorController.mainApp = mainApp;

	}

	public static void setNameTag(String userFirstName, String userLastName) {
		firstName = userFirstName;
		lastName = userLastName;

	}
}