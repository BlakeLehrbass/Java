// 44. Count many leaf nodes in a given binary tree?

// O(n)
// Iterates through each node just once,
// so time increases linearly.

public class Task44 {

    static Node rootNode;

    public static void main( String[] args ) {

        System.out.println();
        Insert( rootNode, 12 );
        Insert( rootNode, 14 );
        Insert( rootNode, 8 );
        Insert( rootNode, 6 ); // Leaf
        Insert( rootNode, 19 ); // Leaf
        Insert( rootNode, 13 ); // Leaf

        System.out.println( "Leaf count: " + GetLeafCount(rootNode) );

    }

    // Returns the number of leaf nodes.
    public static int GetLeafCount( Node currentNode ) {

        if ( currentNode == null ) {
            return 0;
        } else if ( currentNode.left == null && currentNode.right == null ) {
            // Has no child nodes,
            // meaning it's a leaf node.
            return 1;
        } else {
            return GetLeafCount( currentNode.left ) +  GetLeafCount( currentNode.right );
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