package console.program;

/**
 * The Main class is the entry point of the sample console program.
 */
public class Main {

	public static void main(String args[]) {
		System.out.println("Welcome to MyCar! ");
		MyCar mycar = new MyCar("My Car!");
		mycar.run();
	}

}
