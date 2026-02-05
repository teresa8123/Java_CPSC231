import java.util.LinkedList;

public class TestCards
{
    public static void main(String[] args)
    {
        //////////////////* TESTING Card.java *//////////////////
        /* Test default constructor */
        Card defaultCard = new Card(); // Should create Ace of Spades
        System.out.println("Default Card (Ace of Spades expected): " + defaultCard);
        // Modify the default card and verify changes
        defaultCard.setValue(4);
        defaultCard.setSuit(0); // Hearts
        System.out.println("Modified Default Card (Four of Hearts expected): " + defaultCard);

        /* Test Overloaded Constructor */ 
        Card overloadCard = new Card(12, 0); // Queen of Hearts
        System.out.println("Overloaded Card (Queen of Hearts expected): " + overloadCard);

        /* Test Copy Constructor */
        Card copyCard = new Card(overloadCard); // Should copy Queen of Hearts
        System.out.println("Copied Card (Queen of Hearts expected): " + copyCard);

        /* Test equals Method */
        if (overloadCard.equals(copyCard)) {
            System.out.println("Copy Constructor Works (cards are equal)");
        } else {
            System.out.println("Copy Constructor Failed (cards are not equal)");
        }

        // Equality test with a different card
        Card differentCard = new Card(10, 2); // Ten of Clubs
        if (overloadCard.equals(differentCard)) {
            System.out.println("False Positive - cards should not match");
        } else {
            System.out.println("equals() Correctly Identifies Different Cards");
        }

        /* Test Getters and String Conversions */
        System.out.println("Queen of Hearts Value (12 expected): " + overloadCard.getValue());
        System.out.println("Queen of Hearts Suit (0=Hearts expected): " + overloadCard.getSuit());
        System.out.println("String Value: " + overloadCard.getStringValue(overloadCard.getValue()));
        System.out.println("String Suit: " + overloadCard.getStringSuit(overloadCard.getSuit()));


        //////////////////* TESTS Deck.java *//////////////////
        /* Test Default Constructor */
        Deck defaultDeck = new Deck();
        System.out.println("Original Deck: " + defaultDeck);
        System.out.println("Size: " + defaultDeck.size());

        /* Test Copy Constructor */
        Deck copiedDeck = new Deck(defaultDeck);
        System.out.println("\nCopied Deck: " + copiedDeck);
        System.out.println("Size: " + copiedDeck.size());

        // Verify they have the same cards but are different objects
        System.out.println("\nAre the decks equal? " + defaultDeck.toString().equals(copiedDeck.toString()));
        System.out.println("Are they the same object? " + (defaultDeck == copiedDeck));


        //////////////////* TESTS Dealer.java *//////////////////
        /* Test Default Constructor */
        Dealer defaultDealer = new Dealer();
        System.out.println("Initial Deck (Full 52-card deck expected): " + defaultDealer);
        System.out.println("Initial Deck Size (52 expected): " + defaultDealer.size());

        /* Test deals() Method */
        // Test 1: Deal 5 cards
        Dealer testDealer = new Dealer();
        System.out.println("Dealing 5 cards:");
        LinkedList<Card> dealtCards = testDealer.deals(5);
        System.out.println("Dealt Cards: " + dealtCards);
        System.out.println("Remaining Deck Size (47 expected): " + testDealer.size());
        System.out.println("Remaining Deck: " + testDealer);

        // Test 2: Deal more cards than available
        LinkedList<Card> overDeal = testDealer.deals(50);
        System.out.println("Actually dealt (47 expected): " + overDeal.size());
        System.out.println("Remaining Deck Size (0 expected): " + testDealer.size());
        System.out.println("Remaining Deck: " + testDealer);

        // Test 3: Deal from empty deck
        LinkedList<Card> emptyDeal = testDealer.deals(1);
        System.out.println("Dealt Cards (should be empty): " + emptyDeal);
        System.out.println("Remaining Deck Size (0 expected): " + testDealer.size());

        /* Edge Case: Deal 0 cards */
        Dealer edgeDealer = new Dealer();
        LinkedList<Card> zeroCards = edgeDealer.deals(0);
        System.out.println("Dealt Cards (should be empty): " + zeroCards);
        System.out.println("Deck Size After 0-card Deal (52 expected): " + edgeDealer.size());
    }
}