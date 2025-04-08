// 18. Remove duplicates from the given array in Java?

// O(n * n)
// In the worst case scenario,
// compares every pair of numbers exactly once,
// so the time taken increases quadratically as the array of numbers gets longer.

public class Task18 {

    public static void main( String[] args ) {

        // Generates an array of 10-20 numbers,
        // each with a random value from 1-10.
        int[] numbers = new int[Random( 10, 20 )];
        System.out.println();
        System.out.println( "Numbers:" );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 1, 10 );
            System.out.print( numbers[i] + " " );
        }

        int[] noCopies = RemoveDuplicates( numbers );
        System.out.println();
        System.out.println();
        System.out.println( "Without duplicates:" );
        for ( int i = 0; i < noCopies.length; i++ ) {
            System.out.print( noCopies[i] + " " );
        }

        System.out.println();

    }

    public static int[] RemoveDuplicates( int[] numbers ) {

        int[] originals = new int[0];

        for ( int i = 0; i < numbers.length; i++ ) {

            boolean isOriginal = true;
            for ( int j = 0; j < i; j++ ) {
                if ( numbers[i] == numbers[j] ) {
                    // The number is a duplicate of a previous number in the array,
                    // so it will not be added to the array of originals.
                    isOriginal = false;
                    break;
                }
            }

            if ( isOriginal ) {
                // The number is not a duplicate of any earlier number,
                // so it is added to the array of originals.
                originals = Append( originals, numbers[i] );
            }

        }

        return originals;

    }

    // Created a method to add numbers to the end of arrays.
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