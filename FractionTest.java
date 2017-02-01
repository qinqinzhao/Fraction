package fraction;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class FractionTest {

	@Test
	public void testFraction1() {
		assertEquals("3/5", new Fraction(3,5).toString());
		assertEquals("-3/5", new Fraction(-6,10).toString());
		assertEquals("-7/3", new Fraction(21,-9).toString());
		assertEquals("7/3", new Fraction(-14,-6).toString());
		assertEquals("-2", new Fraction(10,-5).toString());
		assertEquals("0", new Fraction(0, 8).toString());
	}

	@Test
	public void testFraction2() {
		assertEquals("2", new Fraction(2).toString());
		assertEquals("0", new Fraction(0).toString());
		assertEquals("-5", new Fraction(-5).toString());
	}

	@Test
	public void testFraction3() {
		assertEquals("1/5", new Fraction("  1/5").toString());
		assertEquals("-9/10", new Fraction("-1 8/20  ").toString());
		assertEquals("-3/7", new Fraction("6 /-14").toString());
		assertEquals("6/7", new Fraction("-18/ -2 1").toString());
		assertEquals("0", new Fraction("0/5").toString());
		assertEquals("-2", new Fraction("6/-3").toString());
	}
	
	@Test
	public void testAdd() {
		Fraction f1 = new Fraction(2, 3);
		assertEquals("1", new Fraction(-1, -3).add(f1).toString());
		Fraction f2 = new Fraction(6, -10);
		assertEquals("-2/5", new Fraction(1, 5).add(f2).toString());
		Fraction f3 = new Fraction(-5, 20);
		assertEquals("0", new Fraction(1, 4).add(f3).toString());
	}
	
	@Test
	public void testSubtract() {
		Fraction f1 = new Fraction(2, 3);
		assertEquals("0", new Fraction(-6, -9).subtract(f1).toString());
		Fraction f2 = new Fraction(6, -10);
		assertEquals("7/20", new Fraction(2, -8).subtract(f2).toString());
		Fraction f3 = new Fraction(-5, -20);
		assertEquals("-1/4", new Fraction(0, 2).subtract(f3).toString());
	}
	
	@Test
	public void testMultiply() {
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(6, -10);
		Fraction f3 = new Fraction(-5, 20);
		assertEquals("-2/5", (f1.multiply(f2)).toString());
		assertEquals("-1/6", (f1.multiply(f3)).toString());
		assertEquals("3/20", (f2.multiply(f3).toString()));
	}
	
	@Test
	public void testDivide() {
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(6, -10);
		Fraction f3 = new Fraction(-5, 20);
		assertEquals("-10/9", (f1.divide(f2)).toString());
		assertEquals("-8/3", (f1.divide(f3)).toString());
		assertEquals("12/5", (f2.divide(f3).toString()));
	}
	
	@Test
	public void testAbs() {
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(6, -10);
		Fraction f3 = new Fraction(0, 20);
		assertEquals("2/3", f1.abs().toString());
		assertEquals("3/5", f2.abs().toString());
		assertEquals("0", f3.abs().toString());
	}
	
	@Test
	public void testNegate() {
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(6, -10);
		Fraction f3 = new Fraction(0, 20);
		assertEquals("-2/3", f1.negate().toString());
		assertEquals("3/5", f2.negate().toString());
		assertEquals("0", f3.negate().toString());
	}
	
	@Test
	public void testInverse() {
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(6, -10);
		Fraction f3 = new Fraction(-5, 5);
		assertEquals("3/2", f1.inverse().toString());
		assertEquals("-5/3", f2.inverse().toString());
		assertEquals("-1", f3.inverse().toString());
	}
	
	@Test
	public void testEquals() {
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(4, 6);
		Fraction f3 = new Fraction(2);
		Fraction f4 = new Fraction(4);
		assertTrue(f1.equals(f2));
		assertFalse(f3.equals(f4));
	}
	
	@Test
	public void testCompareTo() {
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(1, 4);
		Fraction f3 = new Fraction(2, -3);
		Fraction f4 = new Fraction(-5);
		Fraction f5 = new Fraction(-10, 2);
		assertTrue(f1.compareTo(f2) > 0);
		assertTrue(f3.compareTo(f4) > 0);
		assertTrue(f3.compareTo(f2) < 0);
		assertTrue(f5.compareTo(f4) == 0);
	}
	
	@Test
	public void testToString() {
		assertEquals("1/5", new Fraction(3, 15).toString());
		assertEquals("-3/4", new Fraction(6, -8).toString());
		assertEquals("-2", new Fraction(-2).toString());
		assertEquals("0", new Fraction(0, -2).toString());
	}

	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		assertEquals("2", new Fraction(2, 0).toString());
		assertEquals("2", new Fraction("2/0").toString());
		assertEquals("2", new Fraction(0, 2).inverse().toString());
	}
	
	@Test(expected = NumberFormatException.class)
	public void testMalFormedInput() {
		Fraction f1 = new Fraction("a1");
		Fraction f2 = new Fraction("2/");
		Fraction f3 = new Fraction("/3");
	}
	
	@Test(expected = ClassCastException.class) 
	public void testClassCast() {
		Fraction f1 = new Fraction(2, 3);
		assertTrue(f1.compareTo("a") > 0);
		assertTrue(f1.compareTo("b1") > 0);
		assertTrue(f1.compareTo("-") > 0);
	}
	
}
