package de.dpma.projekt.view;

import de.dpma.projekt.models.ReportBook;
import de.dpma.projekt.models.User;
//import de.dpma.projekt.models.user.Apprentice;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class StartViewApprenticeController {

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

	// Konstruktor
	public StartViewApprenticeController() {
	}

	private void showApprenticeDetails(User apprentice) {
		if (apprentice != null) {
			
			/**
			 * TODO von Datenbank Getter setzen
			 * @author MaSpecter
			 */
			nameLabel.;
			birthdayLabel.;
			adressLabel.;
			beginOfEmployment.;
			endOfEmployment.;
			deploymentLocation.;
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

}