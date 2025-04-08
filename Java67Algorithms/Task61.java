// 61. Implement the Insertion Sort Algorithm?

// O(n * n)
// For each item in the array,
// compares it with a number of values
// that also scales linearly with n.

public class Task61 {

    public static void main( String[] args ) {

        // Creates a random array of numbers and prints it.
        int[] numbers = new int[Random( 10, 20 )];

        System.out.println();
        System.out.print( "Unsorted: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 0, 100 );
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

        // Sorts and prints the numbers.
        InsertionSort( numbers );

        System.out.println();
        System.out.print( "Sorted:   " );
        for ( int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

    }

    // A simple sorting method
    // that for each value,
    // shifts earlier elements in the array until
    // the current value is in the right spot.
    public static void InsertionSort( int array[] ) {

        // Iterates for each value.
        for ( int i = 0; i < array.length; i++ ) {

            int index = i;
            int current = array[i];

            // Compares the current value to all earlier ones.
            // Each time it finds a higher value,
            // it will shift that value 1 to the right.
            // Once it finds an earlier value that is lower than itself,
            // it will end the loop and place the current value at that position.
            for ( int j = i - 1; j >= 0; j-- ) {
                if ( array[j] > current ) {
                    // Shifts value over.
                    array[j + 1] = array[j];
                    index = j;
                } else {
                    break;
                }
            }

            array[index] = current;

        }

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}