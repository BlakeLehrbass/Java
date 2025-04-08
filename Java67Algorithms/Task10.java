// 10. Reverse words in a given sentence without using any library method?

// O(n)
// Increases linearly as the number of letters or words in a sentence increases.

public class Task10 {

    public static void main( String[] args ) {
        System.out.println();
        System.out.println( ReverseWord( "Good morning sir! I would like to speak to you about your car's extended warranty. Also I broke into your house and ate the food in your fridge." ) );

        System.out.println();
        System.out.println( ReverseWord( "Here's what I have that you don't: a functioning liver, depth perception, and a pulse!" ) );

        System.out.println();
        System.out.println( ReverseWord( "Cat\\Dog!" ) );

        System.out.println();
        System.out.println( ReverseWord( "Oh boy I sure love \"quotation marks\"" ) );

        System.out.println();
        System.out.println( ReverseWord( "????what happens if we put question marks at the start of the sentence" ) );

        System.out.println();
        System.out.println( ReverseWord( "1wordonly" ) );
    }

    public static String ReverseWord( String s ) {
        // Makes sure that if an invalid String is put into the method, it doesn't cause an error.
        if ( s == null || s.length() == 0 ) {
            return "";
        }

        // The notLetters array contains all characters that are not letters, or could not be part of a word (like an apostrophe).
        String notLetters = " `~!@#$%^&*()-_=+[{]}\\|;:\",<.>/?";

        // The words String[] contains all of the words in the sentence. (A word must be a group of letters with non-letters next to it, unless it is at the beginning or end of the sentence, in which case it only needs spaces to the right or left of it).
        // The most amount of words possible in s is 1 + half of s.length(), since each word must be separated by a character.
        String[] words = new String[1 + (int) (s.length() / 2)];

        // The wordSeparation String[] contains the text before each word (such as the spaces in between them or punctuation marks).
        String[] wordSeparation = new String[words.length];

        words[0] = "";
        wordSeparation[0] = "";


        // The index variables keeps track of what index to use for the words and wordPreviousText when adding letters to the words.
        // Without it, the code would not be know what word to add a letter to when it gets to one.
        int wordIndex = 0;
        int separationIndex = 0;
        for ( int i = 0; i < s.length(); i++ ) {

            if ( !notLetters.contains( String.valueOf( s.charAt(i) ) ) ) {
                // The character is a letter.

                if ( i > 0 && notLetters.contains( String.valueOf( s.charAt(i - 1) ) ) ) {
                    // The previous character was not a letter,
                    // meaning a new word has begun,
                    // so increases the index.
                    wordIndex++;
                    words[wordIndex] = "";
                }

                // Adds a character to the appropriate word in the words array.
                words[wordIndex] = words[wordIndex] + String.valueOf( s.charAt(i) );

            } else {

                // The character is not a letter.

                if ( i > 0 && !notLetters.contains( String.valueOf( s.charAt(i - 1) ) ) ) {
                    // The previous character was a letter,
                    // meaning a new word separation has begun,
                    // so increases the index.
                    separationIndex++;
                    wordSeparation[separationIndex] = "";
                }

                // Adds a character to the appropriate String in the wordPreviousText array.
                wordSeparation[separationIndex] = wordSeparation[separationIndex] + String.valueOf( s.charAt(i) );

            }

        }

        // Now that it has all the text, it will turn it into a new String, called sReversed.
        // The wordPreviousText String[] (spaces and punctuation) will be added to the String in normal order,
        // but the words String[] will be added in reverse order.
        String sReversed = "";
        for ( int i = 0; i <= wordIndex + 1; i++ ) {

            if ( i >= 0 && wordSeparation[i] != null ) {
                sReversed = sReversed + wordSeparation[i];
            }

            if ( wordIndex - i >= 0 && words[wordIndex - i] != null ) {
                sReversed = sReversed + words[wordIndex - i];
            }

        }

        // Finally, the reversed String is returned.
        return sReversed;
    }
}