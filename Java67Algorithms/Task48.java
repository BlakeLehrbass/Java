// 48. Check if a binary tree is balanced or not?

// O(n)
// Iterates through each node just once,
// so time increases linearly.

import java.util.*;

public class Task48 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 8 );
        Insert( rootNode, 4 );
        Insert( rootNode, 2 );
        Insert( rootNode, 6 );
        Insert( rootNode, 12 );
        Insert( rootNode, 10 );
        Insert( rootNode, 14 );

        // There should be a total of 3 on the left and 3 on the right,
        // so should output true.
        System.out.println( "Is balanced? " + IsBalanced() );
        // Adds another root to the left,
        // but the difference will be within the acceptable range,
        // so should output true.
        Insert( rootNode, 1 );
        System.out.println( "Is balanced? " + IsBalanced() );
        // Adds another root to the left.
        // The difference is now more than 1,
        // so should output false.
        Insert( rootNode, 3 );
        System.out.println( "Is balanced? " + IsBalanced() );

    }

    // Returns true if the tree is balanced,
    // returns false if not.
    public static boolean IsBalanced() {

        // For a tree to be balanced,
        // it must have an at most +/- 1 difference between the left and right sides from the root.
        int leftSide = GetChildCount( rootNode.left );
        int rightSide = GetChildCount( rootNode.right );

        return ( leftSide <= rightSide + 1 && rightSide <= leftSide + 1 );

    }
    // Returns the total number of child nodes that descend from the current node.
    public static int GetChildCount( Node currentNode ) {

        if ( currentNode == null ) {
            return 0;
        } else {
            // Returns 1 for itself,
            // and also calls the method on its child nodes and returns that.
            return 1 + GetChildCount( currentNode.left ) + GetChildCount( currentNode.right );
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