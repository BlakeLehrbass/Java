// 7. Count many vowels and consonants in a given String?

// O(n)
// Goes through each letter in the String once.

public class Task7 {

    public static void main( String[] args ) {
        String s = "Hello Rishi!";
        System.out.println( "Vowels: " + CheckVowels(s) + " Consonants: " + CheckConsonants(s) );
    }

    public static int CheckVowels( String s ) {

        String vowels = "aeiouAEIOU";
        int n = 0;

        for ( int i = 0; i < s.length(); i++ ) {
            if ( vowels.contains( String.valueOf( s.charAt(i) ) ) ) {
                n++;
            }
        }

        return n;

    }

    public static int CheckConsonants( String s ) {

        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        int n = 0;

        for ( int i = 0; i < s.length(); i++ ) {
            if ( consonants.contains( String.valueOf( s.charAt(i) ) ) ) {
                n++;
            }
        }

        return n;

    }
}