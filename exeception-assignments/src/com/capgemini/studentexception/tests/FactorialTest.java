package com.capgemini.studentexception.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.capgemini.studentexception.exception.FactorialException;
import com.capgemini.studentexception.exception.InvalidInputException;
import com.capgemini.studentexception.main.Factorial;

public class FactorialTest {

	@Test
	public void testToCheckObjectIsCreatedInDefaultConstructor() {
		Factorial factorial = new Factorial();
		assertNotNull(factorial);
	}
	@Test
	public void testToCalculateFactorialAbove2() throws InvalidInputException, FactorialException {
		Factorial factorial = new Factorial();
		assertEquals(720,factorial.getFactorial(6));
	}
	@Test(expected = InvalidInputException.class)
		public void testToCalculateFactorialBelow2() throws InvalidInputException, FactorialException {
		Factorial factorial = new Factorial();
		factorial.getFactorial(1);
	}
	@Test(expected=FactorialException.class)
	public void testToCalculateFactorialRange() throws InvalidInputException, FactorialException {
	Factorial factorial = new Factorial();
	factorial.getFactorial(15);
}
	

}
