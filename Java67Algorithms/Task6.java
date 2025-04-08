// 6. Find duplicate characters in a String?

// O(n)
// Goes through each letter in the string once,
// comparing it to a string with a finite possible length.

public class Task6 {

    public static void main( String[] args ) {
        System.out.println( FindDuplicateCharacters( "pseudopseudohypoparathyroidism" ) );
        System.out.println( FindDuplicateCharacters( "floccinaucinihilipilification" ) );
        System.out.println( FindDuplicateCharacters( "antidisestablishmentarianism" ) );
    }

    public static String FindDuplicateCharacters( String s ) {

        String firstTimeCharacters = "";
        String duplicateCharacters = "";

        for ( int i = 0; i < s.length(); i++ ) {

            String c = String.valueOf( s.charAt(i) );

            if ( !firstTimeCharacters.contains(c) ) {
                // The character hasn't been found yet, so it is added to firstTimeCharacters.
                firstTimeCharacters = firstTimeCharacters + c;
            } else {
                // Adds the character to the string of duplicate characters.
                duplicateCharacters = duplicateCharacters + c;
            }

        }

        return duplicateCharacters;

    }

}