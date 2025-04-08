// 47. Check if a given binary tree is a binary search tree?

// O(n)
// Worst case scenario,
// iterates through all nodes except the very last,
// so time increases linearly.
// However if the tree is basically completely random,
// then the time taken is going to be closer to a constant,
// because it will not require a lot of depth until it returns false.

import java.util.*;

public class Task47 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 9 );
        Insert( rootNode, 6 );
        Insert( rootNode, 5 );
        Insert( rootNode, 8 );
        Insert( rootNode, 12 );
        Insert( rootNode, 11 );
        Insert( rootNode, 15 );

        // The Insert method already puts the nodes in valid locations,
        // so the output should be true.
        System.out.println( "Is search tree? " + IsSearchTree(rootNode) );

        // The tree is no longer a valid search tree,
        // because the root node of 13 has a right child of 12.
        // The output should be false.
        rootNode.value = 13;
        System.out.println( "Is search tree? " + IsSearchTree(rootNode) );

    }

    // Returns true of the tree is a valid binary search tree,
    // returns false if it is not.
    public static boolean IsSearchTree( Node currentNode ) {

        if ( currentNode == null ) {
            return true;
        } else {

            if ( currentNode.left != null && currentNode.value <= currentNode.left.value ) {
                // Left child node has value equal to or greater than the parent node,
                // so it is an invalid BST.
                return false;
            } else if ( currentNode.right != null && currentNode.right.value <= currentNode.value ) {
                // Right child node has value equal to or less than the parent node,
                // so it is an invalid BST.
                return false;
            }

            return IsSearchTree( currentNode.left ) && IsSearchTree( currentNode.right );
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