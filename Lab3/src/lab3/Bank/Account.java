package lab3.Bank;

public class Account implements IAccount {
	
	private Double balance;
	private String currency;
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setBalance(Double balance) {
		if(balance >=0)
			this.balance = balance;
		else
			this.balance = 0.0;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public Account() {
		balance = 0.0;
		currency = "SEK";
	}
	
	public Account(Double _amount, String _currency) {
		balance = _amount;
		currency = _currency;
	}

	@Override
	public Double withdraw(Double requestedAmount) {
		if(balance >= requestedAmount)
			balance -= requestedAmount;
		return balance;
	}

	@Override
	public Double deposit(Double amountToDeposit) {
		if(amountToDeposit >= 0)
			balance += amountToDeposit;
		return balance;
	}

	@Override
	public void convertToCurrency(String currencyCode, Double rate) {
		if(currency != currencyCode)
		{
			currency = currencyCode;
			balance *= rate;
		}
	}

	@Override
	public void TransferToAccount(IAccount account) {
		if(currency == account.getCurrency())
		{
			Double accountBalance = this.balance;
			this.withdrawAll();
			account.deposit(accountBalance);
		}
	}

	@Override
	public Double withdrawAll() {	
		return withdraw(balance);
	}
	
}