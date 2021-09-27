package app.controller;

import java.util.Date;
import app.Brand;
import app.CarSystem;
import app.Type;
import app.view.console.ConsoleView;

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

				double penaltyRate = view.getDoubleInput("Input penalty rate:");
				String plateNumber = view.getInput("Input plate number: ");
				double rentRate = view.getDoubleInput("Input rent rate:");
				Date dataOfProduction = view.getDateInput("(Input data of production (DD-MM-yyyy):");
				System.out.println(carSys.getBrandString());
				int brandIndex = view.getIntInput("Select brand");
				System.out.println(carSys.getTypeString());
				int typeIndex = view.getIntInput("Select type");
				carSys.createVehicle(penaltyRate, plateNumber, rentRate, brandIndex, typeIndex, dataOfProduction);
				System.out.println("Created!");
				System.out.println(carSys.getVehicleList().get(carSys.getVehicleList().size() - 1));
				break;
			case "2":
				System.out.println("search");
				String carInfoString = carSys.findAndGetCarString(view.getInput("Please enter plate number: "));
				System.out.println(carInfoString);
				break;
			case "3":
				// 1.find the vehicle which is to be updated, if null return
				// 2.determine which fields to update
				// 2.1 show the found vehicle info
				// 2.2 get user\'s CORRESPONDING input fields to update
				// e.g. input plate number
				// => find a vehicle
				// => display the vehicle info
				// => choose which field to update
				// => input update
				// => complete update
				// 0. Plate Number:String
				// 1. Renting Rate:double
				// 2. Date of Production:Date
				// if ==0, return view.getInput()...
				System.out.println("update");
				String updatePlateNumber = view.getInput("Input car plate number:");
				if (carSys.retreiveVehicle(updatePlateNumber) == null) {
					System.out.println("Not found");
					return;
				}
				String[][] fields = carSys.retreiveVehicle(updatePlateNumber).getFields();
				view.printFields(fields);
				int choose = view.getIntInput("Select what you want to change:");
				if (choose < 0 || choose >= fields.length) {
					System.out.println("Invalid Input");
					return;
				}
				dynamicInput(updatePlateNumber, fields[choose][1], "Please input updated value");
				System.out.println("Complete!");
				break;
			case "4":
				System.out.println("delete");
				System.out.println(carSys.getAllVehiclesInfo());
				carSys.deleteVehicle(view.getInput("please input plate number to delete: "));
				System.out.println("After delete: " + "\n" + carSys.getAllVehiclesInfo());
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

	private void dynamicInput(String plateNumber, String fieldName, String hint) {
		switch (fieldName) {
		case "penaltyRate":
			carSys.updateVehiclePenaltyRate(plateNumber, view.getDoubleInput(hint));
			return;
		case "plateNumber":
			carSys.updateVehiclePlateNumber(plateNumber, view.getInput(hint));
			return;
		case "rentingRate":
			carSys.updateVehicleRentingRate(plateNumber, view.getDoubleInput(hint));
			return;
		case "brand":
			System.out.println(carSys.getBrandString());
			carSys.updateVehicleBrand(plateNumber, view.getIntInput(hint));
			return;
		case "type":
			System.out.println(carSys.getTypeString());
			carSys.updateVehicleType(plateNumber, view.getIntInput(hint));
			return;
		case "dateOfProduction":
			carSys.updateVehicleDate(plateNumber, view.getDateInput(hint));
			return;
		case "rentingCustomer":
			openUpdateRentingCustomerMenu();
			return;
		default:
			return;
		}
	}

	private void openUpdateRentingCustomerMenu() {
		// TODO Auto-generated method stub

	}

}
