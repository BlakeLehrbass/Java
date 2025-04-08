// 55. Given a binary tree, return the postorder traversal of its nodes' values, using Stack?

// O(n)
// Iterates through each node just once,
// so time increases linearly.

import java.util.*;

public class Task55 {

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

        // Gets the binary tree's values in a stack format.
        Stack<Integer> stack = Traverse();

        System.out.println( "Stack values: (top-to-bottom)" );
        while ( !stack.isEmpty() ) {
            System.out.println( stack.pop() );
        }

    }

    // Returns the binary tree as a stack of values.
    public static Stack<Integer> Traverse() {

        // Uses a stack to track what nodes still need to be evaluated.
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Integer> stack2 = new Stack<Integer>();

        stack1.push( rootNode );

        // Pushes each node to a different stack,
        // reversing its order.
        while ( !stack1.isEmpty() ) {

            Node current = stack1.pop();

            stack2.push(current.value);

            if ( current.left != null ) {
                stack1.push( current.left );
            }
            if ( current.right != null ) {
                stack1.push( current.right );
            }

        }

        // Evaluates each node in the second stack.
        /* while ( !stack2.isEmpty() ) {
            Node current = stack2.pop();
            System.out.println( "Value: " + current.value );
        } */

        // Returns the second stack.
        return stack2;

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