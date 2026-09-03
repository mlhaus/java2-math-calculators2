package edu.kirkwood.model;

import java.util.Objects;

/**
 * Represents a fraction with an integer numerator and denominator.
 * This class provides methods for fraction arithmetic, simplification,
 * and comparison.
 */
public class Fraction implements Comparable<Fraction> {
    private int numerator;
    private int denominator;

    /**
     * Default constructor
     * Initializes a new fraction to 1/1
     */
    public Fraction() {
        numerator = 1;
        denominator = 1;
    }

    /**
     * Constructs a fraction with a specified numerator and denominator.
     *
     * @param numerator   the numerator of the fraction
     * @param denominator the denominator of the fraction
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Returns a string representation of the fraction in the format "numerator/denominator".
     *
     * @return a string representation of the fraction
     */
    @Override
    public String toString() {
        // Implementation needed
        return "";
    }

    /**
     * Gets the numerator of the fraction.
     *
     * @return the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Set the numerator of the fraction
     * @param numerator the top portion of a fraction
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }


    /**
     * Gets the denominator of the fraction.
     *
     * @return the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Sets the denominator of the fraction.
     *
     * @param denominator the new denominator
     * @throws ArithmeticException if the denominator is zero
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Compares this fraction to another fraction
     * @param o the other Fraction object to be compared.
     * @return a negative int, zero, or a positive int. Positives mean objects are out of sort order.
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * Determines if two fraction objects are the same
     *
     * @param o the other object to be compared.
     * @return a boolean true is both objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    /**
     * This method is supported for the benefit of hash tables such as HashMap and HashSet.
     *
     * @return an integer representing a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of a and b
     */
    public static int gcd(int a, int b) {
        // Implementation needed
        return 0;
    }

    /**
     * Calculates the least common multiple (LCM) of two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the least common multiple of a and b
     */
    public static int lcm(int a, int b) {
        // Implementation needed
        return 0;
    }

    /**
     * Simplifies this fraction to its lowest terms by dividing the numerator
     * and denominator by their greatest common divisor.
     */
    public void simplify() {
        // Implementation needed
    }

    /**
     * Converts this fraction to a mixed number string representation (e.g., "1 2/3").
     * If the fraction is a proper fraction, it returns the fraction itself.
     *
     * @return a string representation of the fraction as a mixed number
     */
    public String toMixedNumber() {
        // Implementation needed
        return "";
    }

    /**
     * Adds another fraction to this fraction.
     *
     * @param other the fraction to add
     * @return a new Fraction object representing the sum
     */
    public Fraction add(Fraction other) {
        // Implementation needed
        return null;
    }

    /**
     * Subtracts another fraction from this fraction.
     *
     * @param other the fraction to subtract
     * @return a new Fraction object representing the difference
     */
    public Fraction subtract(Fraction other) {
        // Implementation needed
        return null;
    }

    /**
     * Multiplies this fraction by another fraction.
     *
     * @param other the fraction to multiply by
     * @return a new Fraction object representing the product
     */
    public Fraction multiply(Fraction other) {
        // Implementation needed
        return null;
    }

    /**
     * Divides this fraction by another fraction.
     *
     * @param other the fraction to divide by (the divisor)
     * @return a new Fraction object representing the quotient
     * @throws IllegalArgumentException if the divisor is zero
     */
    public Fraction divide(Fraction other) {
        // Implementation needed
        return null;
    }

}
