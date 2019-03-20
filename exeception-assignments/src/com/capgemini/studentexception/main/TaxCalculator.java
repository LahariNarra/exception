package com.capgemini.studentexception.main;

import org.hamcrest.core.IsNull;

import com.capgemini.studentexception.exception.CountryException;
import com.capgemini.studentexception.exception.NameException;
import com.capgemini.studentexception.exception.NotEligibleException;

public class TaxCalculator {
	private String employeeName;
	private boolean isIndian;
	private double employeeSalary;
	private double taxAmount;

	public TaxCalculator() {
		super();
	}

	public TaxCalculator(String employeeName,boolean isIndian, double employeeSalary)
			throws CountryException, NameException {
		super();

		if (employeeName != null && !employeeName.isEmpty())
			this.employeeName = employeeName;
		else
			throw new NameException("Name is not valid exception");
		if (!isIndian)
			throw new CountryException("Country is Not valid exception");
			
		else
			this.isIndian = isIndian;
		this.employeeSalary = employeeSalary;
	}

	public double calculateTax(double employeeSalary) throws NotEligibleException {
		if (employeeSalary >= 100000)
			return (employeeSalary * 0.08);
		else if (employeeSalary >= 50000 && employeeSalary < 100000)
			return (employeeSalary * 0.06);
		
		else if (employeeSalary >= 30000 && employeeSalary < 50000)
			return (employeeSalary * 0.05);
		else if (employeeSalary >= 10000 && employeeSalary < 30000)
			return (employeeSalary * 0.04);
		else
		throw new NotEligibleException("Your salary is not eligible for tax");
	}

}
