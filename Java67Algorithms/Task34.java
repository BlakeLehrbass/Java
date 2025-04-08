// 34. Remove duplicate nodes in an unsorted linked list?

// My understanding is that "duplicates" refers to 2 different nodes with the same value,
// not the same node appearing twice (which would create a cylce, which is addressed in #30).

// O(n * n)
// Compares each node to each later node,
// meaning the time taken increases quadratically as the list gets longer.

public class Task34 {

    public static void main( String[] args ) {

        // Creates list.
        List animals = new List();
        animals.AddToEnd( new Node( "cat" ) );
        animals.AddToEnd( new Node( "dog" ) );
        animals.AddToEnd( new Node( "fish" ) );
        animals.AddToEnd( new Node( "dog" ) );
        animals.AddToEnd( new Node( "rabbit" ) );
        animals.AddToEnd( new Node( "fish" ) );

        System.out.println();
        System.out.println( "List:" );
        animals.Print();

        RemoveDuplicates(animals);

        System.out.println();
        System.out.println( "List without duplicates:" );
        animals.Print();
        System.out.println();

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
                System.out.println( current.value );
                current = current.nextNode;
            }

        }

    }

    public static class Node {

        String value;
        Node nextNode;

        public Node( String value ) {
            this.value = value;
        }

    }

    // Removes all nodes with a duplicate value in the given list.
    // Will repeat forever if the list contains a cycle,
    // but it won't for the purposes of this program.
    public static void RemoveDuplicates( List list ) {

        // For each node,
        // compares its value with those of all nodes later in the list.
        // If the values match, removes the later node.
        Node a = list.GetFirst();

        // Repeats until a reaches the end of the list.
        if ( a != null ) {

            while ( a.nextNode != null ) {

                Node b = a;

                // Repeats until b reaches the end of the list.
                while ( b.nextNode != null ) {
                    Node previousNode = b;

                    b = b.nextNode;

                    if ( a.value.equals(b.value) ) {

                        // a and b have the same value,
                        // so removes b by making the previous node skip over it.
                        previousNode.nextNode = b.nextNode;

                    }

                }

                a = a.nextNode;

            }

        }

    }

}