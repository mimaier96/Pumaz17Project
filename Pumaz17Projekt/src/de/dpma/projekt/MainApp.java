package de.dpma.projekt;

import java.io.IOException;
import java.sql.Connection;

import de.dpma.projekt.db.DatabaseConnection;
import de.dpma.projekt.models.User;
import de.dpma.projekt.models.user.Instructor;
import de.dpma.projekt.models.util.JobList;
import de.dpma.projekt.models.util.RoleList;
import de.dpma.projekt.models.util.UserList;
import de.dpma.projekt.view.AdminViewAddUserController;
import de.dpma.projekt.view.AdminViewAddUserController;
import de.dpma.projekt.view.AdminViewInstructorController;
import de.dpma.projekt.view.BorderLayoutController;
import de.dpma.projekt.view.ChangePasswordController;
import de.dpma.projekt.view.LoginWindowController;
import de.dpma.projekt.view.StartViewApprenticeController;
import de.dpma.projekt.view.StartViewInstructorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private Scene scene;
	private BorderPane borderLayout;
	
	
	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
//		initBorderLayout();
		loadBorder("view/MenuFull.fxml", "title");
		loadScene("view/LoginWindow.fxml", "Login");

		loadBorder("view/MenuPart4.fxml", "title");
		controllerUpdate();
		
	}

	public static void main(String[] args) {
		setTemporaryDataBase();
		Connection con = DatabaseConnection.getInstance();

		launch(args);

	}

//	public void initBorderLayout() {
//		try {
////			FXMLLoader loader = new FXMLLoader();
////			loader.setLocation(MainApp.class.getResource("view/MenuFull.fxml"));
////			borderLayout = (BorderPane) loader.load();
//			borderLayout = new BorderPane();
//			scene = new Scene(borderLayout);
//			this.primaryStage.setTitle("Login");
//			this.primaryStage.setScene(scene);
//			this.primaryStage.show();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public void loadScene(String path, String title) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(path));

				AnchorPane anchor = (AnchorPane) loader.load();
				System.out.println("dddd");
			
//			this.primaryStage.setTitle(title);
			this.borderLayout.setCenter(anchor);
//			this.primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void loadBorder(String path, String title) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(path));

				borderLayout = (BorderPane) loader.load();
				
			
//			this.primaryStage.setTitle(title);

				scene = new Scene(borderLayout);
				this.primaryStage.setScene(scene);
//			this.borderLayout.setTop(anchor);
			this.primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void controllerUpdate() {
		LoginWindowController.setMainApp(this);
		StartViewInstructorController.setMainApp(this);
		StartViewApprenticeController.setMainApp(this);
		AdminViewAddUserController.setMainApp(this);
		AdminViewAddUserController.setMainApp(this);
		BorderLayoutController.setMainApp(this);
		ChangePasswordController.setMainApp(this);
		AdminViewInstructorController.setMainApp(this);
	}

	public Stage getPrimaryStage() {

		return primaryStage;

	}
	

	public static void setTemporaryDataBase() {

		// Da der M�ll mit der DB grade net geht, brauchen wir ein paar Standard Daten
		// zum Testen:D
		// RoleList.addRole("Instructor");
		// RoleList.addRole("Azubi");
		// RoleList.addRole("Trainer");
		//
		// JobList.addJob("FA");
		// JobList.addJob("Versager");
		// Instructor u =new Instructor("Karl","Lars","LAL","LOOL","Instructor","LAL");
		// UserList.addUser(u);
		// Instructor k =new Instructor("Hanna","Sepp","LAL","LOOL","Instructor","LAL");
		// UserList.addUser(k);

	}

}
