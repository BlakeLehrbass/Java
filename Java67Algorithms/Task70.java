// 70. Swap two numbers without using the third variable?

// O(1)
// Number of operations performed is indifferent to
// what the numbers actually are.

public class Task70 {

    public static void main( String[] args ) {

        for ( int i = 0; i < 10; i++ ) {
            // Creates 2 numbers and prints them.
            int a = Random( 0, 100 );
            int b = Random( 0, 100 );

            System.out.println( "a, b: " + a + ", " + b );

            // Swaps their values without a third variable.
            // To show the logic here,
            // aI and bI are used to indicate each variable's original value.
            a += b; // a = aI + bI
            b = a - b; // b = ( aI + bI ) - bI = aI
            a = a - b; // b = ( aI + bI ) - aI = bI

            System.out.println( "Swapped:" );
            System.out.println( "a, b: " + a + ", " + b );
            System.out.println();
        }

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}