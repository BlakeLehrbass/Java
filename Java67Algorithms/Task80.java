// 80. Print Floyd's triangle?

// O(n*n)
// n represents the number of rows.
// For a given number of rows,
// the number of values to print can be represented by:
// O( n + (n-1) + (n-2) + (n-3) ... + (n-(n-1)) )
// Which is also:
// O( n * (n+1) / 2 )
// Which simplifies to O(n*n).

public class Task80 {

    public static void main( String[] args ) {

        FloydsTriangle(15);

    }

    // Prints the Floyd's Triangle sequence up to a specified depth.
    public static void FloydsTriangle( int depth ) {

        int n = 1;
        for ( int row = 1; row <= depth; row++ ) {

            for ( int i = 0; i < row; i++ ) {
                // Prints the number.
                // Adds more spaces after it if it has fewer digits.
                System.out.print( n );
                int spaces = 3 - (int) Math.log10( n );
                for ( int j = 0; j < spaces; j++ ) {
                    System.out.print( " " );
                }
                n++;
            }

            // Starts a new row on a new line.
            System.out.println();

        }

    }

}