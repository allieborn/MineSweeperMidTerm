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

    int getHiddenCell(int y, int x) {
        return hiddenGrid[x][y];
    }

    private void setHiddenGrid(int x, int y, int newValue) {
        hiddenGrid[x][y] = newValue;
    }

    void initiateHiddenGrid() {
        // calculates the max number of bombs this game CAN have
        int maxBombs = GridHelper.getMaxBombs(hiddenGrid.length * hiddenGrid.length);
        int bombsPlaced = 0;

        // creates a Random object bombGen to generate numbers between 0 and 9
        Random bombRandGen = new Random();

        // bomb will be placed when this number matches "cycleMax"
        int cycleCellCount = 0;

        // Randomly generates how many cells to pass before placing another bomb
        int cycleCellMax = bombRandGen.nextInt(9) + bombRandGen.nextInt(9);

        for (int i = 0; i < hiddenGrid.length; i++) {
            for (int j = 0; j < hiddenGrid[i].length; j++) {
                // if maxbombs has not been reached, and this 'cycles' max cells is hit, place bomb
                if ((cycleCellCount == cycleCellMax) && (bombsPlaced < maxBombs)) {
                    //sets the current cell to a bomb
                    setHiddenGrid(i, j, -1);

                    // increments all cells around it
                    oneUps(i, j);

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

        System.out.println("*********Max Bombs: " + maxBombs);
        System.out.println("*********Current Bombs: " + bombsPlaced);
    }

    void printGridToConsole() {
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

    private void oneUps(int x, int y) {

    }

    // THINGS THIS CLASS WILL DO
    // [in progress] "Set" or initialize it's entire self (done with GridHelper)

}

