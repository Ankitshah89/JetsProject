package com.skilldistillery.jets;

import java.io.*;
import java.util.*;

public class AirField {
	Scanner kb = new Scanner(System.in);

	private List<Jet> jets = new ArrayList<>();

	// Constructor
	public AirField() {
		readAndPopulateFromFile();

	}

	// This method reads and populated the data from the .txt file.
	// It splits individual data when it encounters a ",". It will then parse the
	// data into its respective data types.
	// It also checks for a specific Jet type and adds to a list.

	public List<Jet> readAndPopulateFromFile() {
		BufferedReader bufIn = null;
		try {
			FileReader fr = new FileReader("Jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {

				String[] fields = line.split(", ");
				String type = fields[0].trim();
				String model = fields[1].trim();

				int range = Integer.parseInt(fields[2].trim());
				double speed = Double.parseDouble(fields[3]);
				long price = Long.parseLong(fields[4]);

				if (type.contentEquals("FighterJet")) {
					jets.add(new FighterJet(type, model, range, speed, price));

				} else if (type.contentEquals("CargoJet")) {
					jets.add(new CargoPlane(type, model, range, speed, price));

				} else if (type.contentEquals("PassengerJet")) {
					jets.add(new otherType(type, model, range, speed, price));
				}

			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading file : " + e.getMessage());

		}
		return jets;
	}

	// This method displays the main menu
	public void displayMenu() {

		System.out.println("*********************************************");
		System.out.println("*                                           *");
		System.out.println("*\t1. List fleet                       *");
		System.out.println("*\t2. Fly all Jets                     *");
		System.out.println("*\t3. View Fastest Jet                 *");
		System.out.println("*\t4. View Jet with Longest Range      *");
		System.out.println("*\t5. Load All Cargo Jets              *");
		System.out.println("*\t6. Dogfight !!                      *");
		System.out.println("*\t7. Add a Jet To Fleet               *");
		System.out.println("*\t8. Remove a jet from Fleet          *");
		System.out.println("*\t9. Quit                             *");
		System.out.println("*                                           *");
		System.out.println("*********************************************");

	}

	// This method displays the list of jets in our file
	public void displayJets() {
		for (Jet jet : jets) {
			System.out.println(jet);

		}

	}

	// This method prints out the details and the amount of time the jet can fly
	// until it runs out of fuel.
	public void flyJets() {
		for (Jet jet : jets) {
			jet.fly();

		}
	}

	// Method to call the jet with the fastest Speed
	public String fastestJet() {
		double currentSpeed = Integer.MIN_VALUE;
		String speed = null;
		for (Jet jet : jets) {
			if (jet.getSpeed() > currentSpeed) {
				currentSpeed = jet.getSpeed();
				speed = jet.toString();
			}
		}
		return speed;
	}

	// method to call the Jet with the longestRange
	public String longestRange() {
		double currentRange = Integer.MIN_VALUE;
		String range = null;
		for (Jet jet : jets) {
			if (jet.getRange() > currentRange) {
				currentRange = jet.getRange();
				range = jet.toString();
			}

		}
		return range;

	}

	// Method that calls in the interface which prompts the message of loading the
	// Cargo planes.
	public void loadCargo() {
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				CargoPlane cargoPlane = ((CargoPlane) jet);
				System.out.println(cargoPlane.toString());
				cargoPlane.loadCargo();

			}

		}
	}

	// Method that call in the interface which prompts the message of FighterJets
	// fighting.
	public void dogFight() {
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				FighterJet fighterJet = (FighterJet) jet;
				System.out.println(fighterJet.toString());
				fighterJet.fight();
			}

		}
	}

	// This method displays a menu which allows the user to add more to the fleet of
	// jets.
	public void displayAddFleetMessage() {
		System.out.println("Enter a type you want to add to the field (1-4)");
		System.out.println();
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Plane");
		System.out.println("3. Passenger Jet");
		System.out.println("4. Quit");
		System.out.println();
		System.out.print("Choose : ");
		System.out.println();

	}

	// This method add the user input fleet to the already existing fleet of jets.
	public void addJetToFleet() {
		int range = 0;
		double speed = 0;
		long price = 0;
		int choice = 0;
		boolean keepGoing = true;
		boolean exceptionTrue = false;

		// choice (1-3); 4 quit , other- redisplay the option

		do {
			displayAddFleetMessage();
			choice = kb.nextInt();
			if (choice == 4) {
				System.out.println("Thanks for the input !");
				break;
			}
			if (choice > 4 || choice < 1) {
				System.err.println("Invalid Choice !");
				System.out.println();
				continue;
			}
			System.out.print("Enter the Jet model: ");
			String model = kb.next();
			try {
				System.out.print("Enter the range for " + model + " : ");
				range = kb.nextInt();
				System.out.print("Enter the speed for " + model + " : ");
				speed = kb.nextDouble();
				System.out.print("Enter the price for " + model + " : ");
				price = kb.nextLong();
			} catch (InputMismatchException e) {
				System.err.println("Wrong input format");
				exceptionTrue = true;
			} finally {
				if (exceptionTrue) {

					kb.nextLine();
					System.out.println("Please enter again : ");
					System.out.print("Please enter the range again (Integer) : ");
					range = kb.nextInt();
					System.out.print("Please enter the speed agian (Double) : ");
					speed = kb.nextDouble();
					System.out.print("Please enter the price again (Long) : ");
					price = kb.nextLong();
				}
			}
			Jet jet = null;

			System.out.println("from 1");
			System.out.println("you entered choice = " + choice);
			switch (choice) {
			case 1:
				System.out.println("inside case 1 ");
				jet = new FighterJet("Fighter Jet", model, range, speed, price);
				break;
			case 2:
				jet = new CargoPlane("Cargo", model, range, speed, price);
				break;
			case 3:
				System.out.println("from 3");
				jet = new otherType("PassengerJet", model, range, speed, price);
				break;
			default:
				System.out.println("from 2");
				System.err.print("inside default Please Enter the correct choice (1-4) : ");
			}
			if (jet != null) {
				jets.add(jet);
			}
			displayJets();
			System.out.println();
		} while (keepGoing);
	}

	// This method displays the user a list of jets by type and model and asks them
	// if they want to remove any.
	// It also displays the remaining list of jets.
	public void removeJet() {
		System.out.println("Which jet to remove?");
		System.out.println();
		int counter = 1;
		for (Jet jet : jets) {
			System.out.println(counter + ". " + "Type: " + jet.getType() + "\t\t" + "Model: " + jet.getModel());
			counter++;
		}
		System.out.println();
		System.out.print("Choose a number :");
		System.out.println();

		int removedJet = kb.nextInt();
		if (removedJet > jets.size()) {
			System.err.println("The list does not have that number");
		} else {
			jets.remove(removedJet - 1);
			displayJets();
		}

	}

	public void speedInMach() {
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				FighterJet fighterjet = ((FighterJet) jet);
				System.out.println("Mach:");
				fighterjet.getSpeedInMach();
			}

		}
	}

}
