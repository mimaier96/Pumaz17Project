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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private Scene scene;
	public BorderPane borderLayout = new BorderPane();
	public Instructor i= new Instructor(1,"awd", "adwda", "adwd", "adada", "dawdawd", "adawd");
	
	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
//		initBorderLayout();
		loadBorder("view/MenuPart2.fxml", "title");
		loadScene("view/LoginWindow.fxml", "Login");

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
	
	public boolean showUserAddDialog() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AdminViewAddUser.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Benutzer hinzufügen");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

             
            AdminViewAddUserController addUserController = loader.getController();
            addUserController.setDialogStage(dialogStage);
            addUserController.addUserData();

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	
	public boolean showUserEditDialog(User user) {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AdminViewAddUser.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Benutzer bearbeiten");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

             
            AdminViewAddUserController addUserController = loader.getController();
            addUserController.setDialogStage(dialogStage);
            addUserController.setUserData(user);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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

		// Da der Müll mit der DB grade net geht, brauchen wir ein paar Standard Daten
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
