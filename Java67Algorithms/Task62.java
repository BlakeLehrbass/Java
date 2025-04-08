// 62. Implement a Merge Sort Algorithm?

// O(n*log(n))
// For each "level" of recursion,
// there are n comparisons.
// The number of levels of recursion
// is proportional to the number of times the array can be halved,
// which is proportional to log(n).

public class Task62 {

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
        int[] sorted = MergeSort( numbers );

        System.out.println();
        System.out.print( "Sorted:   " );
        for ( int i = 0; i < sorted.length; i++ ) {
            System.out.print( sorted[i] + " " );
        }
        System.out.println();

    }

    // A sorting algorithm that
    // recursively splits the array in half,
    // then recombines those halves in a sorted manner
    // before returning the sorted array.
    public static int[] MergeSort( int array[] ) {

        if ( array.length == 1 ) {
            return array;
        }

        // Splits the array into 2 halves.
        int mid = array.length / 2;

        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        for ( int i = 0; i < left.length; i++ ) {
            left[i] = array[i];
        }
        for ( int i = 0; i < right.length; i++ ) {
            right[i] = array[i + mid];
        }

        // Sorts each half of the array.
        int[] leftSorted = MergeSort(left);
        int[] rightSorted = MergeSort(right);

        return Merge( leftSorted, rightSorted );

    }

    // Combines both sorted arrays into a single sorted array and returns it.
    public static int[] Merge( int[] left, int[] right ) {

        int[] array = new int[left.length + right.length];
        int index = 0;

        int i = 0;
        int j = 0;

        // Compares the values of each array (which are already sorted),
        // adding the lower values first into the new array.
        while ( i < left.length && j < right.length ) {
            if ( left[i] < right[j] ) {
                array[index] = left[i];
                index++;
                i++;
            } else {
                array[index] = right[j];
                index++;
                j++;
            }
        }

        // Copies over the remainder of the values
        // (which are guaranteed to be ascending,
        // and higher than the most recent array value).
        for ( ; i < left.length; i++ ) {
            array[index] = left[i];
            index++;
        }
        for ( ; j < right.length; j++ ) {
            array[index] = right[j];
            index++;
        }

        return array;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}