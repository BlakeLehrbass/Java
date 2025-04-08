// 23. Perform a binary search in a given array?

// O(log(n))
// Each time the search doesn't find the target value,
// it halves the remaining search range.
// Meaning the maximum number of searches required
// will increase logarithmically as the array gets longer

public class Task23 {

    public static void main( String[] args ) {

        int[] numbers = new int[100];
        int n = 0;

        System.out.println();
        System.out.println( "Numbers:" );
        for ( int i = 0; i < numbers.length; i++ ) {
            // Randomizes the array somewhat.
            // The numbers will still be ascending,
            // but there may be some duplicate numbers,
            // or some missing numbers.
            n += Random( 0, 2 );

            numbers[i] = n;
            System.out.print( n + " " );
        }
        System.out.println();
        System.out.println();

        // Performs 5 tests with the given array.
        for ( int i = 0; i < 5; i++ ) {

            int targetNumber = Random( 0, 100 );

            int index = BinarySearch( numbers, targetNumber );

            System.out.println( "targetNumber: " + targetNumber );
            if ( index >= 0 ) {
                System.out.println( "found at index: " + index );
            } else {
                System.out.println( "Not found" );
            }
            System.out.println();

        }

    }

    // Returns index of the target number.
    // Requires the numbers array to already be sorted.
    public static int BinarySearch( int[] numbers, int target ) {

        // low and high define the boundaries of the search.
        int low = 0;
        int high = numbers.length - 1;
        int mid = 0;

        while ( low <= high ) {

            // Until the target value is found,
            // the program will look at the value between the low and high indexes.
            // If the value is more than the target number,
            // then the target number would have to be lower in the array,
            // so the high boundary moves becomes 1 below the mid index.
            // Similarly, if the value is less than the target number,
            // the value would have to be above the mid index,
            // so the low value becomes 1 above the mid index.

            mid = ( low + high ) / 2;

            if ( numbers[mid] == target ) {
                // The target value was found, so it returns the index.
                return mid;
            } else if ( numbers[mid] > target ) {
                // Must search lower in the array.
                high = mid - 1;
            } else {
                // Must search higher in the array.
                low = mid + 1;
            }

        }

        // The target value was not found, so returns -1.
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