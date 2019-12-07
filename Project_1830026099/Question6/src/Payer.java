public interface Payer {
	// Implements methods in the interface
	
	// Implements the method to get value of name
	public String getName();
	// Implements the method to get value of debt
	public int getDebt();
	// Implements the method to (decrease/increase) the amount of debt
	public void pay(int amount) throws NegativeSalaryException;
}