// 28. Find the middle element of a singly linked list in one pass?

// O(n)
// Iterates through half the list,
// so time increases linearly as the list gets longer.

import java.util.*;

public class Task28 {

    public static void main( String[] args ) {

        LinkedList<String> names = new LinkedList<String>();

        names.add( "John" );
        names.add( "Johnny" );
        names.add( "Johnathon" );
        names.add( "Albert" );
        names.add( "Johnson" );

        String middle = GetMiddle(names);

        System.out.println( "Middle: " + middle );

    }

    // Gets center element in the list.
    // If the list has an even length, takes the middle element that is earlier in the list.
    public static String GetMiddle( LinkedList<String> list ) {

        int length = list.size();

        Iterator<String> iterator = list.iterator();

        String current = "";
        for ( int i = 0; i < ( length + 1 ) / 2; i++ ) {
            current = iterator.next();
        }

        return current;

    }
}