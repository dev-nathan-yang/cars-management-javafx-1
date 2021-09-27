package app.view.gui.tests;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import app.Brand;
import app.CarSystem;
import app.Customer;
import app.Type;
import app.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class ListViewController implements Initializable {
	@FXML
	private ListView<Vehicle> vehicle_list;
	@FXML
	private Button search_vehicle_button;
	@FXML
	private TextField plateNumber_textField;

	
	CarSystem carSys = new CarSystem();
	ObservableList list = FXCollections.observableArrayList();
	
	




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		vehicle_list.setCellFactory(new Callback<ListView<Vehicle>, ListCell<Vehicle>>(){

			@Override
			public ListCell<Vehicle> call(ListView<Vehicle> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
		
		
		// initializatio data start
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
		// initializaiton data end
		
		
		
		
		
		
		search_vehicle_button.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
			String plateNumber = plateNumber_textField.getText();
			System.out.println(plateNumber);
			Vehicle target = carSys.retreiveVehicle(plateNumber);
			list.removeAll(list);
			list.addAll(target);
			vehicle_list.getItems().clear();
			vehicle_list.getItems().addAll(list);
		});
	}

//	private CarSystem loadVehicleData() {
//		CarSystem carSys = new CarSystem();
//		Customer c1 = new Customer("ALex", "1554897", "dfdf@gaa.com");
//		Customer c2 = new Customer("Bbob", "123213123", "bob@bob.com");
//		Customer c3 = new Customer("Cindy", "323213213", "cindy@qq.com");
//		Customer c4 = new Customer("doggy", "4123123", "doggy@qqc.com");
//		
//		Vehicle v1 = new Vehicle (100, "XD1", 101, Brand.Audi, Type.SUV, new Date());
//		Vehicle v2 = new Vehicle (200, "XD2", 201, Brand.Benz, Type.Van, new Date());
//		Vehicle v3 = new Vehicle (300, "XD3", 301, Brand.Lambogini, Type.Van, new Date());
//		Vehicle v4 = new Vehicle (400, "XD4", 401, Brand.Audi, Type.Sedan, new Date());
//		
//		carSys.addVehicle(v1);
//		carSys.addVehicle(v2);
//		carSys.addVehicle(v3);
//		carSys.addVehicle(v4);
//
//		carSys.addCustomer(c1);
//		carSys.addCustomer(c2);
//		carSys.addCustomer(c3);
//		carSys.addCustomer(c4);
//		
//		
//		list.removeAll(list);
//		list.addAll(v1,v2,v3,v4);
//		vehicle_list.getItems().addAll(list);
//		return carSys;
//	}
	
}
