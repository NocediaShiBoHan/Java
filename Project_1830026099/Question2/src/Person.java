public abstract class Person implements Payer {
	// Declare the private variable of class Person
	private String name;
	private int debt;
	
	// The Constructor
	public Person(String name, int debt) {
		// Initialize the Person
		this.name = name;
		this.debt = debt;
	}
	
	@Override
	// Return the value of name
	public String getName() {
		return name;
	}
	
	@Override
	// return the value of debt
	public int getDebt() {
		return debt;
	}
	
	// Set and change the value of debt
	protected void setDebt(int debt) {
		this.debt = debt;
	}

	// Do not know what kind of person the person is
	public abstract void pay(int amount);
	
	// Test the constructor and other methods
	public static void testPerson() {
		System.out.println("   ");
		System.out.println("-------Person-------");
		System.out.println("--------------------");
		// Cannot create an object of Person
	}
}