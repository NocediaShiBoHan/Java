import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
	// Declare the private variable of class FinanceOffice
	private static Scanner input = new Scanner(System.in);
	
	// Test the command line interface code
	public static void main(String[] args) {
		// Test readLine() method
		String str1 = readLine("Type some text: ");
		// Output the result of readLine()
		System.out.println("Text read is: " + str1);
		// Get the integer through readPosInt() method
		int i = readPosInt("Type an integer: ");
		// Output the result of readPosInt()
		System.out.println("Integer read is: " + i);
		// Test readLine() method again
		String str2 = readLine("Type some text again: ");
		// Output another result of readLine()
		System.out.println("Text read is: " + str2);
	}
	

	private static String readLine(String Line) {
		// Print its string argument on the screen 
		System.out.print(Line);
		// Return the next line(Let it not remain)
		return input.nextLine(); 
	}
	
	// The readPosInt method tests the integer
	private static int readPosInt(String Int) {
		// Put the whole code of the method inside a while loop
		while (true) {
			// Print the argument on screen
			System.out.print(Int);
			int n = 0;
			try {
				// Read the input
				n = input.nextInt(); 
				// If this input is not an integer
			} catch (InputMismatchException e) {  
				// Throw the Exception with the message
				System.out.println("You must type an integer!"); 
				// Get a new input
				input.nextLine(); 
				// Continue and read the next input
				continue;
			}
			// If it is wrong, get the next input
			input.nextLine();
			// If the input is positive/zero
			if(n >= 0) { 
				// return this correct input
				return n; 
			} 
			// If the input is negative
			else {
				System.out.println("Positive integers only!"); // give a warning, loop again
			}
		}
	}
}