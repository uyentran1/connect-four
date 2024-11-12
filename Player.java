import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private Grid grid;
    private int score;

    public Player (String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0; 
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    
    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    /**
     * Prompts the player to choose a column to drop their disc
     * Validates the input, ensuring the column is within range and not full
     * @param scanner the Scanner instance for reading input
     * @return the latest Disc object with the player's symbol and chosen column
     */
    public Disc takeTurn(Scanner scanner) {
        int column = -1;

        // Prompt until a valid column is entered
        while (column < 1 || column > 7) {
            System.out.printf("\n%s, choose a column to drop your disc (1-7): ", name);
            try {
                column = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                column = -1; // Reset column to continue the loop
                continue;
            }
            // Check if the chosen column is in range 
            if (column < 1 || column > 7) {
                System.out.println("\nInvalid column. Please choose a number between 1 and 7.");
            // Check if the chosen column is already full
            } else if (grid.columnIsFull(column)) {
                System.out.println("\nColumn is full. Please choose a another number between 1 and 7.");
                column = -1; // Reset column to re-prompt
            }   
        }

        System.out.println("\nValid move.");
        
        // Create and place the disc on the grid
        Disc latestDisc = new Disc(this.symbol, column);
        grid.placeDisc(latestDisc);

        return latestDisc;
    }
}
