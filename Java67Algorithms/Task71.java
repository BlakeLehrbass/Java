// 71. Check if two rectangles overlap with each other?

// O(1)
// Time taken is never more than 4 comparisons,
// regardless of the x/y values of each rectangle.

public class Task71 {

    public static void main( String[] args ) {

        for ( int i = 0; i < 10; i++ ) {

            // Generates 2 rectangles with random positions.
            Rect a = new Rect( Random( 0, 9 ), Random( 0, 9 ), Random( 0, 9 ), Random( 0, 9 ) );
            Rect b = new Rect( Random( 0, 9 ), Random( 0, 9 ), Random( 0, 9 ), Random( 0, 9 ) );

            // Prints the rectangles by using extremely advanced means.
            boolean printA = false;
            boolean printB = false;
            System.out.println( "------------------------------" );
            for ( int y = 0; y < 10; y++ ) {
                for ( int x = 0; x < 10; x++ ) {

                    if ( a.x1 <= x && x <= a.x2 && a.y1 <= y && y <= a.y2 ) {
                        printA = true;
                    } else {
                        printA = false;
                    }
                    if ( b.x1 <= x && x <= b.x2 && b.y1 <= y && y <= b.y2 ) {
                        printB = true;
                    } else {
                        printB = false;
                    }

                    if ( printA && printB ) {
                        System.out.print( " X " );
                    } else if ( printA ) {
                        System.out.print( " A " );
                    } else if ( printB ) {
                        System.out.print( " B " );
                    } else {
                        System.out.print( "   " );
                    }

                }
                System.out.println();
            }
            System.out.println( "------------------------------" );

            // Prints whether there is overlap.
            System.out.println( "Overlap? " + CheckIfOverlapping( a, b ) );
            System.out.println();
            System.out.println();
            System.out.println();

        }

    }

    // Returns true if the rectangles overlap,
    // else returns false.
    public static boolean CheckIfOverlapping( Rect a, Rect b ) {

        // If x2 of one rectangle is less than x1 of the other,
        // then one is completely to the left of the other
        // and thus they don't overlap.
        if ( a.x2 < b.x1 || b.x2 < a.x1 ) {
            return false;
        }
        // Same logic with y positions.
        if ( a.y2 < b.y1 || b.y2 < a.y1 ) {
            return false;
        }

        // There is overlap in both the x and y positions.
        return true;

    }

    // Each Rectangle is defined by 2 coordinates,
    // top left (x1, y1) and bottom right (x2, y2).
    public static class Rect {

        int x1, y1, x2, y2;

        public Rect( int x1, int y1, int x2, int y2 ) {
            // Assures that x1 <= x2 and y1 <= y2.
            if ( x1 > x2 ) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }
            if ( y1 > y2 ) {
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }

            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
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