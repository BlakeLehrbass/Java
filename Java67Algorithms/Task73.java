// 73. Implement an LRU Cache in your favorite programming language?

import java.util.*;
import java.lang.Object;

public class Task73 {

    public static void main( String[] args ) {

        // Creates the cache.
        // It uses a LinkedHashMap to preserve the order of the entries,
        // so that the program can determine which entry has been least recently modified.
        final int MAX_ENTRIES = 10;
        Map cache = new LinkedHashMap( MAX_ENTRIES + 1, .75F, true ) {
            // This method is called just after a new entry has been added.
            public boolean removeEldestEntry( Map.Entry eldest ) {
                return size() > MAX_ENTRIES;
            }
        };

        // Turns the cache into a synchronized map,
        // so there would be no issues caused my multi-threading.
        cache = (Map) Collections.synchronizedMap(cache);

        // Adds 10 mappings to the cache,
        // filling it to its maximum capacity.
        for ( int i = 0; i < 10; i++ ) {
            cache.put( "" + i, "Value" );
        }
        System.out.println();
        Print(cache);

        // Updates the value linked to the "0" key.
        // This will make "0" the most recently used key, moving it to the end of the cache.
        cache.put( "0", "Updated Value" );
        System.out.println();
        Print(cache);

        // Adds an 11th mapping to the cache,
        // causing the least recently used mapping to be erased.
        // This happens to be the "1" key mapping
        // (because "0" is now at the front).
        cache.put( "10", "New" );
        System.out.println();
        Print(cache);

    }

    // Prints all mappings in the cache
    // (for demonstration purposes).
    public static void Print( Map cache ) {
        Set< Map.Entry<String, String> > sets = cache.entrySet();
        System.out.println( "Printing cache:" );
        for ( Map.Entry<String, String> map : sets ) {
            System.out.println( "key: " + map.getKey() + " value: " + map.getValue() );
        }
    }

}