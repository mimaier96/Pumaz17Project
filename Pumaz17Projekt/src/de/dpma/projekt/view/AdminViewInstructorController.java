package de.dpma.projekt.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdminViewInstructorController {
	
	static final Logger log = LogManager.getLogger(LoginWindowController.class.getName());

	public static MainApp mainApp;
	
	//Tabellen Ansicht Elemente
	@FXML
	private TableView<User> userTable;
	@FXML
	private TableColumn<User, Integer> idColumn;
	@FXML
	private TableColumn<User, String> userLastNameColumn;
	@FXML
	private TableColumn<User, String> userFirstNameColumn;
	@FXML
	private TableColumn<User,String> userUserNameColumn;
	@FXML
	private TableColumn<User, String> userRoleColumn;
	@FXML
	private TableColumn<User, String> userEmailColumn;
	
	

	@FXML
	private void initialize() {
		
		log.info("-->Starte: setTableView Data");		
		//setzt die Werte für die Benutzertabelle
		userFirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().userFirstNameProperty());
		userLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().userLastNameProperty());
		userEmailColumn.setCellValueFactory(cellData -> cellData.getValue().userEmailProperty());
		userUserNameColumn.setCellValueFactory(cellData -> cellData.getValue().userEmailProperty());
		userRoleColumn.setCellValueFactory(cellData -> cellData.getValue().userRoleProperty());
		
		log.info("-->Beende: setTableView Data");

	}

	public AdminViewInstructorController() {

	}

	@FXML
	private void handleAdminPermissionsButton() {

	}

	@FXML
	private void handleAddUser() {
		mainApp.showUserAddDialog();
	}
	
	@FXML
	private void handleEditUser() {
		mainApp.loadScene("view/AdminViewAddUser.fxml", "Benutzer bearbeiten");
	}
	

	@FXML
	private void backToInstructorView() {
		mainApp.loadScene("view/StartViewInstructor.fxml", "Übersicht");
	}

	public static void setMainApp(MainApp mainApp) {
		AdminViewInstructorController.mainApp = mainApp;

	}
}