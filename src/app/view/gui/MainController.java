package app.view.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainController implements Initializable{
	
	@FXML
	private Button vehiclesViewButton;
	@FXML
	private Button customersViewButton;
	@FXML
	private Button rentalViewButton;
	@FXML
	private VBox mainContainer;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("mainController initialize");
		
		vehiclesViewButton.addEventHandler(MouseEvent.MOUSE_PRESSED,e->{
			try {
				Parent p = FXMLLoader.load(getClass().getResource("/app/view/gui/tests/vehicle_view.fxml"));
				mainContainer.getChildren().clear();
				mainContainer.getChildren().add(p);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		customersViewButton.addEventHandler(MouseEvent.MOUSE_PRESSED, e->{
			try {
				Parent p = FXMLLoader.load(getClass().getResource("/app/view/gui/customer_view.fxml"));
				mainContainer.getChildren().clear();
				mainContainer.getChildren().add(p);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		rentalViewButton.addEventHandler(MouseEvent.MOUSE_PRESSED, e->{
			try {
				Parent p = FXMLLoader.load(getClass().getResource("/app/view/gui/rental_view.fxml"));
				mainContainer.getChildren().clear();
				mainContainer.getChildren().add(p);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
}
