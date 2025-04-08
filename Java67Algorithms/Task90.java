// 90. Check if a given year is a leap year in Java?

// O(1)

public class Task90 {

    public static void main( String[] args ) {

        int year = 2025;
        System.out.println( year + " is leap year? " + IsLeapYear(year) );
        year = 2020;
        System.out.println( year + " is leap year? " + IsLeapYear(year) );
        year = 1900;
        System.out.println( year + " is leap year? " + IsLeapYear(year) );
        year = 0;
        System.out.println( year + " is leap year? " + IsLeapYear(year) );
        year = -32;
        System.out.println( year + " is leap year? " + IsLeapYear(year) );

    }

    public static boolean IsLeapYear( int year ) {

        // Positive years are "AD",
        // negative years are "BC".

        if ( year >= 1582 ) { // Gregorian Calendar invented

            // According to the Gregorian Calendar,
            // all years divisible by 4 are leap years,
            // except for century years that aren't divisible by 400.
            if ( year % 100 == 0 ) {
                return year % 400 == 0;
            }
            return year % 4 == 0;

        } else if ( year >= -45 ) { // Julian Calendar invented

            // According to the Julian Calendar,
            // all years divisible by 4 are leap years.
            return year % 4 == 0;

        }

        // Leap years did not exist before 45 BC.
        return false;

    }

}