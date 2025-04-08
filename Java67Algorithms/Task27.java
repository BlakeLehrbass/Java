// 27. Calculate the average of all numbers in a given array?

// O(n)
// Iterates through each value once,
// so time taken increases linearly as the array gets longer.

public class Task27 {

    public static void main( String[] args ) {

        int[] numbers = new int[Random(5, 10)];

        System.out.println();
        System.out.print( "Numbers: " );
        for ( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = Random(1, 10);
            System.out.print( numbers[i] + " " );
        }
        System.out.println();

        double average = GetAverage(numbers);
        System.out.println( "Average: " + average );
        System.out.println();

    }

    public static double GetAverage( int[] numbers ) {

        // To get the average,
        // adds all of the numbers together,
        // then divides by the array length.

        int sum = 0;
        for ( int i = 0; i < numbers.length; i++ ) {
            sum += numbers[i];
        }

        return (double) sum / numbers.length;

    }

    public static int Random( int min, int max ) {
        // If the min is higher than the max, that'll cause some problems, so they swap places.
        if ( min > max ) {
            return max + (int) ( Math.random() * ( min + 1 - max ) );
        }
        return min + (int) ( Math.random() * ( max + 1 - min ) );
    }

}