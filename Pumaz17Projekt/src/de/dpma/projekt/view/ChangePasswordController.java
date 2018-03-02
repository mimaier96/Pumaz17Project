package de.dpma.projekt.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import de.dpma.projekt.MainApp;
import de.dpma.projekt.db.DatabaseConnection;

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
	private Label checkfail;

	
	@FXML
	private void handleSaveButton() throws SQLException {
		log.info("-->Starte: handleSaveButton");
		PreparedStatement prepStat = null; 
		ResultSet result = null;
		final String UPDATE_PASSWORD = "UPDATE berichtsheft.user SET Password = '"+ newPassword.getText() +"' WHERE Username = '"+ username.getText() +"';";

		if(newPassword.getText().equals(newPasswordCheck.getText())) {
			
		prepStat = con.prepareStatement(UPDATE_PASSWORD);
		result = prepStat.executeQuery();
		
		while(result.next()) {
		log.info("-->" + result.getString("password") );
		
		}
		} else {
		}
		log.info("-->Beende: handleSaveButton");	
	}

	
}
