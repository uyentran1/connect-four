public class Disc {
    private char symbol;
    private int playersColumn; // position int[] or column?
    private int gridColumn; // position int[] or column?

    public Disc(char symbol, int playersColumn) {
        this.symbol = symbol;
        this.playersColumn = playersColumn;
        // Grid column starts from 0, Player's column starts from 1
        this.gridColumn = playersColumn - 1;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getPlayersColumn() {
        return playersColumn;
    }
    
    public int getGridColumn() {
        return gridColumn;
    }
}
