package de.dpma.projekt;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		loadScene("view/LoginWindow.fxml","Anchor");
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void loadScene(String path, String paneType) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(path));
			Scene scene;

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

			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
