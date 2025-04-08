// 54. How do you implement Stack using Queues?

// Push: O(n)
// The program has to move each element to a list and back,
// so the time taken increases linearly as the queue gets longer.

// Other: O(1)
// The other options just require accessing/modifying the head of the queue,
// which takes a constant amount of time.

import java.util.*;

public class Task54 {

    public static void main( String[] args ) {

        Stack stack = new Stack();
        stack.Push( "Banana" );
        stack.Push( "Bananb" );
        stack.Push( "Bananc" );
        stack.Push( "Banand" );
        stack.Push( "Banane" );

        while ( !stack.IsEmpty() ) {
            System.out.println( stack.Pop() + " taken from top of Stack" );
        }
        System.out.println( "Stack is empty? " + stack.IsEmpty() );

    }


    // A class that behaves effectively like a Stack,
    // but actually uses Queues instead.
    public static class Stack {

        // The head of the queue
        // represents the top of the stack.
        Queue<String> queue;

        public Stack() {
            queue = new LinkedList<String>();
        }

        public boolean IsEmpty() {
            return queue.peek() == null;
        }

        public void Push( String value ) {

            // Moves elements in queue to a list,
            // effectively flipping it over.
            LinkedList<String> copy = new LinkedList<String>();
            while ( queue.peek() != null ) {
                copy.addLast( queue.poll() );
            }

            // Adds the new element to the front of the list.
            // This means that it will be added to the end of the queue.
            copy.addFirst(value);

            // Moves the elements back to the queue.
            while ( !copy.isEmpty() ) {
                queue.offer( copy.pop() );
            }

        }

        public String Pop() {
            return queue.poll();
        }

        public String Peek() {
            return queue.peek();
        }

    }

}