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
    void initializeGrid() {
        int maxBombs = GridHelper.getMaxBombs((int)Math.pow(hiddenGrid.length, 2.0)); // A: How many bombs CAN this have?
        bombsPlaced = 0;                                                              // B: How many bombs DOES this have?
        int cycleCap = randomCycleCap();                                              // C:  Sets cycleCap to a randomly generated number between 0 and 15,
        int cycleCellCount = 0;                                                       // D:  cycleCap starts at zero and goes up

        for (int i = 0; i < hiddenGrid.length; i++) {
            for (int j = 0; j < hiddenGrid[i].length; j++) {

                if (hiddenGrid[i][j] == null) {
                    setCell(i, j, 0);     // a: initializes the null value to 0
                }
                if((cycleCellCount == cycleCap) && (bombsPlaced < maxBombs)){
                    placeBomb(i, j, -1);  // a: turns this cell into a bomb, increments cells around it
                    cycleCellCount = 0;           // b: Restarts the 'cycle counter'
                    cycleCap = randomCycleCap();  // c: Gives us a new number to 'count down' to, to place the next bomb
                } else{
                    ++cycleCellCount;             // a. Moves to the next cell in the 'cycle' having done nothing
                }
            }
        }
        System.out.println("Bombs placed: " + bombsPlaced);
    }

    /** generates a random number
     * between 0 and 15 for a count
     * down to the next bomb
     * @return the new 'cycle cap'
     */
    private static int randomCycleCap() {
        int newValue = 0;
        int iterations = 3;
        Random bombRandGen = new Random();

        for (int i = 0; i <= iterations; i++) {
            newValue += bombRandGen.nextInt(4);
        }

        return newValue;
    }

    /**
     * places a bomb and makes the appropriate changes
     * @param x row
     * @param y column
     * @param newValue new value this cell will be
     */
    private void placeBomb(int x, int y, int newValue) {
        setCell(x, y, newValue);               // a: Turns this cell into a bomb
        ++bombsPlaced;                         // b: increments bombs placed
        GridHelper.oneUpAll(x, y, hiddenGrid); // b: Increments all cells surrounding the new bomb
    }

    /**
     * returns the number of bombs placed on this map
     */
    int getBombsPlaced () {
        return bombsPlaced;
    }

    /**
     * returns the held value of a specific cell
     * @param x row
     * @param y column
     * @return value held in the cell x by y
     */
    int getCell(int x, int y) {
        try {
            return hiddenGrid[x][y];
        } catch (IndexOutOfBoundsException hiddenIndex) {}
        return hiddenGrid[x][y];
    }

    /**
     * sets a specific cell with the given integer
     * @param x row
     * @param y column
     * @param newValue value to set cell x by y to
     */
    private void setCell(int x, int y, int newValue) {
        hiddenGrid[x][y] = newValue;
    }

    /**
     * Passes our hiddenGrid object to be printed
     * cell by cell to the console
     */
    void printGrid() {
        GridHelper.printGrid(hiddenGrid);
    }
}

