// 52. How do you implement a Queue using two Stacks?

// Offer: O(n)
// Because it's using a Stack instead of an actual Queue,
// adding to the front of it takes time because
// one must create a copy of the Stack
// and iteratively add things to it.

// Peek/Poll: O(1)
// Accessing the top of a Stack only takes constant time.

import java.util.Stack;

public class Task52 {

    public static void main( String[] args ) {

        Queue queue = new Queue();
        queue.Offer( "Sarah" );
        queue.Offer( "Sarbh" );
        queue.Offer( "Sarch" );
        queue.Offer( "Sardh" );
        queue.Offer( "Sareh" );

        while ( queue.Peek() != null ) {
            System.out.println( queue.Poll() + " taken from end of queue" );
        }
        System.out.println( "Queue now empty" );

    }

    // A class that behaves effectively like a Queue,
    // but actually uses Stacks instead.
    public static class Queue {

        // This stack has the oldest elements on the top
        // and newest on the bottom.
        Stack<String> stack;

        public Queue() {
            stack = new Stack<String>();
        }

        // Adds an element to the back of the queue.
        // Returns true if successful,
        // false otherwise.
        public boolean Offer( String value ) {

            // Moves the stack to a second stack,
            // which effectively flips it over,
            // meaning the start of the queue is now on top.
            Stack<String> stackCopy = new Stack<String>();
            while ( !stack.isEmpty() ) {
                stackCopy.push( stack.pop() );
            }

            // The start of the queue is on top,
            // so the new element is being add to the start of the queue.
            stackCopy.push(value);

            // Flips the stack back around.
            while ( !stackCopy.isEmpty() ) {
                stack.push( stackCopy.pop() );
            }

            return true;

        }

        // Returns element at front of the queue,
        // or returns null if there are no elements.
        public String Peek() {
            if ( stack.isEmpty() ) {
                return null;
            }
            return stack.peek();
        }

        // Removes and returns the element at the front of the queue.
        public String Poll() {
            // Returns top element of stack2,
            // also removes it from the stack.
            return stack.pop();
        }

    }

}