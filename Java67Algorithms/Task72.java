// 72. Design a Vending Machine?

/*
Specifications (according to the website):
1. Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter.
2. Allow user to select products Coke(25), Pepsi(35), Soda(45)
3. Allow user to take refund by canceling the request.
4. Return the selected product and remaining change if any
5. Allow reset operation for vending machine supplier.
*/

// This program can be interacted with using the console.
// Of course, a real vending machine would not work like that.
// This is just to help show how it works.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task72 {

    // This is used for getting console input.
    static Scanner keyboard;

    public static void main( String[] args ) {

        keyboard = new Scanner(System.in);

        // Creates the vending machine and gets it running.
        VendingMachine vm = new VendingMachine();

        vm.Run();

    }

    public static class VendingMachine {

        // Tracks all coins and items inside the vending machine.
        static Inventory<Coin> inventoryCoins;
        static Inventory<Item> inventoryItems;

        // Tracks the # of each coin contained.
        public enum State {
            IDLE, SELECTING, BUYING;
        }

        // String state = State.IDLE;
        State state = State.IDLE;

        // Indicates what item is currently being bought.
        Item selectedItem;
        // Indicates the money remaining to pay until the item can be bought.
        int remainingPrice = 0;

        public VendingMachine() {

            // The vending machine is initialized with
            // 5 of each coin and 4 of each item.

            inventoryCoins = new Inventory<Coin>();
            inventoryItems = new Inventory<Item>();

            for ( Coin c : Coin.values() ) {
                inventoryCoins.Add( c, 5 );
            }
            for ( Item i : Item.values() ) {
                inventoryItems.Add( i, 4 );
            }

        }

        // Runs continuously while the vending machine is on.
        public void Run() {

            boolean isRunning = true;

            String input = "";

            while ( isRunning ) {

                switch ( state ) {

                    case State.IDLE:

                        // Options: "Select Item to Buy", "View Contents", "Clear Machine", "Shut Down".

                        // "Select Item to Buy" goes to "Select" state, where the user can buy an item.
                        // "View Contents" shows all items and cash contained in the machine.
                        // "Clear Machine" removes all items and cash from the machine.
                        // "Shut Down" closes the program.

                        input = "" + GetLimitedNumberInput( 4, "1. Select Item to Buy, 2. View Contents, 3. Clear Machine, 4. Shut Down" );

                        switch ( input ) {
                            case "1": // Select
                                state = State.SELECTING;
                                break;
                            case "2": // View contents
                                ViewContents();
                                break;
                            case "3": // Clear
                                Clear();
                                break;
                            case "4": // Shut down
                                isRunning = false;
                                break;
                        }

                        break;

                    case State.SELECTING:

                        // Options: "[Item]", "Cancel".

                        // "[Item]"
                        // Selects that item
                        // and goes to "Buying" state.

                        // "Cancel"
                        // Returns to "Idle" state.

                        // Gets name of all available items as a single String.
                        String message = "";
                        ArrayList<Item> itemsPresented = new ArrayList<Item>();
                        int n = 0;
                        for ( Item item : Item.values() ) {
                            if ( inventoryItems.HasItem(item) ) {
                                n++;
                                message = message + n + ". " + item + ", ";
                                itemsPresented.add(item);
                            }
                        }
                        input = "" + GetLimitedNumberInput( n, message + "0. Cancel", true );


                        if ( input.equals("0") ) { // Cancel
                            state = State.IDLE;
                        } else { // [Item]
                            selectedItem = itemsPresented.get( Integer.parseInt(input) - 1 );
                            remainingPrice = selectedItem.value;
                            state = State.BUYING;
                        }

                        break;

                    case State.BUYING:

                        // Options: "Insert [Coin]", "Cancel".

                        // "Insert [Coin]":
                        // User continuously inserts money into the machine.
                        // Once the cash meets the purchase price,
                        // the machine attempts to complete the purchase.

                        // "Cancel":
                        // Returns any money already inputted for the item,
                        // and returns to "Idle" state.

                        System.out.println( "Buying " + selectedItem );
                        System.out.println( "Remaining cost: $" + ( (double) remainingPrice / 100 ) );
                        System.out.println();

                        message = "";
                        for ( int i = Coin.values().length - 1; i >= 0; i-- ) {
                            Coin c = Coin.values()[i];
                            message = message + (Coin.values().length - i) + ". Insert " + c + ", ";
                        }
                        input = "" + GetLimitedNumberInput( Coin.values().length, message + "0. Cancel", true );

                        switch ( input ) {
                            case "0": // Cancel
                                RefundPurchase();
                                break;
                            default: // Insert [Coin]
                                // Finds the coin
                                InsertCoin( Coin.values()[Coin.values().length - Integer.parseInt(input)] );
                                break;
                        }

                        break;

                }

            }

        }

        // Adds a coin for the current purchase.
        // If the coin total meets or exceeds the purchase requirement,
        // it attempts to complete the purchase.
        public void InsertCoin( Coin coin ) {

            inventoryCoins.Add(coin);

            // When the current item has been bought,
            // gives user the item,
            // as well as any change, if necessary.

            remainingPrice -= coin.GetValue();

            if ( remainingPrice <= 0 ) {
                CompletePurchase();
            }

        }
        // Completes the current purchase.
        // The purchase ends in either:
        // the user getting their item and change,
        // or in the case that the machine can't give proper change,
        // cancels the purchase and refunds the user.
        public void CompletePurchase() {

            // Gives buyer their change.

            ArrayList<Coin> change = AccumulateChange( -remainingPrice );

            if ( change != null ) {

                // Gives product,
                // and any change if necessary.

                System.out.println( "The machine gives you the " + selectedItem + "." );
                inventoryItems.Remove(selectedItem);

                if ( change.size() > 0 ) {
                    System.out.println( "Your change:" );
                    for ( Coin c : change ) {
                        System.out.println( "+ " + c );
                    }
                }
                System.out.println();

                state = state.IDLE;

            } else {

                // There is insufficient change,
                // so cancels the purchase
                // and returns the money that the user put in.

                System.out.println( "Sorry, there's not enough change in the machine." );

                RefundPurchase();

            }

        }
        // Refunds all money given for the current purchase.
        // The cash returned won't necessarily be the exact same arrangement as the input,
        // but the total will be the same.
        public void RefundPurchase() {
            ArrayList<Coin> change = AccumulateChange( selectedItem.value + -remainingPrice );

            System.out.println( "Purchase refunded." );
            if ( change.size() > 0 ) {
                System.out.println( "Returned cash:" );
                for ( Coin c : change ) {
                    System.out.println( "+ " + c );
                }
                System.out.println();
            }

            state = state.IDLE;
        }

        // Returns the change up to a given amount.
        public static ArrayList<Coin> AccumulateChange( int changeOwed ) {
            ArrayList<Coin> coins = new ArrayList<Coin>();
            return AccumulateChange( coins, Coin.DOLLAR, changeOwed );
        }
        public static ArrayList<Coin> AccumulateChange( ArrayList<Coin> coins, Coin maxCoin, int changeOwed ) {

            // Returning change has some awkward cases.
            // For example, if the machine holds a quarter and 3 dimes,
            // and has to give 30 cents of change.
            // If it iterates through the coins from largest to smallest
            // and subtracts those coins from the change required,
            // it will see the quarter and remove 25 cents,
            // then look for a nickel for the remaining 5 but not find it,
            // then will give up,
            // even though it could have returned 3 dimes instead.

            // For that reason,
            // to guarantee all possibilities have been tested,
            // this method will recursively test all possible combinations of coins,
            // starting with the highest-value coins.

            if ( changeOwed == 0 ) {
                // The exact amount of change has been found,
                // so the machine can give the change.
                return coins;
            } else {

                // More change is needed.
                // Attempts to compile the rest of the change,
                // starting with the largest coins first.

                for ( int i = Coin.values().length - 1; i >= 0; i-- ) {

                    Coin c = Coin.values()[i];

                    if ( inventoryCoins.HasItem(c) && c.GetValue() <= maxCoin.GetValue() && c.GetValue() <= changeOwed ) {

                        // Coin exists in inventory,
                        // has equal or less value to the maxCoin,
                        // and will not exceed the desired change amount.

                        // Adds the coin to the list of change coins,
                        // and removes it from the inventory.
                        coins.add(c);
                        inventoryCoins.Remove(c);

                        ArrayList<Coin> coinsNew = AccumulateChange( coins, c, changeOwed - c.GetValue() );

                        if ( coinsNew != null ) {
                            return coinsNew;
                        } else {
                            // The coins could not form to the appropriate change amount,
                            // so puts the coin back in the inventory.
                            coins.remove(c);
                            inventoryCoins.Add(c);
                        }

                    }

                }

                // No configuration found.
                return null;

            }

        }

        // Prints the items and coins that are in the machine.
        public void ViewContents() {

            System.out.println( "Items:" );
            for ( int i = Item.values().length - 1; i >= 0; i-- ) {
                Item c = Item.values()[i];
                int quantity = inventoryItems.GetQuantity(c);
                if ( quantity > 0 ) {
                    System.out.println( "  " + quantity + " " + c + "s" );
                }
            }

            int cashTotal = 0;
            System.out.println( "Cash:" );
            for ( int i = Coin.values().length - 1; i >= 0; i-- ) {
                Coin c = Coin.values()[i];
                int quantity = inventoryCoins.GetQuantity(c);
                if ( quantity > 0 ) {
                    System.out.println( "  " + quantity + " " + c + "s" );
                    cashTotal += quantity * c.value;
                }
            }
            System.out.println( "Cash total: $" + ( (double) cashTotal / 100 ) );
            System.out.println();

        }
        // Clears all contents of the machine.
        public void Clear() {
            inventoryCoins.Clear();
            inventoryItems.Clear();
        }

    }

    // Specifies all items that can be bought from the vending machine.
    public static enum Item {

        COKE(25), PEPSI(35), SODA(45), PICKLE_JAR(500);

        private int value;

        private Item( int value ) {
            this.value = value;
        }

        public int GetValue() {
            return value;
        }

    }

    // Specifies all coins that can be used to buy from the vending machine.
    public static enum Coin {

        PENNY(1), NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100);

        private int value;

        private Coin( int value ) {
            this.value = value;
        }

        public int GetValue() {
            return value;
        }

    }

    // A class used to store quantities for objects of a given type.
    public static class Inventory<T> {

        private Map< T, Integer> inventory = new HashMap<T, Integer>();

        public int GetQuantity( T item ) {
            int quantity = 0;
            if ( inventory.get(item) != null ) {
                quantity = inventory.get(item);
            }
            return quantity;
        }
        public boolean HasItem( T item ) {
            return GetQuantity(item) > 0;
        }

        // Increases the count of the given item by 1.
        public void Add( T item ) {
            int quantity = GetQuantity(item);
            inventory.put( item, quantity + 1 );
        }
        // Increases the count of the given item by a given number.
        public void Add( T item, int count ) {
            int quantity = GetQuantity(item);
            inventory.put( item, quantity + count );
        }
        // Decreases the count of the given item by 1,
        // unless it's already at 0.
        public void Remove( T item ) {
            int quantity = GetQuantity(item);
            if ( quantity > 0 ) {
                inventory.put( item, quantity - 1 );
            }
        }

        // Clears the inventory's contents.
        public void Clear() {
            inventory.clear();
        }

    }

    // Prompts the user to input Strings until the input is an Integer
    // within a certain range (from 1 to max).
    // Whether or not "0" is a valid input can be set with the third parameter.
    public static int GetLimitedNumberInput( int max, String message ) {
        return GetLimitedNumberInput( max, message, false );
    }
    public static int GetLimitedNumberInput( int max, String message, boolean allowZero ) {
        String input = "";

        // Repeats until a number is pressed.
        boolean isValid = false;
        while ( !isValid ) {
            // Gets user input.
            System.out.println( message );
            input = keyboard.nextLine();

            isValid = IsInteger(input);

            if ( !isValid ) {
                System.out.println( "Invalid input (not an integer)." );
            } else {
                int n = Integer.parseInt( input );

                if ( ( allowZero && n < 0 ) || ( !allowZero && n < 1 ) || n > max ) {
                    isValid = false;
                    System.out.println( "Invalid input (out of range)." );
                }
            }

            System.out.println();
        }

        return Integer.parseInt(input);
    }

    // Returns true if the given String can be converted to a valid int.
    public static boolean IsInteger( String s ) {
        if ( s == null ) {
            return false;
        }
        try {
            int n = Integer.parseInt(s);
        } catch ( NumberFormatException nfe ) {
            return false;
        }
        return true;
    }

}