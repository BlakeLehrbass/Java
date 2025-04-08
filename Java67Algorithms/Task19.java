// 19. Sort an integer array in place using the QuickSort algorithm?

// O(n*log(n))
// Consists of n loops of the QuickSort method,
// each of which takes an amount of time proportional to log(n).

public class Task19 {

    public static void main( String[] args ) {

        // Generates a random array of numbers and prints it.
        int[] numbers = new int[Random( 10, 20 )];

        System.out.println();
        System.out.print( "Unsorted: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 1, 100 );
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

        // Sorts and prints the numbers.
        QuickSort(numbers);

        System.out.println();
        System.out.print( "Sorted:   " );
        for ( int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

    }

    public static void QuickSort( int[] array ) {
        QuickSort( array, 0, array.length - 1 );
    }
    // A fast sorting algorithm
    // which works by continuously choosing a "pivot",
    // by which other numbers are to be shifted around in the array.
    public static void QuickSort( int array[], int begin, int end ) {

        if ( begin < end ) {
            // Gets the point at which the array should be split.
            int partitionIndex = Partition( array, begin, end );

            QuickSort( array, begin, partitionIndex - 1 );
            QuickSort( array, partitionIndex + 1, end );
        }

    }

    private static int Partition( int array[], int begin, int end ) {

        // Takes the last element as the pivot.
        // It doesn't really matter where it takes it from,
        // since the array is presumably in a random order anyway.
        int pivot = array[end];
        int i = (begin - 1);

        for ( int j = begin; j < end; j++ ) {
            if ( array[j] <= pivot ) {
                // If the element is less than the pivot,
                // it is placed before the pivot.
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;

        // Returns the point at which the array is split;
        // all values before this index are below or equal to the pivot,
        // and all values after are above the pivot.
        return i + 1;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}