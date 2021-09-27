package app.view.gui.tests;

import app.Vehicle;
import javafx.scene.control.ListCell;

public class ListViewCell extends ListCell<Vehicle> {
	
	@Override
	public void updateItem(Vehicle v, boolean empty) {
		super.updateItem(v, empty);
		if(v!=null) {
			MyData data = new MyData();
			data.setInfo(v.toString());
			setGraphic(data.getView());
		}
	}

}
