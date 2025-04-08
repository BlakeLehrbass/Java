// 59. Implement the Bucket Sort Algorithm?

// O(n)
// On average, with an evenly distributed array,
// the bucket sort algorithm sorts values in linear time.
// Sometimes it's represented as O(n + k),
// with k representing the number of buckets used,
// but  equals n in this case.

import java.util.*;

public class Task59 {

    public static void main( String[] args ) {

        // Creates a random array of numbers and prints it.
        int[] numbers = new int[Random( 10, 20 )];

        System.out.println();
        System.out.print( "Unsorted: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random( 0, 100 );
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

        // Sorts and prints the numbers.
        BucketSort(numbers);

        System.out.println();
        System.out.print( "Sorted:   " );
        for ( int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

    }

    // A sorting algorithm which first
    // groups all values into "buckets" based on their value,
    // sorts each bucket,
    // then uses the buckets to fill in the array.
    public static void BucketSort( int array[] ) {

        if ( array == null || array.length == 0 ) {
            return;
        }

        // Each bucket will contain a list of similar values,
        // which will then be sorted.
        // The buckets are also arranged such that
        // all values in one bucket are less than all values in the next.
        List<Integer>[] buckets = new ArrayList[array.length];
        for ( int i = 0; i < buckets.length; i++ ) {
            buckets[i] = new ArrayList<Integer>();
        }

        // Gets lowest and highest values of the array.
        // This is used to determine the range of values
        // that can go in each bucket.
        int min = array[0];
        int max = array[0];
        for ( int i = 1; i < array.length; i++ ) {
            if ( array[i] < min ) {
                min = array[i];
            } else if ( array[i] > max ) {
                max = array[i];
            }
        }

        // Now iterates through array,
        // assigning each value to a bucket corresponding to its value.
        for ( int i = 0; i < array.length; i++ ) {
            // The bucketIndex is determined such that
            // the lowest value in the array will always go in the first bucket,
            // and the highest value will always go in the last.
            int bucketIndex = ( array[i] - min ) * buckets.length / ( max - min + 1 );
            buckets[bucketIndex].add( array[i] );
        }

        // Sorts each bucket.
        // This will use BubbleSort,
        // but other sorting methods are also viable.
        for ( int i = 0; i < buckets.length; i++ ) {
            BubbleSort(buckets[i]);
        }

        // For each bucket,
        // adds its values to the array in ascending order.
        int index = 0;
        for ( int i = 0; i < buckets.length; i++ ) {
            for ( int j = 0; j < buckets[i].size(); j++ ) {
                array[index] = buckets[i].get(j);
                index++;
            }
        }

    }

    // Taken from task 57,
    // modified to use a list instead of an array.

    // Iterates through the whole array.
    // It will compare each number with the number after it.
    // If the next number is lower,
    // switches their positions.
    // It will continue this process
    // until it has passed through the array without having to make a swap.
    public static void BubbleSort( List<Integer> bucket ) {

        boolean madeChange = true;
        while ( madeChange ) {
            madeChange = false;
            for ( int i = 0; i < bucket.size() - 1; i++ ) {
                if ( bucket.get(i) > bucket.get( i + 1 ) ) {
                    int temp = bucket.get(i);
                    bucket.set( i, bucket.get( i + 1 ) );
                    bucket.set( i + 1, temp );
                    madeChange = true;
                }
            }
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