// 9. Find all permutations of String?

// O( n! )
// With a given string of length n,
// the first character can be placed in n possible places,
// then for each of those, the second character can be in n-1 possible places,
// then the third can be in n-2 possible places,
// continued until the last character is placed.

public class Task9 {

    public static void main( String[] args ) {
        // String s = "bean cave";
        FindPermutations( "fish" );
    }


    // It isn't strictly necessary to have 2 methods here,
    // but this way the only parameter is the String,
    // which is more intuitive.
    public static void FindPermutations( String s ) {
        FindPermutations( s, "" );
    }
    public static void FindPermutations( String remainingString, String scrambledString ) {


        // remainingString contains the characters that haven't been added to the scrambled message yet.
        // scrambledString contains the rest of the string, already scrambled by previous iterations of the method.


        // For each character in the remainingString variable,
        // removes it from the remainingString variable
        // adds it to the end of the scrambledString variable,
        // then calls itself again.
        if ( remainingString.length() > 0 ) {

            for ( int i = 0; i < remainingString.length(); i++ ) {

                // Takes the character at index i, removes it from the remaining string, and adds it to the end of the scrambled string.
                char nextCharacter = remainingString.charAt(i);

                String remainingNew = remainingString.substring( 0, i ) + remainingString.substring( i + 1, remainingString.length() );
                String scrambledNew = scrambledString + nextCharacter;


                // Calls the method again, but this time with a fewer remaining characters, and more scrambled characters.
                FindPermutations( remainingNew, scrambledNew );

            }

        } else {
            // No unscrambled characters remain,
            // so prints out the scrambled string.
            System.out.println( scrambledString );
        }

    }

}