package de.dpma.projekt.view;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.models.User;
import de.dpma.projekt.models.user.Instructor;
import de.dpma.projekt.models.util.JobList;
import de.dpma.projekt.models.util.RoleList;
import de.dpma.projekt.models.util.UserList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AdminViewAddAzubiController {
	public static MainApp mainApp;
	//TODO TextFields adden
	
	@FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField userNameField;
    /*Wird nicht benötigt, da Passwort standardmäßig
     * in der Datenbank auf 'Anfang12' gesetzt wird*/
    
    @FXML
    private TextField passwordField;
    
    //Dropdown Role
    @FXML
    private ComboBox<String> roleComboBox;
    @FXML
    private TextField emailField;
    
    
    //Nur bei Azubi
    
    //Ausbildungsberuf Dropdown
    @FXML
    private ComboBox<String> jobComboBox;
    //Ausbildungsleiter Dropdown
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
    private TextField locationOfDeploymentField;
    @FXML
    private TextField beginOfApprenticeshipField;
    @FXML
    private TextField endOfApprenticeshipField;
    
    
    private ArrayList roleComboBox() {
    	return null;
    }
    
    private ArrayList jobComboBox() {
    	return null;
    }
    
    /**Initialisiert diese Controller Klasse. Methode wird nach laden
     * des zugehörigen fxml files aufgerufen
     * 
     * @author MaSpecter
     */
    @FXML
	private void initialize() {
    	
    	ObservableList<String> instructors=FXCollections.observableArrayList(UserList.getInstructors());
    	instructorComboBox.setItems(instructors);
    	
    	ObservableList<String> jobs=FXCollections.observableArrayList(JobList.getJobs());
    	jobComboBox.setItems(jobs);
    	
    	ObservableList<String> roles=FXCollections.observableArrayList(RoleList.getRoles());
    	roleComboBox.setItems(roles);
	}

    
    public static void setMainApp(MainApp mainApp) {
		LoginWindowController.mainApp = mainApp;

	}
		
	}
