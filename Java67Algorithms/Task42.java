// 42. Traverse a binary tree in Postorder traversal without recursion

// O(n)
// Iterates through each node just once,
// so time increases linearly.

import java.util.*;

public class Task42 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 12 );
        Insert( rootNode, 13 );
        Insert( rootNode, 5 );
        Insert( rootNode, 2 );
        Insert( rootNode, 19 );
        Insert( rootNode, 8 );

        Traverse();

    }

    // Traverses the whole tree,
    // evaluating each node only after
    // both of its child nodes have been evaluated.
    public static void Traverse() {

        // Uses a stack to track what nodes still need to be evaluated.
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();

        stack1.push( rootNode );

        // Pushes each node to a different stack,
        // reversing its order.
        while ( !stack1.isEmpty() ) {

            Node current = stack1.pop();

            stack2.push(current);

            if ( current.left != null ) {
                stack1.push( current.left );
            }
            if ( current.right != null ) {
                stack1.push( current.right );
            }

        }

        // Evaluates each node in the second stack.
        while ( !stack2.isEmpty() ) {
            Node current = stack2.pop();
            System.out.println( "Value: " + current.value );
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