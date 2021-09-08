package app;
import java.util.Date;

public class RentalRecord implements Comparable<RentalRecord> {
	
	private Customer customer;
	private Date startDate;
	private Date expectedReturnDate;
	private Date actualReturnDate;
	private double rentalFee;
	private double penaltyFee;
	
	

	public RentalRecord(Customer customer, Date startDate, Date expectedReturnDate) {
		this.customer = customer;
		this.startDate = startDate;
		this.expectedReturnDate = expectedReturnDate;
	}



	public void setActualReturnDate() {
		this.actualReturnDate = new Date();
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}



	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}



	public Date getActualReturnDate() {
		return actualReturnDate;
	}



	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}



	public double getRentalFee() {
		return rentalFee;
	}



	public void setRentalFee(double rentalFee) {
		this.rentalFee = rentalFee;
	}



	public double getPenaltyFee() {
		return penaltyFee;
	}



	public void setPenaltyFee(double penaltyFee) {
		this.penaltyFee = penaltyFee;
	}

	@Override
	public int compareTo(RentalRecord o) {
		if(this.startDate.before(o.getStartDate())) return -1;
		if(this.startDate.after(o.getStartDate())) return 1;
		return 0;
	}
	
}
