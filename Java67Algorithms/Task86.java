// 86. Print a given Pyramid structure?

// O(n*n)
// n represents the number of rows.
// For a given number of rows,
// the number of things to print can be represented by:
// O( n + (n-1) + (n-2) + (n-3) ... + (n-(n-1)) )
// Which is also:
// O( n * (n+1) / 2 )
// Which simplifies to O(n*n).

public class Task86 {

    public static void main( String[] args ) {

        Pyramid(10);

    }

    // Prints a "pyramid" structure up to a given depth.
    public static void Pyramid( int depth ) {

        System.out.println();
        for ( int row = 1; row <= depth; row++ ) {

            // Indents entire row by a certain amount
            // based on the total depth.
            for ( int i = 0; i < depth - row; i++ ) {
                System.out.print( " " );
            }

            for ( int i = 0; i < row; i++ ) {
                System.out.print( "* " );
            }

            // Starts a new row on a new line.
            System.out.println();

        }

    }

}