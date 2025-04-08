// 12. Check if the given String is Palindrome?

// O(n)
// The IsPalindrome method has a for loop that repeats a number of times equal to half the length of the String,
// which means the duration increases linearly as the String gets longer.

public class Task12 {

    public static void main( String[] args ) {
        String s = "tacocat";
        System.out.println( s + " is palindrome? " + IsPalindrome(s) );
        s = "palindrome";
        System.out.println( s + " is palindrome? " + IsPalindrome(s) );
        s = "oooooooooooooooooo";
        System.out.println( s + " is palindrome? " + IsPalindrome(s) );
    }

    public static boolean IsPalindrome( String s ) {

        // Compares the first half of the letters to the second half of the letters
        // (compares first letter to last letter, second letter to second last letter, etc.).
        // If any letters compared do not match, that means that it is not a palindrome.
        // If the comparisons all match, then the for loop will end and it will return true.
        for ( int i = 0; i <= (int) ( s.length() / 2 ); i++ ) {
            if ( s.charAt(i) != s.charAt( s.length() - 1 - i ) ) {
                return false;
            }
        }

        return true;
    }

}