package de.dpma.projekt.view;

import java.io.File;
import java.util.ArrayList;
import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.db.UserDaoImpl;
import de.dpma.projekt.models.User;
import de.dpma.projekt.models.user.Apprentice;
import de.dpma.projekt.models.user.Instructor;
import de.dpma.projekt.models.util.JobList;
import de.dpma.projekt.models.util.RoleList;
import de.dpma.projekt.models.util.UserList;
import de.dpma.projekt.utils4Code.DateUtil;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AdminViewAddUserController {
	public static MainApp mainApp;
	
	static final Logger log = LogManager.getLogger(LoginWindowController.class.getName());
	
	private User user;

	private boolean addClicked = false;
	private Stage dialogStage;

	@FXML
	private TableView<User> userTable;
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

//	@FXML
//	private TextField passwordField;

	// Dropdown Role
	@FXML
	private ComboBox<String> roleComboBox;
	@FXML
	private TextField emailField;
	@FXML
	private Button fileUploadButton;

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
	private DatePicker birthdayField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField houseNumberField;
	@FXML
	private TextField postalCodeField;
	@FXML
	private TextField cityField;
	@FXML
	private DatePicker beginOfApprenticeshipField;
	@FXML
	private DatePicker endOfApprenticeshipField;
	// Ausbildungsbeh�rde Dropdown 
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

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

//	private boolean inputIsValid() {
//		
//		log.info("-->Starte: inputIsValid -- Daten�berpr�fung");
//
//		String errorMessage = "";
//
//		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
//			errorMessage += "Kein g�ltiger Vorname!\n";
//		}
//
//		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
//			errorMessage += "Kein g�ltiger Nachname!\n";
//		}
//
//		if (userNameField.getText() == null || userNameField.getText().length() == 0) {
//			errorMessage += "Kein g�ltiger Benutzername!\n";
//		}
//
//		// hier nicht n�tig
//		
////		if (passwordField.getText() == null || passwordField.getText().length() == 0) {
////			errorMessage += "Kein g�ltiges Passwort!\n";
////		}
//
//		// Variablen zur �berpr�fung, ob Email '@ und .' enth�lt
//		String eMCs = "@";
//		CharSequence emailMustChars = eMCs;
//
//		/**
//		 * �berpr�ft, ob Email '@ und .' enth�lt
//		 * 
//		 * Maracus
//		 */
//
//		boolean isEmailCorrect = emailField.getText().contains(emailMustChars);
//		if (emailField.getText() == null || emailField.getText().length() == 0) {
//			errorMessage += "Bitte geben Sie eine E-Mail Adresse an!\\n";
//		} else if (isEmailCorrect == false) {
//			errorMessage += "Keine g�ltige E-Mail Adresse!\\n";
//		}
//
//		// Nur f�r Azubis
	
//	if (roleComboBox.getValue().equals("Auszubildene/r")) {
//
//		if (yearOfEmploymentField.getText() == null || yearOfEmploymentField.getText().length() == 0) {
//			errorMessage += "Kein g�ltiges Ausbildungsjahr!\\n";
//		} else {
//			// String Eingabe wird auf eine Ganzzahl �berpr�ft
//			try {
//				Integer.parseInt(yearOfEmploymentField.getText());
//			} catch (NumberFormatException e) {
//				errorMessage += "Kein g�ltiges Ausbildungsjahr!\n";
//			}
//		}
//
////		if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
////			errorMessage += "Kein g�ltiges Geburtsdatum! Format: TT.MM.JJJJ\n";
////		} else {
////			if (!DateUtil.validDate(birthdayField.getText())) {
////				errorMessage += "Kein g�ltiges Geburtsdatum! Format: TT.MM.JJJJ\n";
////			}
////		}
//
////		if (streetField.getText() == null || streetField.getText().length() == 0) {
////			errorMessage += "Keine g�ltiger Stra�enname!\\n";
////		}
////		if (houseNumberField.getText() == null || houseNumberField.getText().length() == 0) {
////			errorMessage += "Keine g�ltige Hausnummer!\\n";
////		} else {
////			try {
////				Integer.parseInt(houseNumberField.getText());
////			} catch (NumberFormatException e) {
////				errorMessage += "Keine g�ltige Hausnummer!\\n";
////			}
////		}
////
////		// �berpr�ft, ob die Eingabe eine f�nfstellige Ganzzahl ist
////		if (postalCodeField.getText() == null || postalCodeField.getText().length() != 5) {
////			errorMessage += "Bitte geben Sie eine Postleitzahl ein!\\n";
////		} else {
////			try {
////				/**
////				 * �berpr�ft den g�ltigen Postleitzahlen-Bereich von Deutschland
////				 * 
////				 * Maracus
////				 */
////				int plzCheck = Integer.parseInt(postalCodeField.getText());
////				if (plzCheck < 01000 || plzCheck > 99998) {
////					errorMessage += "Keine g�ltige Postleizahl!\\n";
////				}
////			} catch (NumberFormatException e) {
////				errorMessage += "Keine g�ltige Postleitzahl!\\n";
////			}
////		}
////
////		if (cityField.getText() == null || cityField.getText().length() == 0) {
////			errorMessage += "Keine g�ltige Stadt!\\n";
////		}
//
////		if (beginOfApprenticeshipField.getText() == null || beginOfApprenticeshipField.getText().length() == 0) {
////			errorMessage += "Kein g�ltiges Datum f�r den Ausbildungsbeginn! Format: TT.MM.JJJJ\\n";
////		} else {
////			if (!DateUtil.validDate(beginOfApprenticeshipField.getText())) {
////				errorMessage += "Kein g�ltiges Datum f�r den Ausbildungsbeginn! Format: TT.MM.JJJJ\\n";
////			}
////		}
////
////		if (endOfApprenticeshipField.getText() == null || endOfApprenticeshipField.getText().length() == 0) {
////			errorMessage += "Kein g�ltiges Datum f�r das Ausbildungsende! Format: TT.MM.JJJJ\\n";
////		} else {
////			if (!DateUtil.validDate(endOfApprenticeshipField.getText())) {
////				errorMessage += "Kein g�ltiges Datum f�r das Ausbildungsende! Format: TT.MM.JJJJ\\n";
////			}
////		}
//}
//
//		if (errorMessage.length() == 0) {
//			log.info("-->Beende: inputIsValid -- Daten�berpr�fung");
//			return true;
//		} else {
//
//			// Zeige Fehlermeldung
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.initOwner(dialogStage);
//			alert.setTitle("Falsche oder fehldene Eingaben!");
//			alert.setHeaderText("Bitte Eingaben korrigieren!");
//			alert.setContentText(errorMessage);
//
//			alert.showAndWait();
//			
//			log.info("-->Beende: inputIsValid -- Daten�berpr�fung");
//
//			return false;
//		}
//		
//	}


	/**
	 * Wird aufgerufen, wenn der user auf speichern klickt
	 * 
	 * Maracus
	 */

	@FXML
	private void handleSaveAddUser() {
//		if (inputIsValid()) {
		DateUtil u = new DateUtil();
			//Wird sp�ter aus der db bezogen
		switch(roleComboBox.getValue()) {
		
		case "Auszubildende/r":
			System.out.println("a");
			mainApp.i.createApprentice(firstNameField.getText(), lastNameField.getText(), userNameField.getText(), "Anfang12", "Apprentice", emailField.getText(), 5, instructorComboBox.getValue(),Integer.parseInt(yearOfEmploymentField.getText()), Date.valueOf(birthdayField.getValue()), streetField.getText(), Integer.parseInt(houseNumberField.getText()), Integer.parseInt(postalCodeField.getText()), cityField.getText(),locationOfDeploymentComboBox.getValue() ,Date.valueOf(beginOfApprenticeshipField.getValue()), Date.valueOf(endOfApprenticeshipField.getValue()));
			break;
		case "Ausbildungsleiter/in":
			mainApp.i.createInstructor(firstNameField.getText(), lastNameField.getText(), userNameField.getText(), "Anfang12", "Instructor", emailField.getText());
			System.out.println("b");
			break;
		case "Ausbilder/in":
			mainApp.i.createTrainer(firstNameField.getText(), lastNameField.getText(), userNameField.getText(), "Anfang12", "Trainer", emailField.getText());
			System.out.println("c");
			break;
		}
			addClicked = true;
			dialogStage.close();
		}
//	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	@FXML
	private void handleFileUpload() {
		log.info("-->Starte: File Upload Dialog");
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Unterschrift hochladen");
//		chooser.showOpenDialog(null);
		
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "PNG files (*.png)", "*.png");
		chooser.getExtensionFilters().add(extFilter);

        // Show open file dialog
        File file = chooser.showOpenDialog(mainApp.getPrimaryStage());

        
	}
	
	public User addUserData() {
		
		return null;
	}

	
	public User setUserData(User user) {
		this.user = user;
		
		try {
		
		firstNameField.setText(user.getFirstname());
		lastNameField.setText(user.getLastname());
		userNameField.setText(user.getUsername());
		roleComboBox.setValue(user.getRole());
		emailField.setText(user.getEmail());
		
		
		User selectedUser = userTable.getSelectionModel().getSelectedItem();
		
		if(selectedUser != null) {
			boolean addClicked = mainApp.showUserEditDialog(selectedUser);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Keine Auswahl");
			alert.setHeaderText("Kein Benutzer ausgew�hlt!");
			alert.setContentText("Bitte w�hlen Sie einen Benutzer aus der Tabelle aus.");
		}
		}catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Keine Auswahl");
			alert.setHeaderText("Kein Benutzer ausgew�hlt!");
			alert.setContentText("Bitte w�hlen Sie einen Benutzer aus der Tabelle aus.");
		}
		
		
		return null;
	}
	
	
	@FXML
	private void initialize() {

		ObservableList<String> instructors = FXCollections.observableArrayList(UserList.getInstructors());
		instructors.add("Michael Baumgartner");
		instructors.add("Peter Stremm");
		instructorComboBox.setItems(instructors);
		instructorComboBox.setValue("Bitte w�hlen ...");
		
		/**
		 * TODO Wieder frei kommentieren, sobald DB handling gemacht
		 */
//		instructorComboBox.setValue(instructors.get(0));

		ObservableList<String> jobs = FXCollections.observableArrayList(JobList.getJobs());
		jobs.add("FISI");
		jobs.add("FIAN");
		jobComboBox.setItems(jobs);
		jobComboBox.setValue("Bitte w�hlen ...");

		ObservableList<String> roles = FXCollections.observableArrayList(RoleList.getRoles());
		roles.add("Ausbildungsleiter/in");
		roles.add("Auszubildende/r");
		roles.add("Ausbilder/in");
		roleComboBox.setItems(roles);
		roleComboBox.setValue("Bitte w�hlen ...");
		
		ObservableList<String> dep = FXCollections.observableArrayList();
		dep.add("M�nchen");
		dep.add("Jena");
		dep.add("Hauzenberg");
		locationOfDeploymentComboBox.setItems(dep);
		locationOfDeploymentComboBox.setValue("Bitte w�hlen ...");
		
		isApprentice();
	}

	public static void setMainApp(MainApp mainApp) {
		AdminViewAddUserController.mainApp = mainApp;

	}


	
	@FXML
	private void isApprentice() {
		if(roleComboBox.getValue().equals("Auszubildende/r") ==false) {

			gpApprentice.setVisible(false);
			
			
		}
		else {
			gpApprentice.setVisible(true);
			
		}
		
		
	}
}
