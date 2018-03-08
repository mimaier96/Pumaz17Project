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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	 * Wird nicht benötigt, da Passwort standardmäßig in der Datenbank auf
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

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	private boolean inputIsValid() {
		
		log.info("-->Starte: inputIsValid -- Datenüberprüfung");

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

		// hier nicht nötig
		
//		if (passwordField.getText() == null || passwordField.getText().length() == 0) {
//			errorMessage += "Kein gültiges Passwort!\n";
//		}

		// Variablen zur Überprüfung, ob Email '@ und .' enthält
		String eMCs = "@";
		CharSequence emailMustChars = eMCs;

		/**
		 * Überprüft, ob Email '@ und .' enthält
		 * 
		 * @author MaSpecter
		 */

		boolean isEmailCorrect = emailField.getText().contains(emailMustChars);
		if (emailField.getText() == null || emailField.getText().length() == 0) {
			errorMessage += "Bitte geben Sie eine E-Mail Adresse an!\\n";
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

//		if (streetField.getText() == null || streetField.getText().length() == 0) {
//			errorMessage += "Keine gültiger Straßenname!\\n";
//		}
//		if (houseNumberField.getText() == null || houseNumberField.getText().length() == 0) {
//			errorMessage += "Keine gültige Hausnummer!\\n";
//		} else {
//			try {
//				Integer.parseInt(houseNumberField.getText());
//			} catch (NumberFormatException e) {
//				errorMessage += "Keine gültige Hausnummer!\\n";
//			}
//		}
//
//		// Überprüft, ob die Eingabe eine fünfstellige Ganzzahl ist
//		if (postalCodeField.getText() == null || postalCodeField.getText().length() != 5) {
//			errorMessage += "Bitte geben Sie eine Postleitzahl ein!\\n";
//		} else {
//			try {
//				/**
//				 * Überprüft den gültigen Postleitzahlen-Bereich von Deutschland
//				 * 
//				 * @author MaSpecter
//				 */
//				int plzCheck = Integer.parseInt(postalCodeField.getText());
//				if (plzCheck < 01000 || plzCheck > 99998) {
//					errorMessage += "Keine gültige Postleizahl!\\n";
//				}
//			} catch (NumberFormatException e) {
//				errorMessage += "Keine gültige Postleitzahl!\\n";
//			}
//		}
//
//		if (cityField.getText() == null || cityField.getText().length() == 0) {
//			errorMessage += "Keine gültige Stadt!\\n";
//		}

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
			log.info("-->Beende: inputIsValid -- Datenüberprüfung");
			return true;
		} else {

			// Zeige Fehlermeldung
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Falsche oder fehldene Eingaben!");
			alert.setHeaderText("Bitte Eingaben korrigieren!");
			alert.setContentText(errorMessage);

			alert.showAndWait();
			
			log.info("-->Beende: inputIsValid -- Datenüberprüfung");

			return false;
		}
		
	}


	/**
	 * Wird aufgerufen, wenn der user auf speichern klickt
	 * 
	 * @author MaSpecter
	 */

	@FXML
	private void handleSaveAddUser() {
		if (inputIsValid()) {

			//Wird später aus der db bezogen
			
			
			Date d = new Date(2001,2,30);
			System.out.println("dadw"+firstNameField.getText()+ lastNameField.getText()+ userNameField.getText()+"Lel"+ roleComboBox.getValue()+ emailField.getText());
//			if(jobComboBox.getValue().equals("")) {
				System.out.println(firstNameField.getText()+ lastNameField.getText()+ userNameField.getText()+"Lel"+ roleComboBox.getValue()+ emailField.getText());
				System.out.println(d);
				System.out.println(mainApp.i.getFirstnameS());
//				mainApp.i.createApprentice(firstNameField.getText(), lastNameField.getText(), userNameField.getText(), "Lel", roleComboBox.getValue(), emailField.getText(), 1, "Dieter", 2018, d, streetField.getText(), 3, 81669, cityField.getText(),"DEPLOYMENT" ,d, d);

				mainApp.i.createApprentice("THorste", "OTto", "OTTOWWWO", "Lel","adawda", "kalus@adwd", 1, "Dieter", 2018, d, "adawdad", 3, 81669, "adawda","DEPLOYMENT" ,d, d);//			}
			addClicked = true;
			dialogStage.close();
		}
	}

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
			alert.setHeaderText("Kein Benutzer ausgewählt!");
			alert.setContentText("Bitte wählen Sie einen Benutzer aus der Tabelle aus.");
		}
		}catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Keine Auswahl");
			alert.setHeaderText("Kein Benutzer ausgewählt!");
			alert.setContentText("Bitte wählen Sie einen Benutzer aus der Tabelle aus.");
		}
		
		
		return null;
	}
	
	
	@FXML
	private void initialize() {

		ObservableList<String> instructors = FXCollections.observableArrayList(UserList.getInstructors());
		instructorComboBox.setItems(instructors);
		
		/**
		 * TODO Wieder frei kommentieren, sobald DB handling gemacht
		 */
//		instructorComboBox.setValue(instructors.get(0));

		ObservableList<String> jobs = FXCollections.observableArrayList(JobList.getJobs());
		jobComboBox.setItems(jobs);
		jobComboBox.setValue("Bitte wählen ...");

		ObservableList<String> roles = FXCollections.observableArrayList(RoleList.getRoles());
		roles.add("Ausbildungsleiter/in");
		roles.add("Auszubildende/r");
		roles.add("Ausbilder/in");
		roleComboBox.setItems(roles);
		roleComboBox.setValue("Bitte wählen ...");
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
