// 2. Check if two Strings are anagrams of each other?

// O(n * n)
// For every character in the first string, it must compare it with all letters in the second string.
// If the strings are different lengths or do not match, it will not take as long;
// that is simply the longest-case scenario.

public class Task2 {

    public static void main( String[] args ) {

        String s1 = "solemn";
        String s2 = "melons";
        System.out.println( s1 + " is anagram of " + s2 + "? " + IsAnagram( s1, s2 ) );

        s1 = "apple";
        s2 = "donut";
        System.out.println( s1 + " is anagram of " + s2 + "? " + IsAnagram( s1, s2 ) );

    }

    public static boolean IsAnagram( String s1, String s2 ) {

        // Assuming that an anagram MUST use exactly the same characters as the other word, including spaces, then they must be the same length.
        // Therefore, if they are not, we can skip the longer calculations that follow and just return false right away.
        if ( s1.length() != s2.length() ) {
            return false;
        }

        // Now the program will go through each letter of s1. It will check to see if the letter is in the other string somewhere.
        // If it isn't, then it returns false instantly. If it is, it sets the boolean in usedLetters[j] to become true and goes to the next letter
        boolean[] usedLetters = new boolean[s2.length()];

        for ( int i = 0; i < s1.length(); i++ ) {

            char c = s1.charAt(i);
            // Tracks if the character was found.
            boolean cFound = false;

            for ( int j = 0; j < s2.length(); j++ ) {

                // If usedLetters[j] is true, that means that the letter has already been matches with a letter in s1
                if ( c == s2.charAt(j) && !usedLetters[j] ) {
                    usedLetters[j] = true;
                    cFound = true;
                    break;
                }

            }

            if ( !cFound ) {
                // If it gets here, that means that c was not found in s2, which means that one string has a letter the other doesn't, and thus it is not an anagram
                return false;
            }

        }

        // If it gets here, that means that s1 and s2 are the same length, and contain the same letters in the strings (which means it's an anagram).
        return true;

    }
}