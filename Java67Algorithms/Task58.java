// 58. Implement Iterative QuickSort Algorithm?

// O(n*log(n))
// Consists of n loops of the QuickSort method,
// each of which takes an amount of time proportional to log(n).

import java.util.*;

public class Task58 {

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

    // A fast sorting algorithm
    // which works by continuously choosing a "pivot",
    // by which other numbers are to be shifted around in the array.
    // Very similar to the Task19 problem,
    // but uses Stacks instead of recursion.
    public static void QuickSort( int array[] ) {

        Stack<Integer> stackBegin = new Stack<Integer>();
        Stack<Integer> stackEnd = new Stack<Integer>();

        stackBegin.push(0);
        stackEnd.push( array.length - 1 );

        while ( !stackBegin.isEmpty() ) {

            int begin = stackBegin.pop();
            int end = stackEnd.pop();

            if ( begin < end ) {

                int partitionIndex = Partition( array, begin, end );

                // Instead of calling QuickSort again,
                // adds the values to Stacks.

                // Adds right side of partition.
                stackBegin.push( partitionIndex + 1 );
                stackEnd.push(end);

                // Adds left side of partition.
                stackBegin.push(begin);
                stackEnd.push( partitionIndex - 1 );

            }
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