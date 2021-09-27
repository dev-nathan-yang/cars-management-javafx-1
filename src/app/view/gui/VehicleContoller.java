package app.view.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Set;

import app.Brand;
import app.CarSystem;
import app.Customer;
import app.Type;
import app.Vehicle;

public class VehicleContoller implements Initializable
{
	
	ObservableList list = FXCollections.observableArrayList();
	@FXML
	private ListView<Vehicle> vehicle_list;
	@FXML
	private Button search_vehicle_button;
	@FXML
	private TextField plateNumber_textField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarSystem carSys = this.loadVehicleData();
		search_vehicle_button.addEventHandler(MouseEvent.MOUSE_PRESSED, e->{
			String plateNumber = plateNumber_textField.getText();
			System.out.println(plateNumber);
			Vehicle target = carSys.retreiveVehicle(plateNumber);
			list.removeAll(list);
			list.addAll(target);
			vehicle_list.getItems().clear();
			vehicle_list.getItems().addAll(list);
		});
	}
	
	private CarSystem loadVehicleData() {
		CarSystem carSys = new CarSystem();
		Customer c1 = new Customer("ALex", "1554897", "dfdf@gaa.com");
		Customer c2 = new Customer("Bbob", "123213123", "bob@bob.com");
		Customer c3 = new Customer("Cindy", "323213213", "cindy@qq.com");
		Customer c4 = new Customer("doggy", "4123123", "doggy@qqc.com");
		
		Vehicle v1 = new Vehicle (100, "XD1", 101, Brand.Audi, Type.SUV, new Date());
		Vehicle v2 = new Vehicle (200, "XD2", 201, Brand.Benz, Type.Van, new Date());
		Vehicle v3 = new Vehicle (300, "XD3", 301, Brand.Lambogini, Type.Van, new Date());
		Vehicle v4 = new Vehicle (400, "XD4", 401, Brand.Audi, Type.Sedan, new Date());
		
		carSys.addVehicle(v1);
		carSys.addVehicle(v2);
		carSys.addVehicle(v3);
		carSys.addVehicle(v4);

		carSys.addCustomer(c1);
		carSys.addCustomer(c2);
		carSys.addCustomer(c3);
		carSys.addCustomer(c4);
		
		
		list.removeAll(list);
		list.addAll(v1,v2,v3,v4);
		vehicle_list.getItems().addAll(list);
		return carSys;
	}
	
	
	
}