// 3. Print the first non-repeated character from String?

// O(n)
// Increases linearly as the string gets longer.
// For each character, must compare it to the singles string and potentially the doubles string, once or multiple times.
// However, because those strings will only contain at most 1 of every character,
// this is effectively multiplying the time taken by a constant,
// which will not affect the notation.

public class Task3 {

    public static void main( String[] args ) {
        // Should output "m".
        System.out.println( GetFirstNonRepeat( "hippopotomonstrosesquippedaliophobia" ) );
    }

    public static char GetFirstNonRepeat( String s ) {

        // Tracks all characters that have already appeared.
        String appears = "";
        // Tracks all character that appear more than once.
        String duplicates = "";

        // For each character,
        // either adds it to the appears string,
        // or adds it to the duplicates string if it's already in the appears string,
        // or does nothing with it if it is already in the duplicates string.
        for ( int i = 0; i < s.length(); i++ ) {

            char c = s.charAt(i);

            if ( appears.indexOf(c) < 0 ) {

                // The "appears" string does not contain the character,
                // so it is added to that string.

                appears = appears + c;

            } else {

                // The "appears" string already contains the character,
                // so it is added to the duplicates string, if it isn't there already.

                if ( duplicates.indexOf(c) < 0 ) {
                    duplicates = duplicates + c;
                }

            }

        }

        // Now goes through all characters in the "appears" string.
        // If there is a character there that is not contained in the "duplicates" string,
        // that means that it only appears once, and is returned.

        for ( int i = 0; i < appears.length(); i++ ) {

            char c = appears.charAt(i);

            if ( duplicates.indexOf(c) < 0 ) {
                return c;
            }

        }

        return 0;

    }

}