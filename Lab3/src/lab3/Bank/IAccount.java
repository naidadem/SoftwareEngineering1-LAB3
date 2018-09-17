package lab3.Bank;

public interface IAccount {
	
	public abstract String getCurrency();
	
	
	/*
	 * Method for withdrawing money from account
	 * */
	public abstract Double withdraw(Double requestedAmount);	

	/*
	 * Method that withdraws all the money from the account
	 * */
	public abstract Double withdrawAll();
	
	/*
	 * Method for adding money to account
	 * */
	public abstract Double deposit(Double amoutToDeposit);
	
	/*
	 * Method for converting you money into different currency
	 * 
	 * the method returns true if the conversion has been performed
	 * false if the conversion fails
	 * */
	public abstract void convertToCurrency(String currencyCode, Double rate);
	
	/*
	 * Method that makes transfer from one account to another. 
	 * The transfer should be possible only if both account hold the same currency.
	 * */
	
	public abstract void TransferToAccount(IAccount account);
}