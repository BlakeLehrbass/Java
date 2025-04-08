// 87. Find the highest repeating word from a given file in Java?

// O(n)
// Accessing/modifying objects in a hashmap takes constant time,
// so for each word in the file, it will add a constant amount of time,
// meaning it will scale linearly as the text file gets longer.

import java.util.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class Task87 {

    public static void main( String[] args ) {

        System.out.println();
        MostCommonWord( "Constitution.txt" );

    }

    // Prints the most common word in the given file.
    public static void MostCommonWord( String fileName ) {

        File file = new File( fileName );

        Scanner scanner = GetScanner(file);

        // Uses a hash map to track what words are present,
        // and how many times each has occurred.
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        try {

            // Gets the text file as a single String.
            String full = readFile( file.getCanonicalPath(), Charset.defaultCharset() );

            // Uses space and punctuation to distinguish betwen words.
            StringTokenizer st = new StringTokenizer( full, "\n\r\t\b\f .?!,:;" );

            // For each word,
            // create an entry for it in the hash map
            // and tracks its number of occurrences.
            while ( st.hasMoreElements() ) {

                // Gets next word.
                String word = st.nextElement().toString();

                // Sets the word to lowercase so that words
                // with/without capitals will be counted together.
                word = word.toLowerCase();

                // Checks if the word exists in the hash map.
                // If so, increases the value by 1.
                // If not, adds it to the hash map and sets the value to 1.
                if ( map.containsKey( word ) ) {
                    int n = map.get( word );
                    map.put( word, n + 1 );
                } else {
                    map.put( word, 1 );
                }

            }

            // Iterates through all words in the map to find the most common word.
            String highestWord = "";
            int highestCount = -1;

            for ( String word : map.keySet() ) {
                int n = map.get(word);
                if ( n > highestCount ) {
                    highestWord = word;
                    highestCount = n;
                }
            }

            System.out.println( "Most common word in " + fileName + ": " + highestWord );

        } catch ( Exception e ) {
            System.out.println( "Exception" );
        }

    }

    public static Scanner GetScanner( File file ) {
        try {
            Scanner scanner = new Scanner( file );
            return scanner;
        } catch ( FileNotFoundException ex ) {
            System.out.println( "FileNotFoundException" );
            return null;
        }
    }

    static String readFile( String path, Charset encoding ) throws IOException {
        byte[] encoded = Files.readAllBytes( Paths.get(path) );
        return new String( encoded, encoding );
    }

}