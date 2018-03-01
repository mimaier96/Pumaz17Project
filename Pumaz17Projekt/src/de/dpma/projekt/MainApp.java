package de.dpma.projekt;

import java.io.IOException;
import java.sql.Connection;

import de.dpma.projekt.db.DatabaseConnection;
import de.dpma.projekt.models.User;
import de.dpma.projekt.models.user.Instructor;
import de.dpma.projekt.models.util.JobList;
import de.dpma.projekt.models.util.RoleList;
import de.dpma.projekt.models.util.UserList;
import de.dpma.projekt.view.AdminViewAddAzubiController;
import de.dpma.projekt.view.AdminViewAddUserController;
import de.dpma.projekt.view.AdminViewInstructorController;
import de.dpma.projekt.view.LoginWindowController;
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

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		loadScene("view/AdminViewAddAzubi.fxml", "Anchor", "S");
		controllerUpdate();
	}

	public static void main(String[] args) {
		setTemporaryDataBase();
		Connection con = DatabaseConnection.getInstance();

		launch(args);
		
	}

	public void loadScene(String path, String paneType, String title) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(path));

			switch (paneType) {
			case "Anchor":
				scene = new Scene(new AnchorPane((AnchorPane) loader.load()));
				break;
			case "Border":
				scene = new Scene(new BorderPane((BorderPane) loader.load()));
				break;
			default:
				scene = new Scene(new AnchorPane((AnchorPane) loader.load()));
			}
			//
			// LoginWindowController controller = loader.getController();
			// controller.setMainApp(this);
			this.primaryStage.setTitle(title);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void controllerUpdate() {
		LoginWindowController.setMainApp(this);
		StartViewInstructorController.setMainApp(this);
		AdminViewAddUserController.setMainApp(this);
		AdminViewAddAzubiController.setMainApp(this);
	}

	public Stage getPrimaryStage() {

		return primaryStage;

	}
	
	
	
	
	
	
	public static void setTemporaryDataBase() {
		
		//Da der M�ll mit der DB grade net geht, brauchen wir ein paar Standard Daten zum Testen:D
		RoleList.addRole("Instructor");
		RoleList.addRole("Azubi");
		RoleList.addRole("Trainer");
		
		JobList.addJob("FA");
		JobList.addJob("Versager");
		Instructor u =new Instructor("Karl","Lars","LAL","LOOL","Ausbildungsleiter/in","LAL");
		UserList.addUser(u);
		Instructor k =new Instructor("Hanna","Sepp","LAL","LOOL","Ausbildungsleiter/in","LAL");
		UserList.addUser(k);
		
		
	}
	
}
