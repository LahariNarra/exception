package com.capgemini.studentexception.main;

import com.capgemini.studentexception.exception.DebitLimitException;

public class CurrentBankAccount extends BankAccount {
	private double debitLimit;
	private double borrowedAmount;

	public CurrentBankAccount() {
		super();

	}

	public CurrentBankAccount(long accountId, String accountHolderName, double accountBalance, double debitLimit) {
		super(accountId, accountHolderName, "Current", accountBalance);
		this.debitLimit = debitLimit;

	}

	public double getDebitLimit() {
		return debitLimit;
	}

	public void setDebitLimit(double debitLimit) {
		this.debitLimit = debitLimit;
	}

	public double getBorrowedAmount() {
		return borrowedAmount;
	}

	public void setBorrowedAmount(double borrowedAmount) {
		this.borrowedAmount = borrowedAmount;
	}

	@Override
	public double withdraw(double amount) throws DebitLimitException  {
		double balance = getAccountBalance() - amount;
		if (balance > 0)
			setAccountBalance(balance);
		else if (Math.abs(balance) <= (debitLimit - borrowedAmount)) {
			setAccountBalance(0);
			borrowedAmount = borrowedAmount + Math.abs(balance);
		} else
			throw new DebitLimitException("You have exceeded with debit limit");
		return getAccountBalance();
	}

	@Override
	public double deposit(double amount) {
		if (borrowedAmount == 0)
			return super.deposit(amount);
		else if (amount >= borrowedAmount) {
			setAccountBalance(amount - borrowedAmount);
			borrowedAmount = 0;
		} else {
			borrowedAmount = borrowedAmount - amount;
		}
		return getAccountBalance();
	}

}
