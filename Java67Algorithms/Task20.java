// 20. Remove duplicates from an array in place?

// O(n*log(n))
// First sorts the array using the QuickSort algorithm,
// which has a time complexity of O(n*log(n)).
// Afterwards, iterates through every value in the array,
// comparing it to one other value.
// So the time taken overall is O(n*log(n) + n),
// which is just O(n*log(n)).

public class Task20 {

    public static void main( String[] args ) {

        // Creates a random array of numbers and prints it.
        int[] numbers = new int[Random( 10, 20 )];

        System.out.println();
        System.out.print( "Unsorted and with duplicates:  " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 1, 20 );
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

        // Sorts the array, removing duplicates, and prints it.
        SortAndRemoveDuplicates(numbers);

        System.out.println();
        System.out.print( "Sorted and without duplicates: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

    }

    // Sorts the array,
    // and replaces all duplicate values with 0s.
    public static void SortAndRemoveDuplicates( int[] numbers ) {

        // First sorts array.
        QuickSort( numbers );

        // Sorting it "in place" means without a second array,
        // which means the length of the array can't be changed.
        // Instead, all duplicate values are replaced with 0s.

        // Starts at the end of the array and moves backwards.
        // This ensures that the first instance of each value will be kept.
        for ( int i = numbers.length - 1; i >= 0; i-- ) {
            // Because the array is already sorted,
            // any duplicate numbers will be adjacent.
            // Meaning each number only needs to be compared to the number before it.
            if ( i != 0 && numbers[i] == numbers[i - 1] ) {
                // The number is a duplicate, so it is replaced with 0.
                numbers[i] = 0;
            }
        }

    }

    // These are just taken from Task19.

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

    // A method to add numbers to the end of arrays.
    public static int[] Append( int[] array, int n ) {
        if ( array == null || array.length == 0 ) {
            array = new int[1];
            array[0] = n;
            return array;
        }

        int[] arrayCopy = new int[array.length + 1];
        for ( int i = 0; i < array.length; i++ ) {
            arrayCopy[i] = array[i];
        }
        arrayCopy[array.length] = n;
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