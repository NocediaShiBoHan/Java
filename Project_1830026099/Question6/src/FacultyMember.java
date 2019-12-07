public class FacultyMember extends Employee {
	// The Constructor
	public FacultyMember(String name, int salary) throws NegativeSalaryException  {
		// Initialize the FacultyMember
		super(name, salary);
	}

	@Override
	// UIC should pay money to the FacultyMember
	public void pay(int amount) {
		// Change the debt to pay money for UIC
		setDebt(this.getDebt() + amount);
	}

	// Test the constructor and other methods
	public static void testFacultyMember() {
		System.out.println("   ");
		System.out.println("---FacultyMember----");
		try {
			// Create an object of the faculty member with name and salary
			FacultyMember f1 = new FacultyMember("Nocedia", 5000);
			// Test the name of the faculty member
			System.out.println(f1.getName() == "Nocedia");
			// Test the salary that UIC owes to the faculty member
			System.out.println(f1.getDebt() == -5000);
			// UIC pays 4000 to the faculty member
			f1.pay(5000);
			// Test the salary that UIC owes 0 to the faculty member
			System.out.println(f1.getDebt() == 0);
			// The faculty member temporarily borrow 7000 from UIC
			f1.pay(7000);
			// Test the money that the faculty member borrowed from UIC
			System.out.println(f1.getDebt() == 7000);
			// The faculty member pay 7000 back to UIC
			f1.pay(-7000);
			// Test the money that the faculty member owes 0 to UIC
			System.out.println(f1.getDebt() == 0);
		} catch (Exception ex1) {
			// Throw the Exception with the message
			System.out.println(ex1.getMessage());
		}
		try {
			// Create another object of the Faculty Member with name and salary
			FacultyMember f2 = new FacultyMember("Saxon", -1000);
			// Test the name of the faculty member
			System.out.println(f2.getName() == "Saxon");
			// The salary cannot be less than zero
		} catch (Exception ex2) {
			// Throw the Exception with the message
			System.out.println(ex2.getMessage().equals("An employee cannot have a negative salary!"));
		}
		System.out.println("--------------------");
	}
}