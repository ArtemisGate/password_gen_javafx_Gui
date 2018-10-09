package passGenerator;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI_JavaFx extends Application 
{
	private TextField pass_len = new TextField();
	private TextField password = new TextField();
	private Button gen = new Button("Generate Password");

	public static void main(String[] args) 
	{
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create UI
		GridPane container = new GridPane();
		
		// Set horizontal and vertical gap
		container.setHgap(3);
		container.setVgap(3);
		
		// Add components to pane
		container.add(new Label("Enter Length of Password"), 0, 0);
		container.add(pass_len, 1, 0);
		container.add(new Label("Password:"),0 , 1);
		container.add(password, 1, 1);
		container.add(gen, 1, 2);
		
		//Set UI properties
		container.setAlignment(Pos.CENTER);
		pass_len.setAlignment(Pos.BOTTOM_RIGHT);
		password.setAlignment(Pos.BOTTOM_RIGHT);
		password.setEditable(true);
		GridPane.setHalignment(gen, HPos.RIGHT);
		
		
		gen.setOnAction(e ->{
			password.setText(PasswordGenerator.main(pass_len.getText()));
		});
		
		Scene scene = new Scene(container, 300,400);
		primaryStage.setTitle("Password Generator");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
		
	}

}
