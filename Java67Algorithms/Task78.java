// 78. Find the most significant prime factor of a given integral number?

// O(n)
// In the worst case,
// must iterate through all numbers from 2 to n.

import java.util.List;
import java.util.ArrayList;

public class Task78 {

    public static void main( String[] args ) {

        System.out.println();
        for ( int i = 0; i < 5; i++ ) {
            int n = Random( 1, 1000 );
            System.out.println( "Highest prime factor of " + n + ": " + GetHighestPrimeFactor(n) );
        }

    }

    // Returns the highest prime factor of a number.
    public static int GetHighestPrimeFactor( int n ) {

        int p;

        for ( p = 2; p <= n; p++ ) {
            if ( n % p == 0 ) {
                // p is a prime factor,
                // so divides the copy by p.
                n /= p;
                // Also decreases p by 1,
                // so that for the next iteration p will have the same value.
                p--;
            }
        }

        // When it returns p,
        // p will contain the highest prime factor of the number.
        return p;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}