// 14. Find the duplicate number on a given integer array?

// Once more, I will assume that "the duplicate number" is singular.

// O(n*n)
// In the worst case scenario, it will have to compare every number with every other number.
// So it will scale quadratically as the quantity of numbers increases.
// Technically if the range of numbers is very limited,
// then it might take a roughly fixed amount of time if it's nearly guaranteed that there is a double for the first digit,
// but that's not really important.


// Imports for the Contains method.
import java.util.Arrays;

public class Task14 {

    public static void main( String[] args ) {

        // Generates a random set of numbers.
        // The amount of numbers is random from 25-100, and each number can be anything from 1 to 100.
        // There may be more than 1 duplicate number, or none at all.
        int[] numbers = new int[Random( 25, 50 )];

        System.out.println();
        System.out.println( "Numbers:" );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 1, 100 );
            System.out.print( numbers[i] + " " );
        }

        System.out.println();
        int duplicate = GetDuplicateNumber(numbers);
        if ( duplicate != -1 ) {
            System.out.println( "Duplicate: " + duplicate );
        } else {
            System.out.println( "No duplicates found" );
        }

    }

    // Returns a duplicate number found in an array of numbers.
    public static int GetDuplicateNumber( int[] numbers ) {

        for ( int i = 0; i < numbers.length; i++ ) {

            // Compares this number to numbers after it.
            // If they match, returns the value.
            // It only needs to search the numbers after it,
            // because it will have already been compared to all prior numbers.

            // Tecnhically this might not return the first duplicate number in the array,
            // since if they're structured like this:
            // 1, 2, 2, 1
            // it would return 1 first, before 2, even though the first instance of 1 isn't really a duplicate.
            for ( int j = i + 1; j < numbers.length; j++ ) {
                if ( numbers[j] == numbers[i] ) {
                    return numbers[i];
                }
            }

        }

        // Technically if the input numbers had a -1 in them,
        // then this would get confusing.
        // But in this example it doesn't.
        return -1;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }
}