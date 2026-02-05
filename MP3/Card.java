public class Card
{
    //MEMBER VARIABLES STORED AS INTEGERS
    private int m_value;
    private int m_suit;
    // private int m_color;

    // Member Variables for a value (2-10, J, Q, K, A)
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    // Member Variables for a suit (heart, spade, clubs diamonds)
    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    // // Member Variables for card color
    // public static final int RED = 0;
    // public static final int BLACK = 1;

    // Default Constructor (Creates an Red Ace of Spades)
    public Card()
    {
        m_value = 14;
        m_suit = 1;
        // m_color = 0;

    }

    // Overloaded Constructor
    public Card(int value, int suit /* , int color */) // Accepts a value and a suit
    {
        m_value = value;
        m_suit = suit;
        // m_color = color;

    }

    // Copy Constructor
    public Card(Card original)
    {
        m_suit = original.getSuit();
        m_value = original.getValue();
        // m_color = original.getColor();
    }

    // toString method ~ Displays the suit and value of the card
    public String toString()
    {
        // suits should be texutally represented 
        return "Card: " + /* getStringColor(m_color) + " " + */ getStringValue(m_value) + " of " + getStringSuit(m_suit);
    }

    // equals method ~ Assumes two cards are equal if their values are equal (suits can be different)
    public boolean equals(Object o) 
    {
        if (!(o instanceof Card))
        {
            return false;
        }
        else{
            Card otherCards = (Card) o;
            return this.m_value == otherCards.m_value && this.m_suit == otherCards.m_suit;
        }
    }

    // Accessors & Mutators
    public int getValue()
    {
        return m_value;
    }
    public String getStringValue(int value)
    {
        switch (value)
        {
            case 2:
                return "Two";
            case 3: 
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6: 
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9: 
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13: 
                return "King";
            case 14:
                return "Ace";
            default:
                return "None";
        }

    }
    public void setValue(int value)
    {
        m_value = value;
    }

    public int getSuit()
    {
        return m_suit;
    }
    public String getStringSuit(int suit)
    {
        switch (suit)
        {
            case 0:
                return "Hearts";
            case 1: 
                return "Spades";
            case 2:
                return "Clubs";
            case 3:
                return "Diamonds";
            default:
                return "None";
        }
    }
    public void setSuit(int suit)
    {
        m_suit = suit;
    }

    // public int getColor()
    // {
    //     return m_color;
    // }
    // public String getStringColor(int color)
    // {
    //     switch (color)
    //     {
    //         case 0:
    //             return "Red";
    //         case 1:
    //             return "Black";
    //         default:
    //             return "None";
    //     }
    // }
    // public void setColor(int color)
    // {
    //     m_color = color;
    // }
}