package com.capgemini.studentexception.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.studentexception.exception.DebitLimitException;
import com.capgemini.studentexception.exception.LowBalanceException;
import com.capgemini.studentexception.main.CurrentBankAccount;

public class CurrentBankAccountTest {

	CurrentBankAccount currentAccount;

	@Before
	public void setUp() {
		currentAccount = new CurrentBankAccount(101, "Lahari", 24000, 20000);
	}

	@Test
	public void tesCurrentBankAccountIsCreatedWithDefaultConstructor() {
		CurrentBankAccount currentAccount = new CurrentBankAccount();
		assertNotNull(currentAccount);
	}

	@Test
	public void testCurrentBankAccountIsCreatedWithParametrizedConstructor() {
		assertEquals(101, currentAccount.getAccountId());
		assertEquals("Lahari", currentAccount.getAccountHolderName());
		assertEquals(24000.0, currentAccount.getAccountBalance(), 0.01);
		assertEquals(20000, currentAccount.getDebitLimit(), 0.01);

	}

	@Test
	public void testWithdrawAmountWithCurrentBalance() throws LowBalanceException, DebitLimitException {
		currentAccount.withdraw(24000);
		assertEquals(0, currentAccount.getAccountBalance(), 0.01);
	}

	@Test
	public void testWithdrawAmountWithoutExtendingDebitLimt() throws LowBalanceException, DebitLimitException {
		currentAccount.withdraw(34000);
		assertEquals(0, currentAccount.getAccountBalance(), 0.01);
	}

	@Test(expected = DebitLimitException.class)
	public void testWithdrawAmountWithExtendingDebitLimt() throws LowBalanceException, DebitLimitException {
		currentAccount.withdraw(55000);

	}

	@Test
	public void testDepositAmountWithBorrowedAmountGreaterThanZero() throws LowBalanceException, DebitLimitException {
		currentAccount.withdraw(20000);
		currentAccount.deposit(25000);
		assertEquals(29000, currentAccount.getAccountBalance(), 0.01);
	}

	@Test
	public void testDepositAmountWithBorrowedAmountEqualToZero() throws LowBalanceException, DebitLimitException {
		currentAccount.withdraw(24000);
		currentAccount.deposit(25000);
		assertEquals(25000, currentAccount.getAccountBalance(), 0.01);
	}

	@Test
	public void testDepositAmountWithBorrowedAmountLessThanZero() throws LowBalanceException, DebitLimitException {
		currentAccount.withdraw(34000);
		currentAccount.deposit(25000);
		assertEquals(15000, currentAccount.getAccountBalance(), 0.01);
	}
}
