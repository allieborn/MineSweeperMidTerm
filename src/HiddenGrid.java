import java.util.Random;

/**
 * Initialization of a hidden grid object that
 * holds bombs, numbers, and empty cells
 *
 * @author Sarah Guarino
 * @author Allie Born
 * @version 1.0
 */
class HiddenGrid {

    private Integer[][] hiddenGrid;
    private int bombsPlaced;

    /**
     * constructor for HiddenGrid objects
     * @param userGridRequest how many cells wide and tall the user requested
     */
    HiddenGrid(int userGridRequest) {
        hiddenGrid = new Integer[userGridRequest][userGridRequest];
        bombsPlaced = 0;
    }

    /**
     * Randomly generates bombs in the grid for every game,
     * and increments the cells around it
     */
    void initializeGrid() { // FIXME: Portion this out!
        int maxBombs = GridHelper.getMaxBombs(hiddenGrid.length * hiddenGrid.length); // A: How many bombs CAN this have?
        bombsPlaced = 0;                                                                  // B: How many bombs DOES this have?

        Random bombRandGen = new Random();
        int cycleCap = bombRandGen.nextInt(5)               // A:  Sets cycleCap to a randomly generated number between 0 and 15,
                + bombRandGen.nextInt(5)                    //     which will change every "cycle". A cycle starts over and a
                + bombRandGen.nextInt(5);                   //     new bomb is placed when cycleCellCount matches CycleCap
        int cycleCellCount = 0;                                   // B:  cycleCap starts at zero and goes up

        for (int i = 0; i < hiddenGrid.length; i++) {  // two birdies nested, checking each individual cell
            for (int j = 0; j < hiddenGrid[i].length; j++) {
                if (hiddenGrid[i][j] == null) {
                    setCell(i, j, 0);
                }

                // A: if it's time to place a bomb,
                //    and we HAVEN'T hit 'maximum bombs'
                if ((cycleCellCount == cycleCap) && (bombsPlaced < maxBombs)) {
                    setCell(i, j, -1);                    // 1: Turns this cell into a bomb
                    GridHelper.oneUpAll(i, j, hiddenGrid);        // 2: Increments all cells surrounding the new bomb
                    ++bombsPlaced;                                // 3: Increments the current bomb total
                    cycleCellCount = 0;                           // 4: Restarts the 'cycle counter'
                    cycleCap = bombRandGen.nextInt(5)       // 5. Sets the next cycle's "cap" to an integer between 0 and 15
                            + bombRandGen.nextInt(5)
                            + bombRandGen.nextInt(5);

                // B: if it's time to place a bomb,
                //    and we HAVE hit maximum bombs,
                //    and the value isn't already filled with something else
                }  else {
                    ++cycleCellCount; // 0. Moves to the next cell in the 'cycle' having done nothing
                }
            }
        }
    }

    /**
     * returns the held value of a specific cell
     * @param x row
     * @param y column
     * @return value held in the cell x by y
     */
    int getCell(int x, int y) {
        return hiddenGrid[x][y];
    }

    /**
     * sets a specific cell with the given integer
     * @param x row
     * @param y column
     * @param newValue value to set cell x by y to
     */
    void setCell(int x, int y, int newValue) {
        hiddenGrid[x][y] = newValue;
    }

    /**
     * Passes our hiddenGrid object to be printed
     * cell by cell to the console
     */
    void printGrid() {
        GridHelper.printGrid(hiddenGrid);
    }

    int getSafeCells (int gridLength) {
        return (gridLength * gridLength) - bombsPlaced;
    }
}

