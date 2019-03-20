package com.capgemini.studentexception.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.capgemini.studentexception.exception.CountryException;
import com.capgemini.studentexception.exception.NameException;
import com.capgemini.studentexception.exception.NotEligibleException;
import com.capgemini.studentexception.main.TaxCalculator;

public class TaxCalculatorTest {

	@Test
	public void testToCheckObjectIsCreatedByDefaultConstructor() {
		TaxCalculator taxCalculator = new TaxCalculator();
		assertNotNull(taxCalculator);
	}

	@Test
	public void testToCheckValidCountry() throws CountryException, NameException {
		TaxCalculator taxCalculator = new TaxCalculator("Lahari", true, 150000);

	}

	@Test(expected = CountryException.class)
	public void testToCheckNotValidCountry() throws CountryException, NameException {
		TaxCalculator taxCalculator = new TaxCalculator("Lahari", false, 150000);

	}

	@Test
	public void testToCheckValidName() throws CountryException, NameException {
		TaxCalculator taxCalculator = new TaxCalculator("Lahari", true, 150000);
	}
	@Test(expected = NameException.class)
	public void testToCheckNotValidName() throws CountryException, NameException {
		TaxCalculator taxCalculator = new TaxCalculator("", true, 150000);

	}
	@Test
	public void testToCaluclateTaxAbove1Lakh() throws CountryException, NameException, NotEligibleException {
		TaxCalculator taxCalculator = new TaxCalculator("Lahari", true, 150000);
		assertEquals(12000, taxCalculator.calculateTax(150000));
	}
	@Test
	public void testToCaluclateTaxBetween50000And1Lakh() throws CountryException, NameException, NotEligibleException {
		TaxCalculator taxCalculator = new TaxCalculator("Lahari", true, 80000);
		assertEquals(4800, taxCalculator.calculateTax(80000));
	}
	@Test
	public void testToCaluclateTaxBetween30000And50000() throws CountryException, NameException, NotEligibleException {
		TaxCalculator taxCalculator = new TaxCalculator("Lahari", true, 45000);
		assertEquals(2250, taxCalculator.calculateTax(45000));
	}
	@Test
	public void testToCaluclateTaxBetween10000And30000() throws CountryException, NameException, NotEligibleException {
		TaxCalculator taxCalculator = new TaxCalculator("Lahari", true, 120000);
		assertEquals(480, taxCalculator.calculateTax(12000));
	}
	@Test(expected=NotEligibleException.class)
	public void testToCaluclateTaxBelow10000() throws CountryException, NameException, NotEligibleException {
		TaxCalculator taxCalculator = new TaxCalculator("Lahari", true, 5000);
		 taxCalculator.calculateTax(5000);
	}
}
