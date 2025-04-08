// 56. Difference between Stack and Queue data structure

import java.util.*;

public class Task56 {

    public static void main( String[] args ) {

        // The main difference between Stacks and Queues
        // is how they order their elements.

        // Stack use the LIFO principle
        // (last in, first out).
        // That means that when taking something out of a stack,
        // it takes the element that was most recently added.
        // It's like a pile of plates,
        // where you can only add/remove plates at the top of the pile.

        // Queues however use the FIFO principle
        // (first in, first out).
        // Meaning when taking something out of a queue,
        // it takes the element that has been there the longest.
        // It's like a line of people waiting for a service;
        // it's only fair that the person who's been waiting the longest
        // should be served first.

        // This also means that Queues must have a pointer for each side of the queue.
        // Meanwhile, Stacks only need one pointer,
        // which is used for both insertion and deletion.

        // In terms of time complexity,
        // stacks are a little bit faster,
        // as they are less complicated.

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // The Stack will print out most recently added elements first:
        // 5, 4, 3, 2, 1
        System.out.println( "Stack:" );
        while ( !stack.isEmpty() ) {
            System.out.println( stack.pop() );
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // The Queue will print out oldest elements first:
        // 1, 2, 3, 4, 5
        System.out.println( "Queue:" );
        while ( queue.peek() != null ) {
            System.out.println( queue.poll() );
        }

    }

}