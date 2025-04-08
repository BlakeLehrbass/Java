// 84. Add two numbers without using the plus operator in Java?

// O(log(b))
// Time taken is proportional to the number of bits in b.

public class Task84 {

    public static void main( String[] args ) {

        System.out.println();
        for ( int i = 0; i < 5; i++ ) {
            int a = Random( 1, 100 );
            int b = Random( 1, 100 );
            System.out.println( a + " + " + b + " = " + AdditionA( a, b ) );
        }

    }

    // Returns the sum of the 2 numbers.
    // Uses no mathematical operators (such as +, -, *, or /).
    public static int AdditionA( int a, int b ) {

        int carry;

        // Repeats until b is equal to 0
        // (meaning the carry is 0, so a is the entire sum).
            System.out.println( "a, b: " + a + ", " + b );
        while ( b != 0 ) {

            // Sets the carry to be all bits that are 1 for both a and b.
            carry = a & b;

            // Sets a to be the addition of a and b, without the carried values.
            a = a ^ b;

            // The carry has "1" at every bit where a and b both had 1s.
            // So much like with regular addition,
            // the 1 should be "carried over" to the left.
            b = carry << 1;

            System.out.println( "a, b: " + a + ", " + b );

        }

        return a;

    }

    // Returns the sum of the 2 numbers.
    // Technically it does not use the + operator...
    // This is not the intended solution though.
    public static int AdditionB( int a, int b ) {
        return a - - b;
    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}