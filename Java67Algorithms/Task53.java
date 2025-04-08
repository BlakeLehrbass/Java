// 53. Write a Java program to implement Stack using an array and linked list?

// StackArray:

// Push/Pop: O(n)
// Each operation requires creating a new array
// and copying over most or all of the values,
// so the time scales linearly as the array gets longer.

// IsEmpty/Peek: O(1)
// Access just one value
// (array.length or end-of-array value).

// StackList:

// O(1)
// Linked lists are very similar to Stacks,
// in that modifying or accessing the front of them
// takes just a constant amount of time.

import java.util.LinkedList;

public class Task53 {

    public static void main( String[] args ) {

        StackArray stackArray = new StackArray();
        stackArray.Push( "Banana" );
        stackArray.Push( "Bananb" );
        stackArray.Push( "Bananc" );
        stackArray.Push( "Banand" );
        stackArray.Push( "Banane" );

        while ( !stackArray.IsEmpty() ) {
            System.out.println( stackArray.Pop() + " taken from top of StackArray" );
        }
        System.out.println( "StackArray now empty" );

        StackList stackList = new StackList();
        stackList.Push( "1emon" );
        stackList.Push( "2emon" );
        stackList.Push( "3emon" );
        stackList.Push( "4emon" );
        stackList.Push( "5emon" );

        while ( !stackList.IsEmpty() ) {
            System.out.println( stackList.Pop() + " taken from top of StackList" );
        }
        System.out.println( "StackList now empty" );

    }


    // A class that behaves effectively like a Stack,
    // but actually uses an array instead.
    public static class StackArray {

        String[] array;

        public StackArray() {
            array = new String[0];
        }

        public boolean IsEmpty() {
            return array.length == 0;
        }

        public void Push( String value ) {
            // Must extend the array by 1 in order to add the new value.
            String[] arrayCopy = new String[array.length + 1];
            for ( int i = 0; i < array.length; i++ ) {
                arrayCopy[i] = array[i];
            }
            arrayCopy[array.length] = value;

            array = arrayCopy;
        }

        public String Pop() {

            // Must shrink the array by 1,
            // then return the removed value.
            String value = array[array.length - 1];

            String[] arrayCopy = new String[array.length - 1];
            for ( int i = 0; i < array.length - 1; i++ ) {
                arrayCopy[i] = array[i];
            }

            array = arrayCopy;

            return value;

        }

        public String Peek() {
            return array[array.length - 1];
        }

    }

    // A class that behaves effectively like a Stack,
    // but actually uses a list instead.
    public static class StackList {

        // The front of the list will represent the top of a stack.
        LinkedList<String> list;

        public StackList() {
            list = new LinkedList<String>();
        }

        public boolean IsEmpty() {
            return list.isEmpty();
        }

        public void Push( String value ) {
            list.addFirst(value);
        }

        public String Pop() {
            return list.pop();
        }

        public String Peek() {
            return list.peek();
        }

    }

}