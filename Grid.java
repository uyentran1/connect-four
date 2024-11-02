public class Grid {
    final static int HEIGHT = 6;
    final static int WIDTH = 7;

    protected char[][] gameGrid;

    public Grid() {
        // Create new grid
        this.gameGrid = new char[HEIGHT][WIDTH];
        for (char[] row : gameGrid) {
            for (int i = 0; i < row.length; i++)
                row[i] = ' ';
        }
    }

    // Check if grid is full
    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == ' ')
                    return false;
        return true;
            }
        }
    }

    // Update a new disc into game grid
    public void getDisc(Disc newDisc) {
        for (char[] row : gameGrid) {
            for (int i = 0; i < newDisc.getPosition(); i++) {
                if (row[i] == ' ') {
                    row[i] = newDisc.getSymbol();
                    break;
                }
            }
        }
    }

    // Check if game has a winner
    public boolean haveWinner() {
        // win senarios list

        // for scenario in senarios, if scenarios (== true), return true. 


        return true;
    }
}
