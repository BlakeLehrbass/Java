// 35. Find the sum of two linked lists using Stack?

// O(n + m)
// Time taken increases linearly as the lists get longer.

import java.util.*;

public class Task35 {

    public static void main( String[] args ) {

        // Creates 2 linked lists.
        // Each node in the list represents a digit in the number.

        LinkedList<Integer> list1 = new LinkedList<Integer>();
        int length = Random( 2, 4 );

        System.out.println();
        System.out.print( "List 1: " );
        for ( int i = 0; i < length; i++ ) {
            int n = Random( 0, 9 );
            list1.add( n );
            System.out.print( n + " " );
        }
        System.out.println();

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        length = Random( 2, 4 );
        System.out.println();
        System.out.print( "List 2: " );
        for ( int i = 0; i < length; i++ ) {
            int n = Random( 0, 9 );
            list2.add( n );
            System.out.print( n + " " );
        }
        System.out.println();

        System.out.println();
        System.out.println( "Sum: " + GetSum( list1, list2 ) );

    }

    // Returns the sum of both lists.
    public static int GetSum( LinkedList<Integer> list1, LinkedList<Integer> list2 ) {
        return GetListAsNumber( list1 ) + GetListAsNumber( list2 );
    }

    // Returns the number represented by the digits of the list.
    public static int GetListAsNumber( LinkedList<Integer> list ) {

        Stack<Integer> stack = new Stack<Integer>();

        Iterator<Integer> iterator = list.iterator();

        // Iterates through the original list,
        // adding every element to the top of the stack.
        while ( iterator.hasNext() ) {
            stack.push( iterator.next() );
        }

        // Tracks the sum of the number so far.
        int value = 0;
        // For each position a digit is to the left of the rightmost one,
        // it is multiplied by 10.
        int exponent = 0;
        while ( !stack.empty() ) {
            value += stack.pop() * (int) Math.pow( 10, exponent );
            exponent++;
        }

        return value;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}