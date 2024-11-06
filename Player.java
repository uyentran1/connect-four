import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private Grid grid;

    public Player (String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    // Player is promted to enter a column to drop a new disc
    // After each turn, indicate move was valid
    // Update the gameGrid and return the latest Disc object
    public Disc takeTurn() {
        Scanner s = new Scanner(System.in);
        int column = -1;

        // Prompt until a valid column (1-7) is entered
        while (column < 1 || column > 7) {
            System.out.printf("%s, choose a column to drop your disc (1-7): ", name);
            if (s.hasNextInt()) {
                column = s.nextInt();
                if (column < 1 || column > 7) {
                    System.out.println("\nInvalid column. Please choose a number between 1 and 7.");
                }
                
            } else {
                System.out.println("\nInvalid input. Please enter a number.");
                s.next(); // Clear the invalid input
            }
        }
        // s.close();
        // TODO: If column is not full, indicate when move is valid and update grid
        System.out.println("\nValid move.");
        Disc latestDisc = new Disc(this.symbol, column);
        this.grid.getDisc(latestDisc);
        // TODO: If column is full, choose again

        return latestDisc;
    }
}
