package de.dpma.projekt.view;

import de.dpma.projekt.MainApp;
import de.dpma.projekt.models.ReportBook;
import de.dpma.projekt.models.User;
import de.dpma.projekt.models.user.Apprentice;
import de.dpma.projekt.utils4Code.DateUtil;
//import de.dpma.projekt.models.user.Apprentice;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;

public class StartViewApprenticeController {

	public static MainApp mainApp;
	
	/**
	 * @param reportBookApproved
	 *            case 1 das Berichtsheft ist noch nicht vervollst�ndigt case 2 das
	 *            Berichtsheft wurde vom Instructor genehmigt case 3 Das
	 *            Berichtsheft wurde vom Instructor zur�ckgewiesen
	 * 
	 * @author MaSpecter
	 */
	public int reportBookApproved = 1;
	
	//F�r nameTag
	private static String firstName;
	private static String lastName;

	@FXML
	private void menuItemLogout() {
		mainApp.loadBorder("view/MenuPart2.fxml", "title");;
		mainApp.loadScene("view/LoginWindow.fxml", "Anmeldung");
	}

	@FXML
	private Label nameLabel;
	@FXML
	private Label birthdayLabel;
	@FXML
	private Label adressLabel;
	@FXML
	private Label beginOfEmployment;
	@FXML
	private Label endOfEmployment;
	@FXML
	private Label deploymentLocation;
	@FXML
	private Label nameTag;
	
	//Tabellen Ansicht Berichtshefte
	@FXML
	private TableView<ReportBook> reportBookTable;
	@FXML
	private TableColumn<ReportBook, Image> statusColumn;
	@FXML
	private TableColumn<ReportBook, Integer> numberColumn;
	@FXML
	private TableColumn<ReportBook, String> weekColumn;
	@FXML
	private TableColumn<ReportBook, String> departmentColumn;
	@FXML
	private TableColumn<ReportBook, String> kindOfReportColumn;
	@FXML
	private TableColumn<ReportBook, String> noteColumn;

	// Constructor
	public StartViewApprenticeController() {
	}

	private void showApprenticeDetails(Apprentice apprentice) {
		if (apprentice != null) {
			

			nameLabel.setText(apprentice.getFirstname() + " " + apprentice.getLastname());
			birthdayLabel.setText(DateUtil.format(apprentice.getApprenticeBirthday()));
			adressLabel.setText(apprentice.getAdressStreetApprentice() + " " + apprentice.getAdressHouseNumberApprentice() + "\n" + apprentice.getAdressPostalCode() + apprentice.getAdressCity());
			beginOfEmployment.setText(DateUtil.format(apprentice.getBeginOfApprenticeship()));
			endOfEmployment.setText(DateUtil.format(apprentice.getEndOfApprenticeship()));
			deploymentLocation.setText(apprentice.getLocationOfDeployment());
		}
	}

	@FXML
	private void handleCreateReportBook() {
		mainApp.loadBorder("view/MenuPart2.fxml", "title");
		mainApp.loadScene("view/ReportBookWeekly.fxml", "Neues Berichtsheft");

	}
	
	private void setStatusColumn(ReportBook reportBook) {
//		if(reportBook.getReportBookApproved()) {
//			
//		}
	}
	
	

	/**
	 * Berichtsheft bearbeiten Button
	 * @author MaSpecter
	 */
//	@FXML
//	private void handleEditReportBook() {
//		
//		ReportBook selectedReportBook = /*TODO Datenbank*/.getSelectionModel().getSelectedItem();
//        if (selectedReportBook != null) {
//            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
//            if (okClicked) {
//                showReportBookDetails(selectedReportBook);
//            }
//
//        } else {
//            // Kein Berichtsheft ausgew�hlt
//            Alert alert = new Alert(AlertType.WARNING);
//            alert.setTitle("Keine Auswahl");
//            alert.setHeaderText("Kein Berichtsheft ausgew�hlt");
//            alert.setContentText("Kein Berichtsheft ausgew�hlt!");
//
//            alert.showAndWait();
//        }
//		
//	}
	
	@FXML
	private void initialize() {
		//setzt das NameTag
		nameTag.setText(firstName + " " + lastName);
		//setzt die Werte f�r die Berichtsheft Tabelle
		
		/**
		 * TODO Daniel fragen
		 */
		
//		statusColumn.setCellValueFactory(cellData -> cellData.getValue());
//		numberColumn.setCellValueFactory(cellData -> cellData.getValue().getNumber());
//		weekColumn.setCellValueFactory(cellData -> cellData.getValue().getDateA() + cellData.getValue().getDateE());
//		departmentColumn.setCellValueFactory(cellData -> cellData.getValue().getDepartment());
		
		
	}
	
	//setzt das nameTag
		public static void setNameTag(String userFirstName, String userLastName) {
			firstName = userFirstName;
			lastName = userLastName;	
		}

	public static void setMainApp(MainApp mainApp) {
		StartViewApprenticeController.mainApp = mainApp;

	}

}