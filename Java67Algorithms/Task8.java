// 8. Count the occurrence of a given character in String?

// O(n)
// Goes through each character once.

public class Task8 {

    public static void main( String[] args ) {
        String s = "banana man";
        System.out.println( CountChar( s, 'a' ) );
    }

    public static int CountChar( String s, char c ) {

        // Tracks the number of occurrences.

        int n = 0;

        for ( int i = 0; i < s.length(); i++ ) {
            if ( s.charAt(i) == c ) {
                // The currently indexed character matches the desired character,
                // so the count is increased.
                n++;
            }
        }

        return n;
    }
}