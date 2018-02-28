package de.dpma.projekt.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class AdminViewAddUserController {

	ObservableList<String> chooseRoleList = FXCollections.observableArrayList("Auszubildender", "Ausbilder",
			"Ausbildungsleiter", "Administrator");

	@FXML
	private ChoiceBox<String> chooseRole;

	@FXML
	private void initialize() {
		chooseRole.setValue("Bitte wählen ...");
	}

	@FXML
	private void dateiWaehlenButton() {

	}

}
