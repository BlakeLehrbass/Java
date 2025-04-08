// 37. Check if given linked list is palindrome in Java?

// O(n * n)
// Getting the length of the list takes O(n) time.
// When comparing the nodes, at worst,
// the first half of nodes will have to be compared with the node
// (n / 2) positions ahead of itself (on average).
// Going ahead in the list takes time on its own,
// meaning the time taken will increase quadratically as the list gets longer.

// However, in the case where the list is not a palindrome,
// it will only take O(n) time,
// because it is very likely that the first comparison
// will determine that it's not a palindrome.

public class Task37 {

    public static void main( String[] args ) {

        // Creates initial list.
        List list = new List();
        list.AddToEnd( new Node('t') );
        list.AddToEnd( new Node('a') );
        list.AddToEnd( new Node('c') );
        list.AddToEnd( new Node('o') );
        list.AddToEnd( new Node('c') );
        list.AddToEnd( new Node('a') );
        list.AddToEnd( new Node('t') );

        System.out.println();
        System.out.println( "List:" );
        list.Print();
        System.out.println();

        System.out.println( "Is palindrome? " + IsPalindrome(list) );

    }

    // Returns true if the list is a palindrome,
    // returns false if it isn't.
    // Assumes the list is non-cyclical.
    public static boolean IsPalindrome( List list ) {

        // The program must know the length in order to know which nodes to compare.
        int length = 0;
        Node current = list.GetFirst();
        while ( current != null ) {
            current = current.nextNode;
            length++;
        }

        // Compares all nodes in the first half of the list
        // with the nodes in the second half.
        current = list.GetFirst();
        // This value, alongside the length value,
        // is used to determine how far ahead in the list the opposite node is.
        int index = 0;
        while ( index < ( length ) / 2 ) {

            // Gets the equivalent node on the other side of the list.
            Node opposite = current;
            for ( int i = 0; i < length - ( index * 2 ) - 1; i++ ) {
                opposite = opposite.nextNode;
            }

            // If the nodes don't match,
            // the list cannot be a palindrome.
            if ( current.value != opposite.value ) {
                return false;
            }

            current = current.nextNode;

            index++;

        }

        // All nodes were matched,
        // so the list is a palindrome.
        return true;

    }

    public static class List {

        Node head;
        Node tail;

        public List() {
        }

        public void AddToEnd( Node newNode ) {
            // Adds to the end of the list.

            if ( head == null ) {
                head = newNode;
                tail = newNode;
            } else {
                tail.nextNode = newNode;
                tail = newNode;
            }

        }
        public void AddToStart( Node newNode ) {

            if ( head == null ) {
                head = newNode;
                tail = newNode;
            } else {
                head.nextNode = newNode;
                head = newNode;
            }

        }

        public Node GetFirst() {
            return head;
        }
        public Node GetLast() {
            return tail;
        }

        // Will repeat forever if there is a cycle,
        // but there won't be for the purposes of this program.
        public void Print() {

            Node current = head;

            while ( current != null ) {
                System.out.print( current.value + " " );
                current = current.nextNode;
            }

        }

    }

    public static class Node {

        char value;
        Node nextNode;

        public Node( char value ) {
            this.value = value;
        }

    }

}