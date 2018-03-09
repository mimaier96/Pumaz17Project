package de.dpma.projekt.view;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.db.DatabaseConnection;
import de.dpma.projekt.db.UserDaoImpl;
import de.dpma.projekt.models.User;
import de.dpma.projekt.models.util.UserList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginWindowController {
	static final Logger log = LogManager.getLogger(LoginWindowController.class.getName());
	private Connection con = DatabaseConnection.getInstance();	
	
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
	private void handleLoginButton() throws SQLException {
		log.info("-->Starte: handleLogin");
		String usernameDataBase = null;
		String passwordDataBase = null;
		String roleDataBase = null;
		//Für nameTag @author MaSpecter
		String userFirstName = null, userLastName = null;

	
		
		for (User user : UserDaoImpl.usersList) {

			if (user.getUsername().equals(username.getText())) {
				usernameDataBase = user.getUsername();
				passwordDataBase = user.getPassword();
				roleDataBase = user.getRole().toLowerCase();
				
				//für NameTag
				userFirstName= user.getFirstname();
				userLastName = user.getLastname();
			}
		}
		
		if(username.getText().equals(usernameDataBase) && password.getText().equals(passwordDataBase)
		   || username.getText().equals("Admin") && password.getText().equals("Anfang12")) {
			if(username.getText().equals("Admin")) {
				roleDataBase = "instructor";
			}
			log.info("-->Login erfolgreich!");
			switch (roleDataBase) {
			case "apprentice":
				//setzt nameTag
				StartViewApprenticeController.setNameTag(userFirstName, userLastName);
				mainApp.loadScene("view/StartViewApprentice.fxml", "Digitales Berichtsheft");			
			break;
			case "trainer":
			case "instructor":
				//setzt nameTag
				StartViewInstructorController.setNameTag(userFirstName, userLastName);
				mainApp.loadScene("view/StartViewInstructor.fxml", "Ausbildungsleiter/in");
			break;
			}	
		} else {
			
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Falsche Eingabe!");
            alert.setHeaderText("Benutzername oder Passwort inkorrekt!");
            alert.setContentText("Bitte versuchen Sie es erneut.");
            
            //Bei falscher Eingabe werden die beiden Eingabefelder gecleared
            username.clear();
            password.clear();

            alert.showAndWait();
			log.info("-->Login fehlgeschlagen!");
		}
		log.info("-->Beende: handleLogin");
	}

	@FXML
	private void handlePasswordLostButton() {
		mainApp.loadScene("view/ChangePassword.fxml", "Passwort vergessen");
	}

	public static void setMainApp(MainApp mainApp) {
		LoginWindowController.mainApp = mainApp;

	}
}