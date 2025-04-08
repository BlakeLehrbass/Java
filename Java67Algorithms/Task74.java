// 74. Check if a given number is a Palindrome?

// O(n)
// Time taken increases linearly as the length of the number increases.

public class Task74 {

    public static void main( String[] args ) {
        int n = 111;
        System.out.println( n + " is palindrome? " + IsPalindrome(n) );
        n = 123;
        System.out.println( n + " is palindrome? " + IsPalindrome(n) );
        n = 123454321;
        System.out.println( n + " is palindrome? " + IsPalindrome(n) );
    }

    // Returns true if the number is a palindrome,
    // returns false otherwise.
    public static boolean IsPalindrome( int n ) {
        return ( n == Reverse(n) );
    }

    // Returns the input number with the order of its digits reversed.
    public static int Reverse( int n ) {

        int reverse = 0;

        // For each digit in the original number,
        // multiplies the reverse value by 10 (shifting all digits 1 left),
        // adds that digit to the reverse number,
        // then divides the input number by 10 (effectively removing that digit).
        while ( n != 0 ) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }

        return reverse;

    }

}