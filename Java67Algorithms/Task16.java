// 16. Find all pairs of integer arrays whose sum is equal to a given number?

// This question is worded strangely. We'll assume it means "find all pairs of integers IN an array whose sum is equal to a given number".

// O(n * n)
// Compares each number to each number exactly once,
// therefore the time taken will increase quadratically as the length of the array increases.

public class Task16 {

    public static void main( String[] args ) {

        // Assembles an array of 10-20 numbers, each a random value from 1-100.
        int[] numbers = new int[Random( 10, 20 )];
        System.out.println();
        System.out.println( "Numbers: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 1, 100 );
            System.out.print( " " + numbers[i] );
        }

        System.out.println();
        System.out.println( "Pairs that add to 100: " );
        int[][] pairs = GetPairsSum( numbers, 100 );
        for ( int i = 0; i < pairs.length; i++ ) {
            System.out.print( "(" + pairs[i][0] );
            System.out.print( "," + pairs[i][1] + ") " );
        }

        System.out.println();
        System.out.println();
        System.out.println( "Edge case: int[] has no pairs: 1, 2, 3, 4, 5" );
        numbers = new int[] { 1, 2, 3, 4, 5 };

        System.out.println( "Pairs that add to 100: " );
        pairs = GetPairsSum( numbers, 100 );
        for ( int i = 0; i < pairs.length; i++ ) {
            System.out.print( " " + pairs[i][0] );
            System.out.print( ", " + pairs[i][1] + "." );
        }

    }

    public static int[][] GetPairsSum( int[] numbers, int n ) {

        if ( numbers == null || numbers.length == 0 ) {
            return null;
        }

        int[][] pairs = new int[0][2];

        for ( int i = 0; i < numbers.length; i++ ) {
            // Only compares it to numbers later in the array,
            // since it will have already been compared to ones before it.
            for ( int j = i + 1; j < numbers.length; j++ ) {

                if ( i != j ) {

                    if ( numbers[i] + numbers[j] == n ) {
                        // This means that the pair adds to the desired value, and so it is added to the array of pairs.
                        int[] pair = { numbers[i], numbers[j] };
                        pairs = Append( pairs, pair );
                    }

                }

            }
        }

        // Returns all of the pairs that add to the desired number.
        return pairs;

    }

    // This method is used in order to add a pair to the array of pairs.
    public static int[][] Append( int[][] array, int[] a ) {

        // Copies over the elements of the previous array
        // into a new array with a length that is 1 longer.
        int[][] arrayCopy = new int[array.length + 1][0];
        for ( int i = 0; i < array.length; i++ ) {
            arrayCopy[i] = array[i];
        }

        // Adds the new array.
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