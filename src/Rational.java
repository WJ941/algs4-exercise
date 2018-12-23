import edu.princeton.cs.algs4.StdOut;

public class Rational {
    private final int numerator;
    private final int denominator;
    public Rational(int num, int den)
    {
        assert den != 0 : "denominator must not be zero";
        int gcdThis = gcd(num, den);
        numerator = num / gcdThis;
        denominator = den / gcdThis;
    }
    public Rational plus(Rational b)
    {
        int newNumerator = numerator * b.denominator + b.numerator * denominator;
        int newDenominator = denominator * b.denominator;
        return new Rational(newNumerator, newDenominator);
    }
    public Rational minus(Rational b)
    {
        int newNumerator = numerator * b.denominator - b.numerator * denominator;
        int newDenominator = denominator * b.denominator;
        return new Rational(newNumerator, newDenominator);
    }
    public Rational times(Rational b)
    {
        int newNumerator = numerator * b.numerator;
        int newDenominator = denominator * b.denominator;
        return new Rational(newNumerator, newDenominator);
    }
    public Rational divides(Rational b)
    {
        if (b.numerator == 0) throw new IllegalArgumentException("divider must not be zero");
        return times(new Rational(b.denominator, b.numerator));
    }
    public boolean equals(Rational b)
    {
        if (numerator == b.numerator && denominator == b.denominator) return true;
        int gcdThis = gcd(numerator, denominator);
        int gcdB = gcd(b.numerator, b.denominator);
        if (numerator / gcdThis == b.numerator / gcdB
                && denominator / gcdThis == b.denominator / gcdB
        ) return true;
        return false;
    }
    public String toString()
    {
        return numerator + "/" + denominator;
    }
    private static int gcd(int p, int q)
    {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
    public static void main(String[] args)
    {
        Rational r1 = new Rational(3, 0);
        Rational r2 = new Rational(3, 4);
        StdOut.println("r1:       " + r1);
        StdOut.println("r2:       " + r2);
        StdOut.println("r1 + r2:  " + r1.plus(r2));
        StdOut.println("r1 - r2:  " + r1.minus(r2));
        StdOut.println("r1 * r2:  " + r1.times(r2));
        StdOut.println("r1 / r2:  " + r1.divides(r2));
        StdOut.println("r1 == r2: " + r1.equals(r2));
    }
}
