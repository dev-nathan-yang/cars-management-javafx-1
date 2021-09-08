package model;

public class Vehicle {
	
	private String plateNumber;
	private double rentingRate;
	private double penaltyRate;
	
	private Customer currentCustomer;
	
	public boolean isAvailable() {
		return this.currentCustomer == null;
	}
	
	public void rentThis() {
		if(this.isAvailable()) {
			
		return;
		}
		
		return;
		
	}
	
	public void returnThis() {
		
	}
	
	private void setCurrentCustomer(Customer current) {
		this.currentCustomer = current;
	}

}
