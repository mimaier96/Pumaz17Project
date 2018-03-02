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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminViewAddAzubiController {
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
	 * Wird nicht ben�tigt, da Passwort standardm��ig in der Datenbank auf
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
	// Ausbildungsbeh�rde Dropdown
	@FXML
	private ComboBox<String> locationOfDeploymentComboBox;

	private ArrayList roleComboBox() {
		return null;
	}

	private ArrayList jobComboBox() {
		return null;
	}

	private void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	private boolean inputIsValid() {

		String errorMessage = "";

		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errorMessage += "Kein g�ltiger Vorname!\n";
		}

		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
			errorMessage += "Kein g�ltiger Nachname!\n";
		}

		if (userNameField.getText() == null || userNameField.getText().length() == 0) {
			errorMessage += "Kein g�ltiger Benutzername!\n";
		}

		if (passwordField.getText() == null || passwordField.getText().length() == 0) {
			errorMessage += "Kein g�ltiges Passwort!\n";
		}

		// Variablen zur �berpr�fung, ob Email '@ und .' enth�lt
		String eMCs = "@.";
		CharSequence emailMustChars = eMCs;

		/**
		 * �berpr�ft, ob Email '@ und .' enth�lt
		 * 
		 * @author MaSpecter
		 */

		boolean isEmailCorrect = emailField.getText().contains(emailMustChars);
		if (emailField.getText() == null || emailField.getText().length() == 0) {
			errorMessage += "Keine g�ltige E-Mail Adresse!\\n";
		} else if (isEmailCorrect == false) {
			errorMessage += "Keine g�ltige E-Mail Adresse!\\n";
		}

		// Nur f�r Azubis

		if (yearOfEmploymentField.getText() == null || yearOfEmploymentField.getText().length() == 0) {
			errorMessage += "Kein g�ltiges Ausbildungsjahr!\\n";
		} else {
			// String Eingabe wird auf eine Ganzzahl �berpr�ft
			try {
				Integer.parseInt(yearOfEmploymentField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Kein g�ltiges Ausbildungsjahr!\n";
			}
		}

		if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
			errorMessage += "Kein g�ltiges Geburtsdatum! Format: TT.MM.JJJJ\n";
		} else {
			if (!DateUtil.validDate(birthdayField.getText())) {
				errorMessage += "Kein g�ltiges Geburtsdatum! Format: TT.MM.JJJJ\n";
			}
		}

		if (streetField.getText() == null || streetField.getText().length() == 0) {
			errorMessage += "Keine g�ltiger Stra�enname!\\n";
		}
		if (houseNumberField.getText() == null || houseNumberField.getText().length() == 0) {
			errorMessage += "Keine g�ltige Hausnummer!\\n";
		} else {
			try {
				Integer.parseInt(houseNumberField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Keine g�ltige Hausnummer!\\n";
			}
		}

		// �berpr�ft, ob die Eingabe eine f�nfstellige Ganzzahl ist
		if (postalCodeField.getText() == null || postalCodeField.getText().length() != 5) {
			errorMessage += "Keine g�ltige Postleitzahl!\\n";
		} else {
			try {
				/**
				 * �berpr�ft den g�ltigen Postleitzahlen-Bereich von Deutschland
				 * 
				 * @author MaSpecter
				 */
				int plzCheck = Integer.parseInt(postalCodeField.getText());
				if (plzCheck < 01000 || plzCheck > 99998) {
					errorMessage += "Keine g�ltige Postleizahl!\\n";
				}
			} catch (NumberFormatException e) {
				errorMessage += "Keine g�ltige Postleitzahl!\\n";
			}
		}

		if (cityField.getText() == null || cityField.getText().length() == 0) {
			errorMessage += "Keine g�ltige Stadt!\\n";
		}

		if (beginOfApprenticeshipField.getText() == null || beginOfApprenticeshipField.getText().length() == 0) {
			errorMessage += "Kein g�ltiges Datum f�r den Ausbildungsbeginn! Format: TT.MM.JJJJ\\n";
		} else {
			if (!DateUtil.validDate(beginOfApprenticeshipField.getText())) {
				errorMessage += "Kein g�ltiges Datum f�r den Ausbildungsbeginn! Format: TT.MM.JJJJ\\n";
			}
		}

		if (endOfApprenticeshipField.getText() == null || endOfApprenticeshipField.getText().length() == 0) {
			errorMessage += "Kein g�ltiges Datum f�r das Ausbildungsende! Format: TT.MM.JJJJ\\n";
		} else {
			if (!DateUtil.validDate(endOfApprenticeshipField.getText())) {
				errorMessage += "Kein g�ltiges Datum f�r das Ausbildungsende! Format: TT.MM.JJJJ\\n";
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
			
			//TODO im Code Methode aufrufen, die Insert in DB macht
			
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
	 * zugeh�rigen fxml files aufgerufen
	 * 
	 * @author MaSpecter
	 */
	@FXML
	private void initialize() {

		ObservableList<String> instructors = FXCollections.observableArrayList(UserList.getInstructors());
		instructorComboBox.setItems(instructors);
		instructorComboBox.setValue(instructors.get(0));

		ObservableList<String> jobs = FXCollections.observableArrayList(JobList.getJobs());
		jobComboBox.setItems(jobs);

		ObservableList<String> roles = FXCollections.observableArrayList(RoleList.getRoles());
		roleComboBox.setItems(roles);
	}

	public static void setMainApp(MainApp mainApp) {
		LoginWindowController.mainApp = mainApp;

	}

}
