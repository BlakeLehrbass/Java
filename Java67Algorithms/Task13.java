// 13. Find a missing number in a given integer array of 1 to 100?

// Note that from here on out, the number put here is 2 higher than the one on the website, because the website has 2 11s and 2 12s.

// Also, the problem says "find a missing number".
// Can there be more than 1 missing number? Not sure. I'll assume no.

// O(n)
// The time taken is proportional to the amount of numbers it must search.

public class Task13 {

    public static void main( String[] args ) {

        int min = 1;
        int max = 100;

        // Assembles an array of all numbers from 1-100,
        // but missing 1 randomly-determined number.
        int[] numbers = new int[max - min];
        int missingNumber = Random( min, max );

        System.out.println();
        System.out.println( "numbers:" );

        for ( int i = 0; i < numbers.length + 1; i++ ) {

            // Adds the number to the numbers array,
            // unless it is meant to be the missing number.
            int n = i + min;
            if ( n < missingNumber ) {
                numbers[i] = n;
                System.out.print( n + " " );
            } else if ( n > missingNumber ) {
                // The number is being added after the missing number was skipped,
                // meaning they must be added 1 index behind so that the numbers array has no gaps.
                numbers[i - 1] = n;
                System.out.print( n + " " );
            }

        }

        System.out.println();
        System.out.println();
        System.out.println( "missing number: " + GetMissingNumber( numbers, min, max ) );

    }

    // Returns the first number within the given range determined to be missing from the given array of numbers.
    public static int GetMissingNumber( int[] numbers, int min, int max ) {

        // The numbers array contains the given number.
        // Assumes that it is not necessarily sorted by value, and that there may be duplicates.

        // The min value represents the lowest possible value for numbers, and the max value represents the maximum possible value.

        // The numbersFound boolean[] contains a boolean variable for each number from min to max (including).
        // Each boolean variable in the array corresponds to whether or not a specific number has been found.
        // This number equal to the index of that variable, + min.

        boolean[] presentNumbers = new boolean[max - min + 1];
        // For each number in the numbers array,
        // sets the corressponding boolean value to be true.
        for ( int i = 0; i < numbers.length; i++ ) {

            int n = numbers[i];
            if ( n >= min && n <= max ) {
                presentNumbers[n - min] = true;
            }

        }

        // For each number, determines if it is present in the array. If not, then returns it.
        for ( int i = 0; i < presentNumbers.length; i++ ) {

            if ( !presentNumbers[i] ) {

                // This number was not found,
                // so returns it.
                return i + min;
            }

        }

        return -1;

    }

    // Generates a random number from the minimum to maximum value.
    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }
}