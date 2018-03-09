package de.dpma.projekt.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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

public class ChangePasswordController {
	static final Logger log = LogManager.getLogger(ChangePasswordController.class.getName());
	private Connection con = DatabaseConnection.getInstance();	

	@FXML
	private TextField username;
	@FXML
	private PasswordField oldPassword;
	@FXML
	private PasswordField newPassword;
	@FXML
	private PasswordField newPasswordCheck;
	@FXML
	public static MainApp mainApp;

	
	@FXML
	private void handleSaveButton() throws SQLException {
		log.info("-->Starte: handleSaveButton");
		PreparedStatement prepStatUp = null; 
		PreparedStatement prepStatGet = null;
		ResultSet result = null;
		String passwordDataBase = "";
		String usernameDataBase = "";
		User userDataBase = new User();
		String update = "Password";
		final String GET_USERNAME_PASSWORD = "SELECT Username, Password FROM berichtsheft.user WHERE username = ?";
		final String UPDATE_PASSWORD = "UPDATE berichtsheft.user SET Password = ? WHERE Username = ?";
		
		/*prepStatGet = con.prepareStatement(GET_USERNAME_PASSWORD);
		prepStatGet.setString(1, username.getText());
		result = prepStatGet.executeQuery();
		
		while(result.next()) {
			passwordDataBase = result.getString("Password");
		}*/
		
		for (User user : UserDaoImpl.usersList) {

			if (user.getUsername().equals(username.getText())) {
				passwordDataBase = user.getPassword();
				usernameDataBase = user.getUsername();
				userDataBase = user;
			}
		}
		
		// �berpr�ft ob ein Benutzer eingegeben wurde, falls nicht wird er zur�ck zum Login geworfen
		if(username.getText().equals("")) {
			mainApp.loadScene("view/LoginWindow.fxml", "�bersicht");	
		}
		
		//�berpr�ft ob der eingegebene User ein Passwort hat, falls nicht Fehlermeldung
		else if(passwordDataBase.equals("") && !username.getText().equals("")) {
			
			Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Falsche Eingabe!");
            alert.setHeaderText("Benutzername, Altes Passwort oder Neues Passwort inkorrekt!");
            alert.setContentText("Bitte versuchen Sie es erneut.");

            alert.showAndWait();
			log.info("--> Eingabefehler!");
		}
		
		//�berpr�ft ob alle Daten richtig eingegeben wurde und �ndert das Passwort
		else if(newPassword.getText().equals(newPasswordCheck.getText()) && passwordDataBase.equals(oldPassword.getText())) {
			
		/*prepStatUp = con.prepareStatement(UPDATE_PASSWORD);
		prepStatUp.setString(1, newPassword.getText());
		prepStatUp.setString(2, username.getText());
		prepStatUp.executeUpdate();*/
			
		UserDaoImpl.updateUser(userDataBase, update, newPassword.getText());
		
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("Passwort �ndern.");
        alert.setHeaderText("Passwort ge�ndert!");
        alert.setContentText("Sie haben Ihr Passwort erfolgreich ge�ndert.");

        alert.showAndWait();
        
		mainApp.loadScene("view/LoginWindow.fxml", "�bersicht");
		}
		
		//Falls eine der EIngaben fehlerhaft ist, wird eine Fehlermeldung ausgegeben
		else {
			
			Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Falsche Eingabe!");
            alert.setHeaderText("Benutzername, Altes Passwort oder Neues Passwort inkorrekt!");
            alert.setContentText("Bitte versuchen Sie es erneut.");

            alert.showAndWait();
			log.info("--> Eingabefehler!");	
		}
		
			log.info("-->Beende: handleSaveButton");	
	}
	
	@FXML
	private void handleCancelButton() {
		mainApp.loadScene("view/LoginWindow.fxml", "Login");
	}

	public static void setMainApp(MainApp mainApp) {
		ChangePasswordController.mainApp = mainApp;

	}
	
	@FXML
	private void initialize() {
	}

	public ChangePasswordController() {
	}
}
