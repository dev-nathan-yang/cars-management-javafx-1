package app.view.gui.tests;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MyData implements Initializable{

	@FXML
	Button car_delete_btn;
	@FXML
	Button car_edit_btn;
	@FXML
	Text car_description_txt;
	@FXML
	HBox cellView;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void setInfo(String str) {
		car_description_txt.setText(str);
	}
	
	public HBox getView() {
		return this.cellView;
	}

}
