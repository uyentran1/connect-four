import java.util.Scanner;

public class ConnectFour {
    static String nameOne = "";
    static String nameTwo = "";
    // static Player playerOne;
    // static Player playerTwo;
    // static Player[] players = {playerOne, playerTwo};
    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Connect Four Game!");

        // Print the initial grid 
        Grid gameGrid = new Grid();
        System.out.println(gameGrid);
        
        getPlayersNames();

        // Set up players
        Player playerOne = new Player(nameOne, 'X');
        Player playerTwo = new Player(nameTwo, 'O');
        playerOne.setGrid(gameGrid); // Think how we can do this in Player class
        playerTwo.setGrid(gameGrid); // Think how we can do this in Player class
        System.out.println();
        System.out.printf("Welcome %s and %s! ", nameOne, nameTwo);
        System.out.printf("%s's symbol is %c, and %s's symbol is %c.\n", nameOne, playerOne.getSymbol(), nameTwo, playerTwo.getSymbol());
        System.out.println();
        
        
        // Game logic
        
        /*
        while game is not over (have winner or grid full)
        each player take turn
        after each turn, indicate move was valid, and game has won or ongoing
        
        print winner and grid (if game's over)
        
        */
        Player[] players = {playerOne, playerTwo};
        Player nextPlayer = players[0];
        boolean gameOver = false;
        while (!gameOver) {
            Disc latestDisc = nextPlayer.takeTurn();
            System.out.println(gameGrid);

            // After each turn, indicate game is over or on-going
            gameOver = gameGrid.haveWinner(latestDisc);
            if (gameOver)
                System.out.println("Gameover. (ABC is the winner or TIE.)");
            else
                System.out.println("Game is ongoing.");
            nextPlayer = (nextPlayer == players[0]) ? players[1] : players[0];
        }
        
    

        s.close();
        
    }

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