// 60. Implement the Counting Sort Algorithm?

// O(n + k)
// Time increases linearly as n and k increase.
// n represents the array length,
// and k represents the total number of unique values possible (-1).

public class Task60 {

    public static void main( String[] args ) {

        // Creates a random array of numbers and prints it.
        int[] numbers = new int[Random( 5, 10 )];
        int k = 5;

        System.out.println();
        System.out.print( "Unsorted: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 0, k );
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

        // Sorts and prints the numbers.
        int[] sorted = CountingSort( numbers, k );

        System.out.println();
        System.out.print( "Sorted:   " );
        for ( int i = 0; i < sorted.length; i++ ) {
            System.out.print( sorted[i] + " " );
        }
        System.out.println();

    }

    // A sorting method which requires an input for the maximum value.
    // It keeps track of the number of equal or lower values for each 0-k value,
    // and uses that to determine where to place each value
    // (k is the maximum value present in the array).
    // Best used when k is much lower than the length of the array.
    public static int[] CountingSort( int array[], int k ) {

        // For each 0-k value,
        // counts the number of other values equal to or below that value.
        int[] c = new int[k + 1];

        for ( int i = 0; i < array.length; i++ ) {
            c[array[i]]++;
        }
        for ( int i = 1; i < c.length; i++ ) {
            c[i] += c[i - 1];
        }

        // Creates new array to store sorted values.
        int[] sorted = new int[array.length];

        // Iterates through the original array backwards.
        for ( int i = array.length - 1; i >= 0; i-- ) {
            // Using the value in c correspoding to the value of array[i],
            // determines where it should place the value.
            int index = c[array[i]] - 1;
            sorted[index] = array[i];
            // The corresponding c value is decreased,
            // so that if there is a duplicate of array[i],
            // it will be placed in an empty spot.
            c[array[i]]--;
        }

        // Returns sorted array.
        return sorted;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}