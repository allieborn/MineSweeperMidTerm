import java.util.Random;

class HiddenGrid {

    private int[][] hiddenGrid;

    /**
     * constructor for HiddenGrid objects
     * @param userGridRequest how many cells wide and tall the user requested
     */
    HiddenGrid(int userGridRequest) {
        hiddenGrid = new int[userGridRequest][userGridRequest];
    }

    int getCell(int x, int y) {
        return hiddenGrid[x][y];
    }

    private void setCell(int x, int y, int newValue) {
        hiddenGrid[x][y] = newValue;
    }

    void initializeGrid() {
        // calculates the max number of bombs this game CAN have, and how many it DOES have, respectively
        int maxBombs = GridHelper.getMaxBombs(hiddenGrid.length * hiddenGrid.length);
        int bombsPlaced = 0;

        // creates a Random object bombGen to generate numbers between 0 and 9
        Random bombRandGen = new Random();
        // Randomly generates how many cells to pass before placing another bomb, 0-18.
        int cycleCellMax = bombRandGen.nextInt(9) + bombRandGen.nextInt(9);
        // bomb will be placed when this number matches "cycleMax"
        int cycleCellCount = 0;

        // two birdies nested, checking each individual cell
        for (int i = 0; i < hiddenGrid.length; i++) {
            for (int j = 0; j < hiddenGrid[i].length; j++) {
                // if this Cycle's 'max' has been reached AND we haven't hit our 'maximum' bombs limit, place a bomb.
                if ((cycleCellCount == cycleCellMax) && (bombsPlaced < maxBombs)) {
                    //sets the current cell to a bomb
                    setCell(i, j, -1);

                    // increments all cells around it
                    oneUp(i, j - 1); // N
                    oneUp(i + 1, j - 1); // NE
                    oneUp(i + 1, j  ); // E
                    oneUp(i + 1, j - 1); // SE
                    oneUp(i , j - 1); // S
                    oneUp(i - 1, j + 1); // SW
                    oneUp(i - 1, j); // W
                    oneUp(i - 1, j + 1); // NW


                    // restart this cycle's counter
                    cycleCellCount = 0;
                    // adds current bomb to total
                    ++bombsPlaced;
                    // How many cells to pass before place another bomb?
                    cycleCellMax = bombRandGen.nextInt(5) + bombRandGen.nextInt(5) + bombRandGen.nextInt(5);
                } else {
                    ++cycleCellCount;
                }
            }
        }

        System.out.println("Bombs Placed: " + bombsPlaced);
    }

    /**
     * Prints entire Mirror Grid to the console
     */
    void printGrid() {
        // PRINTS TOP ROW OF COLUMN LABELS
        System.out.print("\t|");
        for (int s = 0; s < hiddenGrid.length; s++) {
            System.out.print("y" + s + "\t|");
        }
        System.out.println();

        // creates first border
        for (int s = 0; s <= hiddenGrid.length; s++) {
            System.out.print(" __\t");
        }
        System.out.println();

        // Iterates through every row x
        for (int i = 0; i < hiddenGrid.length; i++) {
            System.out.print("x" + i + "\t|");
            for (int j = 0; j < hiddenGrid[i].length; j++) {
                System.out.print(hiddenGrid[i][j] + "\t|");
            }
            System.out.println();
            for (int s = 0; s <= hiddenGrid.length; s++) {
                System.out.print(" __\t");
            }
            System.out.println();
        }
    }

    private void oneUp(int x, int y) {
        try {
            if(hiddenGrid[x][y] > -1) {
                hiddenGrid[x][y] = hiddenGrid[x][y] + 1;
            }
        } catch(IndexOutOfBoundsException e) {
        }
    }

    // THINGS THIS CLASS WILL DO
    // [in progress] "Set" or initialize it's entire self (done with GridHelper)

}

