// 4. Reverse a given String using recursion?

// O(n)
// The ReverseString method is called for each character in the string. Increasing the string's length increases the time it takes linearly.

public class Task4 {

    public static void main( String[] args ) {
        String s = "Backwards";
        System.out.println( ReverseString(s) );
    }

    public static String ReverseString( String s ) {

        // Returns the last character of the string,
        // then calls this method again on a string with the last character cut off.
        // Or if its length is only 1,
        // ends the recursion by returning just that character.

        if ( s.length() > 1 ) {
            return "" + s.charAt( s.length() - 1 ) + ReverseString( s.substring( 0, s.length() - 1 ) );
        } else {
            return "" + s.charAt(0);
        }

    }
}