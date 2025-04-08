// 82. Calculate the square root of a given number?

// O(log(n))
// Like a Binary Search,
// each iteration halves the amount of remaining values to consider,
// making it operate in logarithmic time.

public class Task82 {

    public static void main( String[] args ) {

        System.out.println();
        for ( int i = 0; i < 10; i++ ) {

            int n = Random( 1, 100 );
            System.out.println( "Root of " + n + ": " + GetSquareRoot(n) );

        }

    }

    // Returns the square root of the number,
    // without using built-in methods like Math.sqrt().
    // Only goes to a certain level of precision.
    public static double GetSquareRoot( int n ) {

        if ( n == 1 || n == 0 ) {
            return n;
        }
        if ( n < 0 ) {
            return -1;
        }

        // Similar to a Binary Search,
        // establishes a low and high value.
        // Every iteration, gets the value between them (mid),
        // and evaluates that as a hypothetical square root.
        // If mid^2 is too low,
        // sets the low value to mid.
        // Or if mid^2 is too high,
        // sets the high value to mid.
        // Or if mid^2 is close enough to the target number,
        // returns mid.
        double low = 0;
        double high = n;
        double mid = n / 2;
        double square = 0;

        // The acceptable difference between the square and the input number.
        double precision = 0.00001;
        double difference = 100;

        // Repeats until the difference is within the acceptable range.
        while ( difference > precision || difference < -precision ) {

            mid = ( high + low ) / 2;
            square = mid * mid;

            if ( square > n ) {
                // Brings high down to mid.
                high = mid;
            } else {
                // Brings low up to mid.
                low = mid;
            }

            difference = square - n;

        }

        return mid;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}