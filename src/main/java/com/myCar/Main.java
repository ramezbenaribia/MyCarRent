package com.myCar;

/**
 * The Main class is the entry point of the console program of MyCar.
 */
public class Main {

	public static void main(String args[]) {
		System.out.println("Welcome to MyCar! ");
		MyCar mycar = new MyCar();

		String csvFile = "Fleet.csv";

		mycar.initMyCar(csvFile);

		mycar.run();

	}
}