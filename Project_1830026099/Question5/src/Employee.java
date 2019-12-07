public class Employee extends Person{
	// The Constructor
	public Employee(String name, int salary) throws NegativeSalaryException {
		// Initialize the Employee
		super(name, -salary);
		// If the salary is strictly less than zero
		if(salary < 0) {
			// Throw the Exception with the message
			throw new NegativeSalaryException("An employee cannot have a negative salary!");
		}
	}

	@Override
	// UIC should pay money to the Employee
	public void pay(int amount) throws NegativeSalaryException {
		// The amount paid by UIC cannot larger than the salary
		if(-getDebt() < amount) { 
			// Throw the Exception with the message
			// when the employee is over paid
			throw new NegativeSalaryException("An employee cannot be overpaid by " + (getDebt() + amount) +" yuans!");
		} 
		// After paying this amount, UIC needs to 
		// pay an additional salary to the employee
		else {
			setDebt(getDebt() + amount); 
		}
	}
	
	// Test the constructor and other methods
	public static void testEmployee() {
		System.out.println("   ");
		System.out.println("------Employee------");
		try {
			// Create an object of the Employee with name and salary
			Employee e1 = new Employee("Nocedia", -10000);
			// Test the name of the Employee
			System.out.println(e1.getName() == "Nocedia");
		  // The salary cannot be less than zero
		} catch (Exception ex1) {
			// Throw the Exception with the message
			System.out.println(ex1.getMessage() == "An employee cannot have a negative salary!");
		}

		try {
			// Create another object of the Employee with name and salary
			Employee e2 = new Employee("Saxon", 10000);
			// Test the name of the Employee
			System.out.println(e2.getName() == "Saxon");
			// Test the salary that UIC owes to the Employee 
			System.out.println(e2.getDebt() == -10000);
			// UIC pays 2000 to the Employee
			e2.pay(2000);
			// Test the salary that UIC still owes to the Employee 
			System.out.println(e2.getDebt() == -8000);
			// UIC pays 12000 to the Employee
			e2.pay(12000);
		  // The employee is over paid
		} catch (Exception ex2) {
			// Throw the Exception with the message
			System.out.println(ex2.getMessage().equals("An employee cannot be overpaid by 4000 yuans!"));
		}
		System.out.println("--------------------");
	}
}