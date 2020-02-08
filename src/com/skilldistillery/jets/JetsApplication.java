package com.skilldistillery.jets;

//import java.io.FileNotFoundException;
import java.util.Scanner;

public class JetsApplication {
	private static Scanner kb;

	static {
		kb = new Scanner(System.in);
	}

	private AirField airfield = new AirField();

	public static void main(String[] args) {

		JetsApplication app = new JetsApplication();

		app.run();

	}

	public void run() {

		boolean keepGoing = true;

		do {
			airfield.displayMenu();
			System.out.println();

			System.out.print("Enter a choice (1-9):");

			int choice = kb.nextInt();

			switch (choice) {
			case 1:
				airfield.displayJets();
				System.out.println();
				break;
			case 2:
				airfield.flyJets();
				System.out.println();
				break;
			case 3:
				System.out.println("The fastest jet is  (** " + airfield.fastestJet() + " **)");
				System.out.println();
				break;
			case 4:
				System.out.println("The jet with the longest range is  (** " + airfield.longestRange() + " **)");
				System.out.println();
				break;
			case 5:
				airfield.loadCargo();
				System.out.println();
				break;
			case 6:
				airfield.dogFight();
				System.out.println();
				break;
			case 7:
				airfield.addJetToFleet();
				System.out.println();
				break;
			case 8:
				airfield.removeJet();
				System.out.println();
				break;
			case 9:
				System.out.println("GOODBYE !");
				keepGoing = false;
				break;

			}
		} while (keepGoing);

	}

}
