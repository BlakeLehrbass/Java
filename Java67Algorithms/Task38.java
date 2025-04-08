// 38. Implement a binary search tree?

// Search/Insert: O(log(n))
// For both of these operations,
// each instance effectively halves the number of remaining nodes to consider,
// meaning the time taken increases logarithmically as more nodes are added.
// Granted if the tree is poorly balanced, it may approach O(n) time instead.

// IsEmpty/Clear: O(1)
// Just assessing 1 variable or settings its value.

public class Task38 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 10 );
        Insert( rootNode, 3 );
        Insert( rootNode, 7 );
        Insert( rootNode, 14 );
        Insert( rootNode, 5 );
        Insert( rootNode, 3 );

        Search( rootNode, 5 );
        Search( rootNode, 6 );

        System.out.println( "Is empty? " + IsEmpty() );

        Clear();
        System.out.println( "Cleared tree" );

        System.out.println( "Is empty? " + IsEmpty() );

    }

    // Finds target value and returns the associated node.
    // Also prints out the process of the program,
    // to prove that it works as intended
    // (as there are no visuals).
    public static Node Search( Node currentNode, int target ) {

        if ( currentNode == null ) {
            System.out.println( "Value of " + target + " not found." );
            System.out.println();
            return null;
        } else if ( target < currentNode.value ) {
            // Searches left.
            System.out.println( target + " < " + currentNode.value );
            return Search( currentNode.left, target );
        } else if ( currentNode.value < target ) {
            // Searches right.
            System.out.println( currentNode.value + " < " + target );
            return Search( currentNode.right, target );
        } else {
            // Value found.
            System.out.println( "Value of " + target + " found." );
            System.out.println();
            return currentNode;
        }

    }

    // Adds a new value to the tree.
    // Also prints out the process of the program,
    // to prove that it works as intended
    // (as there are no visuals).
    public static Node Insert( Node currentNode, int newValue ) {

        if ( currentNode == null ) {
            // Adds the node here.
            System.out.println( "Node with value " + newValue + " created" );

            if ( rootNode == null ) {
                System.out.println( "No root node exists, node becomes root node" );
                rootNode = new Node(newValue);
            }

            System.out.println();
            return new Node(newValue);
        } else if ( newValue < currentNode.value ) {
            // Searches left.
            System.out.println( newValue + " < " + currentNode.value );
            currentNode.left = Insert( currentNode.left, newValue );
        } else if ( currentNode.value < newValue ) {
            // Searches right.
            System.out.println( currentNode.value + " < " + newValue );
            currentNode.right = Insert( currentNode.right, newValue );
        } else {
            // The new value is a duplicate.
            System.out.println( "Node with value " + newValue + " is duplicate, not added" );
            System.out.println();
        }

        return currentNode;

    }

    // Returns true if the tree is empty,
    // returns false otherwise.
    public static boolean IsEmpty() {
        return rootNode == null;
    }

    // Erases tree.
    public static void Clear() {
        rootNode = null;
    }

    public static class Node {

        int value;

        Node left;
        Node right;

        public Node( int value ) {
            this.value = value;
        }

    }

}