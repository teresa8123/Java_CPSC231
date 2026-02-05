public class Driver
{
    public static void main(String[] args)
    {
        System.out.println("=== Welcome to the Game of Spoons! ===");

        Game game = new Game(); // uses default constructor
        int loser = game.play();

        System.out.println("\n=== Game Over ===");
        System.out.println("Player " + loser + " did not get a spoon and loses the game!");
    }
}
