// 36. Remove duplicate elements from a sorted linked list?

// O(n)
// Each node is compared to 1 other node,
// so the time taken increases linearly as the list gets longer.

public class Task36 {

    public static void main( String[] args ) {

        // Creates initial ascending list with duplicate numbers and prints the list.
        List list = new List();
        list.AddToEnd( new Node(1) );
        list.AddToEnd( new Node(2) );
        list.AddToEnd( new Node(4) );
        list.AddToEnd( new Node(4) );
        list.AddToEnd( new Node(5) );
        list.AddToEnd( new Node(6) );
        list.AddToEnd( new Node(7) );
        list.AddToEnd( new Node(7) );
        list.AddToEnd( new Node(7) );
        list.AddToEnd( new Node(8) );
        list.AddToEnd( new Node(8) );
        list.AddToEnd( new Node(10) );

        System.out.println();
        System.out.println( "List:" );
        list.Print();
        System.out.println();

        // Removes the duplicates and prints the list again.
        RemoveDuplicates(list);

        System.out.println();
        System.out.println( "List without duplicates:" );
        list.Print();
        System.out.println();

    }

    // Removes all nodes with a duplicate value in the given list.
    // Will repeat forever if the list contains a cycle,
    // but it won't for the purposes of this program.
    // Assumes the list is sorted.
    public static void RemoveDuplicates( List list ) {

        // For each node,
        // compares its value with that of the next node.
        // If the value matches,
        // the next node is removed.
        Node a = list.GetFirst();

        // Repeats until a reaches the end of the list.
        if ( a != null ) {

            while ( a.nextNode != null ) {

                if ( a.value == a.nextNode.value ) {
                    a.nextNode = a.nextNode.nextNode;
                } else {
                    a = a.nextNode;
                }

            }

        }

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

        int value;
        Node nextNode;

        public Node( int value ) {
            this.value = value;
        }

    }

}