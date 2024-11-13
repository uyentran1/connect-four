public class Grid {
    final static int HEIGHT = 6;
    final static int WIDTH = 7;
    private static final char EMPTY_CELL = ' ';
    private char[][] grid;

    // Initialise a new grid with empty cells
    public Grid() {
        this.grid = new char[HEIGHT][WIDTH];
        for (char[] row : grid) {
            for (int col = 0; col < row.length; col++) {
                row[col] = EMPTY_CELL;
            }
        }
    }

    // Check if the grid is full
    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    // Check if a column is full. Parameter: player input column (starts from 1)
    public boolean columnIsFull(int playerInputColumn) {
        int gridColumn = playerInputColumn - 1;
        return grid[0][gridColumn] != EMPTY_CELL;
    }

    // Place a new disc in the first empty row of the specified column
    public void placeDisc(Disc disc) {
        for (int i = grid.length - 1; i >= 0; i--) {
            if (grid[i][disc.getGridColumn()] == EMPTY_CELL) {
                grid[i][disc.getGridColumn()] = disc.getSymbol();
                disc.setRow(i);
                break;
            }
        }
    }

    // Check for a winning condition after placing the latest disc
    public boolean haveWinner(Disc latestDisc) {
        int row = latestDisc.getRow();
        int col = latestDisc.getGridColumn();
        char symbol = latestDisc.getSymbol();

        // Define directions as row and column increments: {rowIncrement, colIncrement}
        int[][] directions = {
            {0, 1}, // Horizontal
            {1, 0}, // Vertical
            {-1, 1}, // Diagonal (bottom-left to top-right)
            {1, 1} // Diagonal (top-left to bottom-right)
        };

        // Check each direction for a winning line
        for (int[] direction : directions) {
            if (checkLine(row, col, direction[0], direction[1], symbol)) {
                return true;
            }
        }
        
        return false;
    }

    // Helper method to check for four consecutive symbols in a given direction
    private boolean checkLine(int row, int col, int rowIncrement, int colIncrement, char symbol) {
        int count = 0;

        // Check 3 adjacent discs in both directions along the line
        for (int i = -3; i <= 3; i++) {
            int r = row + i * rowIncrement;
            int c = col + i * colIncrement;
            if (r >= 0 && r < HEIGHT && c >= 0 && c < WIDTH && grid[r][c] == symbol) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
            }
        }

        return false;
    }

    /**
     * Visualises the current state of the grid
     * The grid visual comprises a header row illustrating the column numbers,
     * followed by disc rows holding discs dropped by the players
     */
    @Override
    public String toString() {
        StringBuilder gridVisual = new StringBuilder();
        StringBuilder headerRowVisual = new StringBuilder("\n");

        // Use a loop to create the header row with column numbers
        for (int i = 1; i <= WIDTH; i++) {
            headerRowVisual.append(String.format("| %d ", i));
        }
        headerRowVisual.append("|\n");
        gridVisual.append(headerRowVisual);

        // Append each row of the grid with cell contents
        for (char[] row : grid) {
            StringBuilder discRowVisual = new StringBuilder("|");
            for (char cell : row) {
                discRowVisual.append(String.format(" %s |", cell));
            }
            discRowVisual.append("\n");
            gridVisual.append(discRowVisual);
        }

        return gridVisual.toString();
    }
}
