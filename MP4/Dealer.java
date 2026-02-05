import java.util.Collections;
import java.util.LinkedList;

public class Dealer
{
    private Deck m_deck;                     // The current deck of cards
    private LinkedList<Card> m_discardPile; 

    // Default Constructor ~ initializes both deck and discard pile
    public Dealer()
    {
        m_deck = new Deck();
        m_discardPile = new LinkedList<Card>();
    }

    // deals ~ Deals up to n cards, refilling from discard pile if necessary
    public LinkedList<Card> deals(int n)
    {
        LinkedList<Card> dealtCards = new LinkedList<Card>();

        for (int i = 0; i < n; i++)
        {
            // If deck is empty, attempt to refill from discard pile
            if (m_deck.size() == 0 && !m_discardPile.isEmpty())
            {
                reshuffleFromDiscard();
            }

            // If there's still a card to draw, add it to the dealt hand
            if (m_deck.size() > 0)
            {
                dealtCards.add(m_deck.deal());
            }
        }

        return dealtCards;
    }

    // discard ~ Adds a card to the discard pile
    public void discard(Card c)
    {
        if (c != null)
        {
            m_discardPile.add(c);
        }
    }

    // reshuffleFromDiscard !~Refill the deck by shuffling and moving all cards from discard pile
    private void reshuffleFromDiscard()
    {
        Collections.shuffle(m_discardPile); // Randomize the discard pile
        while (!m_discardPile.isEmpty())
        {
            m_deck.addCard(m_discardPile.remove());
        }
    }

    // size ~ Returns the number of cards left in the deck
    public int size()
    {
        return m_deck.size();
    }

    // toString ~ Returns a string representation of the current deck
    public String toString()
    {
        return m_deck.toString();
    }
}
