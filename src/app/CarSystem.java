package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarSystem {

	private List<Customer> customerList;
	private List<Vehicle> vehicleList;

	public CarSystem() {
		this.customerList = new ArrayList<Customer>();
		this.vehicleList = new ArrayList<Vehicle>();
	}

	public void createCustomer(String name, String phoneNumber, String email) {
		customerList.add(new Customer(name, phoneNumber, email));
	}

	public void updateCustomer(String email, Customer customer) {
		for (Customer c : customerList) {
			if (c.getEmail().equals(email)) {
				c.setName(customer.getName());
				c.setPhoneNumber(customer.getPhoneNumber());
			}
		}
	}

	public Customer retreiveCustomer(String email) {
		for (Customer c : customerList) {
			if (c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}

	public void deleteCustomer(String email) {
		List<Customer> tempList = new ArrayList<>();
		for (Customer c : customerList) {
			if (!c.getEmail().equals(email)) {
				tempList.add(c);
			}
		}
		this.customerList = tempList;

	}

	public void addCustomer(Customer customer) {
		this.customerList.add(customer);
	}

	public void showCustomers() {
		for (Customer c : customerList) {
			System.out.println(c);
		}
		System.out.println();
	}

	public void createVehicle(double penaltyRate, String plateNumber, double rentingRate, Brand brand, Type type,
			Date dateOfProduction) {
		vehicleList.add(new Vehicle(penaltyRate, plateNumber, rentingRate, brand, type, dateOfProduction));
	}

	public void updateVehicle(String plateNumber, Vehicle vehicle) {
		for (Vehicle v : vehicleList) {
			if (v.getPlateNumber().equals(plateNumber)) {
				v.setBrand(vehicle.getBrand());
				v.setDateOfProduction(vehicle.getDateOfProduction());
				v.setPenaltyRate(vehicle.getPenaltyRate());
				v.setPlateNumber(vehicle.getPlateNumber());
				v.setRecords(vehicle.getRecords());
				v.setRentingCustomer(v.getRentingCustomer());
				v.setRentingRate(vehicle.getRentingRate());
				v.setType(vehicle.getType());
			}
		}
	}

	public Vehicle retreiveVehicle(String plateNumber) {
		for (Vehicle v : vehicleList) {
			if (v.getPlateNumber().equals(plateNumber)) {
				return v;
			}
		}
		return null;
	}

	public void deleteVehicle(String plateNumber) {
		List<Vehicle> tempList = new ArrayList<>();
		for (Vehicle v : vehicleList) {
			if (!v.getPlateNumber().equals(plateNumber)) {
				tempList.add(v);
			}
		}
		this.vehicleList = tempList;
	}

	public void addVehicle(Vehicle v) {
		this.vehicleList.add(v);
	}

	public void showVehicles() {
		for (Vehicle v : vehicleList) {
			System.out.println(v);
		}
		System.out.println();
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

//	public void setCustomerList(List<Customer> customerList) {
//		this.customerList = customerList;
//	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public Customer getCustomerByIndex(int index) {
		return customerList.get(index);
	}

	public Vehicle getVehicleByIndex(int index) {
		return vehicleList.get(index);
	}

	public String getVehicleSelectionListString() {
		String info = "";
		for (Vehicle v : getVehicleList()) {
			if(!v.isAvailableForRenting()) continue;
			info += (getVehicleList().indexOf(v) + "Type: " + v.getType() + ", Brand: " + v.getBrand() + "Rent Rate:"
					+ v.getRentingRate() + "\n");
		}
		return info;
	}

	public String getCustomerSelectionListString() {
		String info = "";
		for (Customer v : customerList) {
			info += customerList.indexOf(v) + "Email: " + v.getEmail() + ", Name: " + v.getName() + "\n";
		}
		return info;
	}

	public void rentCar(String email, int vIndex, Date estimateDate) {
		Customer tempC = getCustomerByEmail(email);
		Vehicle pickedV = getVehicleByIndex(vIndex);
		pickedV.rentVehicle(tempC, estimateDate);
	}

	private Customer getCustomerByEmail(String email) {
		for(Customer c : customerList) {
			if(c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}

	public String getAllVehiclesInfo() {
		String info = "";
		for (Vehicle v : getVehicleList()) {
			info += ("IsAvailable=" + v.isAvailableForRenting() + " " + v.getCurrentCustomerInfo() + " PlateNumer "
					+ v.getPlateNumber() + " Type: " + v.getType() + ", Brand: " + v.getBrand() + "Rent Rate:"
					+ v.getRentingRate() + "\n");
		}
		return info;
	}

	public boolean ifEmailExists(String email) {
		for(Customer c: customerList) {
			if(c.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Vehicle> getRentingVehicleBListEmail(String email){
		ArrayList<Vehicle> rentingVehicles = new ArrayList<>();
		for(Vehicle v: vehicleList) {
			if(v.isAvailableForRenting()) continue;  // for not renting customer, skip it
			if(v.getRentingCustomer().getEmail().equals(email)) {
				rentingVehicles.add(v);
			}
		}
		return rentingVehicles;
	}
	
	public String getRentingVehicleStringByCustomerEmail(String email) {
		String info = "";
		for(Vehicle v: getRentingVehicleBListEmail(email)) {
			info += ""+ getRentingVehicleBListEmail(email).indexOf(v)+ " "+ v.getPlateNumber()+ " "+ v.getType()+"\n";
		}
		return info;
	}
	
	public void returnCar(String email, int index) {
		getRentingVehicleBListEmail(email).get(index).returnVehicle();
	}

//	public void setVehicleList(List<Vehicle> vehicleList) {
//		this.vehicleList = vehicleList;
//	}

}
