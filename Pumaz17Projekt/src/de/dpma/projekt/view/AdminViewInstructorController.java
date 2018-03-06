package de.dpma.projekt.view;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdminViewInstructorController {

	public static MainApp mainApp;
	
	private static String firstName;
	private static String lastName;
	
	@FXML
	private Label nameTag;
	
	@FXML
	private TableView<User> userTable;
	@FXML
	private TableColumn<User, Integer> idColumn;
	@FXML
	private TableColumn<User, String> userLastName;
	@FXML
	private TableColumn<User, String> userFirstName;
	@FXML
	private TableColumn<User,String> userUserName;
	@FXML
	private TableColumn<User, String> userRole;
	@FXML
	private TableColumn<User, String> userEmail;
	
	

	@FXML
	private void initialize() {

		nameTag.setText(firstName + " " + lastName);
		
		userFirstName.setCellValueFactory(cellData -> cellData.getValue().userFirstNameProperty());


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
	
	public static void setNameTag(String userFirstName, String userLastName) {
		firstName = userFirstName;
		lastName = userLastName;
		
	}

	@FXML
	private void backToInstructorView() {
		mainApp.loadScene("view/StartViewInstructor.fxml", "Übersicht");
	}

	public static void setMainApp(MainApp mainApp) {
		AdminViewInstructorController.mainApp = mainApp;

	}
}