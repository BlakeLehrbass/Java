// 45. In order traversal in given binary tree?

// O(n)
// Iterates through each node just once,
// so time increases linearly.

import java.util.*;

public class Task45 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 16 );
        Insert( rootNode, 11 );
        Insert( rootNode, 9 );
        Insert( rootNode, 14 );
        Insert( rootNode, 18 );
        Insert( rootNode, 17 );

        Traverse(rootNode);

    }

    // Traverses the whole tree,
    // evaluating the nodes in order from lowest to highest.
    // Basically just exactly the same as the pre-order algorithm,
    // except it evaluates the left nodes before evaluating itself.
    public static void Traverse( Node currentNode ) {

        if ( currentNode == null ) {
            return;
        } else {
            Traverse( currentNode.left );
            System.out.println( "Value: " + currentNode.value );
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