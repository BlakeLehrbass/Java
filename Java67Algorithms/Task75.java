// 75. Check if a given number is an Armstrong number?

// O(n)
// Scales linearly as the number gets longer.

public class Task75 {

    public static void main( String[] args ) {
        int n = 1634;
        System.out.println( n + " is armstrong number? " + IsArmstrongNumber(n) );
        n = 1001;
        System.out.println( n + " is armstrong number? " + IsArmstrongNumber(n) );
        n = 153;
        System.out.println( n + " is armstrong number? " + IsArmstrongNumber(n) );
        n = 1;
        System.out.println( n + " is armstrong number? " + IsArmstrongNumber(n) );
        n = -1;
        System.out.println( n + " is armstrong number? " + IsArmstrongNumber(n) );
        n = 0;
        System.out.println( n + " is armstrong number? " + IsArmstrongNumber(n) );
    }

    // Returns true if the number is an armstrong number,
    // returns false otherwise.
    public static boolean IsArmstrongNumber( int n ) {

        if ( n < 0 ) {
            // Armstrong numbers can't be negative (apparently).
            return false;
        } else if ( n == 0 ) {
            // 0 has to be returned here,
            // otherwise it'll cause a problem with the log function.
            return true;
        }

        // An armstrong number (also known as a "narcissistic number"
        // is a number which is equal to the sum of all of its digits
        // each raised to the power of the number of digits.

        // Gets the sum of each digit raised to the power of the number of digits,
        // returns true if the sum equals the original number.

        int nCopy = n;
        int sum = 0;
        int k = (int) ( Math.log10(n) + 1 );

        while ( nCopy != 0 ) {

            int digit = nCopy % 10;
            sum += Math.pow( digit, k );
            nCopy /= 10;

        }

        // System.out.println( "  n, sum: " + n + ", " + sum );
        return n == sum;

    }

}
