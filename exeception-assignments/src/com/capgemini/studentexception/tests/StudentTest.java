package com.capgemini.studentexception.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.capgemini.studentexception.exception.StudentAgeException;
import com.capgemini.studentexception.exception.StudentNameException;
import com.capgemini.studentexception.main.Student;

public class StudentTest {

	@Test
	public void testToCheckStudentObjectWithDefaultconstructor() {
		Student student = new Student();
		assertNotNull(student);
	}

	@Test(expected = StudentAgeException.class)
	public void testToCheckAgeisNotWithinRange() {
		Student student = new Student(78, "Lahari", 22, "Btech");

	}

	@Test
	public void testToCheckAgeisWithinRange() {
		Student expected = new Student(79, "Narra", 20, "Btech");

	}

	@Test(expected = StudentNameException.class)
	public void testToCheckNameisNotValidException() {
		Student student = new Student(78, "L@*ari", 22, "Btech");

	}

	@Test
	public void testToCheckNameIsValidException() {
		Student expected = new Student(78, "Lahari", 20, "Btech");

	}

}