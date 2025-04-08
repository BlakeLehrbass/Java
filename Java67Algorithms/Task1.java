// 1. Print duplicate characters from String?

// O(n)
// n represents the length of the string.
// The program must go through each letter exactly once, so the time it takes increases linearly as n increases.
// It will be comparing each string to a set of used characters,
// however this set of characters will only increase when a new character is introduced, so it has a finite limit,
// thus the amount of time taken for each character will not increase proportionally to the length of the string.

public class Task1 {

    public static void main( String[] args ) {

        String s = "i like pumpkin pie";
        String used = "";

        for ( int i = 0; i < s.length(); i++ ) {

            if ( used.indexOf( s.charAt(i) ) >= 0 ) {
                // Character already contained, so it is a duplicate, and should be printed.
                System.out.println( s.charAt(i) );
            } else {
                // Adds character to collection of used characters.
                used = used + s.charAt(i);
            }

        }

    }

}