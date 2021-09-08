package app;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarSystem {
	
	List<Customer> customerList;
	List<Vehicle> vehicleList;
	
	public CarSystem() {
		this.customerList = new ArrayList<Customer>();
		this.vehicleList = new ArrayList<Vehicle>();
	}
	
	
	public void createCustomer (String name, String phoneNumber, String email) {
		customerList.add(new Customer(name,phoneNumber,email));
	}
	
	public void updateCustomer(String email, Customer customer) {
		for(Customer c:customerList) {
			if(c.getEmail().equals(email)) {
				c.setName(customer.getName());
				c.setPhoneNumber(customer.getPhoneNumber());
			}
		}
	}
	
	public Customer retreiveCustomer(String email) {
		for(Customer c: customerList) {
			if(c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}
	
	public void deleteCustomer(String email) {
		List<Customer> tempList = new ArrayList<>();
		for(Customer c: customerList) {
			if(!c.getEmail().equals(email)) {
				tempList.add(c);
			}
		}
		this.customerList = tempList;
		
	}
	
	public void addCustomer(Customer customer) {
		this.customerList.add(customer);
	}
	
	public void showCustomers() {
		for(Customer c: customerList) {
			System.out.println(c);
		}
		System.out.println();
	}
	
	

	
	public void createVehicle (double penaltyRate, String plateNumber, double rentingRate, Brand brand, Type type,
			Date dateOfProduction) {
		vehicleList.add(new Vehicle(penaltyRate,plateNumber,rentingRate,brand,type,dateOfProduction));
	}
	
	public void updateVehicle(String plateNumber, Vehicle vehicle) {
		for(Vehicle v:vehicleList) {
			if(v.getPlateNumber().equals(plateNumber)) {


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
		for(Vehicle v: vehicleList) {
			if(v.getPlateNumber().equals(plateNumber)) {
				return v;
			}
		}
		return null;
	}
	
	public void deleteVehicle(String plateNumber) {
		List<Vehicle> tempList = new ArrayList<>();
		for(Vehicle v: vehicleList) {
			if(!v.getPlateNumber().equals(plateNumber)) {
				tempList.add(v);
			}
		}
		this.vehicleList = tempList;
	}
	
	public void addVehicle(Vehicle v) {
		this.vehicleList.add(v);
	}
	
	public void showVehicles() {
		for(Vehicle v: vehicleList) {
			System.out.println(v);
		}
		System.out.println();
	}
}
