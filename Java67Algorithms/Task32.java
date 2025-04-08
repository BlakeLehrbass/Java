// 32. Reverse a linked list? / Reverse a singly linked list without recursion?

// O(n)
// Iterates through each item in the list once,
// and each iteration takes a constant amount of time.

import java.util.*;

public class Task32 {

    public static void main( String[] args ) {

        LinkedList<String> names = new LinkedList<String>();

        names.add( "Linda" );
        names.add( "Lindb" );
        names.add( "Lindc" );
        names.add( "Lindd" );
        names.add( "Linde" );
        names.add( "Lindf" );
        names.add( "Lindg" );
        names.add( "Lindh" );
        names.add( "Lindi" );

        LinkedList<String> namesReversed = ReverseList(names);

        Iterator iterator = namesReversed.iterator();

        System.out.println();
        while ( iterator.hasNext() ) {
            System.out.print( iterator.next() + " " );
        }
        System.out.println();
        System.out.println();

    }

    // Returns the reverse of the given list.
    public static LinkedList ReverseList( LinkedList list ) {

        Iterator iterator = list.iterator();

        // Creates a second list.
        LinkedList listReversed = new LinkedList();

        // Iterates through the original list,
        // adding every element to the start of the reversed list.
        while ( iterator.hasNext() ) {
            listReversed.addFirst( iterator.next() );
        }

        return listReversed;

    }

}