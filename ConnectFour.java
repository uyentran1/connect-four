import java.util.Scanner;

public class ConnectFour {
    static String nameOne = "";
    static String nameTwo = "";
    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Connect Four Game!");
        
        // Get players' names
        getPlayersNames();
        System.out.printf("\nWelcome, %s and %s! ", nameOne, nameTwo);
        System.out.printf("%s's symbol is X, and %s's symbol is O.\n", nameOne, nameTwo);

        // Initialise player scores and round counter
        int scoreOne = 0;
        int scoreTwo = 0;
        int round = 1;

        // Play up to 3 rounds
        while (round <= 3 && scoreOne < 2 && scoreTwo < 2) {
            System.out.printf("\n--- Round %d ---\n", round);
            Grid gameGrid = new Grid();
            Player playerOne = new Player(nameOne, 'X', gameGrid);
            Player playerTwo = new Player(nameTwo, 'O', gameGrid);

            // Game loop for a single round
            Player nextPlayer = playerOne;
            boolean gameOver = false;
        
            while (!gameOver) {
                Disc latestDisc = nextPlayer.takeTurn(s);
                System.out.println(gameGrid);

                // Check if there is a winner or if the grid is full (tie)
                if (gameGrid.haveWinner(latestDisc)) {
                    gameOver = true;
                    if (nextPlayer == playerOne) {
                        scoreOne++;
                    } else {
                        scoreTwo++;
                    }
                    System.out.printf("Gameover. %s wins this round!\n", nextPlayer.getName());
                } else if (gameGrid.isFull()) {
                    gameOver = true;
                    System.out.println("Gameover. It's a tie!");
                }

                // Switch player
                nextPlayer = (nextPlayer == playerOne) ? playerTwo : playerOne;
            }

            // Display the current score
            System.out.printf("Current score after round %d: %s - %d, %s - %d\n", 
                                round, nameOne, scoreOne, nameTwo, scoreTwo);

            round++;
        }

        // Announce the final winner
        if (scoreOne > scoreTwo) {
            System.out.printf("\nCongratulations %s! You are the final winner with a score of %d to %d.\n", 
                              nameOne, scoreOne, scoreTwo);
        } else if (scoreTwo > scoreOne) {
            System.out.printf("\nCongratulations %s! You are the final winner with a score of %d to %d.\n", 
                              nameTwo, scoreTwo, scoreOne);
        } else {
            System.out.println("\nThe game ends in a draw after 3 rounds!");
        }

        s.close();
    }

    // Method to get the names of the players
    public static void getPlayersNames() {
        do {
            System.out.print("Please enter the names of two players, each on a new line:\n");
            // Read two lines of input
            if (s.hasNextLine()) {
                nameOne = s.nextLine().trim();
            }
            if (s.hasNextLine()) {
                nameTwo = s.nextLine().trim();
            }
            // Check if both inputs are non-empty
            if (nameOne.isEmpty() || nameTwo.isEmpty()) {
                System.out.println("Invalid input. Make sure you enter two names on separate lines.");
            }
        } while (nameOne.isEmpty() || nameTwo.isEmpty());
    }
}