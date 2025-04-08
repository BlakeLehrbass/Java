// 24. Transpose a Matrix?

// O(n * m)
// Rearranging the matrix takes time
// proportional to the number of values in the matrix,
// which is equal to n (rows) * m (columns).

public class Task24 {

    public static void main( String[] args ) {

        // Generates a matrix with random dimensions and values,
        // prints it, then transposes it and prints that.

        int[][] matrix = new int[Random(4,8)][Random(4,8)];

        System.out.println();
        System.out.println( "Original:" );
        for ( int i = 0; i < matrix.length; i++ ) {

            for ( int j = 0; j < matrix[i].length; j++ ) {
                int n = Random( 1, 50 );
                matrix[i][j] = n;

                if ( n < 10 ) {
                    System.out.print( n + "   " );
                } else {
                    System.out.print( n + "  " );
                }
            }

            System.out.println();

        }

        int[][] matrixTransposed = Transpose(matrix);

        System.out.println();
        System.out.println( "Transposed:" );
        for ( int i = 0; i < matrixTransposed.length; i++ ) {

            for ( int j = 0; j < matrixTransposed[i].length; j++ ) {
                int n = matrixTransposed[i][j];

                if ( n < 10 ) {
                    System.out.print( n + "   " );
                } else {
                    System.out.print( n + "  " );
                }
            }

            System.out.println();

        }
        System.out.println();

    }

    // Assumes that the matrix input is rectangular
    // (that is, all rows have an equal length).
    public static int[][] Transpose( int[][] matrix ) {

        int[][] matrixTransposed = new int[matrix[0].length][matrix.length];

        for ( int i = 0; i < matrixTransposed.length; i++ ) {
            for ( int j = 0; j < matrixTransposed[i].length; j++ ) {
                matrixTransposed[i][j] = matrix[j][i];
            }
        }

        return matrixTransposed;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}