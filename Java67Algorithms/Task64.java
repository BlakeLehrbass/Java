// 64. Implement Sieve of Eratosthenes Algorithm to find Prime numbers?

// O(n * log(log(n)))

// n represents the limit value of the method.

// The number of iterations of Loop A (see code)
// is equal to O( sqrt(n) ).
// For each iteration of Loop A,
// Loop B (see code) iterates a number of times equal to O( n / i ),
// with i being the current prime number being used,
// not exceeding sqrt(n).

// Together they can be expressed as:
// O( n/2 + n/3 + n/5 + n/7 + ... + n/sqrt(n) )
// Factoring out n from the numerator, we get:
// O( n * ( 1/2 + 1/3 + 1/5 + 1/7 + ... + 1/sqrt(n) ) ). (1)

// According to the Harmonic Series,
// ( 1/2 + 1/3 + 1/5 + 1/7 + ... + 1/sqrt(n) ),
// with all the denominators being prime numbers,
// is equal to log(log(sqrt(n))),
// which is essentially equal to log(log(n)).

// So by substituting that into (1),
// it shows that the algorithm has a time complexity of:
// O(n * log(log(n))).

// A more detailed (and probably better) explanation:
// https://www.geeksforgeeks.org/how-is-the-time-complexity-of-sieve-of-eratosthenes-is-nloglogn/

import java.util.*;

public class Task64 {

    public static void main( String[] args ) {

        // Gets all primes from 1-100 and prints them.
        int[] primes = SieveEratosthenesAlgorithm(100);

        System.out.println();
        System.out.print( "Primes: " );
        for ( int i = 0; i < primes.length; i++ ) {
            System.out.print( primes[i] + " " );
        }
        System.out.println();

    }

    // Returns all primes up to a certain limit.
    public static int[] SieveEratosthenesAlgorithm( int limit ) {

        boolean[] isComposite = new boolean[limit];
        isComposite[0] = true;
        int primeCount = 0;

        // For each prime number below the square root of the limit,
        // sets all multiples of that number to be a composite.
        for ( int i = 2; i <= Math.sqrt(limit); i++ ) { // LOOP A

            if ( !isComposite[i - 1] ) {

                // Starts at the square of i,
                // since i * a lower number
                // would've already been covered by that lower number.
                int j = i * i;
                while ( j <= limit ) { // LOOP B
                    // This number is a multiple of i,
                    // therefore it must be a composite.
                    isComposite[j - 1] = true;
                    j += i;
                }

            }

        }

        // Compiles list of all non-composite numbers.
        List<Integer> primes = new ArrayList<Integer>();

        for ( int i = 2; i < limit; i++ ) {
            if ( !isComposite[i - 1] ) {
                primes.add(i);
            }
        }

        // Returns prime numbers as an int[].
        return primes.stream().mapToInt(i -> i).toArray();

    }

}