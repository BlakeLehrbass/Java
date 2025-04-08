// 50. Convert a binary search tree to a sorted doubly-linked list. you are only allowed to change the target of pointers but cannot create any new nodes.

// My understanding of these instructions would be that
// the Node class used for the tree must be the same as the one for the lists.

// O(n)
// Iterates through each node just once,
// so time increases linearly.

import java.util.*;

public class Task50 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 18 );
        Insert( rootNode, 12 );
        Insert( rootNode, 16 );
        Insert( rootNode, 7 );
        Insert( rootNode, 6 );
        Insert( rootNode, 13 );
        Insert( rootNode, 14 );

        List list = ConvertToList();

        System.out.println( "List:" );
        list.Print();

    }

    // Returns the nodes of the binary search tree
    // as a sorted, doubly-linked list.
    // This will be very similar to the in-order traversal method,
    // except that as it goes it will be adding things to the list.
    public static List ConvertToList() {
        return ConvertToList( rootNode, new List() );
    }
    public static List ConvertToList( Node currentNode, List list ) {

        if ( currentNode == null ) {
            return list;
        } else {
            // Adds the left-most nodes to the list first.
            ConvertToList( currentNode.left, list );

            // Must be stored here,
            // since adding the node to the list
            // will get rid of that pointer.
            Node rightNode = currentNode.right;
            list.AddToEnd( currentNode );

            // Adds the right-most nodes to the list later.
            return ConvertToList( rightNode, list );
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

    // The list class and methods here are the same as previous projects,
    // just adjusted it for the "left/right" terminology,
    // and adjusted it to be doubly-linked.
    public static class List {

        Node head;
        Node tail;

        public List() {
        }

        public void AddToEnd( Node newNode ) {
            // Adds to the end of the list.

            if ( head == null ) {
                head = newNode;
                tail = newNode;
            } else {
                tail.right = newNode;
                newNode.left = tail;
                tail = newNode;
            }

        }
        public void AddToStart( Node newNode ) {

            if ( head == null ) {
                head = newNode;
                tail = newNode;
            } else {
                head.left = newNode;
                newNode.right = newNode;
                head = newNode;
            }

        }

        public Node GetFirst() {
            return head;
        }
        public Node GetLast() {
            return tail;
        }

        // Will repeat forever if there is a cycle,
        // but there won't be for the purposes of this program.
        public void Print() {

            Node current = head;

            while ( current != null ) {
                System.out.print( current.value + " " );
                current = current.right;
            }

        }

    }

}