// 57. Implement the Bubble Sort algorithm?

// O(n*n)
// Iterates n times through the array of length n.

public class Task57 {

    public static void main( String[] args ) {

        // Generates a random array of numbers and prints it.
        int[] numbers = new int[Random(10, 20)];

        System.out.println();
        System.out.print( "Numbers: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random(1, 100);
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

        // Sorts and prints the numbers.
        int[] sorted = BubbleSort(numbers);

        System.out.println();
        System.out.print( "Sorted:  " );
        for ( int i = 0; i < sorted.length; i++ ) {
            System.out.print( sorted[i] + " " );
        }
        System.out.println();

    }

    // Iterates through the whole array.
    // It will compare each number with the number after it.
    // If the next number is lower,
    // switches their positions.
    // It will continue this process
    // until it has passed through the array without having to make a swap.
    public static int[] BubbleSort( int[] numbers ) {

        boolean madeChange = true;
        while ( madeChange ) {
            madeChange = false;
            for ( int i = 0; i < numbers.length - 1; i++ ) {
                if ( numbers[i] > numbers[i + 1] ) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    madeChange = true;
                }
            }
        }

        return numbers;
    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}