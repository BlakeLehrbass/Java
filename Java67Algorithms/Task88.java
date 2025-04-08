// 88. Reverse a given Integer in Java?

// O(n)
// Time taken increases linearly as the length of the number increases.

public class Task88 {

    public static void main( String[] args ) {

        System.out.println();
        for ( int i = 0; i < 5; i++ ) {
            int n = Random( 1, 100 );
            System.out.println( n + " reversed: " + Reverse( n ) );
        }

    }

    // Same as from Task88.
    // Returns the input number with the order of its digits reversed.
    public static int Reverse( int n ) {

        int reversed = 0;

        // For each digit in the original number,
        // multiplies the reverse value by 10 (shifting all digits 1 left),
        // adds that digit to the reverse number,
        // then divides the input number by 10 (effectively removing that digit).
        while ( n != 0 ) {
            reversed *= 10;
            reversed += n % 10;
            n /= 10;
        }

        return reversed;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}