import java.util.LinkedList;
import java.util.Random;

public class Deck
{
    // LinkedList that stores the cards currently in the deck
    private LinkedList<Card> m_cards;

    // Default Constructor ~ Initializes a standard 52-card deck
    public Deck()
    {
        m_cards = new LinkedList<Card>();

        for (int suit = 0; suit <= 3; suit++) // 0: Hearts, 1: Spades, 2: Clubs, 3: Diamonds
        {
            for (int value = 2; value <= 14; value++) // 2-10, 11=J, 12=Q, 13=K, 14=A
            {
                int color = (suit == Card.HEARTS || suit == Card.DIAMONDS) ? Card.RED : Card.BLACK;
                m_cards.add(new Card(value, suit, color));
            }
        }
    }

    // Copy Constructor ~ Copies the reference to an existing deck (not deep copy)
    public Deck(Deck original)
    {
        m_cards = original.m_cards;
    }

    // toString ~ Returns the list of cards in the deck as a string
    public String toString()
    {
        return m_cards.toString();
    }

    // Returns the number of cards remaining in the deck
    public int size()
    {
        return m_cards.size();
    }

    // Removes and returns a random card from the deck
    public Card deal()
    {
        Random rand = new Random();
        int r = rand.nextInt(m_cards.size());
        return m_cards.remove(r);
    }

    // Adds a card back into the deck (used when reshuffling from discard pile)
    public void addCard(Card c)
    {
        m_cards.add(c);
    }
}
