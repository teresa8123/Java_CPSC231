import java.util.LinkedList;

public class Dealer
{
    // Member variables
    private Deck m_deck; 

    // Default Constructor ~ initializes m_deck to type of deck
    public Dealer()
    {
        m_deck = new Deck();
    }

    // deals method ~ Returns a new LinkedList that consists of n cards dealt randomly from the deck
    public LinkedList<Card> deals(int n)
    {
        LinkedList<Card> deltCards = new LinkedList<Card>();
        for (int i =0; i <  n; i++)
        {
            deltCards.add(m_deck.deal());
        }
        // return new linked list of cards - if deck is empty, return linked list of 0
        return deltCards;
    }

    // size method ~ Returns the number of cards in m_deck
    public int size()
    {
        return m_deck.size();
    }

    // toString method ~ calls toString on m_deck and returns the result
    public String toString()
    {
        return m_deck.toString();
    }
}