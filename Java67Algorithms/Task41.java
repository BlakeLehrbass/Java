// 41. Implement a Post-order traversal algorithm?

// O(n)
// Iterates through each node just once,
// so time increases linearly.

import java.util.*;

public class Task41 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 9 );
        Insert( rootNode, 6 );
        Insert( rootNode, 8 );
        Insert( rootNode, 11 );
        Insert( rootNode, 14 );
        Insert( rootNode, 12 );

        Traverse(rootNode);

    }

    // Traverses the whole tree,
    // evaluating each node only after
    // both of its child nodes have been evaluated.
    public static void Traverse( Node currentNode ) {

        if ( currentNode == null ) {
            return;
        } else {

            Traverse( currentNode.left );
            Traverse( currentNode.right );

            System.out.println( "Value: " + currentNode.value );

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