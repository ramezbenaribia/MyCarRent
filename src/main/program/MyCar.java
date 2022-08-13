package main.program;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * The MyCar class provides the functionality needed to manage orders and
 * checkout.
 */
public class MyCar {
	public static final String banner = new String(new char[100]).replace('\u0000', '-');;

	private String name;
	private ArrayList<Vehicle> vehicleList;
	private int vehicleListSize;

	public MyCar(String name) {
		this.name = name;
		this.vehicleList = new ArrayList<Vehicle>();
		this.vehicleListSize = 0;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Vehicle> getVehicleList() {
		return this.vehicleList;
	}

	/**
	 * The method to initialize the system of MyCar
	 */

	public void initMyCar(String path) {
		ArrayList<String[]> lines = CSVReader.read(path);
		this.vehicleListSize = lines.size();

		for (int i = 0; i < this.vehicleListSize; i++) {
			String[] line = lines.get(i);

			String vehicleID = line[0];
			String brand = line[1];
			String model = line[2];
			String type = line[3];
			String manufactureYear = line[4];
			String seatsNumber = line[5];
			String color = line[6];
			String rentalPerDay = line[7];
			String insurancePerDay = line[8];
			String serviceFee = line[9];
			String discount = line[10];

			Vehicle newVehicle = new Vehicle(
					vehicleID,
					brand,
					model,
					type,
					Integer.parseInt(manufactureYear),
					Integer.parseInt(seatsNumber),
					color,
					Integer.parseInt(rentalPerDay),
					Integer.parseInt(insurancePerDay),
					Integer.parseInt(serviceFee),
					discount);
			vehicleList.add(newVehicle);

		}

	}

	/**
	 * The method to operate the MyCar.
	 */
	public void run() {
		boolean exit = false;
		do {
			printMenu();

			String stringInput = readUserInput();

			// Check the user input and continue with the next iteration
			// if no input is provided
			if (stringInput.isEmpty()) {
				System.out.println("Please select a valid menu option.");
				continue;
			}

			char input = stringInput.charAt(0);

			switch (input) {
				case '1':
					this.search();
					break;
				case '2':
					this.browse();
					break;
				case '3':
					this.filter();
					break;
				case '4':
					exit = true;
					break;
				default:
					System.out.println("Please select a valid menu option.");
					break;
			}
		} while (!exit);
	}

	/**
	 * The utility method to print menu options.
	 */
	public static void printMenu() {
		System.out.println(banner + "\n" + "> Select from main menu" + "\n" + banner);
		System.out.printf("   %s%n", "1) Search by brand");
		System.out.printf("   %s%n", "2) Browse by vehicle type");
		System.out.printf("   %s%n", "3) Filter by number of passengers");
		System.out.printf("   %s%n", "4) Exit");
		System.out.print("Please select: ");
	}

	/**
	 * The utility method to read user input.
	 */
	public static String readUserInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	/**
	 * The method to search for a vehicle by brand .
	 */
	public void search() {
		ArrayList<Vehicle> filteredVehicleList = new ArrayList<Vehicle>();

		System.out.print("Please provide a brand: ");
		String stringInput = readUserInput();

		for (int i = 0; i < this.vehicleListSize; i++) {
			Vehicle vehicle = this.vehicleList.get(i);
			String vehicleBrand = vehicle.getBrand();
			if (vehicleBrand.equals(stringInput)) {
				filteredVehicleList.add(vehicle);
			}
		}

		System.out.println(banner + "\n" + "> Select from  matching list" + "\n" + banner);

		this.selectCar(filteredVehicleList);
	}

	/**
	 * The method to browse for a vehicle by type.
	 */
	public void browse() {
		ArrayList<String> vehicleTypeList = new ArrayList<String>();
		ArrayList<Vehicle> filteredVehicleList = new ArrayList<Vehicle>();
		int vehicleTypeListSize = 0;

		for (int i = 0; i < this.vehicleListSize; i++) {
			Vehicle vehicle = this.vehicleList.get(i);
			if (!vehicleTypeList.contains(vehicle.getType())) {
				vehicleTypeList.add(vehicle.getType());
			}
		}

		vehicleTypeListSize = vehicleTypeList.size();

		System.out.println(banner + "\n" + ">  Browse by type of vehicle" + "\n" + banner);
		do {

			for (int i = 1; i <= vehicleTypeListSize; i++) {
				String type = vehicleTypeList.get(i - 1);
				System.out.printf("   %s", i + ") " + type);
				System.out.println();
			}

			int exitChoiceNumber = vehicleTypeListSize + 1;

			System.out.printf("   %s%n", exitChoiceNumber + ") Go to main menu");

			System.out.print("Please select: ");

			String stringInput = readUserInput();

			// Check the user input and continue with the next iteration
			// if no input is provided
			if (stringInput.isEmpty()) {
				System.out.println("Please select a valid menu option.");
				continue;
			}

			char input = stringInput.charAt(0);
			int choice = Character.getNumericValue(input);

			if (choice > 0 && choice <= vehicleTypeListSize) {
				String typeInput = vehicleTypeList.get(choice - 1);
				System.out.println(banner + "\n" + "> Select from list of " + typeInput + "s" + "\n" + banner);

				for (int i = 0; i < this.vehicleListSize; i++) {
					Vehicle vehicle = this.vehicleList.get(i);
					String vehicleType = vehicle.getType();
					if (vehicleType.equals(typeInput)) {
						filteredVehicleList.add(vehicle);
					}
				}
				this.selectCar(filteredVehicleList);

			} else if (choice == exitChoiceNumber) {
				break;
			} else {
				System.out.println("Please select a valid menu option.");

			}

		} while (true);

	}

	/**
	 * The method to filter for a vehicle by number of passengers.
	 */
	public void filter() {
		ArrayList<Vehicle> filteredVehicleList = new ArrayList<Vehicle>();

		System.out.print("Please provide the number of passengers: ");
		String stringInput = readUserInput();
		char input = stringInput.charAt(0);
		int numberOfPassengers = Character.getNumericValue(input);

		for (int i = 0; i < this.vehicleListSize; i++) {
			Vehicle vehicle = this.vehicleList.get(i);
			int vehicleSeatsNumber = vehicle.getSeatsNumber();
			if (vehicleSeatsNumber >= numberOfPassengers) {
				filteredVehicleList.add(vehicle);
			}
		}

		System.out.println(banner + "\n" + "> Select from  matching list" + "\n" + banner);

		this.selectCar(filteredVehicleList);
	}

	/**
	 * The method to select a vehicle for rent.
	 */
	public void selectCar(ArrayList<Vehicle> filteredVehicleList) {

		int filteredVehicleListSize = filteredVehicleList.size();
		int exitChoiceNumber = filteredVehicleListSize + 1;

		do {

			for (int i = 1; i <= filteredVehicleListSize; i++) {
				Vehicle vehicle = filteredVehicleList.get(i - 1);

				System.out.printf("   %s%s - %s %s %s with %s seats %n", i + ") ",
						vehicle.getVehicleID(),
						vehicle.getBrand(),
						vehicle.getModel(),
						vehicle.getType(),
						vehicle.getSeatsNumber());
			}

			System.out.printf("   %s%n", exitChoiceNumber + ") Go to main menu");

			System.out.print("Please select: ");

			String stringInput = readUserInput();

			// Check the user input and continue with the next iteration
			// if no input is provided
			if (stringInput.isEmpty()) {
				System.out.println("Please select a valid menu option.");
				continue;
			}

			char input = stringInput.charAt(0);
			int choice = Character.getNumericValue(input);

			if (choice > 0 && choice <= filteredVehicleListSize) {
				Vehicle selectedVehicle = filteredVehicleList.get(choice - 1);
				this.rentCar(selectedVehicle);

			} else if (choice == exitChoiceNumber) {
				break;
			} else {
				System.out.println("Please select a valid menu option.");
			}

		} while (true);

	}

	/**
	 * The method to rent a vehicle and select dates for the rent period.
	 */
	public void rentCar(Vehicle vehicle) {

		String pickUpDate;
		String returnDate;
		boolean exit = false;

		System.out.println(banner + "\n" + ">  Provide dates" + "\n" + banner);
		do {
			System.out.print("Please provide pick-up date (dd/mm/yyyy): ");
			pickUpDate = readUserInput();

		} while (!Validators.validateDate(pickUpDate));
		do {
			System.out.print("Please provide return date (dd/mm/yyyy): ");
			returnDate = readUserInput();

		} while (!Validators.validateDate(returnDate) || !Validators.validateReturnDate(returnDate, pickUpDate));

		RentedVehicle rentedVehicle = new RentedVehicle(vehicle, pickUpDate, returnDate);

		this.showVehicleDetails(rentedVehicle);

		System.out.print("Would you like to reserve the vehicle (Y/N)? ");
		do {
			String stringInput = readUserInput();

			char input = stringInput.charAt(0);

			switch (input) {
				case 'Y':
					this.providePersonalInformation(rentedVehicle);
					break;
				case 'y':
					this.providePersonalInformation(rentedVehicle);

					break;
				case 'N':
					System.out.println(banner + "\n" + "> Select from  matching list" + "\n" + banner);
					exit = true;
					break;

				case 'n':
					System.out.println(banner + "\n" + "> Select from  matching list" + "\n" + banner);
					exit = true;

					break;
				default:
					System.out.println("Please select a valid menu option.");
					break;
			}

		} while (!exit);

	}

	/**
	 * The method to Provide personal information .
	 */

	public void providePersonalInformation(RentedVehicle vehicle) {
		String clientName;
		String clientSurname;
		String clientEmail;
		String clientPassengersChoice;
		boolean exit = false;

		System.out.println(banner + "\n" + "> Provide personal information" + "\n" + banner);

		do {
			System.out.print("Please provide your given name: ");
			clientName = readUserInput();

		} while (!Validators.validateName(clientName));
		vehicle.setClientName(clientName);

		do {
			System.out.print("Please provide your surname: ");
			clientSurname = readUserInput();

		} while (!Validators.validateName(clientSurname));
		vehicle.setClientSurname(clientSurname);

		do {
			System.out.print("Please provide your email address: ");
			clientEmail = readUserInput();

		} while (!Validators.validateEmail(clientEmail));
		vehicle.setClientEmail(clientEmail);

		do {
			System.out.print("Please provide number of passengers: ");
			clientPassengersChoice = readUserInput();

		} while (!Validators.validateNumber(clientPassengersChoice));

		vehicle.setClientPassengersChoice(clientPassengersChoice);
		System.out.print("Confirm and pay (Y/N): ");

		do {
			String stringInput = readUserInput();

			char input = stringInput.charAt(0);

			switch (input) {
				case 'Y':
					this.printreceipt(vehicle);
					break;
				case 'y':
					this.printreceipt(vehicle);

					break;
				case 'N':
					this.rentCar(vehicle);
					break;

				case 'n':
					this.rentCar(vehicle);
					break;
				default:
					System.out.println("Please select a valid menu option.");
					break;
			}

		} while (!exit);

	}

	/**
	 * The method to print receipt of the rented vehicle .
	 */

	public void printreceipt(RentedVehicle vehicle) {

		System.out.println(banner + "\n"
				+ ">  Congratulations! Your vehicle is booked. A receipt has been sent to your email. We will soon be in touch before your pick-up date."
				+ "\n" + banner);

		System.out.printf("%-25s  %s %s %n", "Name:", vehicle.getClientName(), vehicle.getClientSurname());
		System.out.printf("%-25s  %s %n", "Email:", vehicle.getClientEmail());
		System.out.printf("%-25s  %s %s %s with %s seats %n", "Your vehicle:",
				vehicle.getBrand(),
				vehicle.getModel(),
				vehicle.getType(),
				vehicle.getSeatsNumber());
		System.out.printf("%-25s  %s%n", "Number of passengers:", vehicle.getClientPassengersChoice());
		System.out.printf("%-25s  %s%n", "Pick-up date: ", vehicle.getPickUpDate());
		System.out.printf("%-25s  %s%n", "Return date: ", vehicle.getReturnDate());
		System.out.printf("%-25s  $%.2f %n", "Total payment: ", vehicle.getTotal());
		System.exit(1);

	}

	/**
	 * The method to Show vehicle details before renting it .
	 */
	public void showVehicleDetails(RentedVehicle vehicle) {

		System.out.println(banner + "\n" + ">  Show vehicle details" + "\n" + banner);
		System.out.printf("%-25s  %s%n", "Vehicle:", vehicle.getVehicleID());
		System.out.printf("%-25s  %s%n", "Brand:", vehicle.getBrand());
		System.out.printf("%-25s  %s%n", "Model:", vehicle.getModel());
		System.out.printf("%-25s  %s%n", "Type of vehicle:", vehicle.getType());
		System.out.printf("%-25s  %s%n", "Year of manufacture:", vehicle.getManufactureYear());
		System.out.printf("%-25s  %s%n", "No. Of seats:", vehicle.getSeatsNumber());
		System.out.printf("%-25s  %s%n", "Colour:", vehicle.getColor());
		System.out.printf("%-25s  $%-10.2f ($%.2f * %s days) %n", "Rental:", vehicle.getRental(),
				vehicle.getRentalPerDay(), vehicle.getRentDays());
		System.out.printf("%-25s  $%-10.2f ", "Discounted price:", vehicle.getDiscountedPrice());
		if (vehicle.getDiscountedPrice() == vehicle.getRental()) {
			System.out.printf("(Discount is not applicable) %n");
		} else {
			System.out.println("(" + vehicle.getDiscount() + "% Discount)");
		}
		System.out.printf("%-25s  $%-10.2f ($%.2f * %s days) %n", "Insurance:", vehicle.getInsurance(),
				vehicle.getInsurancePerDay(), vehicle.getRentDays());
		System.out.printf("%-25s  $%-10.2f %n", "Service fee:", vehicle.getServiceFee());
		System.out.printf("%-25s  $%-10.2f %n", "Total:", vehicle.getTotal());

	}
}
