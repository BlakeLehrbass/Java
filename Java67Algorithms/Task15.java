// 15. The largest and smallest number in an unsorted integer array?

// O(n)
// Increases linearly as the length of the array increases.

public class Task15 {

    public static void main( String[] args ) {

        int[] numbers = new int[Random( 10, 20 )];

        System.out.println();
        System.out.println( "Numbers: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 1, 100 );
            System.out.print( numbers[i] + " " );
        }

        int[] minMax = GetMinMax( numbers );
        System.out.println();
        System.out.println();
        System.out.println( "Smallest: " + minMax[0] );
        System.out.println( "Largest:  " + minMax[1] );

    }

    // Returns the lowest and highest numbers as an array.
    public static int[] GetMinMax( int[] numbers ) {

        // The ints s and l represent the smallest and largest numbers found so far, respectively.
        // At the start, they are both set to the first number in the array.
        int s = numbers[0];
        int l = numbers[0];
        for ( int i = 0; i < numbers.length; i++ ) {

            int n = numbers[i];
            if ( n < s ) {
                s = n;
            }

            if ( n > l ) {
                l = n;
            }

        }

        return new int[] { s, l };

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }
}