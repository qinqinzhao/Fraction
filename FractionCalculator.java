package fraction;

import java.util.Scanner;

public class FractionCalculator {
	
	static Scanner scanner = new Scanner(System.in);
	
	/**
	 * The main method that runs the calculator. It first prints a zero (indicating the current
	 * contents of the calculator), and instructions of how to enter commands to do different 
	 * calculations. It then prints a prompt and accepts commands from the user, and after each 
	 * command, it prints the result and a new prompt, until the user quits the program.
     */
	public static void main(String args[]) {
		System.out.println("0 \n");	
		System.out.println("This is a fraction calculator.\n"
				+ "You will enter numbers and commands to do calculations. \n"
				+ "Here are the commands it supports: \n"
				+ "'a': To take the absolute value of the number currently displayed. \n"
				+ "'c': To clear (reset to zero) the calculator. \n"
				+ "'i': To invert the number currently displayed (a/b to b/a) \n"
				+ "'s n<': To discard the number currently displayed and replace it with n. \n"
				+ "'q': To quit the program. \n"
				+ "'+ n<': To add n< to the number currently displayed. \n"
				+ "'- n': To subtract n from the number currently displayed. \n"
				+ "'* n': To multiply the number currently displayed by n. \n"
				+ "'/ n': To divide the number currently displayed by n. \n");
		Fraction f = new Fraction(legalNumber());
		while (true) {
			String command = legalCommand();
			System.out.println(command);
            if (command.startsWith("a")) {
                f = f.abs();
            } else if (command.startsWith("c")) {
                f = new Fraction(0);
            } else if (command.startsWith("i")) {
                if (f.getNumerator() != 0) {
                	f = f.inverse();
                } else {
                	System.out.println("When doing inverse, the numerator cannot be zero.");
                	continue;
                }
            } else if (command.startsWith("q")) {
                break;
            } else if (command.startsWith("s")) {
            	f = new Fraction(command.substring(command.indexOf("s") + 1).trim());
            } else if (command.startsWith("+")) {
            	f = f.add(new Fraction(command.substring(command.indexOf("+") + 1).trim()));
            } else if (command.startsWith("-")) {
                f = f.subtract(new Fraction(command.substring(command.indexOf("-") + 1).trim()));
            } else if (command.startsWith("*")) {
                f = f.multiply(new Fraction(command.substring(command.indexOf("*") + 1).trim()));
            } else if (command.startsWith("/")) {
                f = f.divide(new Fraction(command.substring(command.indexOf("/") + 1).trim()));
            } else {
				System.out.println("Please reenter the correct command. ");
			}
            System.out.println(f.toString());
		}
	}
	
	/**
	 * Checks whether the user enters a legal starting number. If the input does not follow the 
	 * following two formats: 1) a; 2) a/b (blanks are allowed), the user will be asked to enter
	 * again, until the number is in legal format.
	 * @return The number that the user enters.
	 */
	public static String legalNumber() {
		System.out.println("Please enter a number, either in fraction format (a/b), or a whole number. ");
		String number = scanner.nextLine();
		if (number == null || number.length() == 0 ||
			number.matches("( *)(-?)( *)([0-9])+( *)(([/])( *)(-?)( *)([0-9])+)?") == false) {
			System.out.println("Please enter a correct number. ");
			return legalNumber();
		}
		return number;
	}
	
	/**
	 * Checks whether the user enters a legal command, which has to be one of the following: "a", "c",
	 * “i", "q", "s n", "+ n", "- n", "* n", "/ n" (n is either a fraction or a whole number; blanks 
	 * are allowed but not necessary). If the input does not match the above formats, the user will be
	 * asked to enter again, until the command is in legal format. 
	 * @return The command that the user enters.
	 */
	public static String legalCommand() {
		System.out.println("Please enter a command from the ones listed above. ");
		String command = scanner.nextLine();
		if (command == null || command.length() == 0 ||
			(command.matches("(a|c|i|q|)") == false &&
			command.matches("(s|\\+|-|\\*|/)( *)(-?)( *)([0-9])+( *)(([/])( *)(-?)( *)([0-9])+)?") == false)) {
			System.out.println("Please enter a correct command. ");
			return legalCommand();
		}
		return command;
	}
}
