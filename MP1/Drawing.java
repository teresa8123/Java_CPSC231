/*   MP1: Drawing with 2D Arrays
 *   CPSC231
 *   Teresa Wong
 *   tewong@chapman.edu
 */
public class Drawing 
{
    /*
        This method takes in two integers (width and height)  return a two-dimensional
        char array of the specified width and height after initializing each item in the array creating a canvas.

        The canvas has a decorative border where all corners contain:   " + " ,
        all vertical edges contain:  ' | ' , 
        and all horizontal edges contain:  ' = ' . 
        All of the cells in the middle of the canvas are initialized to contain a space ' '
     */
    public static char[][] createCanvas(int width, int height)
    {
        // Create a 2D char array with the specified width and height
        char[][] canvas = new char[height][width];
    
        // Iterate through the canvas matrix
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                // Check if the current cell is on the border
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1)
                {
                    // Check if the current cell is a corner
                    if ((i == 0 && j == 0) || (i == 0 && j == width - 1) || (i == height - 1 && j == 0) || (i == height - 1 && j == width - 1))
                    {
                        canvas[i][j] = '+'; // Corners
                    }
                    else if (i == 0 || i == height - 1)
                    {
                        canvas[i][j] = '='; // Horizontal edges
                    } 
                    else
                    {
                        canvas[i][j] = '|'; // Vertical edges
                    }
                }
                else
                {
                    // Initialize the cells in the middle of the canvas with a space
                    canvas[i][j] = ' ';
                }
            }
        }
    
        return canvas;
    }


    /*
        This method takes in a reference to the canvas, the character you want to paint to the canvas,
        and the x and y coordinates of where you'd like to place that character. 
        
        It modifies the canvas array in memory by changing the cell at the specified X and Y coordinates.
    */
    public static void addCharacter(char[][] canvas, char emoji, int x, int y)
    {
        // Check if the coordinates are within the canvas bounds
        if (y >= 0 && y < canvas.length && x >= 0 && x < canvas[0].length)
        {
            canvas[y][x] = emoji; // Place the character at the specified position
        }
        else
        {
            System.out.println("Coordinates are out of bounds, Cannot place emoji.");
        }
    }


    /* 
        This method prints out the Canvas by iterating through each outer array as a single line,
        and each position in the outer array as a cell on that line.

        It also adds axis labels for you to the output, so you can verify
        that your characters are being added appropriately.
    */
    public static void printCanvas(char[][] canvas) {
        System.out.println();
        System.out.println();
        for (int i = 0; i < canvas.length; ++i) {
            System.out.print((canvas.length - i - 1) + " ");
            
            for (int col = 0; col < canvas[i].length; ++ col) {
                System.out.print(canvas[i][col]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.print(" ");
        for (int i = 0; i < canvas[0].length; ++i) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.println();
        System.out.println();


    }

    /*
        Main method to print out the ASCII Art:
        Printing this ASCII Art:
        +=========+
        |  /\_/\  |   
        | ( o.o ) |
        |  > ^ <  |
        +=========+

     */

    public static void main(String[] args)
    {
        // Create a canvas of width 11 and height 5 (to match the desired ASCII art)
        // Image was found in the ASCII Art Archive
        char[][] canvas = createCanvas(11, 5);
        
        // Add Characters to the Canvas
        // First line: /\_/\
        addCharacter(canvas, '/', 3, 1);
        addCharacter(canvas, '\\', 4, 1);
        addCharacter(canvas, '_', 5, 1);
        addCharacter(canvas, '/', 6, 1);
        addCharacter(canvas, '\\', 7, 1);
        
        // Second line: ( o.o )
        addCharacter(canvas, '(', 2, 2);
        addCharacter(canvas, 'o', 4, 2);
        addCharacter(canvas, '.', 5, 2);
        addCharacter(canvas, 'o', 6, 2);
        addCharacter(canvas, ')', 8, 2);
        
        // Third line: > ^ <
        addCharacter(canvas, '>', 3, 3);
        addCharacter(canvas, '^', 5, 3);
        addCharacter(canvas, '<', 7, 3);
        
        // Print out the canvas with the art added
        printCanvas(canvas);
    }
}
