public class PizzaOrder
{
    /* Private member variables */
    private Pizza[] m_order;    // Array of type Pizza (each pizza saved in this array is a pizza object)
    private int m_numPizzas;

    // Default Constructor ~ Deaults to an order of a single medium cheese pizza
    public PizzaOrder()
    {
        this.m_numPizzas = 1;
        this.m_order = new Pizza[m_numPizzas];    
        this.m_order[0] = new Pizza("medium", 1, 0, 0); // Default pizza single medium cheese
    }

    // Overloaded Constructor 
    public PizzaOrder(int numPizzaAdded)
    {
        this.m_order = new Pizza[numPizzaAdded];       // Takes in numPizzas for and adds the number of pizzas and initizalizes the order to an empty array of that size
        this.m_numPizzas = 0;
    }

    // addPizza Method ~ Adds pizzas to the order array
    public int addPizza(Pizza pizza)
    {
        if (m_numPizzas < m_order.length)
        {  
            m_order[m_numPizzas] = pizza;    // Add pizza to the next available slot
            m_numPizzas++; 
            return 1;                    
        }
        else
        {
            return -1;
        }
    }

    // calcTotal Method ~ Returns the total cost of the order by adding up the prices of each pizza in the order
    public double calcTotal()
    {
        double totalOrderCost = 0;
        for (Pizza pizza : m_order)
        {
            totalOrderCost += pizza.calcCost(pizza.getSize(), pizza.getCheese(), pizza.getPepperoni(), pizza.getVeggie());
        }   
        return totalOrderCost;
    }

    // toString Method
    public String toString()
    {
        String order = "";
        for (int i = 0; i < m_numPizzas; i++)   // Loops through each pizza in the order and reads out each pizza
        {
            order += m_order[i].toString() + "\n";  
        }
        return order + "Order Total: $" + calcTotal();
    }
}