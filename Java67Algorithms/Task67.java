// 67. Check if a number is even or odd without using a modulo operator?

// O(1).
// Compares one number with another,
// taking constant time.

public class Task67 {

    public static void main( String[] args ) {

        for ( int i = 0; i < 10; i++ ) {
            int n = Random( 1, 100 );
            System.out.println();
            System.out.printf( "IsEven(%d): %b", n, IsEven(n) );
            System.out.println();
        }

    }

    // Returns true if the number is even,
    // false if the number is odd.
    public static boolean IsEven( int n ) {
        // If the number is even,
        // then the bit at the '1' position would be off,
        // so the resulting number will be 0.
        return ( n & 1 ) == 0;
    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}