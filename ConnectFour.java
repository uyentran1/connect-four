import java.util.Scanner;

/**
 * This ConnectFour class has been enhanced to include a multi-round match format.
 * In this enhanced version, the game is played up to 3 rounds, with the player who wins
 * 2 rounds declared the final winner. After each round, the current score is displayed, 
 * and the match can end early if a player wins 2 rounds before reaching the third round.
 * This enhancement adds an additional layer of competition and allows for a "best of three" 
 * series, making the game more engaging for players.
 */
public class ConnectFour {
    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Connect Four Game!");
        
        // Get players' names
        System.out.print("Enter the name of Player 1: ");
        String nameOne = s.nextLine().trim();
        System.out.print("Enter the name of Player 2: ");
        String nameTwo = s.nextLine().trim();

        // Set symbols for each player
        char symbolOne = chooseSymbol(nameOne);
        char symbolTwo = (symbolOne == 'X') ? 'O' : 'X';

        // Create players with names and symbols
        Player playerOne = new Player(nameOne, symbolOne);
        Player playerTwo = new Player(nameTwo, symbolTwo);

        System.out.printf("%s's symbol is %c, and %s's symbol is %c.\n", 
                          playerOne.getName(), playerOne.getSymbol(), 
                          playerTwo.getName(), playerTwo.getSymbol());

        // Initialize round counter and scores
        int round = 1;
        // Play up to 3 rounds
        while (round <= 3 && playerOne.getScore() < 2 && playerTwo.getScore() < 2) {
            System.out.printf("\n--- Round %d ---\n", round);
            Grid gameGrid = new Grid();
            // Set the grid reference for each player
            playerOne.setGrid(gameGrid);
            playerTwo.setGrid(gameGrid);

            // Game loop for a single round
            Player nextPlayer = playerOne;
            boolean gameOver = false;
        
            while (!gameOver) {
                Disc latestDisc = nextPlayer.takeTurn(s);
                System.out.println(gameGrid);

                // Check if there is a winner or if the grid is full (tie) in this round
                if (gameGrid.haveWinner(latestDisc)) {
                    gameOver = true;
                    nextPlayer.incrementScore();
                    System.out.printf("Game over. %s wins this round!\n", nextPlayer.getName());
                } else if (gameGrid.isFull()) {
                    gameOver = true;
                    System.out.println("Game over. It's a tie!");
                }

                // Switch player for the next turn
                nextPlayer = (nextPlayer == playerOne) ? playerTwo : playerOne;
            }

            // Display the current score
            System.out.printf("Current score after round %d: %s - %d, %s - %d\n", 
                              round, playerOne.getName(), playerOne.getScore(), 
                              playerTwo.getName(), playerTwo.getScore());

            round++;
        }

        // Announce the final winner based on scores
        if (playerOne.getScore() > playerTwo.getScore()) {
            System.out.printf("\nCongratulations %s! You are the final winner with a score of %d to %d.\n", 
                              playerOne.getName(), playerOne.getScore(), playerTwo.getScore());
        } else if (playerTwo.getScore() > playerOne.getScore()) {
            System.out.printf("\nCongratulations %s! You are the final winner with a score of %d to %d.\n", 
                              playerTwo.getName(), playerTwo.getScore(), playerOne.getScore());
        } else {
            System.out.println("\nThe game ends in a draw after 3 rounds!");
        }

        s.close();
    }

    // Method for Player 1 to choose symbol
    public static char chooseSymbol(String playerName) {
        char symbol;
        while (true) { 
            System.out.printf("%s, choose your symbol (X or O): ", playerName);
            symbol = s.nextLine().trim().toUpperCase().charAt(0);
            if (symbol == 'X' || symbol == 'O') {
                return symbol;
            } else {
                System.out.println("Invalid choice. Please choose either X or O.");
            }
        }
    }
}