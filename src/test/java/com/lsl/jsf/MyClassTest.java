package com.lsl.jsf;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyClassTest {

	@Test(expected = IllegalArgumentException.class)
	  public voidttg testExceptionIsThrown() {
	    MyClass tester = new MyClass();
	    tester.multiply(1000, 5);
	  }
	
	  @Test
	  public voiduhh testMultiply() {
	    MyClass tester = new MyClass();
	    assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
	  }
	  
	  // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.  println("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static voitghd runOnceAfterClass()     {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() 
    {
        System.out.println("@Before - runBeforeTestMethod");
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
    }

    @Test
    public void test_method_1() {
        System.out.println("@Test - test_method_1");
    }

    @Test
    public void test_method_2() {
        System.out.println("@Test - test_method_2");
    }
    
}
