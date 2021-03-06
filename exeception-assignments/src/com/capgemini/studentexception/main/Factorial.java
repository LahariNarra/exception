package com.capgemini.studentexception.main;

import com.capgemini.studentexception.exception.FactorialException;
import com.capgemini.studentexception.exception.InvalidInputException;

public class Factorial {
	private int number;

	public Factorial() {
		super();

	}

	public Factorial(int number) {
		super();
		this.number = number;
	}

	public long getFactorial(int number) throws InvalidInputException, FactorialException {
		long factorail = 1;
		if (number > 2) {
			while(number!=1) {
				factorail = number * factorail;
				number--;
			}
			
			if (factorail>Integer.MAX_VALUE || factorail < Integer.MIN_VALUE)
			{
				throw new FactorialException("Factorial is high input range");
			}
			return factorail;
		}	
		else
			throw new InvalidInputException("Number should be greater than 2");
	}

}