
public class SavingsAccount extends BankAccount{
	private double rate = 0.025;
	private String savingsNumber = "0";
	private String accountNumber;
	
	public SavingsAccount(String name, double amount)
	{
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;	
	}
	public SavingsAccount(SavingsAccount old, double amount)
	{
		super(old, amount);
		savingsNumber = (Integer.parseInt(savingsNumber) + 1) + "";
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	public void postInterest()
	{
		setBalance(getBalance() * (1 + rate/12));
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
}
