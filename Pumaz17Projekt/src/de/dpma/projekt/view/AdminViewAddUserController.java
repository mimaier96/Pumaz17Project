package de.dpma.projekt.view;

import java.util.ArrayList;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.db.UserDaoImplementation;
import de.dpma.projekt.models.user.Apprentice;
import de.dpma.projekt.models.util.JobList;
import de.dpma.projekt.models.util.RoleList;
import de.dpma.projekt.models.util.UserList;
import de.dpma.projekt.utils4Code.DateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminViewAddUserController {
	public static MainApp mainApp;

	private boolean saveClicked = false;
	private Stage dialogStage;

	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField userNameField;
	/*
	 * Wird nicht benötigt, da Passwort standardmäßig in der Datenbank auf
	 * 'Anfang12' gesetzt wird
	 */

	@FXML
	private TextField passwordField;

	// Dropdown Role
	@FXML
	private ComboBox<String> roleComboBox;
	@FXML
	private TextField emailField;

	// Nur bei Azubi

	// Ausbildungsberuf Dropdown
	@FXML
	private ComboBox<String> jobComboBox;
	// Ausbildungsleiter Dropdown
	@FXML
	private ComboBox<String> instructorComboBox;
	@FXML
	private TextField yearOfEmploymentField;
	@FXML
	private TextField birthdayField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField houseNumberField;
	@FXML
	private TextField postalCodeField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField beginOfApprenticeshipField;
	@FXML
	private TextField endOfApprenticeshipField;
	// Ausbildungsbehörde Dropdown
	@FXML
	private ComboBox<String> locationOfDeploymentComboBox;

	@FXML
	private GridPane gpAll;

	@FXML
	private GridPane gpApprentice;

	@FXML
	private AnchorPane all;

	private ArrayList roleComboBox() {
		return null;
	}

	private ArrayList jobComboBox() {
		return null;
	}

	ObservableList<String> chooseRoleList = FXCollections.observableArrayList("Auszubildender", "Ausbilder",
			"Ausbildungsleiter");

	@FXML
	private ChoiceBox<String> chooseRole;

	private void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	private boolean inputIsValid() {

		String errorMessage = "";

		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errorMessage += "Kein gültiger Vorname!\n";
		}

		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
			errorMessage += "Kein gültiger Nachname!\n";
		}

		if (userNameField.getText() == null || userNameField.getText().length() == 0) {
			errorMessage += "Kein gültiger Benutzername!\n";
		}

		if (passwordField.getText() == null || passwordField.getText().length() == 0) {
			errorMessage += "Kein gültiges Passwort!\n";
		}

		// Variablen zur Überprüfung, ob Email '@ und .' enthält
		String eMCs = "@.";
		CharSequence emailMustChars = eMCs;

		/**
		 * Überprüft, ob Email '@ und .' enthält
		 * 
		 * @author MaSpecter
		 */

		boolean isEmailCorrect = emailField.getText().contains(emailMustChars);
		if (emailField.getText() == null || emailField.getText().length() == 0) {
			errorMessage += "Keine gültige E-Mail Adresse!\\n";
		} else if (isEmailCorrect == false) {
			errorMessage += "Keine gültige E-Mail Adresse!\\n";
		}

		// Nur für Azubis

		if (yearOfEmploymentField.getText() == null || yearOfEmploymentField.getText().length() == 0) {
			errorMessage += "Kein gültiges Ausbildungsjahr!\\n";
		} else {
			// String Eingabe wird auf eine Ganzzahl überprüft
			try {
				Integer.parseInt(yearOfEmploymentField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Kein gültiges Ausbildungsjahr!\n";
			}
		}

		if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
			errorMessage += "Kein gültiges Geburtsdatum! Format: TT.MM.JJJJ\n";
		} else {
			if (!DateUtil.validDate(birthdayField.getText())) {
				errorMessage += "Kein gültiges Geburtsdatum! Format: TT.MM.JJJJ\n";
			}
		}

		if (streetField.getText() == null || streetField.getText().length() == 0) {
			errorMessage += "Keine gültiger Straßenname!\\n";
		}
		if (houseNumberField.getText() == null || houseNumberField.getText().length() == 0) {
			errorMessage += "Keine gültige Hausnummer!\\n";
		} else {
			try {
				Integer.parseInt(houseNumberField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Keine gültige Hausnummer!\\n";
			}
		}

		// Überprüft, ob die Eingabe eine fünfstellige Ganzzahl ist
		if (postalCodeField.getText() == null || postalCodeField.getText().length() != 5) {
			errorMessage += "Keine gültige Postleitzahl!\\n";
		} else {
			try {
				/**
				 * Überprüft den gültigen Postleitzahlen-Bereich von Deutschland
				 * 
				 * @author MaSpecter
				 */
				int plzCheck = Integer.parseInt(postalCodeField.getText());
				if (plzCheck < 01000 || plzCheck > 99998) {
					errorMessage += "Keine gültige Postleizahl!\\n";
				}
			} catch (NumberFormatException e) {
				errorMessage += "Keine gültige Postleitzahl!\\n";
			}
		}

		if (cityField.getText() == null || cityField.getText().length() == 0) {
			errorMessage += "Keine gültige Stadt!\\n";
		}

		if (beginOfApprenticeshipField.getText() == null || beginOfApprenticeshipField.getText().length() == 0) {
			errorMessage += "Kein gültiges Datum für den Ausbildungsbeginn! Format: TT.MM.JJJJ\\n";
		} else {
			if (!DateUtil.validDate(beginOfApprenticeshipField.getText())) {
				errorMessage += "Kein gültiges Datum für den Ausbildungsbeginn! Format: TT.MM.JJJJ\\n";
			}
		}

		if (endOfApprenticeshipField.getText() == null || endOfApprenticeshipField.getText().length() == 0) {
			errorMessage += "Kein gültiges Datum für das Ausbildungsende! Format: TT.MM.JJJJ\\n";
		} else {
			if (!DateUtil.validDate(endOfApprenticeshipField.getText())) {
				errorMessage += "Kein gültiges Datum für das Ausbildungsende! Format: TT.MM.JJJJ\\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {

			// Zeige Fehlermeldung
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Falsche oder fehldene Eingaben!");
			alert.setHeaderText("Bitte Eingaben korrigieren!");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

	public boolean isSaveClicked() {
		return saveClicked;
	}

	/**
	 * Wird aufgerufen, wenn der user auf speichern klickt
	 * 
	 * @author MaSpecter
	 */

	@FXML
	private void handleSaveAddApprentice() {
		if (inputIsValid()) {

			// TODO im Code Methode aufrufen, die Insert in DB macht

			saveClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Initialisiert diese Controller Klasse. Methode wird nach laden des
	 * zugehörigen fxml files aufgerufen
	 * 
	 * @author MaSpecter
	 */
	@FXML
	private void initialize() {

		ObservableList<String> instructors = FXCollections.observableArrayList(UserList.getInstructors());
		instructorComboBox.setItems(instructors);
		instructorComboBox.setValue("Bitte wählen ...");

		ObservableList<String> jobs = FXCollections.observableArrayList(JobList.getJobs());
		jobComboBox.setItems(jobs);
		jobComboBox.setValue("Bitte wählen ...");

		ObservableList<String> roles = FXCollections.observableArrayList(RoleList.getRoles());
		roles.add("Ausbildungsleiter");
		roles.add("Azubi");
		roles.add("Ausbilder");
		roleComboBox.setItems(roles);
		roleComboBox.setValue("Bitte wählen ...");
		// Weglassen, wenn Dao komplett

		gpApprentice.clearConstraints(all);
	}

	public static void setMainApp(MainApp mainApp) {
		AdminViewAddUserController.mainApp = mainApp;

	}

	@FXML
	private void handleChooseDocumentButton() {

	}

	
	@FXML
	private void isApprentice() {
		
		if(roleComboBox.getValue().equals("Azubi") ==false) {
			
			gpApprentice.setVisible(false);
			
			
		}
		else {
			gpApprentice.setVisible(true);
			
		}
		
		
	}
}
