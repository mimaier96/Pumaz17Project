package de.dpma.projekt.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.db.ApprenticeDao;
import de.dpma.projekt.db.ApprenticeDaoImpl;
import de.dpma.projekt.db.UserDaoImpl;
import de.dpma.projekt.models.User;
import java.sql.SQLException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class AdminViewInstructorController {

	private User user;

	static final Logger log = LogManager.getLogger(LoginWindowController.class.getName());

	public static MainApp mainApp;

	// Tabellen Ansicht Elemente
	@FXML
	private TableView<User> userTable;
	@FXML
	private TableColumn<User, String> userLastNameColumn;
	@FXML
	private TableColumn<User, String> userFirstNameColumn;
	@FXML
	private TableColumn<User, String> userUserNameColumn;
	@FXML
	private TableColumn<User, String> userRoleColumn;
	@FXML
	private TableColumn<User, String> userEmailColumn;

	@FXML
	private void initialize() {
		log.info("-->Starte: setTableView Data");

		try {
			userTable.setItems(UserDaoImpl.getUsersList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// setzt die Werte f�r die Benutzertabelle
		userFirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().userFirstNameProperty());
		userLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().userLastNameProperty());
		userEmailColumn.setCellValueFactory(cellData -> cellData.getValue().userEmailProperty());
		userUserNameColumn.setCellValueFactory(cellData -> cellData.getValue().userUsernameProperty());
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

		User selectedUser = userTable.getSelectionModel().getSelectedItem();		

		if (selectedUser != null) {
			System.out.println("a");
			boolean changeClicked = mainApp.showUserEditDialog(selectedUser);
			if (changeClicked) {
				mainApp.showUserEditDialog(selectedUser);
            }
		} else {
			System.out.println("c");
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Keine Auswahl");
			alert.setHeaderText("Kein Benutzer ausgew�hlt!");
			alert.setContentText("Bitte w�hlen Sie einen Benutzer aus der Tabelle aus.");
		}
	}

	@FXML
	private void handleDeleteUser() {
		ApprenticeDao AppDao = new ApprenticeDaoImpl();
		try {
			int selectedUser = userTable.getSelectionModel().getSelectedIndex();
			User selectedUserDel = userTable.getSelectionModel().getSelectedItem();
			
			if (selectedUser >= 0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Benutzer l�schen");
				alert.setHeaderText("Sind Sie sicher, dass Sie den Benutzer " + selectedUserDel.getFirstname() + " " + selectedUserDel.getLastname() + " l�schen m�chten?");
				Optional<ButtonType> result = alert.showAndWait();
				
				if (result.get() == ButtonType.OK){
					userTable.getItems().remove(selectedUser);
					
					if (selectedUserDel.getRole().toLowerCase().equals("apprentice")) {
						AppDao.deleteApprentice(selectedUserDel.getId());
					}
						UserDaoImpl.deleteUser(selectedUserDel.getUsername());
				
				}
			} else {
				// Kein Benutzer ausgew�hlt
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(mainApp.getPrimaryStage());
				alert.setTitle("Keine Auswahl");
				alert.setHeaderText("Kein Benutzer ausgew�hlt");
				alert.setContentText("Bitte w�hlen Sie einen Benutzer aus!");
				alert.showAndWait();
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Keine Auswahl");
			alert.setHeaderText("Kein Benutzer ausgew�hlt");
			alert.setContentText("Bitte w�hlen Sie einen Benutzer aus!");
			alert.showAndWait();
		}
	}

	@FXML
	private void backToInstructorView() {
		mainApp.loadScene("view/StartViewInstructor.fxml", "�bersicht");
	}

	public static void setMainApp(MainApp mainApp) {
		AdminViewInstructorController.mainApp = mainApp;

	}
}