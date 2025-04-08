// 40. Traverse a given binary tree in Pre-order without recursion

// O(n)
// Iterates through each node just once,
// so time increases linearly.

import java.util.*;

public class Task40 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 3 );
        Insert( rootNode, 7 );
        Insert( rootNode, 6 );
        Insert( rootNode, 1 );
        Insert( rootNode, 10 );
        Insert( rootNode, 9 );

        Traverse();

    }

    // A depth-first traversal which evaluates a node,
    // then its left node and onwards,
    // then eventually returns to the right.
    public static void Traverse() {

        // Uses a stack to track what nodes still need to be evaluated.
        Stack<Node> stack = new Stack<Node>();

        stack.push( rootNode );

        while ( !stack.isEmpty() ) {

            Node current = stack.pop();
            System.out.println( "Value: " + current.value );

            // Pushes the right before the left,
            // ensuring that the left will be on top
            // so it will be evaluated first.
            if ( current.right != null ) {
                stack.push( current.right );
            }
            if ( current.left != null ) {
                stack.push( current.left );
            }

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