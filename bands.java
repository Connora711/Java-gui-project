//Purpose: A GUI for a band sign up


package application;
import javafx.application.Application;    
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class bands extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Band sign up");//Sets the title of the program
		
		// Create a scene and set it in the stage
        // This determines how the GUI will look
		pane gridPane = new pane();// Pulls the things from the pane class
		Scene scene = new Scene(gridPane, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.show();// Makes the GUI visible
	}
}
