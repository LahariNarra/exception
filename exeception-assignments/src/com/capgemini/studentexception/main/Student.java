package com.capgemini.studentexception.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.studentexception.exception.StudentAgeException;
import com.capgemini.studentexception.exception.StudentNameException;

public class Student {
	private int studentRegNo;
	private String studentName;
	private int studentAge;
	private String studentCourse;

	public Student() {
		super();
	}

	public Student(int studentRegNo, String studentName, int studentAge, String studentCourse) {
		super();
		this.studentRegNo = studentRegNo;

		if (!validateName(studentName))
			this.studentName = studentName;

		else
			throw new StudentNameException("Name is Not within valid exception");

		if (15 <= studentAge && studentAge <= 21)
			this.studentAge = studentAge;
		else
			throw new StudentAgeException("Age is Not within range exception");

		this.studentCourse = studentCourse;
	}

	public boolean validateName(String studentName) {
		Pattern p = Pattern.compile("[^a-zA-Z ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(studentName);
		boolean b = m.find();
		return b;
	}

}