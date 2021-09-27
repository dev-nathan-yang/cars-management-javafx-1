package app.view.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Stage stage = new Stage();
		  //Creating a Text object 
	      Text text = new Text();      
	      
	      //Setting the text to be added. 
	      text.setText("Hello how are you"); 
	       
	      //setting the position of the text 
	      text.setX(50); 
	      text.setY(50); 
	         
	      //Creating a Group object  
	      Group root = new Group(text);   
	               
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 300);  
	      
	      //Setting title to the Stage 
	      stage.setTitle("Sample Application"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene); 
	         
	      //Displaying the contents of the stage 
	      stage.show();
		
		Text txt2 = new Text("This is Text");
		Group p = new Group(txt2);
		
		Scene scene2 = new Scene(p, 80, 60);
		Scene scene1 = new Scene(new Button("click me!"));
		primaryStage.setScene(scene2);
	
		primaryStage.show();

		Stage newStage = new Stage();
		newStage.setScene(scene1);
		newStage.show();

	}

	public static void main(String[] jiba) {
		launch(jiba);
	}

}
