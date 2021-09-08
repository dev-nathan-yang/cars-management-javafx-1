package app;

public class Customer {
	private String name;
	private String phoneNumber;
	private final String email;
	public Customer(String name, String phoneNumber, String email) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
		
}
