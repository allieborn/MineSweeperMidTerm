/**
 * Initialization of a mirror grid object that
 * displays hidden cells, found cells, and flagged cells
 *
 * @author Sarah Guarino
 * @author Allie Born
 * @version 1.0
 */
class MirrorGrid {
    private Integer [][] mirrorGrid;

    /**
     * Constructor initializes Mirror Array to height and width chosen by user
     * @param userGridRequest user entered rows and columns (will always be a square)
     */
    MirrorGrid(int userGridRequest) {
        mirrorGrid = new Integer[userGridRequest][userGridRequest];
    }

    /**
     * initializes the mirrorGrid object with a
     * 'clean slate' of the default value passed
     */
    void initializeGrid() {
        for (int i = 0; i < mirrorGrid.length; i++) {         // 1: Loops through every 'row'
            for (int j = 0; j < mirrorGrid.length; j++) {     // 2: Loops through every 'column' in each row
                setCell(i, j, 0);                  // 3: sets the specific cell at i by j to the defaultValue given
            }
        }
    }

    /**
     * Returns the value of a specific cell
     * @param x the row the value can be found in
     * @param y the column the value can be found in
     * @return [x][y] cell's value
     */
    // Returns the value of a specific cell
    Integer getCell (int x, int y) {
        return mirrorGrid[x][y];
    }

    /**
     * Sets the vakue of a specific cell
     * @param x the row to set
     * @param y the column to set
     * @param newCellValue the value the cell will be initialized with
     */
    void setCell (int x, int y, Integer newCellValue) {
        mirrorGrid[x][y] = newCellValue;
    }

    /**
     * Passes our hiddenGrid object to be printed
     * cell by cell to the console
     */
    void printGrid() {
        GridHelper.printGrid(mirrorGrid);
    }
}

