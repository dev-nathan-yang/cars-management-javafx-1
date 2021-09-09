package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

import app.CarSystem;

public class ConsoleController {

	CarSystem carSys;

	public ConsoleController() {
		carSys = new CarSystem();
	}

	public void rentVehicle() {
//		String email = getInput("please enter user's email:");
//		Customer tempCustomer = retreiveCustomer(email);
//		if(tempCustomer == null) {
//			System.out.println("user does not exist");
//			String answerToCreate = getInput("u wish to create a new user? Y:N :");
//			if(answerToCreate.equals("Y")) {
//				String name = getInput("please enter user's name:");
//				String phoneNumber = getInput("please enter phoneNumber:");
//				createCustomer(name, phoneNumber, email);
//			}else if(answerToCreate.equals("N")) {
//				return;
//			}
//			
//		}

	}

	public void run() {
		showMainMenu();
	}

	private void showMainMenu() {
		while (true) {
			// show main menu, ask for input
			// corresponding menu
			// main menu: 1.vehicle 2.customer 3.rental 0.exit
			// vehicle-submenu: 1.c 2.r 3.u 4.d 5.view cars 0.go back
			// customer-submenu: 1.c 2.r 3.u 4.d 5.view all 0.go back
			// rental-submenu: 1.rent 2.return 3.view records 0.go back
			switch (getInput(
					"Welcome to car managment system\n" + "1.vehicle\n" + "2.customer\n" + "3.rental\n" + "0.exit")) {
			case "1":
				System.out.println("Vehicle menu");
				showVehicleMenu();
				break;
			case "2":
				System.out.println("Customer menu");
				showCustomerMenu();
				break;
			case "3":
				System.out.println("Rental");
				showRentalMenu();
				break;
			case "0":
				System.out.println("See you next time");
				System.exit(0);
				break;
			default:
				System.out.println("Not valid input!");
				break;

			}
			System.out.println();

		}
	}

	private void showRentalMenu() {
		// TODO Auto-generated method stub
		while (true) {
			// rental-submenu: 1.rent 2.return 3.view records 0.go back

			switch (getInput("Please choose from the following actions\n" + "1.rent a vehicle\n"
					+ "2.return a vehicle\n" + "3.view records\n" + "0.go back")) {
			case "1":
				System.out.println("rent a vehicle");
				break;
			case "2":
				System.out.println("return a vehicle");
				break;
			case "3":
				System.out.println("3.view records");
				break;
			case "0":
				System.out.println("go back");
				return;
			default:
				System.out.println("Not valid input!");
				break;

			}
			System.out.println();

		}
	}

	private void showCustomerMenu() {
		// TODO Auto-generated method stub
		while (true) {

			// customer-submenu: 1.c 2.r 3.u 4.d 5.view all 0.go back
			switch (getInput(
					"Please choose from the following actions\n" + "1.add a customer\n" + "2.search a customer\n"
							+ "3.update a customer\n" + "4.delete a customer\n" + "5.view all\n" + "0.go back")) {
			case "1":
				System.out.println("add");
				break;
			case "2":
				System.out.println("search");
				break;
			case "3":
				System.out.println("update");
				break;
			case "4":
				System.out.println("delete");
				break;
			case "5":
				System.out.println("view all");
				break;
			case "0":
				System.out.println("go back");
				return;
			default:
				System.out.println("Not valid input!");
				break;

			}
			System.out.println();

		}
	}

	private void showVehicleMenu() {

		while (true) {

			// vehicle-submenu: 1.c 2.r 3.u 4.d 5.view cars 0.go back
			// customer-submenu: 1.c 2.r 3.u 4.d 5.view all 0.go back
			// rental-submenu: 1.rent 2.return 3.view records 0.go back

			switch (getInput("Please choose from the following actions\n" + "1.add a vehicle\n" + "2.search a vehicle\n"
					+ "3.update a vehicle\n" + "4.delete a vehicle\n" + "5.view all\n" + "0.go back")) {
			case "1":
				System.out.println("add");
				carSys.createVehicle(getDoubleInput("Input penalty rate:"), getInput("Input Plate Number:"),
						getDoubleInput("Input rent rate:"), getBrand(), getType(), getInputDate());
				System.out.println("Created!");
				System.out.println(carSys.getVehicleList().get(carSys.getVehicleList().size()-1));
				break;
			case "2":
				System.out.println("search");
				break;
			case "3":
				System.out.println("update");
				break;
			case "4":
				System.out.println("delete");
				break;
			case "5":
				System.out.println("view all");
				break;
			case "0":
				System.out.println("go back");
				return;
			default:
				System.out.println("Not valid input!");
				break;

			}
			System.out.println();

		}
	}

	private Date getInputDate() {
		// TODO Auto-generated method stub
		return null;
	}

	private Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	private Brand getBrand() {
		// TODO Auto-generated method stub
		return null;
	}

	private double getDoubleInput(String hint) {
		try {
			String raw = getInput(hint);
			return Double.parseDouble(raw);
		} catch (NumberFormatException e) {
			return getDoubleInput(hint);
		}
	}

	private String getInput(String hint) {
		System.out.println(hint);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String output = reader.readLine();
			return output;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
