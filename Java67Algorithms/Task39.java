// 39. Pre-order traversal in a given binary tree?

// O(n)
// Iterates through each node just once,
// so time increases linearly.

public class Task39 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 11 );
        Insert( rootNode, 15 );
        Insert( rootNode, 13 );
        Insert( rootNode, 18 );
        Insert( rootNode, 7 );
        Insert( rootNode, 9 );

        Traverse(rootNode);

    }

    // A depth-first traversal which evaluates a node,
    // then its left node and onwards,
    // then eventually returns to the right.
    public static void Traverse( Node currentNode ) {

        if ( currentNode == null ) {
            return;
        } else {

            System.out.println( "Value: " + currentNode.value );

            Traverse( currentNode.left );
            Traverse( currentNode.right );

        }

    }

    // Adds a new value to the tree.
    public static Node Insert( Node currentNode, int newValue ) {

        if ( currentNode == null ) {
            // Adds the node here.

            if ( rootNode == null ) {
                rootNode = new Node(newValue);
            }

            return new Node(newValue);
        } else if ( newValue < currentNode.value ) {
            // Searches left.
            currentNode.left = Insert( currentNode.left, newValue );
        } else if ( currentNode.value < newValue ) {
            // Searches right.
            currentNode.right = Insert( currentNode.right, newValue );
        } else {
            // The new value is a duplicate.
        }

        return currentNode;

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