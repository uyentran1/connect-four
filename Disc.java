public class Disc {
    private char symbol;
    private int row;
    private int playerInputColumn; 
    private int gridColumn; 

    /**
     * Constructs a Disc with a given symbol and player's input column
     * @param symbol the symbol (X or O) representing the player
     * @param playerInputColumn the 1-based column number input by the player
     */
    public Disc(char symbol, int playerInputColumn) {
        this.symbol = symbol;
        this.playerInputColumn = playerInputColumn;
        // Convert player input (starts from 1) to grid column (starts from 0)
        this.gridColumn = playerInputColumn - 1;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getPlayersColumn() {
        return playerInputColumn;
    }
    
    public int getGridColumn() {
        return gridColumn;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
