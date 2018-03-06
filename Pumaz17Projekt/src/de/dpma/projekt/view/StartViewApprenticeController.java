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

public class StartViewApprenticeController {

	public static MainApp mainApp;

	@FXML
	private void menuItemLogout() {
		mainApp.loadBorder("view/MenuPart4.fxml", "title");
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

	// Construktor
	public StartViewApprenticeController() {
	}

	private void showApprenticeDetails(Apprentice apprentice) {
		if (apprentice != null) {
			
			/**
			 * TODO von Datenbank Getter setzen
			 * @author MaSpecter
			 */
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

	}

	/**
	 * Berichtsheft bearbeiten Button
	 * @author MaSpecter
	 */
	@FXML
	private void handleEditReportBook() {
		
		ReportBook selectedReportBook = /*TODO Datenbank*/.getSelectionModel().getSelectedItem();
        if (selectedReportBook != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showReportBookDetails(selectedReportBook);
            }

        } else {
            // Kein Berichtsheft ausgewählt
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Keine Auswahl");
            alert.setHeaderText("Kein Berichtsheft ausgewählt");
            alert.setContentText("Kein Berichtsheft ausgewählt!");

            alert.showAndWait();
        }
		
	}

	public static void setMainApp(MainApp mainApp) {
		StartViewApprenticeController.mainApp = mainApp;

	}

}