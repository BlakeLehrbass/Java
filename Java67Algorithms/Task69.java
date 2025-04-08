// 69. Find the number of 1s (the Set bit) in a given Bit Sequence?

// O(n)
// Scales linearly as the binary input gets longer.

import java.util.Stack;

public class Task69 {

    public static void main( String[] args ) {

        for ( int i = 0; i < 10; i++ ) {

            // Generates a random number.
            int a = Random( 0, 127 );
            // Converts it to binary.
            String binary = Integer.toBinaryString(a);

            int bitCount = CountBitsA(binary);

            System.out.println( a + ", " + binary );
            System.out.println( "Bit count: " + bitCount );
            System.out.println();

        }

    }

    // Accepts a binary String.
    // Returns the number of Set Bits (1s) in the number.
    public static int CountBitsA( String binary ) {
        int n = Integer.parseInt( binary, 2 );
        int count = 0;
        while ( n > 0 ) {
            // Each time this loop runs,
            // it removes the last '1' from the number.
            n &= n - 1;
            count++;
        }
        return count;
    }

    // A slightly uglier method.
    // Accepts a binary String.
    // Returns the number of Set Bits (1s) in the number.
    public static int CountBitsB( String binary ) {
        int count = 0;
        for ( int i = 0; i < binary.length(); i++ ) {
            if ( binary.charAt(i) == '1' ) {
                count++;
            }
        }
        return count;
    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}