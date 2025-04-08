// 76. Find all prime factors of a given number?

// O(n)
// Time taken increases linearly for each prime factor the number has.

import java.util.List;
import java.util.ArrayList;

public class Task76 {

    static int[] primes;

    public static void main( String[] args ) {

        // For simplicity and speed,
        // the primes will be generated first.
        primes = SieveEratosthenesAlgorithm( 1000 );


        for ( int i = 0; i < 5; i++ ) {

            int n = Random( 1, 1000 );

            System.out.print( "Prime factors of " + n + ": " );
            List<Integer> primeFactors = GetPrimeFactors(n);
            for ( int j : primeFactors ) {
                System.out.print( j + " " );
            }
            System.out.println();

        }

    }

    // Returns an array of all prime factors of the number.
    public static List<Integer> GetPrimeFactors( int n ) {
        List<Integer> list = new ArrayList<Integer>();
        return GetPrimeFactors( n, list );
    }
    public static List<Integer> GetPrimeFactors( int n, List<Integer> list ) {

        // The final returned array should be such that
        // all of the numbers are prime,
        // and the product of all of the numbers is equal to the number.

        // Finds the first prime number for which,
        // when the number is divided by that prime
        // the remainder is 0.
        // Then adds that prime to the list,
        // and recursively calls itself again with n / the prime.

        // Or if the prime exceeds half the number,
        // then it returns the list as-is.

        for ( int i = 0; i < primes.length; i++ ) {

            int prime = primes[i];
            if ( n % prime == 0 ) {
                // The next prime factor has been found.
                list.add(prime);
                return GetPrimeFactors( n / prime, list );
            }
            if ( i > 0 && prime > n / primes[i - 1] ) {
                // The prime is too large,
                // meaning this number has no more prime factors,
                // so just returns itself.
                if ( n > 1 ) {
                    list.add(n);
                }
                return list;
            }

        }

        return list;

    }

    // Taken from Task 64
    // Returns all primes up to a certain limit.
    public static int[] SieveEratosthenesAlgorithm( int limit ) {

        boolean[] isComposite = new boolean[limit];
        isComposite[0] = true;
        int primeCount = 0;

        // For each prime number below the square root of the limit,
        // sets all multiples of that number to be a composite.
        for ( int i = 2; i <= Math.sqrt(limit); i++ ) {

            if ( !isComposite[i - 1] ) {

                // Starts at the square of i,
                // since i * a lower number
                // would've already been covered by that lower number.
                int j = i * i;
                while ( j <= limit ) {
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

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}