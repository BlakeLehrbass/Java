// 31. Find the length of a singly linked list?

// O(n)
// Iterates through each list node exactly once.

import java.util.*;

public class Task31 {

    public static void main( String[] args ) {

        LinkedList<String> fruit = new LinkedList<String>();

        fruit.add( "Apple" );
        fruit.add( "Banana" );
        fruit.add( "Orange" );
        fruit.add( "Pineapple" );
        fruit.add( "Pear" );

        int length = GetLength(fruit);
        System.out.println( "List length: " + length );

    }

    public static int GetLength( LinkedList list ) {

        Iterator iterator = list.iterator();

        int length = 0;

        // Iterates through the original list,
        // adding every element to the start of the reversed list.
        while ( iterator.hasNext() ) {
            iterator.next();
            length++;
        }

        return length;

    }
}