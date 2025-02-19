// What are Enumerations?

// Enumerations are a special kind of data type that contains a set of constants.
// These constants are public and final.
// Unlike classes, Enumerations cannot be instantiated.

// Uses:

// This seems to be most useful when you want to define a specific set of legal values a variable can have.
// For example, if you want to establish a certain set of "states" for your variable,
// instead of just using a variable input to change the state,
// you can use an enumeration value instead.
// This will make it very easy to add/remove states,
// will ensure that you can't make a typo in the variable input which may lead to an error,
// and overall make things more organized and comprehensible.

public class Enumerations {
    
    enum Coffee {
        
        SUMATRA( 8, "Strong, but rather generic." ),
        HOUSE_BLEND( 3, "Barely tastes like anything." ),
        BAVARIAN_CHOCOLATE( 6, "Very rich and dark." ),
        HAZELNUT_VANILLA( 4, "Has a weird aftertaste to it." );
        
        private int strength;
        private String description;
        
        private Coffee( int strength, String description ) {
            this.strength = strength;
            this.description = description;
        }
        
    }

    public static void main(String[] args) {
        
        System.out.println( "Flavours:" );
        System.out.println();
        for ( Coffee flavour : Coffee.values() ) {
            System.out.println( "  " + flavour + ":" );
            System.out.println( "    Strength: " + flavour.strength );
            System.out.println( "    " + flavour.description );
            System.out.println();
        }
        
    }
    
}
