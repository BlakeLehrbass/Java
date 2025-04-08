// 65. Find GCD of two numbers using Euclid's Algorithm?

// O(log(a))

// Assume a > b
// (if not, it will be after 1 iteration anyway).
// After 1 iteration,
// ( a, b ) becomes ( b, a % b ).
// After 1 more,
// ( b, a % b ) becomes ( a % b, b % ( a % b ) ).
// If a > b,
// then a % b must be <= a / 2.
// Meaning that every 2 iterations,
// because the first term goes from a to a % b,
// the first term is decreased by at least a factor of 2,
// so the function is logarithmic.

public class Task65 {

    public static void main( String[] args ) {

        for ( int i = 0; i < 5; i++ ) {
            int a = Random( 20, 100 );
            int b = Random( 10, a );

            // Gets all primes from 1-100 and prints them.
            int gcf = EuclidianAlgorithm( a, b );

            System.out.println();
            System.out.printf( "GCF of %d and %d: %d", a, b, gcf );
            System.out.println();
        }

    }

    // An algorithm to get the GCF of 2 numbers.
    public static int EuclidianAlgorithm( int a, int b ) {

        // Repeatedly calculates the remainder between a and b
        // until the remainder is 0,
        // then returns a as the GCF.
        while ( b != 0 ) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}