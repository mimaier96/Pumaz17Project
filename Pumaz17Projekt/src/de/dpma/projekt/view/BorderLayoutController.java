package de.dpma.projekt.view;

import java.util.ArrayList;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class BorderLayoutController extends BorderPane {

	public static MainApp mainApp;

	@FXML
	private BorderPane borderpane;

	@FXML
	private MenuBar menubar;

	@FXML
	public Menu menu;
	@FXML
	public Menu viewJobs;
	@FXML
	public Menu viewRoles;
	@FXML
	public Menu options;
	@FXML
	public Menu help;
	
	FXMLLoader fxmlLoader;

	@FXML
	private void initialize() {
//		menu.setVisible(false);
		// mainApp.borderLayout.getTop().;
	}

	public static void setMainApp(MainApp mainApp) {
		BorderLayoutController.mainApp = mainApp;

	}

	public BorderLayoutController() {
		fxmlLoader = new FXMLLoader(getClass().getResource("BorderLayout.fxml"));
	}
	
	public BorderPane getBorderPane() throws IOException {
		return (BorderPane) fxmlLoader.load();
	}

	@FXML
	private void logout() {
		menu.setVisible(false);
		mainApp.loadScene("view/LoginWindow.fxml", "Login");
		
	}

	@FXML
	public void test() {
		System.out.println("ddd");
		menu.setVisible(false);

	}

	public MenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(MenuBar menubar) {
		this.menubar = menubar;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Menu getViewJobs() {
		return viewJobs;
	}

	public void setViewJobs(Menu viewJobs) {
		this.viewJobs = viewJobs;
	}

	public Menu getViewRoles() {
		return viewRoles;
	}

	public void setViewRoles(Menu viewRoles) {
		this.viewRoles = viewRoles;
	}

	public Menu getOptions() {
		return options;
	}

	public void setOptions(Menu options) {
		this.options = options;
	}

	public Menu getHelp() {
		return help;
	}

	public void setHelp(Menu help) {
		this.help = help;
	}

}
