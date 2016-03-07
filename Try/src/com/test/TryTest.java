package com.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.main.Try;

public class TryTest {
	Try bc;

	@Before
	public void setUp() throws Exception {
		bc = new Try();
	}

	@Ignore
	@Test
	public void testBracketCheck() {
		assertTrue(bc.check("test]"));
	}

	@Ignore
	@Test
	public void testFactorial() {
		assertEquals(2, bc.factorialNormal(2));
	}

	@Ignore
	@Test
	public void testBigInt() {
		assertEquals(2, bc.factorialBigInt(new BigInteger("2")));
	}

	@Ignore
	@Test
	public void testFibannocciIterator() {
		assertEquals("1123", bc.fibonacciIteratorLoop(4));
	}

	@Ignore
	@Test
	public void testFibannocciRecursive() {
		System.out.println(bc.fibonacciRecursiveLoop(4));
		assertEquals("1123", bc.fibonacciRecursiveLoop(4));
	}

	@Ignore
	@Test
	public void testFizzBuzz() {
		assertEquals("12Fizz4", bc.fizzBuzz(4));
	}

	@Ignore
	@Test
	public void testMatrix() {
		bc.new Matrix().main();
		// Enter the values
	}

	@Ignore
	@Test
	public void testStairCase() {
		bc.stairCase(6);
		// View the result
	}

	@Test
	public void testLeetSpeak() {
		assertEquals("4nudd", bc.generateLeetSpeak("anudd"));
	}

}
