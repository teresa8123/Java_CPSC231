import java.util.LinkedList;
import java.util.Random;

public class Player
{
    private int m_playerNum;
    private LinkedList<Card> m_hand;
    private boolean m_hasSpoon;
    private static int m_nSpoons;
    private int m_matches;
    private int m_matchValue;
    
    // Overlaoded Constructor - takes a player number and a reference to the games dealer
    public Player(int playerNum, Dealer dealer)
    {
        // RETRIEVE 4 CARDS FROM THE DEALER AND PLACE THEM IN THE LINKEDLIST REPRESENTING THE PLAYERS HAND SO EVERY PLATER STARTS THE GAME WITH 4 CARDS
        m_hand = dealer.deals(4);
        m_playerNum = playerNum;
        m_hasSpoon = false;
        m_matches = 0;
        m_matchValue = 0;
    }

    // Another overloaded constructor that takes a player number and a LinkedList of cards representing their entire hand
    public Player(int playerNum, LinkedList<Card> hand)
    {
        m_playerNum = playerNum;
        m_hand = hand;
        m_hasSpoon = false;
        m_matches = 0;
        m_matchValue = 0;
        
    }

    // takeTurn ~ executes a players turns given a new card
    public Card takeTurn(Card passedCard)
    {
        m_hand.add(passedCard);
    
        int[] valueCounts = new int[15];
        for (Card c : m_hand) valueCounts[c.getValue()]++;
    
        int maxCount = 0, bestValue = 0;
        for (int val = 2; val <= 14; val++)
        {
            if (valueCounts[val] > maxCount)
            {
                maxCount = valueCounts[val];
                bestValue = val;
            }
        }
    
        m_matches = maxCount;
        m_matchValue = bestValue;
    
        if (m_matches == 4)
        {
            System.out.println("Player " + m_playerNum + " got FOUR of a kind (" + bestValue + ")!");
            stealSpoon();
            return null;
        }
    
        for (int i = 0; i < m_hand.size(); i++)
        {
            if (m_hand.get(i).getValue() != bestValue)
            {
                return m_hand.remove(i);
            }
        }
    
        return m_hand.remove(new Random().nextInt(m_hand.size()));
    }
    
    

    // stealSpoon ~ decreases spoon count and announces it
    public void stealSpoon()
    {
        if (!m_hasSpoon && m_nSpoons > 0)
        {
            m_hasSpoon = true;
            m_nSpoons--;
            System.out.println(">>> Player " + m_playerNum + " stole a spoon! Remaining spoons: " + m_nSpoons);
        }
    }
    
    // hasFourOfAkind ~ steals spoon if a player has 4 of a kind
    public boolean hasFourOfAKind()
    {
        if (m_matches == 4)
        {
            stealSpoon();
            return true;
        }
        else
        {
            return false;
        } 
    }


    // noticeSpoon Method ~ 33% chance that a player nocies a spon has been stolen
    public boolean noticeSpoon()
    {
        Random rand = new Random();
        int randomChance = rand.nextInt(100);
        if (randomChance <= 32)
        {
            stealSpoon();
            return true;
        }
        else
        {
            System.out.println("Player " + m_playerNum + " did NOT notice a missing spoon.");
            return false;
        }
    }
    
    // Accessors And Mutators
    public int getPlayerNum()
    {
        return m_playerNum;
    }
    public void setPlayerNum(int num)
    {
        m_playerNum = num;
    }

    public LinkedList<Card> getHand()
    {
        return m_hand;
    }
    public void setHand(LinkedList<Card> hand)
    {
        m_hand = hand;
    }

    public boolean doesPlayerHaveSpoon()
    {
        return m_hasSpoon;
    }
    public void setHasSpoon(boolean hasSpoon)
    {
        m_hasSpoon = hasSpoon;
    }

    public int getMatches()
    {
        return m_matches;
    }
    public void setMatches(int matches)
    {
        m_matches = matches;
    }

    public int getMatchValue()
    {
        return m_matchValue;
    }
    public void setMatchVaue(int matchValue)
    {
        m_matchValue = matchValue;
    }

    public static void setNumSpoons(int numSpoons)
    {
        m_nSpoons = numSpoons;
    }
    public static int getNumSpoons()
    {
        return m_nSpoons;
    }
}
