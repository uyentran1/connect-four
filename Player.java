public class Player {
    private String name;
    private char symbol;
    // reference to the grid
    // private Grid gameGrid;

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

    public void takeTurn() {
        System.out.println("test");
        // dropDisc
    }
}
