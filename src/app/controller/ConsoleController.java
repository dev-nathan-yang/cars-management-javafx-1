package app.controller;

import java.util.Date;
import app.Brand;
import app.CarSystem;
import app.Type;
import app.view.ConsoleView;

public class ConsoleController {

	CarSystem carSys; // The model
	ConsoleView view; // The view

	public ConsoleController() {
		carSys = new CarSystem();
		view = new ConsoleView();
	}

	public ConsoleController(CarSystem carSys) {
		this.carSys = carSys;
		view = new ConsoleView();
	}

	public void rentVehicle(String email) {

		String info = carSys.getVehicleSelectionListString();
		if (info.length() < 1) {
			System.out.println("No available cars!");
			return;
		}
		System.out.println("rent a vehicle");
		System.out.println("please pick a vehicle: ");
		System.out.println(info);
		int vIndex = view.getIntInput("please select index from above: ");
		if (vIndex >= carSys.getVehicleList().size() || vIndex < 0
				|| !carSys.getVehicleByIndex(vIndex).isAvailableForRenting()) {
			System.out.println("Not a valid input.");
			return;
		}

		carSys.rentCar(email, vIndex, view.getDateInput("Please input estimate return date (DD-MM-yyyy):"));

	}

	public void run() {
		openMainMenu();
	}

	private void openMainMenu() {
		while (true) {
			// show main menu, ask for input
			// corresponding menu
			// main menu: 1.vehicle 2.customer 3.rental 0.exit
			// vehicle-submenu: 1.c 2.r 3.u 4.d 5.view cars 0.go back
			// customer-submenu: 1.c 2.r 3.u 4.d 5.view all 0.go back
			// rental-submenu: 1.rent 2.return 3.view records 0.go back
			switch (view.getInput(
					"Welcome to car managment system\n" + "1.vehicle\n" + "2.customer\n" + "3.rental\n" + "0.exit")) {
			case "1":
				System.out.println("Vehicle menu");
				openVehicleMenu();
				break;
			case "2":
				System.out.println("Customer menu");
				showCustomerMenu();
				break;
			case "3":
				System.out.println("Rental");
				String email;
				while (true) {
					email = view.getInput("please enter your email to login(enter empty to go back): ");
					if (email.equals(""))
						break;
					if (carSys.ifEmailExists(email)) {
						openRentalMenu(email);
						break;
					} else {
						System.out.println("Not exsited email!");
					}

				}
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

	private void openRentalMenu(String email) {
		while (true) {
			// rental-submenu: 1.rent 2.return 3.view records 0.go back

			switch (view.getInput("Please choose from the following actions\n" + "1.rent a vehicle\n"
					+ "2.return a vehicle\n" + "3.view records\n" + "0.go back")) {
			case "1":
				rentVehicle(email);
				break;
			case "2":
				returnVehicle(email);
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

	private void returnVehicle(String email) {
		System.out.println("return a vehicle");
		// 1. please enter your name (email): 2.show renting record 3. choose which car
		// to return. 4. enter return date 5. show total fee

		System.out.println("Renting cars:\n");
		System.out.println(carSys.getRentingVehicleStringByCustomerEmail(email));
		int index = view.getIntInput("Please select index from above");
		if (index < 0 || index >= carSys.getRentingVehicleBListEmail(email).size()) {
			System.out.println("Not a valid input");
			return;
		}
		carSys.returnCar(email, index);
	}

	private void showCustomerMenu() {
		// TODO Auto-generated method stub
		while (true) {

			// customer-submenu: 1.c 2.r 3.u 4.d 5.view all 0.go back
			switch (view.getInput(
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
				System.out.println(carSys.getCustomerSelectionListString());
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

	private void openVehicleMenu() {

		while (true) {

			// vehicle-submenu: 1.c 2.r 3.u 4.d 5.view cars 0.go back
			// customer-submenu: 1.c 2.r 3.u 4.d 5.view all 0.go back
			// rental-submenu: 1.rent 2.return 3.view records 0.go back

			switch (view.getInput(
					"Please choose from the following actions\n" + "1.add a vehicle\n" + "2.search a vehicle\n"
							+ "3.update a vehicle\n" + "4.delete a vehicle\n" + "5.view all\n" + "0.go back")) {
			case "1":
				System.out.println("add");
				carSys.createVehicle(view.getDoubleInput("Input penalty rate:"), view.getInput("Input Plate Number:"),
						view.getDoubleInput("Input rent rate:"), null,null, null);
				System.out.println("Created!");
				System.out.println(carSys.getVehicleList().get(carSys.getVehicleList().size() - 1));
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
				String allCarsInfo = carSys.getAllVehiclesInfo();
				System.out.println(allCarsInfo);
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

}
