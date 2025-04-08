// 5. Check if a String contains only digits?

// O(n)
// At most, it goes through each letter in the String once, and this increases linearly as n increases.

public class Task5 {

    public static void main( String[] args ) {
        System.out.println( CheckIfNumbers( "1234567890" ) );
        System.out.println( CheckIfNumbers( "abcdefg12" ) );
        System.out.println( CheckIfNumbers( "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111" ) );
        System.out.println( CheckIfNumbers( "1.0" ) );
    }

    public static boolean CheckIfNumbers( String s ) {

        String digits = "1234567890";

        // For each character, evaluates if it is a digit.
        // If not, returns false.
        for ( int i = 0; i < s.length(); i++ ) {

            if ( !digits.contains( String.valueOf( s.charAt(i) ) ) ) {
                return false;
            }
        }

        // If it gets here, that means that all characters are digits, so returns true.
        return true;
    }

}