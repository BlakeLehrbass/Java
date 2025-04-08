// 29. Find the 3rd node from the end in a singly linked list?

// O(n)
// Iterates through the whole list, except for the last 3 elements,
// and O(n - 3) is just O(n).

import java.util.*;

public class Task29 {

    public static void main( String[] args ) {

        LinkedList<String> names = new LinkedList<String>();

        names.add( "Aaron" );
        names.add( "Baron" );
        names.add( "Caron" );
        names.add( "Daron" );
        names.add( "Earon" );
        names.add( "Faron" );
        names.add( "Garon" );
        names.add( "Haron" );
        names.add( "Iaron" );

        String thirdFromLast = GetThirdFromLast(names);
        System.out.println( "Third from last: " + thirdFromLast );

    }

    public static String GetThirdFromLast( LinkedList<String> list ) {

        int length = list.size();

        Iterator<String> iterator = list.iterator();

        String current = "";
        for ( int i = 0; i < length - 3; i++ ) {
            current = iterator.next();
        }

        return current;

    }

}