package app.view.gui.tests;

import java.io.IOException;

import app.Vehicle;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class ListViewCell extends ListCell<Vehicle> {
	
//	public ListViewCell(){
//		
//	}
	@Override
	public void updateItem(Vehicle v, boolean empty) {
		super.updateItem(v, empty);
		if (v != null) {
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/app/view/gui/tests/list_cell_view.fxml"));
			try {
				setGraphic(fxmlloader.load());
				MyData data = fxmlloader.getController();
				data.setInfo(v.toString());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
