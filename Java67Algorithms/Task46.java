// 46. Print all nodes of given binary tree using inorder traversal without recursion

// O(n)
// Iterates through each node just once,
// so time increases linearly.

import java.util.*;

public class Task46 {

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

    // Traverses the entire tree in order.
    public static void Traverse( Node currentNode ) {

        // Uses a stack to track what nodes still need to be evaluated.
        Stack<Node> stack = new Stack<Node>();

        Node current = rootNode;

        while ( !stackMain.isEmpty() || current != null ) {

            if ( current != null ) {
                stack.push( current );
                current = current.left;
            } else {
                Node lastNode = stack.pop();
                System.out.println( "Value: " + lastNode.value );
                current = lastNode.right;
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