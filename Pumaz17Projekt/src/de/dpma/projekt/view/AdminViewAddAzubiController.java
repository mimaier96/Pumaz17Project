package de.dpma.projekt.view;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.models.User;
import de.dpma.projekt.models.user.Instructor;
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
    /*Wird nicht ben�tigt, da Passwort standardm��ig
     * in der Datenbank auf 'Anfang12' gesetzt wird*/
    
//    @FXML
//    private TextField passwordField;
    
    //Dropdown Role
//    @FXML
//    private ComboBox<Role> roleComboBox;
    @FXML
    private TextField emailField;
    
    
    //Nur bei Azubi
    
    //Ausbildungsberuf Dropdown
//    @FXML
//    private ComboBox<Job> jobComboBox;
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
    
//    private final static String PREPARED_SELECT_INSTRUCTORS = "SELECT id, firstname, lastname FROM user WHERE role IS 'Ausbildungsleiter/in';";
//    private ArrayList instructorComboBox() {
    	//TODO aus user table Statement: SELECT id, firstname, lastname FROM user WHERE role IS 'Ausbildungsleiter/in';
    	//f�r jeden instructor, der gefunden wird ein eigenes Objekt erstellen, dieses ArrayList hinzuf�gen
    	//mit for schleife abfrageergebnisse durchiterieren und in arraylist speichern
    
    		
//    	}
    	

//		if (resSet.next()) {
//			int id = (int) resSet.getLong(1);
//			apprentice.setId(id);
//		}
    	
//    	return null;
//    }
    
    private ArrayList roleComboBox() {
    	return null;
    }
    
    private ArrayList jobComboBox() {
    	return null;
    }
    
    /**Initialisiert diese Controller Klasse. Methode wird nach laden
     * des zugeh�rigen fxml files aufgerufen
     * 
     * @author MaSpecter
     */
    @FXML
	private void initialize() {
    	/**@param Nimmt FX instructorComboBox und verkn�pft es mit der ArrayList instructorComboBox
    	 * @author MaSpecter
    	 */
    	System.out.println("1");
//    	instructorComboBox.getItems().addAll(instructorComboBox());
    	
    	ObservableList<String> i=FXCollections.observableArrayList(UserList.getInstructors());
    	
    	instructorComboBox.setItems(i);
    	System.out.println(i);
    	
	}

//	public static MainApp mainApp;
//	
//	public static void setMainApp(MainApp mainApp) {
//		LoginWindowController.mainApp = mainApp;
//
//	}
    public static void setMainApp(MainApp mainApp) {
		LoginWindowController.mainApp = mainApp;

	}
		
	}
