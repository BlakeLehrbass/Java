// 22. Find multiple missing numbers in a given integer array with duplicates?

// For a number to be missing, there has to be a range of "required" numbers.
// So the method will have to pass in a minimum and maximum value to define that range.

// O(n + m)
// The method iterates through 2 arrays,
// one with a length of n (length of numbers array),
// one with a length of m (range).

public class Task22 {

    public static void main( String[] args ) {

        System.out.println();
        System.out.println( "Range: 1-10" );

        int[] numbers = new int[ Random( 10, 20 ) ];
        System.out.println();
        System.out.print( "Numbers:         " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 1, 10 );
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

        int[] missingNumbers = GetMissingNumbers( numbers, 1, 10 );
        System.out.println();
        System.out.print( "Missing numbers: " );
        for ( int i = 0; i < missingNumbers.length; i++ ) {
            System.out.print( missingNumbers[i] + " " );
        }
        System.out.println();

    }

    public static int[] GetMissingNumbers( int[] numbers, int rangeMin, int rangeMax ) {

        // As the numbers are read from the array,
        // the corresponding boolean value will be filled out as true.
        // The index that it corresponds to is equal to the number - rangeMin
        // (meaning the lowest number will always be first boolean,
        // and the highest number will be the last).
        boolean[] presentNumbers = new boolean[rangeMax - rangeMin + 1];
        // Tracks the amount of missing numbers remaining.
        // The first time each value in presentNumbers is set to true,
        // this value increases by 1.
        int missingNumberCount = presentNumbers.length;

        for ( int i = 0; i < numbers.length; i++ ) {
            // It's not possible with the current demonstration,
            // but in the case that a number were to be inputted that's outside of the range,
            // it won't use it to access an index of the presentNumbers array,
            // because that would cause an error.
            if ( numbers[i] >= rangeMin && numbers[i] <= rangeMax ) {
                // To preserve the accuracy of the missingNumberCount variable,
                // it will only decrease the first time a given number is found.
                if ( !presentNumbers[ numbers[i] - rangeMin ] ) {
                    presentNumbers[ numbers[i] - rangeMin ] = true;
                    missingNumberCount--;
                }
            }
        }

        // Assembles an array of missing numbers using the presentNumbers array.
        // Each false value in the array indicates what number is missing via its index.
        int[] missingNumbers = new int[missingNumberCount];
        int index = 0;
        for ( int i = 0; i < presentNumbers.length; i++ ) {
            if ( !presentNumbers[i] ) {
                missingNumbers[index] = i + rangeMin;
                index++;
            }
        }

        return missingNumbers;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}