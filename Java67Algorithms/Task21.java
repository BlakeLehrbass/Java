// 21. Reverse an array in place in Java?

// O(n)
// Iterates through half of the length of the array,
// meaning the time taken will scale linearly as the array gets bigger.

public class Task21 {

    public static void main( String[] args ) {

        int[] numbers = new int[Random( 10, 20 )];
        System.out.println();
        System.out.print( "Unreversed:  " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 1, 100 );
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

        Reverse(numbers);
        System.out.println();
        System.out.print( "Reversed:    " );
        for ( int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

    }

    public static void Reverse( int[] numbers ) {

        // Swaps each number in the first half of the array
        // with the corresponding number on the other half of the array.
        for ( int i = 0; i < numbers.length / 2; i++ ) {
            int temp = numbers[i];
            numbers[i] = numbers[ numbers.length - 1 - i ];
            numbers[ numbers.length - 1 - i ] = temp;
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