package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import app.Brand;
import app.CarSystem;
import app.Customer;
import app.Type;
import app.Vehicle;

class SystemTest {

	@Test
	void test() {
		CarSystem carSys = new CarSystem();
		Customer c1 = new Customer("ALex", "1554897", "dfdf@gaa.com");
		Customer c2 = new Customer("Bbob", "123213123", "bob@bob.com");
		Customer c3 = new Customer("Cindy", "323213213", "cindy@qq.com");
		Customer c4 = new Customer("doggy", "4123123", "doggy@qqc.com");
		carSys.addCustomer(c1);
		carSys.addCustomer(c2);
		carSys.addCustomer(c3);
		carSys.addCustomer(c4);
		carSys.showCustomers();
		System.out.println("after delete");
		carSys.deleteCustomer("cindy@qq.com");
		carSys.showCustomers();
		System.out.println("after delete");
		carSys.deleteCustomer("bob@bob.com");
		carSys.showCustomers();
		System.out.println("after update");
		carSys.updateCustomer("doggy@qqc.com", c1);
		carSys.showCustomers();
	}
	
	@Test
	void test2() {
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
		
		carSys.showVehicles();
		
		System.out.println("after delete");
		carSys.deleteVehicle("XD3");
		carSys.showVehicles();
		
		System.out.println("after update");
		carSys.updateVehicle("XD1", v4);
		carSys.showVehicles();
		
		System.out.println("after delete xd4");
		carSys.deleteVehicle("XD4");
		carSys.showVehicles();
	}
}
