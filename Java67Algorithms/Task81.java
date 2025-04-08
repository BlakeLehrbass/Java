// 81. Print Pascal's triangle?

// O(n*n)
// n represents the number of rows.
// For a given number of rows,
// the number of values to calculate/print can be represented by:
// O( n + (n-1) + (n-2) + (n-3) ... + (n-(n-1)) )
// Which is also:
// O( n * (n+1) / 2 )
// Which simplifies to O(n*n).

public class Task81 {

    public static void main( String[] args ) {

        PascalsTriangle(10);

    }

    // Prints the Pascal's Triangle sequence up to a specified depth.
    public static void PascalsTriangle( int depth ) {

        int[][] rows = new int[depth][0];

        for ( int i = 0; i < depth; i++ ) {

            int[] row = new int[i + 1];

            // Uses the values of the previous row
            // to determine each value.

            for ( int j = 0; j < row.length; j++ ) {

                if ( j == 0 || j == row.length - 1 ) {
                    // On the edge, so is a 1.
                    row[j] = 1;
                } else {
                    // Uses "parent" values above to determine own value.
                    row[j] = rows[i - 1][j - 1] + rows[i - 1][j];
                }

            }

            rows[i] = row;

        }

        // Prints each row.
        for ( int i = 0; i < rows.length; i++ ) {

            // Indents entire row by a certain amount
            // based on the total depth.
            for ( int j = 0; j < depth - i - 1; j++ ) {
                System.out.print( "   " );
            }

            for ( int j = 0; j < i + 1; j++ ) {
                System.out.print( rows[i][j] );
                int spaces = 5 - (int) Math.log10( rows[i][j] );
                for ( int k = 0; k < spaces; k++ ) {
                    System.out.print( " " );
                }
            }

            System.out.println();

        }

    }

}