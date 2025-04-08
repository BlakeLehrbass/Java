// 51. Given a binary search tree and a value k, How do you find a node in the binary search tree whose value is closest to k.

// O(n)
// Iterates through each node just once,
// so time increases linearly.

import java.util.*;

public class Task51 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 4 );
        Insert( rootNode, 2 );
        Insert( rootNode, 14 );
        Insert( rootNode, 7 );
        Insert( rootNode, 3 );
        Insert( rootNode, 17 );
        Insert( rootNode, 11 );

        int target = 10;
        System.out.printf( "Nearest to %d: %d%n", target, GetNearest( rootNode, target ).value );
        target = 3;
        System.out.printf( "Nearest to %d: %d%n", target, GetNearest( rootNode, target ).value );
        target = 15;
        System.out.printf( "Nearest to %d: %d%n", target, GetNearest( rootNode, target ).value );

    }

    // Returns node with the nearest value to the target value.
    public static Node GetNearest( Node currentNode, int target ) {

        if ( currentNode == null ) {
            return null;
        } else {

            if ( currentNode.value == target ) {
                return currentNode;
            } else {

                // Gets nearest nodes to target on the left and right sides.

                Node left = GetNearest( currentNode.left, target );
                Node right = GetNearest( currentNode.right, target );

                // Gets absolute difference for target
                // for current, left, and right nodes.
                // -1 represents that node being null.

                int leftdiff = -1;
                if ( left != null ) {
                    leftdiff = target - left.value;
                    if ( leftdiff < 0 ) {
                        leftdiff *= -1;
                    }
                }
                int rightdiff = -1;
                if ( right != null ) {
                    rightdiff = target - right.value;
                    if ( rightdiff < 0 ) {
                        rightdiff *= -1;
                    }
                }


                int currentdiff = target - currentNode.value;
                if ( currentdiff < 0 ) {
                    currentdiff *= -1;
                }

                // Compares difference for each,
                // returning the node with the lowest difference.

                if ( leftdiff < currentdiff && leftdiff != -1 && ( leftdiff < rightdiff || rightdiff == -1 ) ) {
                    // Left node is not null, and has the lowest difference, so is closest to the target.
                    return left;
                } else if ( rightdiff < currentdiff && rightdiff != -1 && ( rightdiff < leftdiff || leftdiff == -1 ) ) {
                    // Right node is not null, and has the lowest difference, so is closest to the target.
                    return right;
                } else {
                    // Current value is closer to target than other nodes.
                    return currentNode;
                }

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