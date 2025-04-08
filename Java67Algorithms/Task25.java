// 25. Add or subtract two Matrices?

// O(n * m)
// Adding/subtracting the matrices takes time
// proportional to the number of values in each matrix,
// which is equal to n (rows) * m (columns).

public class Task25 {

    public static void main( String[] args ) {

        // Establishes dimensions of both matrices.
        int width = Random( 4, 8 );
        int height = Random( 4, 8 );

        // Creates and prints first matrix.
        int[][] matrix1 = new int[width][height];

        System.out.println();
        System.out.println( "Matrix 1:" );
        for ( int i = 0; i < width; i++ ) {

            for ( int j = 0; j < height; j++ ) {
                int n = Random( 1, 20 );
                matrix1[i][j] = n;

                // Prints the values in a way that is neatly formatted.
                if ( n < 10 ) {
                    System.out.print( n + "   " );
                } else {
                    System.out.print( n + "  " );
                }
            }

            System.out.println();

        }

        // Creates and prints second matrix.
        int[][] matrix2 = new int[width][height];

        System.out.println();
        System.out.println( "Matrix 2:" );
        for ( int i = 0; i < width; i++ ) {

            for ( int j = 0; j < height; j++ ) {
                int n = Random( 1, 20 );
                matrix2[i][j] = n;

                // Prints the values in a way that is neatly formatted.
                if ( n < 10 ) {
                    System.out.print( n + "   " );
                } else {
                    System.out.print( n + "  " );
                }
            }

            System.out.println();

        }

        // Adds matrices and prints the result.
        int[][] matricesAdded = AddMatrices( matrix1, matrix2 );

        System.out.println();
        System.out.println( "Added:" );
        for ( int i = 0; i < width; i++ ) {
            for ( int j = 0; j < height; j++ ) {
                int n = matricesAdded[i][j];

                // Prints the values in a way that is neatly formatted.
                if ( n < 10 ) {
                    System.out.print( n + "   " );
                } else {
                    System.out.print( n + "  " );
                }
            }

            System.out.println();
        }

        // Subtracts the second matrix from the first and prints the result.
        int[][] matricesSubtracted = SubtractMatrices( matrix1, matrix2 );

        System.out.println();
        System.out.println( "Subtracted:" );
        for ( int i = 0; i < width; i++ ) {
            for ( int j = 0; j < height; j++ ) {
                int n = matricesSubtracted[i][j];

                // Prints the values in a way that is neatly formatted.
                if ( n < 10 && n >= 0 ) {
                    System.out.print( n + "   " );
                } else if ( n > -10 ) {
                    System.out.print( n + "  " );
                } else {
                    System.out.print( n + " " );
                }
            }

            System.out.println();
        }

        System.out.println();

    }

    // Assumes both matrices have the same dimensions.
    public static int[][] AddMatrices( int[][] matrix1, int[][] matrix2 ) {

        int[][] newMatrix = new int[matrix1.length][matrix1[0].length];

        for ( int i = 0; i < newMatrix.length; i++ ) {
            for ( int j = 0; j < newMatrix[i].length; j++ ) {
                newMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return newMatrix;

    }

    // Assumes both matrices have the same dimensions.
    public static int[][] SubtractMatrices( int[][] matrix1, int[][] matrix2 ) {

        int[][] newMatrix = new int[matrix1.length][matrix1[0].length];

        for ( int i = 0; i < newMatrix.length; i++ ) {
            for ( int j = 0; j < newMatrix[i].length; j++ ) {
                newMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return newMatrix;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}