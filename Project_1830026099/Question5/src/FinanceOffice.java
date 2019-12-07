import java.util.ArrayList;

public class FinanceOffice {
	// Declare the private variable of class FinanceOffice
	private String name;
	private ArrayList<Payer> payers;

	// The Constructor
	public FinanceOffice(String name) {
		// Initialize the FinanceOffice
		this.name = name;
		payers = new ArrayList<Payer>();
	}

	// Add the payer to the ArrayList of payers
	public void addPayer(Payer payer) {
		this.payers.add(payer);
	}

	// Return as result the total amount of debt of all the payers of the finance office
	public int totalDebt() {
		int total = 0;
		// Use a loop to calculate the debt
		for (Payer p : payers) {
			total += p.getDebt();
		}
		return total;
	}

	// Take as argument the name of a payer
	// And return as result the current amount of debt for this payer
	public int getDebt(String name) throws UnknownPayerException {
		// Get the name of the payer in ArrayList
		for (Payer p : payers) {
			// If the name is correct in the ArrayList
			if (p.getName().equals(name)) {
				// Return the correct amount of debt
				return p.getDebt();
			}
		}
		// Throw an exception if the object has a name not in the ArrayList
		throw new UnknownPayerException("Payer " + name + " unknown");
	}
	
	// Take as argument the name of a payer and an amount of money 
	// And use this method of the payer to pay that amount of money to him/her
	public void pay(String name, int amount) throws UnknownPayerException, NegativeSalaryException {
		// Create a flag to determine if an exception is present
		int Judge = 0;
		// Get the name of the payer in ArrayList
		for(Payer p: payers) { 
			// If the name is correct in the ArrayList
			if (p.getName().equals(name)) {
				// Pay this amount of money
				p.pay(amount);
				// The condition that will not throw an Exception
				Judge = 1; 
			}
		}
		// The condition that will throw an Exception
		if (Judge == 0) {
			throw new UnknownPayerException("Payer " + name + " unknown");
		}
	}
	
	// Test the constructor and other methods
	public static void testFinanceOffice() {
		System.out.println("   ");
		System.out.println("---FinanceOffice----");
		// Create an object of the finance office with its name
		FinanceOffice f = new FinanceOffice("UICoffice");
		// Create an object of the student with his name and debt
		Student s = new Student("Nocedia", 1000);
		// Test the name of the Student
		System.out.println(s.getName() == "Nocedia");
		// Add the payer to the ArrayList of payers
		f.addPayer(s);
		System.out.println(f.totalDebt() == 1000);
		try {
			// The name is wrong
			f.pay("Nostia", 1000);
		} catch (Exception ex1) {
			// Throw the Exception with the message
			System.out.println(ex1.getMessage().equals("Payer Nostia unknown"));
		}
		
		try {
			// Test the correct debt of finance office
			System.out.println(f.getDebt("Nocedia") == 1000);
			// UIC uses 500 of the debt
			f.pay("Nocedia", 600);
			// Test the the current amount of debt for the payer
			System.out.println(f.getDebt("Nocedia") == 400);
			// Test the total amount of debt of all the payers
			System.out.println(f.totalDebt() == 400);
			// Create an object of the student with his name and debt
			Employee e = new Employee("Saxon", 100);
			// Add the payer to the ArrayList of payers
			f.addPayer(e);
			// Test the total amount of debt of all the payers
			System.out.println(f.totalDebt() == 300);
			// The name is wrong
			f.pay("Sasa", 1000);
		} catch (Exception ex2) {
			// Throw the Exception with the message
			System.out.println(ex2.getMessage().equals("Payer Sasa unknown"));
		}
		
		System.out.println("--------------------");
	}
}