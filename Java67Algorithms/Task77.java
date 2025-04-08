// 77. Check if a given number is positive or negative in Java?

// O(1)

public class Task77 {

    public static void main( String[] args ) {

        double n = 100;
        System.out.println( n + " is positive? " + IsPositive(n) );
        n = -100;
        System.out.println( n + " is positive? " + IsPositive(n) );
        n = Double.POSITIVE_INFINITY;
        System.out.println( n + " is positive? " + IsPositive(n) );
        n = Double.NEGATIVE_INFINITY;
        System.out.println( n + " is positive? " + IsPositive(n) );

    }

    public static boolean IsPositive( double n ) {

        if ( n < 0 ) {
            // Number is negative.
            return false;
        } else {
            // Number is positive.
            // Technically 0 might not be a positive number,
            // but it shouldn't matter too much.
            return true;
        }

    }

}