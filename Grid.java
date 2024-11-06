public class Grid {
    final static int HEIGHT = 6;
    final static int WIDTH = 7;

    protected char[][] grid;

    public Grid() {
        // Create new grid
        this.grid = new char[HEIGHT][WIDTH];
        for (char[] row : grid) {
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
            }
        }
        return true;
    }

    // Update a new disc into the grid
    public void getDisc(Disc disc) {
        // Update the disc into the first empty row
        for (int i = grid.length - 1; i >= 0; i--) {
            if (grid[i][disc.getGridColumn()] == ' ') {
                grid[i][disc.getGridColumn()] = disc.getSymbol();
                break;
            }
        }
    }

    // Check if game has a winner after the latest disc
    // Return true either when there is a winning situation or grid is full (a tie)
    // Return false if there is no winning situation or grid 
    public boolean haveWinner(Disc latestDisc) {
        // Winning situations comprise horizontal, vertial and diagonal checks

        // Horizontal check

        // Vertical check

        // Diagonal check (top-left to bottom-right)

        // Diagonal check (bottom-left to top-right)

        // Check if grid is full after checking winning situation
        if (this.isFull())
            return true;


        return false;
    }

    // Visualise the current state of the grid
    // The grid visual consists of 7 rows, in which the first row indicates the column numbers,
    // and the following rows hold players' discs
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
