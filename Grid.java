public class Grid {
    final static int HEIGHT = 6;
    final static int WIDTH = 7;
    private char[][] grid;

    public Grid() {
        // Initialise a new grid
        this.grid = new char[HEIGHT][WIDTH];
        for (char[] row : grid) {
            for (int col = 0; col < row.length; col++) {
                row[col] = ' ';
            }
        }
    }

    // Check if grid is full
    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Check if a column is full. Parameter: player's column
    public boolean columnIsFull(int playersColumn) {
        // Grid column starts from 0, Player's column starts from 1
        int gridColumn = playersColumn - 1;
        for (char[] row : grid) {
            if (row[gridColumn] == ' ') {
                return false;
            }
        }
        return true;
    }

    // Update a new disc into the grid. The disc goes to the first empty row
    public void getDisc(Disc disc) {
        for (int i = grid.length - 1; i >= 0; i--) {
            if (grid[i][disc.getGridColumn()] == ' ') {
                grid[i][disc.getGridColumn()] = disc.getSymbol();
                disc.setRow(i);
                break;
            }
        }
    }

    // Check if game has a winner after the latest disc
    // Return true either when there is a winning situation or grid is full (a tie)
    // Return false if there is no winning situation or grid
    public boolean haveWinner(Disc latestDisc) {
        // Winning situations comprise horizontal, vertial and diagonal checks
        // Horizontal check: check on the row of lastest disc, if 4 disc in a row have the same symbol
        // 4 possibilities of winning discs' columns: 0-1-2-3, 1-2-3-4, 2-3-4-5, 3-4-5-6
        for (int col = 0; col <= 3; col++) {
            if (grid[latestDisc.getRow()][col] == latestDisc.getSymbol() && 
            grid[latestDisc.getRow()][col + 1] == latestDisc.getSymbol() &&
            grid[latestDisc.getRow()][col + 2] == latestDisc.getSymbol() && 
            grid[latestDisc.getRow()][col + 3] == latestDisc.getSymbol()) {
                return true;
            }
        }
    
        // Vertical check: latest disc is is on row 0-2 and 3 discs below latest disc have the same symbol
        if (latestDisc.getRow() <= 2 && 
        grid[latestDisc.getRow() + 1][latestDisc.getGridColumn()] == latestDisc.getSymbol() && 
        grid[latestDisc.getRow() + 2][latestDisc.getGridColumn()] == latestDisc.getSymbol() && 
        grid[latestDisc.getRow() + 3][latestDisc.getGridColumn()] == latestDisc.getSymbol()) {
            return true;
        }
        
        // Diagonal check (bottom-left to top-right)
        // if latestDisc in col 0 and min row = 3, check upper
        if (latestDisc.getGridColumn() == 0 && latestDisc.getRow() >= 3) {
            if (grid[latestDisc.getRow() - 1][latestDisc.getGridColumn() + 1] == latestDisc.getSymbol() &&
            grid[latestDisc.getRow() - 2][latestDisc.getGridColumn() + 2] == latestDisc.getSymbol() &&
            grid[latestDisc.getRow() - 3][latestDisc.getGridColumn() + 3] == latestDisc.getSymbol()) {
                return true;
            }
        }
        // if latestDisc in col 6 and max row = 2, check lower
        if (latestDisc.getGridColumn() == 6 && latestDisc.getRow() <= 2) {
            if (grid[latestDisc.getRow() + 1][latestDisc.getGridColumn() - 1] == latestDisc.getSymbol() &&
            grid[latestDisc.getRow() + 2][latestDisc.getGridColumn() - 2] == latestDisc.getSymbol() &&
            grid[latestDisc.getRow() + 3][latestDisc.getGridColumn() - 3] == latestDisc.getSymbol()) {
                return true;
            }
        }
        // if latestDisc in col 1-5, check each case diagonal if 4 consecutive discs (not out of range) same symbol
        
        
        // Diagonal check (top-left to bottom-right)
        // Check if grid is full after checking winning situation
        if (this.isFull()) {
            return true;
        }

        return false;
    }

    // Visualise the current state of the grid
    // The grid visual consists of 7 rows, in which the first row indicates
    // the column numbers, and the following rows hold players' discs
    @Override
    public String toString() {
        String gridVisual = "";
        String firstRowVisual = String.format("\n| 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n");

        gridVisual += firstRowVisual;

        for (char[] row : grid) {
            String discRowVisual = "|";
            for (char cell : row) {
                discRowVisual += String.format(" %s |", cell);
            }
            discRowVisual += "\n";
            gridVisual += discRowVisual;
        }

        return gridVisual;
    }
}
