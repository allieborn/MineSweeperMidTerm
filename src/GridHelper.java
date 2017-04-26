/**
 * Methods that operate one the various grids in a program
 *
 * @author Sarah Guarino
 * @author Allie Born
 * @version 1.0
 */
class GridHelper {

    /**
     * Copies specific cell in Hidden Grid to Mirror Grid
     * @param x row value
     * @param y column value
     * @param hiddenGrid your HiddenGrid object
     * @param mirrorGrid your MirrorGrid object
     */
    static void copyHiddenCellToMirror(int x, int y, HiddenGrid hiddenGrid, MirrorGrid mirrorGrid) {
        mirrorGrid.setCell(x, y, hiddenGrid.getCell(x, y));
    }

    /**
     * calculates how many bombs a game should have at max, to avoid steep levels.
     * @param cellCount how many cells does the board have?
     * @return returns the maximum number of bombs this game can have
     */
    static int getMaxBombs (int cellCount) {
        int maxBombs = cellCount / 7;
        if (cellCount % 10 > 0) {
            maxBombs += 1;
        }
        return maxBombs;
    }

    /**
     * increments a cell appropriately, based on it's contents
     * @param x row
     * @param y column
     * @param hiddenObject array that is being operated on
     */
    private static void oneUp(int x, int y, Integer[][] hiddenObject) {
        try {
            if (hiddenObject[x][y] == null) {         // A: If this box is not initialized
                hiddenObject[x][y] = 1;
            } else if (hiddenObject[x][y] >= 0) {     // B: If this box is already initialized, +1
                hiddenObject[x][y] += 1;
            }
        } catch(IndexOutOfBoundsException doesntExist) {/* If index is out of bounds, do nothing & move on*/}
    }

    /**
     * uses the oneUp method on each box surrounding a new bomb
     * @param x row
     * @param y column
     * @param hiddenObject array being passed
     */
    static void oneUpAll(int x, int y, Integer[][] hiddenObject) {
        oneUp(x - 1, y - 1, hiddenObject);       // Bottom Left
        oneUp(x, y - 1, hiddenObject);             // Bottom Center
        oneUp(x + 1, y - 1, hiddenObject);       // Bottom Right
        oneUp(x - 1, y, hiddenObject);             // Center Left
        oneUp(x + 1, y, hiddenObject);             // Center Right
        oneUp(x - 1, y + 1, hiddenObject);      // Top Left
        oneUp(x, y + 1, hiddenObject);             // Top Center
        oneUp(x + 1, y + 1, hiddenObject);       // TOP Right
    }

    /**
     * Prints entire grid to the console
     * @param printGrid grid to be printed to the console
     */
    static void printGrid(Object[][] printGrid) { // FIXME: portion this out
        System.out.print("\t|");                      // 1: HORIZONTAL LABELS
        for (int s = 0; s < printGrid.length; s++) {
            System.out.print("y" + s + "\t|");
        }
        horizontalBorder(printGrid);

        for (int i = 0; i < printGrid.length; i++) {  // 2: PRINTING EACH ROW
            System.out.print("x" + i + "\t|");               // A: Printing Vertical Label
            for (int j = 0; j < printGrid[i].length; j++) {  // B: Printing Cell Contents
                if (printGrid[i][j].equals(null)) {
                    System.out.print("This was it!");
                } else if (printGrid[i][j].equals(-2)) {
                    System.out.print("!\t|");
                }else if (printGrid[i][j].equals(-1)) {
                    System.out.print("*\t|");
                } else if (printGrid[i][j].equals(0)) {
                    System.out.print("\t|");
                } else {
                    System.out.print(printGrid[i][j] + "\t|");
                }
            }
            horizontalBorder(printGrid);
        }
    }

    private static void horizontalBorder(Object[][] printGrid) {
        String border;

        System.out.println();
        // creates first border
        for (int s = 0; s <= printGrid.length; s++) {
            System.out.print(" __\t");
        }
        System.out.println();
    }
}
