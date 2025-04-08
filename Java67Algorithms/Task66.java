// 66. Check if a number is the power of two?

// O(1).
// Compares one number with another,
// taking constant time.

public class Task66 {

    public static void main( String[] args ) {

        for ( int i = 0; i < 10; i++ ) {
            int n = Random( 1, 32 );
            System.out.println();
            System.out.printf( "IsPowerOfTwo(%d): %b", n, IsPowerOfTwo(n) );
            System.out.println();
        }

    }

    // Returns true if the input is a power of 2,
    // returns false otherwise.
    public static boolean IsPowerOfTwo( int n ) {
        if ( n > 0 ) {
            // If n is a power of 2 (8 for example),
            // the binary representation would look like this:
            // 8: 000 ... 001000
            // And the negative would look like this:
            // -8: 111 ... 111000
            // This is basically the opposite of the binary for 7,
            // but -1 (because of the way that two's compliment works).
            // So the ( n * -n ) operation would yield the same result as n.

            // But if the number isn't a power of 2,
            // the binary representations would look quite different
            // and the result of the operation would be lower than n.

            return ( n & -n ) == n;
        }
        return false;
    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}