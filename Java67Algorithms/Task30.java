// 30. Check if a given linked list contains a cycle? How to find the starting node of the cycle?

// HasCycle: O(n)
// At most,
// the "b" node will have to travel to the end of the list,
// cycle back earlier, then travel through most of the list again until it matches a.
// This means the time taken will scale linearly as the list gets longer.

// GetCycleStart: O(n * n)
// Worst case scenario is that the last node points to itself,
// meaning the program will have to cycle through 1/2 of the nodes for each node,
// meaning a quadratic time complexity as the list gets longer.

public class Task30 {

    public static void main( String[] args ) {

        // Creates list.
        List names = new List();
        names.AddToEnd( new Node( "1ewis" ) );
        names.AddToEnd( new Node( "2ewis" ) );
        names.AddToEnd( new Node( "3ewis" ) );
        names.AddToEnd( new Node( "4ewis" ) );
        names.AddToEnd( new Node( "5ewis" ) );

        // Should output false.
        System.out.println();
        System.out.println( "Has cycle? " + HasCycle(names) );

        // Creates a cycle within the list.
        // The last node "5ewis" now points to the second node "2ewis".
        names.GetLast().nextNode = names.GetFirst().nextNode;

        // Should now output true.
        System.out.println();
        System.out.println( "Has cycle? " + HasCycle(names) );

        Node cycleStart = GetCycleStart(names);
        System.out.println( "Cycle starts at node with value " + cycleStart.value );
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

    }

    public static class Node {

        String value;
        Node nextNode;

        public Node( String value ) {
            this.value = value;
        }

    }

    // Returns true if the list has a cycle,
    // returns false otherwise.
    public static boolean HasCycle( List list ) {

        // 2 nodes that move at different speeds through the list.
        // If they ever match, there must be a cycle.
        // Otherwise, the b node or its next node will be null.
        // meaning it has reached the end and thus there is no cycle.
        Node a = list.GetFirst();

        // Ensures that the list has at least 1 node.
        if ( a != null ) {

            Node b = a.nextNode;

            while ( b != null && b.nextNode != null ) {

                if ( b == a ) {
                    // Has a cycle.
                    return true;
                } else {
                    b = b.nextNode.nextNode;
                    a = a.nextNode;
                }

            }

        }

        // No cycle found.
        return false;

    }

    // Returns the node that indicates the start of the cycle.
    // If there is no cycle, returns null.
    public static Node GetCycleStart( List list ) {

        // The first node that appears twice should be considered the start of the cycle.
        List listCopy = new List();

        int count = 0;

        Node current = list.GetFirst();
        while ( current != null ) {
            count++;

            listCopy.AddToStart(current);
            current = current.nextNode;

            // Checks of the list contains the current node already.
            // If so, there must be a loop.

            Node test = listCopy.GetFirst();
            while ( test != null ) {
                count++;

                if ( test == current ) {
                    // Cycle-starting node found.
                    return test;
                }

                test = test.nextNode;

            }

        }

        return null;

    }

}