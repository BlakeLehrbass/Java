// 63. Implement the Radix Sort Algorithm?

// O(n*d)
// CountingSort takes linear time,
// and it is called for the number of digits (d).

public class Task63 {

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
        int[] sorted = RadixSort( numbers );

        System.out.println();
        System.out.print( "Sorted:   " );
        for ( int i = 0; i < sorted.length; i++ ) {
            System.out.print( sorted[i] + " " );
        }
        System.out.println();

    }

    // A sorting algorithm which sorts elements
    // using CountingSort for each digit place.
    public static int[] RadixSort( int array[] ) {

        if ( array == null || array.length == 0 ) {
            return array;
        }

        // Gets highest number in array.
        // Uses that to determine how many digit places to run CountingSort for.
        int highest = array[0];
        for ( int i = 1; i < array.length; i++ ) {
            if ( array[i] > highest ) {
                highest = array[i];
            }
        }

        // Runs CountingSort for each digit,
        // from lowest to highest place.
        for ( int place = 1; place <= highest; place *= 10 ) {
            array = CountingSort( array, place );
        }

        return array;

    }

    // Same as from Task60,
    // but accepts a parameter for what digit to examine when sorting.
    public static int[] CountingSort( int array[], int place ) {

        // For each 0-9 value,
        // counts the number of other values equal to or below that value.
        int[] c = new int[10];

        for ( int i = 0; i < array.length; i++ ) {
            c[ ( array[i] / place ) % 10 ]++;
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
            int digit = ( array[i] / place ) % 10;

            int index = c[digit] - 1;
            sorted[index] = array[i];
            // The corresponding c value is decreased,
            // so that if there is a duplicate of array[i],
            // it will be placed in an empty spot.
            c[digit]--;
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