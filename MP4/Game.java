public class Game
{
    // Member Variables
    private Player[] m_players;           
    private Dealer m_dealer;   
    public static int m_nSpoons;          
    private int[] m_placementOrder;          // Tracks the order players took spoons
    private int m_currentPlacement;          // Tracks placement index (1st, 2nd, etc.)

    // Default Constructor ~ Initializes a game with 4 players and 3 spoons
    public Game()
    {
        m_dealer = new Dealer();
        m_players = new Player[4];
        m_nSpoons = 3;
        m_placementOrder = new int[4];
        m_currentPlacement = 0;

        Player.setNumSpoons(m_nSpoons); // Sync spoon count with Player class

        for (int i = 0; i < m_players.length; i++)
        {
            m_players[i] = new Player(i + 1, m_dealer); // Assign each player 4 cards
        }
    }

    // Overloaded Constructor ~ Allows a custom array of players
    public Game(Player[] players)
    {
        m_players = players;
        m_dealer = new Dealer();
        m_nSpoons = players.length - 1;
        m_placementOrder = new int[players.length];
        m_currentPlacement = 0;

        Player.setNumSpoons(m_nSpoons);

        for (Player p : m_players)
        {
            if (p != null) {
                p.setHasSpoon(false); 
            }
        }
    }

    // Play method ~ Core gameplay loop
    public int play()
    {
        boolean spoonStolen = false;
        Card passedCard = m_dealer.deals(1).get(0); // Start with 1 card from dealer

        System.out.println("Game starting with " + m_nSpoons + " spoons!");

        // Main game loop continues until one player is left without a spoon
        while (m_nSpoons > 0 && !isGameOver())
        {
            for (int i = 0; i < m_players.length; i++)
            {
                Player currentPlayer = m_players[i];

                // Skip players who already have a spoon
                if (currentPlayer.doesPlayerHaveSpoon())
                {
                    continue;
                }

                // Player takes their turn and returns a card to pass
                passedCard = handleCardPassing(currentPlayer, passedCard);

                // First player to get 4 of a kind steals the first spoon
                if (!spoonStolen && currentPlayer.hasFourOfAKind())
                {
                    spoonStolen = true;
                    currentPlayer.stealSpoon(); 
                    System.out.println("Player " + currentPlayer.getPlayerNum() + " got FOUR of a kind (" + currentPlayer.getMatchValue() + ") and stole a spoon!");
                    m_placementOrder[m_currentPlacement++] = currentPlayer.getPlayerNum();
                }

                // Other players notice and attempt to steal remaining spoons
                if (spoonStolen && m_nSpoons > 0)
                {
                    for (int j = 0; j < m_players.length; j++) {
                        if (j != i && !m_players[j].doesPlayerHaveSpoon())
                        {
                            if (m_players[j].noticeSpoon())
                            {
                                System.out.println("Player " + m_players[j].getPlayerNum() + " noticed and stole a spoon.");
                                m_placementOrder[m_currentPlacement++] = m_players[j].getPlayerNum();
                            }
                        }
                    }
                }

                // Stop early if game ends mid-round
                if (m_nSpoons == 0 || isGameOver())
                {
                    break;
                }
            }
        }

        // Display results after loop ends
        displayFinalResults();

        // Return the losing player number
        for (Player p : m_players)
        {
            if (!p.doesPlayerHaveSpoon())
            {
                return p.getPlayerNum();
            }
        }

        return -1;
    }

        // Accessors and Mutators
    public Player[] getPlayer()
    {
        return m_players;
    }

    public void setPlayer(Player[] player)
    {
        m_players = player;
    }

    public Dealer getDealer()
    {
        return m_dealer;
    }

    public void setDealer(Dealer dealer)
    {
        m_dealer = dealer;
    }

    public int getNumSpoons()
    {
        return m_nSpoons;
    }

    public void setNumSpoons(int numSpoons)
    {
        m_nSpoons = numSpoons;
        Player.setNumSpoons(numSpoons);
    }

    // HELPER METHODS!!!
    // isGameOver ~ Determines if only one player remains spoonless
    private boolean isGameOver()
    {
        int playersWithoutSpoons = 0;
        for (Player p : m_players) {
            if (!p.doesPlayerHaveSpoon())
            {
                playersWithoutSpoons++;
            }
        }
        return playersWithoutSpoons == 1 || m_nSpoons == 0;
    }

    // handleCardPassing ~ Handles the logic of passing a card between players
    private Card handleCardPassing(Player currentPlayer, Card passedCard)
    {
        Card newCard = currentPlayer.takeTurn(passedCard);
        if (newCard == null && m_dealer.size() > 0)
        {
            return m_dealer.deals(1).get(0);
        }
        return newCard;
    }

    // displayFinalResults() ~ Displays the final order of spoon winners and the losing player
    private void displayFinalResults()
    {
        System.out.println("\n=== Final Placements ===");

        // Print all players who got spoons in order
        for (int i = 0; i < m_currentPlacement; i++)
        {
            int playerNum = m_placementOrder[i];
            Player player = findPlayerByNumber(playerNum);
            if (player != null)
            {
                System.out.println((i + 1) + getOrdinalSuffix(i + 1) + " Place: Player " + playerNum + " - Hand: " + player.getHand());
            }
        }

        // Print the losing player (didn't get a spoon)
        for (Player p : m_players)
        {
            if (!p.doesPlayerHaveSpoon())
            {
                System.out.println("Lost the game: Player " + p.getPlayerNum() + " - Hand: " + p.getHand());
                break;
            }
        }
    }

    // findPlayerByNumber ~ Finds player object by their player number
    private Player findPlayerByNumber(int playerNum)
    {
        for (Player p : m_players)
        {
            if (p.getPlayerNum() == playerNum)
            {
                return p;
            }
        }
        return null;
    }

    // getOrdinalSuffix ~ Gets the ordinal suffix for placement (1st, 2nd, etc.)
    private String getOrdinalSuffix(int n)
    {
        if (n >= 11 && n <= 13)
        {
            return "th";
        }
        switch (n % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}
