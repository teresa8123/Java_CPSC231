public class Pizza
{
    /* Private member variables */
    private String m_size; // Stores the size of the pizza small, medium, large

    // Stores number of toppings
    private int m_cheese;   
    private int m_pepperoni;
    private int m_veggie;

    // Default Constructor ~ Defaults to medium cheese pizza
    public Pizza()
    {
        this.m_size = "Medium";
        this.m_cheese = 1;
        this.m_pepperoni = 0;
        this.m_veggie = 0;
    }

    // Overloaded Constructor
    public Pizza(String s, int c, int p, int v)
    {
        this.m_size = s;
        this.m_cheese = c;
        this.m_pepperoni = p;
        this.m_veggie = v;
    }

    // Copy Constructor
    public Pizza(Pizza otherPizza)
    {
        this.m_size = otherPizza.getSize();
        this.m_cheese = otherPizza.getCheese();
        this.m_pepperoni = otherPizza.getPepperoni();
        this.m_veggie = otherPizza.getVeggie();
    }

    // Accessors and Mutators
    public String getSize()
    {
        return this.m_size;
    }
    public void setSize(String newSize)
    {
        this.m_size = newSize;
    }

    public int getCheese()
    {
        return this.m_cheese;
    }
    public void setCheese(int newCheese)
    {
        this.m_cheese = newCheese;
    }
    public int getPepperoni()
    {
        return this.m_pepperoni;
    }
    public void setPepperoni(int newPepperoni)
    {
        this.m_pepperoni = newPepperoni;
    }
    
    public int getVeggie()
    {
        return this.m_veggie;
    }
    public void setVeggie(int newVeggie)
    {
        this.m_veggie = newVeggie;
    }

    // calcCost() Method ~ Returns a double that is the cost of the pizza
    public double calcCost(String s, int c, int p, int v)
    {
        double toppingsCost;
        double totalCost = 0;
        if (s.equalsIgnoreCase("small"))
        {
            toppingsCost = (c + p + v) * 2;

            totalCost = 10 + toppingsCost;
        }
        else if (s.equalsIgnoreCase("medium"))
        {
            toppingsCost = (c + p + v) * 2;
            totalCost += 12 + toppingsCost;
        }
        else if (s.equalsIgnoreCase("large"))
        {
            toppingsCost = (c + p + v) * 2;
            totalCost += 14 + toppingsCost;
        }
        else
        {
            toppingsCost = (c + p + v) * 2;
            totalCost += 0 + toppingsCost;
        }
        return totalCost;
    }

    // toString method
    public String toString()
    {
        return "This is a " + this.m_size + " pizza with " 
        + this.m_cheese + " cheese toppings, " + this.m_pepperoni + " pepperoni toppings, and "
        + this.m_veggie + " veggie toppings. This pizza comes out to $" + calcCost(this.m_size, this.m_cheese, this.m_pepperoni, this.m_veggie);
    }

    // equals Method ~ Checks to see if two pizzas are the same
    public boolean equals(Object o)
    {
        if (!(o instanceof Pizza))
        {
            return false;
        }
        else
        {
            Pizza other = (Pizza) o;
            return this.m_size.equals(other.getSize()) && this.m_cheese == other.getCheese() && this.m_pepperoni == other.getPepperoni() && this.m_veggie == other.getVeggie();
        }

    }
}