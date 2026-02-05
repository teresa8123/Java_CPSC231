import java.util.LinkedList;
import java.util.Random;

public class Deck
{
    // Member Variables
    // A new deck that consists of all 52 cards (a card of each value and suit and color in a linked list card data stucture)
    private LinkedList<Card> m_cards;

    // Default Constructor ~ Initializes a fresh deck of 52 cards in the linked list
    public Deck()
    {
        m_cards = new LinkedList<Card>();

        for (int suit = 0; suit <= 3; suit++) // 0: Hearts, 1: Spades, 2: Clubs, 3: Diamonds
        { 
            // int color = (suit == Card.HEARTS || suit == Card.DIAMONDS) ? Card.RED : Card.BLACK;

            for (int value = 2; value <= 14; value++) // 2-10, 11=J, 12=Q, 13=K, 14=A
            { 
                // Add card to the deck
                m_cards.add(new Card(value, suit /*, color */));
            }
        }
    }
    // Copy Constructor ~ Creates a deck from another deck
    public Deck(Deck original)
    {
        m_cards = original.m_cards;
    }

    // toString ~ Displays each card currently in the deck
    public String toString()
    {
        return m_cards.toString();
    }

    // size method ~ returns the number cards in the underlying LinkedList<Card> as an integer
    public int size()
    {
        return m_cards.size();
    }

    // deal method ~ removes a random card from the list and returns that card
    public Card deal()
    {
        Random rand = new Random();
        int r = rand.nextInt(m_cards.size());
        return m_cards.remove(r);
    }



}   
