import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        // Get players' names
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the names of two players, divided by a space: ");
        String nameOne = s.next();
        String nameTwo = s.next();

        // Player
        Player playerOne = new Player(nameOne, 'X');
        System.out.println(playerOne.getName());
        System.out.println(playerOne.getSymbol());
        playerOne.takeTurn();

        // disc

        // grid

        // play game

        // visualise game

        // enhancement
        
    }
}