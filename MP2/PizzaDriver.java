// Driver class for the Pizza and PizzaOrder class
public class PizzaDriver
{
    public static void main(String args[])
    {
        // Create Pizzas
        Pizza pizza1 = new Pizza("small", 1, 0 , 1);    // small pizza, 1 cheese, 1 veggie
        Pizza pizza2 = new Pizza("large", 2, 2, 0);     // large pizza, 2 cheese, 2 pepperoni
        Pizza pizza3 = new Pizza(pizza2);   // Same as pizza 2, using copy constructor
        Pizza pizza4 = new Pizza(pizza1);   // Same as pizza 1, using copy constructor
        
        // Create an order of THREE pizzas
        PizzaOrder order = new PizzaOrder(3); 

        // Add Pizzas to Order
        System.out.println(order.addPizza(pizza1));     // add pizza1 to the order
        System.out.println(order.addPizza(pizza2));     // add pizza2 to the order
        System.out.println(order.addPizza(pizza3));     // add pizza3 to the order
        System.out.println(order.addPizza(pizza4));     // add pizza4 to the order ~ prints -1 because order is full


        // Check if pizza1 and pizza 2 the same
        System.out.println(pizza1.equals(pizza3));

        // Prints the order using orders toString method
        System.out.println(order); 
    }
}