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
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

public class BorderLayout {

	public static MainApp mainApp;

	@FXML
	private MenuBar menubar;

	@FXML
	private Menu menu;
	@FXML
	private Menu viewJobs;
	@FXML
	private Menu viewRoles;
	@FXML
	private Menu options;
	@FXML
	private Menu help;

	@FXML
	private void initialize() {
		hidePartsBut(help);
	}


	public static void setMainApp(MainApp mainApp) {
		LoginWindowController.mainApp = mainApp;

	}

	public void hidePartsBut(Menu... men) {

		menubar.getMenus().clear();
		for (Menu m : men) {
			menubar.getMenus().addAll(m);
		}

	}

	
}
