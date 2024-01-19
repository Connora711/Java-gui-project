//Program : bandhw  
//Name: Nicholas Adams
//Date: 9/5/23
//Purpose: A GUI for a band sign up


package application;
import javafx.scene.control.Button;  
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class pane extends GridPane  {
	// Global variables
	// Exact same thing as local variables expect I can use them in different methods
	private TextField nameInput;
	private TextField linkInput;
	private TextField contactNameInput;
	private TextField contactPhoneInput;
	private ToggleGroup radioGroup;
	private CheckBox tuesday;
	private CheckBox friday;
	private CheckBox saturday;
	
	
	public pane() {
		//DECLARTATIONS 
		// Create UI components
		Label nameLabel = new Label("Name of Band: ");// Creates a Label for the text field
		nameInput = new TextField(); // allows for user input  
		
		Label linkLable = new Label("Band website or Facebook page: ");
		linkInput = new TextField();
		
		Label checkBoxLabel = new Label("Days of the week you are typically available for playing (check all that apply):");
		
		Label contactNameLabel = new Label("Contact Name: ");
		contactNameInput = new TextField();
		
		Label contactPhoneLabel = new Label("Contact Phone: ");
		contactPhoneInput = new TextField();
		
		// Groups
		radioGroup = new ToggleGroup();// Makes a group for the radio buttons so you only pick one
		
		// Create radio buttons
		RadioButton sample1Radio = new RadioButton("Sample 1");
        sample1Radio.setToggleGroup(radioGroup);
		RadioButton sample2Radio = new RadioButton("Sample 2");
        sample2Radio.setToggleGroup(radioGroup);
        
        // Create check boxes
        tuesday = new CheckBox("Tuesday");
        friday = new CheckBox("Friday");
        saturday = new CheckBox("Saturday");
        
        // Buttons
        Button submitButton = new Button("Submit Audition");
        Button clearButton = new Button("Clear Form");
        Button exitButton = new Button("Exit");
        
        // Add event handlers to the buttons, makes them do things
        exitButton.setOnAction(e -> Platform.exit());
        clearButton.setOnAction(e -> clearForm());
        
        // Create an Vbox for the radio buttons
 		VBox radioBox = new VBox(10);
 		radioBox.getChildren().addAll(new Label("Sample sound clips of songs:"), sample1Radio, sample2Radio);
 		
 		// Create HBox for the buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(submitButton, clearButton, exitButton);
        
		// Customize the variables
		add(nameLabel, 0, 0);
		add(nameInput, 1, 0);
		add(linkLable, 0, 1);
		add(linkInput, 1, 1);
		add(checkBoxLabel, 0, 3);
		add(tuesday, 0, 4);
		add(friday, 0, 5);
		add(saturday, 0, 6);
		add(contactNameLabel, 0, 7);
		add(contactNameInput, 1, 7);
		add(contactPhoneLabel, 0, 8);
		add(contactPhoneInput, 1, 8);
		add(radioBox, 0, 2, 2, 1);
		add(buttonBox, 0, 9, 2, 1);
		
		// Event handler for the submit button
		submitButton.setOnAction(e -> {
			// Variables that hold the user input from the global variables 
			String name = nameInput.getText();
			String link = linkInput.getText();
			String contactName = contactNameInput.getText();
			String contactPhone = contactPhoneInput.getText();
			
			// Check if the contactPhone is more then 10 digits
			if(contactPhone.length() != 10) {
				// Makes an alert dialog for the error
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setTitle("Input Error");
				errorAlert.setHeaderText(null);
				errorAlert.setContentText("Phone number cant be longer or shorter then 10 digits, please try again");
				// Show the error
				errorAlert.showAndWait();
				return;// Stops processing the form
			}
			// Checks if the input fields are longer then 20 chars
			if(contactName.length() > 20 || name.length() > 20 || link.length() > 20 ) {
				// Makes an alert dialog for the error
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setTitle("Input Error");
				errorAlert.setHeaderText(null);
				errorAlert.setContentText("Input cant be longer then 20 characters, try again");
				// Show the error
				errorAlert.showAndWait();
				return;// Stops processing the form
			}
			
			// Display the messages
			StringBuilder message = new StringBuilder();
			message.append("Name of Band: ").append(name).append("\n");
			message.append("Website/FB page: ").append(link).append("\n");
			message.append("Contact Information: " + contactName + " at " + contactPhone);
			
			// Get the selected radio buttons
			RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
			if(selectedRadioButton != null) {
				message.append("\nSound clips were successfully uploaded: ").append(selectedRadioButton.getText());
			}
			
			// Get the selected check boxes
			message.append("\n"+ name + " are(is) available to play on: ");
			if(tuesday.isSelected()) {
				message.append("\n--Tuesday");
			}
			if(friday.isSelected()) {
				message.append("\n--Friday");
			}
			if(saturday.isSelected()) {
				message.append("\n--Saturday");
			}
			
			// Create an alert dialog box to display the message
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Audition Information");
			alert.setHeaderText(null);
			alert.setContentText(message.toString());
			
			// Show the dialog 
			alert.showAndWait();
		});
	}
	
	public void clearForm() {
		// Clear text fields
		nameInput.clear();
		linkInput.clear();
		contactNameInput.clear();
		contactPhoneInput.clear();
		
		// Clear radio buttons
		radioGroup.selectToggle(null);
		
		// Clear check boxes
		tuesday.setSelected(false);
		friday.setSelected(false);
		saturday.setSelected(false);
	}
}
