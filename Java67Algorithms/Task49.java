// 49. Given a binary search tree, how do you check whether there are two nodes in it whose sum equals a given value?

// O(n)
// O(n * log(n))
// For each node, searches for a particular corresponding node.
// So multiply the time for the search function (which is O(log(n)))
// by the number of iterations.

import java.util.*;

public class Task49 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 9 );
        Insert( rootNode, 3 );
        Insert( rootNode, 13 );
        Insert( rootNode, 6 );
        Insert( rootNode, 15 );
        Insert( rootNode, 18 );
        Insert( rootNode, 11 );

        // Only possible pair is the 9 and 11.
        // Should return true.
        System.out.println( "GetPair(20)? " + GetPair( 20 ) );

        // No 2 nodes add to 30, so should return false.
        System.out.println( "GetPair(30)? " + GetPair( 30 ) );

    }

    // Returns true if there is a valid pair within the tree
    // whose values add to the target value.
    // Returns false otherwise.
    public static boolean GetPair( int target ) {
        return GetPair( rootNode, target );
    }
    public static boolean GetPair( Node currentNode, int target ) {

        // For each node, searches for the corresponding node which would add to the target value.
        // Returns true if that node is found, returns false if not.

        if ( currentNode == null ) {
            return false;
        } else {
            // Searches for corresponding node with value that would add to target.
            int correspondingValue = target - currentNode.value;
            // Ensures that it's not just the same node added to itself.
            Node correspondingNode = Search( currentNode, correspondingValue );
            return correspondingNode != null && correspondingNode != currentNode;
        }

    }

    // Finds target value and returns the associated node.
    public static Node Search( Node currentNode, int target ) {

        if ( currentNode == null ) {
            return null;
        } else if ( target < currentNode.value ) {
            // Searches left.
            return Search( currentNode.left, target );
        } else if ( currentNode.value < target ) {
            // Searches right.
            return Search( currentNode.right, target );
        } else {
            // Value found.
            return currentNode;
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