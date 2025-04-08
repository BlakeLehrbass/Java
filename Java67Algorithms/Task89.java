// 89. Convert a decimal number to binary in Java?

// O(1)
// Always has to add the same number of digits to the result,
// regardless of the inputted number.

public class Task89 {

    public static void main( String[] args ) {

        // Confirm results with: https://www.h-schmidt.net/FloatConverter/IEEE754.html
        double d = 1;
        System.out.println( d + " as binary: " + DecimalToBinary(d) );
        d = 2.5;
        System.out.println( d + " as binary: " + DecimalToBinary(d) );
        d = 0.1;
        System.out.println( d + " as binary: " + DecimalToBinary(d) );
        d = -10.24;
        System.out.println( d + " as binary: " + DecimalToBinary(d) );
        d = 0;
        System.out.println( d + " as binary: " + DecimalToBinary(d) );

    }

    // Returns the given double as a binary String,
    // using the "EEE 754 floating point" format.
    // For easier readability,
    // distinct sections are separated with spaces.
    public static String DecimalToBinary( double d ) {

        // Converts it to a binary String.
        // The first digit is the sign (0 is positive, 1 is negative).
        // The next 8 are for the exponent.
        // The next 53 are for the "mantissa",
        // which is basically just the number part of the number,
        // ranging from 1 to almost 2.

        // Tracks each digit using a StringBuilder.
        StringBuilder result = new StringBuilder();

        // Adds the sign digit.
        if ( d >= 0 ) {
            result.append(0);
        } else {
            result.append(1);
            d *= -1;
        }

        // Finds the exponent value.
        int exponent = 0;

        // As long as the double is >= 2,
        // the exponent must be increased.
        while ( d >= 2 ) {
            d /= 2;
            exponent++;
        }
        // As long as the double is < 1,
        // the exponent must be decreased.
        while ( d < 1 && exponent > -127 ) {
            d *= 2;
            exponent--;
        }

        result.append( "   " );

        // Adds the exponent's digits to the String.

        // The exponent is -127 by default if all bits are 0.
        exponent += 127;
        for ( int i = 7; i >= 0; i-- ) {
            int v = (int) Math.pow( 2, i );
            if ( exponent >= v ) {
                result.append(1);
                exponent -= v;
            } else {
                result.append(0);
            }
        }

        result.append( "   " );

        // Now generates the mantissa.
        // Each digit represents a value equal to 1 / 2^index,
        // with the leftmost being index 1 and each after being 1 higher.

        // The mantissa is 1 by default if all bits are 0.
        d -= 1;
        for ( int i = 1; i < 54; i++ ) {

            double v = 1 / Math.pow( 2, i );

            if ( d >= v ) {
                // The mantissa is more than what the current bit represents,
                // so that bit must be on.
                d -= v;
                result.append(1);
            } else {
                result.append(0);
            }

        }

        // Returns the final String.
        return result.toString();

    }

}