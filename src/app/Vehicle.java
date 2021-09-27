package app;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehicle {
	private double penaltyRate;
	private String plateNumber;
	private double rentingRate;//
	private Brand brand;//
	private Type type;//
	private Date dateOfProduction;
	private Customer rentingCustomer;
	private List<RentalRecord> records;

	public Vehicle(double penaltyRate, String plateNumber, double rentingRate, Brand brand, Type type,
			Date dateOfProduction) {
		this.penaltyRate = penaltyRate;
		this.plateNumber = plateNumber;
		this.rentingRate = rentingRate;
		this.brand = brand;
		this.type = type;
		this.dateOfProduction = dateOfProduction;

		this.records = new ArrayList<>();
	}

	public boolean isAvailableForRenting() {
		return this.rentingCustomer == null;
	}

	public void rentVehicle(Customer newCustomer, Date expectedDate) {
		this.rentingCustomer = newCustomer;
		this.records.add(new RentalRecord(newCustomer, new Date(), expectedDate));
	}

	public void returnVehicle() {
		this.records.get(this.records.size() - 1).setActualReturnDate();
		this.setAvailableForRenting();
	}

	private void setAvailableForRenting() {
		this.rentingCustomer = null;
	}

	public double calculateRentalFee(Date startDate, Date returnDate) {
		return this.rentingRate * DataHelper.getDifferenceDays(startDate, returnDate);
	}

	public double calculatePenaltyFee(Date expected, Date actualDate) {
		return this.penaltyRate * DataHelper.getDifferenceDays(expected, actualDate);
	}

	public double getPenaltyRate() {
		return penaltyRate;
	}

	public void setPenaltyRate(double penaltyRate) {
		this.penaltyRate = penaltyRate;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public double getRentingRate() {
		return rentingRate;
	}

	public void setRentingRate(double rentingRate) {
		this.rentingRate = rentingRate;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrandByIdx(int brandIndex) {
		this.brand = Brand.values()[brandIndex];
	}
	
	public void setBrand(Brand brand) {
		this.brand =brand;
	}


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setTypeByIdx(int typeIndex) {
		this.type = Type.values()[typeIndex];
	}

	public Date getDateOfProduction() {
		return dateOfProduction;
	}

	public void setDateOfProduction(Date dateOfProduction) {
		this.dateOfProduction = dateOfProduction;
	}

	public Customer getRentingCustomer() {
		return rentingCustomer;
	}

	public void setRentingCustomer(Customer rentingCustomer) {
		this.rentingCustomer = rentingCustomer;
	}

	public List<RentalRecord> getRecords() {
		return records;
	}

	public void setRecords(List<RentalRecord> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "Vehicle [penaltyRate=" + penaltyRate + ", plateNumber=" + plateNumber + ", rentingRate=" + rentingRate
				+ ", brand=" + brand + ", type=" + type + ", dateOfProduction=" + dateOfProduction
				+ ", rentingCustomer=" + rentingCustomer + ", records=" + records + "]";
	}

	public String getCurrentCustomerInfo() {

		return isAvailableForRenting() ? "\t" : rentingCustomer.getName();
	}

	public String[][] getFields() {
		Class<? extends Vehicle> c = this.getClass();
		Field[] fields = c.getDeclaredFields();	
		String[][] temp = new String[fields.length][2];
		for (int i = 0; i < fields.length; i++) {
			String[] fieldsInfo = fields[i].toString().split(" ");
	
			String[] dataTypeArr = fieldsInfo[1].split("\\.");
			String[] fieldNameArr = fieldsInfo[2].split("\\.");
			temp[i][0] = dataTypeArr[dataTypeArr.length - 1];
			temp[i][1] = fieldNameArr[fieldNameArr.length - 1];
			}
		return temp;
	}

}
