// 11. Check if two String is a rotation of each other?

// O(n)

// The time taken for the contains method increases linearly as the Strings gets longer.

public class Task11 {

    public static void main( String[] args ) {
        String s1 = "slap";
        String s2 = "laps";
        System.out.println( s1 + ", " + s2 + ": " + IsRotation( s1, s2 ) );

        s1 = "tomato";
        s2 = "totamo";
        System.out.println( s1 + ", " + s2 + ": " + IsRotation( s1, s2 ) );
    }

    public static boolean IsRotation( String s1, String s2 ) {

        // A "rotated" version of a String would be one that has had its first character moved to its last position,
        // or its last character moved to its first position, any number of times.

        // With any rotated String,
        // if you take the text of the String and line it up twice,
        // it will contain the original message somewhere in the middle.
        // This can be used to determine if a String is a rotation of another String.

        // First checks to see if they are the same length. If they aren't, they cannot be rotations, as one has more/fewer characters than the other.
        if ( s1.length() != s2.length() ) {
            return false;
        }

        // If they are the same length, a new String is created called s2Double. It's just s2 + s2.
        // If s2Double contains s1. If it does, that means that s2 is a rotation of s1, and returns True.
        String s2Double = s2 + s2;
        if ( s2Double.contains( s1 ) ) {
            return true;
        }

        // They are not rotations, so returns false.
        return false;
    }
}