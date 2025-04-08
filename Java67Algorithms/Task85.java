// 85. Check if a given number is even/odd without using an Arithmetic operator?

// O(1)

public class Task85 {

    public static void main( String[] args ) {

        System.out.println();
        for ( int i = 0; i < 5; i++ ) {
            int n = Random( 1, 100 );
            System.out.println( n + " is odd? " + IsOdd( n ) );
        }

    }

    // Returns true if the number is odd,
    // returns false otherwise;
    public static boolean IsOdd( int n ) {
        if ( ( n & 1 ) == 1 ) {
            // Number is odd.
            return true;
        }
        // Number is even.
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