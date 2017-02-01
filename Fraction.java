package fraction;

public class Fraction implements Comparable {
    private int numerator, denominator;
    
    /**
     * Computes the greatest common divisor of two integers.
     * @param p, q The two integers.
     * @return The greatest common divisor of p and q.
     */
    private int gcd(int p, int q) {
    	p = Math.abs(p);
    	q = Math.abs(q);
        if (q == 0) {
            return p;
        }
        else {
            return gcd(q, p % q);
        }
    }
    
    /**
     * Normalizes the fraction.
     * Throws an exception if the denominator is zero.
     * @param numerator An integer as the numerator of the fraction.
     * @param denominator An integer as the denominator of the fraction.
     */
	public Fraction(int numerator, int denominator) {
		int gcd = gcd(numerator, denominator);
		if (denominator == 0) {
            throw new ArithmeticException("Divide by zero");
        } else if (denominator < 0 ) {
        	this.numerator = numerator * -1 / gcd;
        	this.denominator = denominator * -1 / gcd;
        } else {
	        this.numerator = numerator / gcd;
	        this.denominator = denominator / gcd;
        }
	}
	
	/**
	 * Transforms whole numbers into fraction format (1 as the denominator).
	 * @param wholeNumber A whole number.
	 */
	public Fraction(int wholeNumber) {
		this(wholeNumber, 1);
	}
	
	/**
	 * Generates a fraction from a given string.
	 * Throws an ArithmeticException if given a string representing a fraction whose 
	 * denominator is zero.
	 * Throws an NumberFormatException if the string does not follow the following two formats:
	 * 1) a; 2) a/b (blanks are allowed).
	 * @param fraction A String containing either a whole number, such as "5" or " -3", 
	 *        or a fraction, such as "8/ -12".
	 */
	public Fraction(String fraction) {
		fraction = fraction.replaceAll("\\s", "");
		if (fraction == null || fraction.length() == 0 ||
			fraction.matches("( *)(-?)( *)([0-9])+( *)(([/])( *)(-?)( *)([0-9])+)?") == false) {
			throw new NumberFormatException();
		}
        if (fraction.indexOf("/") == -1) {
			int wholeNumber = Integer.parseInt(fraction);
			this.numerator = wholeNumber;
			this.denominator = 1;
		} else {
			if (fraction.substring(fraction.indexOf("/") + 1).equals("0")) {
				throw new ArithmeticException("Divide by zero");
			}
			int numerator = Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
			int denominator = Integer.parseInt(fraction.substring(fraction.indexOf("/") + 1));
			int gcd = gcd(numerator, denominator);
			if (denominator < 0 ) {
	        	this.numerator = numerator * -1 / gcd;
	        	this.denominator = denominator * -1 / gcd;
	        } else if (denominator > 0) {
		        this.numerator = numerator / gcd;
		        this.denominator = denominator / gcd;
	        }
		}
	}

	/**
	 * Computes the sum of this fraction and the fraction f.
	 * @param f The given fraction.
	 * @return A new Fraction that is the sum of the two fractions. 
	 */
	public Fraction add(Fraction f) {
		return new Fraction(this.numerator * f.denominator + this.denominator * f.numerator, 
				            this.denominator * f.denominator);
	}
	
	/**
	 * Computes the difference of this fraction and the fraction f.
	 * @param f The given fraction.
	 * @return A new Fraction that is the difference of the two fractions. 
	 */
	public Fraction subtract(Fraction f) {
		return new Fraction(this.numerator * f.denominator - this.denominator * f.numerator,
				            this.denominator * f.denominator);
		
	}
	
	/**
	 * Computes the product of this fraction and the fraction f.
	 * @param f The given fraction.
	 * @return A new Fraction that is the product of the two fractions. 
	 */
	public Fraction multiply(Fraction f) {
		return new Fraction(this.numerator * f.numerator, this.denominator * f.denominator);
	}
	
	/**
	 * Computes the quotient of this fraction and the fraction f.
	 * @param f The given fraction.
	 * @return A new Fraction that is the quotient of the two fractions.
	 */
	public Fraction divide(Fraction f) {
		return new Fraction(this.numerator * f.denominator, this.denominator * f.numerator);
	}
	
	/**
	 * Computes the absolute value of this fraction.
	 * @return A new Fraction that is the absolute value of this fraction.
	 */
	public Fraction abs() {
		return new Fraction(Math.abs(numerator), Math.abs(denominator));
	}
	
	/**
	 * Computes the negate of this fraction; that is, a value that has the same numeric value 
	 * of the original fraction, but the opposite sign.
	 * @return A new Fraction that is the negate of this fraction.
	 */
	public Fraction negate() {
		return new Fraction(numerator * -1, denominator);
	}
	
	/**
	 * Inverses the numerator and denominator of this fraction (a/b to be b/a).
	 * Throws an ArithmeticException if the numerator of this fraction is zero.
	 * @return A new Fraction that is the inverse of this fraction.
	 */
	public Fraction inverse() {
		if (numerator != 0) { 
			return new Fraction(denominator, numerator);
		} else {
			throw new ArithmeticException();
		}
	}
	
	/**
	 * Returns true if o is a fraction equal to this fraction, and false in all other cases.
	 * Is used for assertEquals(expected, actual) JUnit tests.
	 */
	@Override
	public boolean equals(Object o) {
		Fraction f = (Fraction) o;
		if (this.numerator * f.denominator == f.numerator * this.denominator) {
            return true;
        } else {
            return false;
        }
	}
	
	/**
	 * If o is a fraction or an integer, returns:
	 * <ol>
	 *   <li>A negative integer if this is less than o.</li>
	 *   <li>Zero if this is equal to o. </li>
	 *   <li>A positive integer if this is greater than o. </li>
	 * </ol>
	 * If o is neither a Fraction nor an integer, throws a ClassCastException.
	 */
	@Override
	public int compareTo(Object o) {
		if (o instanceof Fraction) {
            Fraction f = this.subtract((Fraction) o);
            return f.numerator * f.denominator;
        } else if (o instanceof Integer) {
            Fraction f = this.subtract(new Fraction((Integer) o));
            return f.numerator * f.denominator;
        } else {
            throw new ClassCastException("o is neither a Fraction nor an int");
        } 
	}
	
	/**
	 * Returns a fraction in string format.
	 * @return A string of the form n/d (n is the numerator and d is the denominator), 
	 *         or just n if d is 1. 
	 */ 
	@Override
	public String toString() {
		if (denominator != 1) {
			return (numerator + "/" + denominator);
		} else {
			return Integer.toString(numerator);
		}
	}
	
	/**
	 * Gets the numerator of this fraction (is used in FractionCalculator.java)
	 * @return The numerator of this fraction.
	 */
	public int getNumerator() {
		return this.numerator;
	}
	
	/**
	 * Gets the denominator of this fraction.
	 * @return The denominator of this fraction.
	 */
	public int getDenominator() {
		return this.denominator;
	}

}
