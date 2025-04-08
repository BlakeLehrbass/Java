// 26. Multiply two Matrices in Java?

// O(a*b*c)
// The code in the nested loops in MutliplyMatrices
// repeats a number of times equal to a * c * b.

public class Task26 {

    public static void main( String[] args ) {

        // Establishes dimensions of both matrices.
        int a = Random( 1, 4 );
        int b = Random( 1, 4 );
        int c = Random( 1, 4 );

        // Creates first matrix.
        int[][] matrix1 = new int[a][b];
        for ( int i = 0; i < a; i++ ) {
            for ( int j = 0; j < b; j++ ) {
                matrix1[i][j] = Random( 1, 10 );
            }
        }

        // Prints it.
        System.out.println();
        System.out.println( "Matrix 1:" );
        PrintMatrix(matrix1);

        // Creates second matrix.
        int[][] matrix2 = new int[b][c];
        for ( int i = 0; i < b; i++ ) {
            for ( int j = 0; j < c; j++ ) {
                matrix2[i][j] = Random( 1, 10 );
            }
        }

        // Prints it.
        System.out.println();
        System.out.println( "Matrix 2:" );
        PrintMatrix(matrix2);

        // Mutliplies matrices.
        int[][] matrix3 = MultiplyMatrices( matrix1, matrix2 );

        // Prints the new matrix.
        System.out.println();
        System.out.println( "Multiplied:" );
        PrintMatrix(matrix3);

    }

    // Returns the product of the 2 matrices,
    // or returns null if the matrices cannot be multiplied.
    // Assumes both matrices are rectangular.
    public static int[][] MultiplyMatrices( int[][] matrix1, int[][] matrix2 ) {

        // First matrix has a rows and b columns.
        // Second matrix has b rows and c columns.
        // Resulting matrix has a rows and c columns.

        int a = matrix1.length;
        int b = matrix1[0].length;
        if ( b != matrix2.length ) {
            // Matrices cannot be multiplied.
            return null;
        }
        int c = matrix2[0].length;

        // Creates new matrix.
        int[][] matrix3 = new int[a][c];

        // Sets the values for each cell.
        for ( int i = 0; i < a; i++ ) {
            for ( int j = 0; j < c; j++ ) {
                // Each cell in the result matrix at a position of [i][j]
                // has a value equal to the sum of:
                // For values of k from 0-b: m1[i][k] * m2[k][j]
                for ( int k = 0; k < b; k++ ) {
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return matrix3;

    }

    // Prints a matrix in a neatly-formatted way.
    public static void PrintMatrix( int[][] matrix ) {
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                int n = matrix[i][j];

                if ( n < 10 ) {
                    System.out.print( n + "   " );
                } else if ( n < 100 ) {
                    System.out.print( n + "  " );
                } else {
                    System.out.print( n + " " );
                }
            }

            System.out.println();
        }
    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}