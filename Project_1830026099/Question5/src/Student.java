public class Student extends Person {
	// The Constructor
	public Student(String name, int debt) {
		// Initialize the Student
		super(name, debt);
	}
	
	@Override
	// Students should pay money to UIC
	public void pay(int amount) {
		// Decrease the amount of debt 
		setDebt(getDebt() - amount);
		// A student can have a negative debt 
	}
	
	// Test the constructor and other methods
	public static void testStudent() {
		System.out.println("   ");
		System.out.println("-------Student------");
		// Create an object of the Student with name and debt
		Student s = new Student("Nocedia", 1000);
		// Test the name of the Student
		System.out.println(s.getName() == "Nocedia");
		// Test the debt of the Student
		System.out.println(s.getDebt() == 1000);
		// Set and change the debt of the Student
		s.setDebt(800);
		// Test the debt after changed
		System.out.println(s.getDebt() == 800);
		// Decrease the amount of debt 
		s.pay(1200);
		// Test the debt after changed
		System.out.println(s.getDebt() == -400);
		System.out.println("--------------------");
	}
}