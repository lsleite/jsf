package com.lsl.jsf;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyClassTest {

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		MyClass tester = new MyClass();
		tester.multiply(1000, 5);
	}

	@Test
	public void testMultiply() {
		MyClass tester = new MyClass();
		assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
	}

	// Run once, e.g. Database connection, connection pool
	@BeforeClass
	public static void runOnceBeforeClass() {
		System.out.println("@BeforeClass - runOnceBeforeClass");
	}

	// Run once, e.g close connection, cleanup
	@AfterClass
	public static void runOnceAfterClass() {
		System.out.println("@AfterClass - runOnceAfterClass");
	}

	// Run once for each @Test method
	// Creating an similar object and share for all @Test
	@Before
	public void runBeforeTestMethod() {
		System.out.println("@Before - runBeforeTestMethod");
	}
	//@Test method cleanup
	@After
	public void runAfterTestMethod() {
		System.out.println("@After - runAfterTestMethod");
	}

}
