// 17. Find duplicate numbers in an array if it contains multiple duplicates?

// O(n*n)
// In the worst case scenario,
// compares every pair of numbers exactly once,
// so the time taken increases quadratically as the array of numbers gets longer.

public class Task17 {

    public static void main( String[] args ) {

        // Assembles an array of 10-20 numbers, each a random value from 1-100.
        int[] numbers = new int[Random( 10, 20 )];
        System.out.println();
        System.out.println( "Numbers: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 1, 100 );
            System.out.print( numbers[i] + " " );
        }

        // Finds all duplicates and prints them.
        int[] duplicates = GetAllDuplicates( numbers );
        System.out.println();
        System.out.println();
        System.out.println( "Duplicates: " );
        for ( int i = 0; i < duplicates.length; i++ ) {
            System.out.print( duplicates[i] + " " );
        }
        System.out.println();

    }

    // Returns an array of all duplicate numbers in an array of numbers.
    public static int[] GetAllDuplicates( int[] numbers ) {

        // Tracks all duplicate numbers.
        int[] duplicates = new int[0];

        // For each value,
        // compares it with all prior values.
        // If there is a match,
        // add it to the array of duplicates.
        for ( int i = 0; i < numbers.length; i++ ) {
            for ( int j = 0; j < i; j++ ) {
                if ( numbers[i] == numbers[j] ) {
                    // The number at index i is a duplicate of j,
                    // so it is added to the array of duplicates.
                    duplicates = Append( duplicates, numbers[i] );
                    break;
                }
            }
        }

        return duplicates;

    }

    // This method is used in order to add a value to the end of an array.
    public static int[] Append( int[] array, int a ) {

        // Copies over the elements of the previous array
        // into a new array with a length that is 1 longer.
        int[] arrayCopy = new int[array.length + 1];
        for ( int i = 0; i < array.length; i++ ) {
            arrayCopy[i] = array[i];
        }

        // Adds the new value.
        arrayCopy[array.length] = a;

        return arrayCopy;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}