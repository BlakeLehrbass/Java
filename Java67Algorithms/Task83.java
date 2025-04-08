// 83. Check if the given number is a prime number?

// O(sqrt(n))
// For a given number,
// at worst, evalutes all numbers from 2 - sqrt(n).

public class Task83 {

    public static void main( String[] args ) {

        System.out.println();
        for ( int i = 0; i < 10; i++ ) {

            int n = Random( 1, 100 );
            System.out.println( n + " is prime? " + IsPrime(n) );

        }

    }

    // Returns true if the number is prime,
    // returns false otherwise.
    public static boolean IsPrime( int n ) {

        // Gets remainder of it divided by any numbers <= its square root.
        // If any of the remainders is 0, the number has a factor and it is not prime.

        for ( int i = 2; i <= Math.sqrt(n); i++ ) {
            if ( n % i == 0 ) {
                return false;
            }
        }

        return true;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}