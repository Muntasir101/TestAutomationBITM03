package com.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNGDemo2 {

	@Test(description="valid Email and valid password")
	public void Login4() {
		System.out.println("I am from Login");
	}

	@Test(description="Invalid Email and valid password")
	public void Login5() {
		System.out.println("I am from Login2");
	}
	
	@Test(enabled=false)
	public void Login6() {
		System.out.println("I am from Login3");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am from before Login");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am from After Login");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am from Before Class");
	}
	

	@AfterClass
	public void afterClass() {
		System.out.println("I am from After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am from Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am from After Test");
	}

}
