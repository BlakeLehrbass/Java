// 68. Subtract two binary numbers?

// O(1).
// The time taken isn't dependent on the size of either number,
// rather just the number of bits in an Integer.

import java.util.Stack;

public class Task68 {

    public static void main( String[] args ) {

        for ( int i = 0; i < 10; i++ ) {
            // Generates 2 random numbers.
            int a = Random( -8, 127 );
            int b = Random( -8, 127 );

            // Converts them to binary Strings.
            String aBinary = Integer.toBinaryString(a);
            String bBinary = Integer.toBinaryString(b);

            // Prints the number,
            // their binary Strings,
            // and the result of the subtraction.
            System.out.println();
            System.out.printf( "SubtractBinaries(%d,%d):", a, b );
            System.out.println();

            System.out.println( aBinary + " -" );
            System.out.println( bBinary + " =" );

            String result = SubtractBinariesA( aBinary, bBinary );
            System.out.println( result );
        }

    }

    // Returns the binary String of the result of a - b.
    public static String SubtractBinariesA( String a, String b ) {
        // Essentially just multiplies b by -1,
        // then returns a + b.
        String twosCompliment = GetTwosCompliment(b);
        return AddBinaries( a, twosCompliment );
    }

    // Returns the negative binary String of a given number.
    public static String GetTwosCompliment( String binary ) {
        // Returns the negative of the number,
        // represented using two's compliment.

        // This will be done by completely switching the 1s and 0s,
        // then adding 1.

        // Tracks each digit using a Stack.
        Stack<Integer> stack = new Stack<Integer>();

        for ( int i = binary.length() - 1; i >= 0; i-- ) {
            if ( binary.charAt(i) == '1' ) {
                stack.push(0);
            } else {
                stack.push(1);
            }
        }

        // If the binary string has a length of less than 32,
        // then it can be assumed that all leftmost numbers were 0s,
        // so they should be 1s now.
        for ( int i = 31 - binary.length(); i >= 0; i-- ) {
            stack.push(1);
        }

        // Builds String using Stack and StringBuilder.
        StringBuilder result = new StringBuilder();
        while ( !stack.isEmpty() ) {
            result.append(stack.pop());
        }

        // Adds 1 (because of how two's compliment works).
        return AddBinaries( result.toString(), "1" );

    }

    // Accepts 2 binary Strings of numbers,
    // and returns their sum as another binary String.
    public static String AddBinaries( String a, String b ) {
        // Adds the binary Strings together.

        // Tracks each digit using a Stack.
        Stack<Integer> stack = new Stack<Integer>();

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        int next;
        int carry = 0;

        while ( aIndex >= 0 || bIndex >= 0 ) {

            // If sum of both is 0,
            // result is 0.
            // If sum of both is 1,
            // result is 1.
            // If sum of both is 2,
            // set to 0 and add +1 to next digit sum.
            // If sum of both is 3,
            // set to 1 and add +1 to next digit sum.

            next = 0 + carry;
            carry = 0;
            if ( aIndex >= 0 ) {
                next += a.charAt(aIndex) - 48;
            }
            if ( bIndex >= 0 ) {
                next += b.charAt(bIndex) - 48;
            }
            if ( next > 1 ) {
                carry = 1;
                next -= 2;
            }

            stack.push(next);

            aIndex--;
            bIndex--;

        }

        // Adds an additional 1 if there is still a carried value
        // and there is space remaining.
        if ( carry > 0 && stack.size() < 32 ) {
            stack.push(1);
        }

        // Builds String using Stack and StringBuilder.
        StringBuilder result = new StringBuilder();

        // Removes any 0s from the front of the string.
        // This is because positive binary numbers are usually expressed without a huge list of 0s first.
        // at least according to Integer.toBinaryString(),
        // so it's good to be consistent.
        boolean skippingZero = true;
        while ( !stack.isEmpty() ) {
            int n = stack.pop();
            if ( !skippingZero || n == 1 ) {
                skippingZero = false;
                result.append(n);
            }
        }

        if ( skippingZero ) {
            // This means that the stack was just full of 0s,
            // so instead of returning an empty String,
            // returns "0".
            return "0";
        } else {
            return result.toString();
        }

    }

    // Of course, one could just do this instead.
    // That's probably not the intention of the question though.
    public static String SubtractBinariesB( String a, String b ) {
        // Parses with Long to avoid integer overflow (if either input is a negative number).
        int aInt = (int) Long.parseLong( a, 2 );
        int bInt = (int) Long.parseLong( b, 2 );
        return Integer.toBinaryString( aInt - bInt );
    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}