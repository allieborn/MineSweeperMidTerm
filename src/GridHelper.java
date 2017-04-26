/**
 * Class description
 *
 * @author Sarah Guarino
 * @author Allie Born
 * @version 1.0
 */
public class GridHelper {

    // THINGS THIS CLASS WILL DO
    // (to be expanded upon)
    // copy hiddenGrid value to MirrorGrid twin if user guesses that box
    // allow someone to "flag" or "guess" a box
    // initialize HiddenGrid

    /**
     * Copies specific cell in Hidden Grid to Mirror Grid
     * @param x row value
     * @param y column value
     * @param hiddenGrid your HiddenGrid object
     * @param mirrorGrid your MirrorGrid object
     */
    static void copyHiddenCellToMirror(int x, int y, HiddenGrid hiddenGrid, MirrorGrid mirrorGrid) {
        mirrorGrid.setCell(x, y, Integer.toString(hiddenGrid.getCell(x, y)));
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
     * increments a cell appropriately, based on it's contents
     * @param x row
     * @param y column
     * @param hiddenObject array that is being operated on
     */
    private static void oneUp(int x, int y, Integer[][] hiddenObject) {
        try {
            // A: If this box is not initialized
            //    initialize it first, then +1
            if (hiddenObject[x][y] == null) {
                hiddenObject[x][y] = 1;

            // B: If this box is already initialized, +1
            } else if (hiddenObject[x][y] >= 0) {
                hiddenObject[x][y] += 1;
            }
        } catch(IndexOutOfBoundsException doesntExist) {
            // do nothing
        }

    }

    /**
     * Prints entire grid to the console
     * @param printGrid grid to be printed to the console
     */
    static void printGrid(Object[][] printGrid) {
        // PRINTS TOP ROW OF COLUMN LABELS
        System.out.print("\t|");
        for (int s = 0; s < printGrid.length; s++) {
            System.out.print("y" + s + "\t|");
        }
        System.out.println();

        // creates first border
        for (int s = 0; s <= printGrid.length; s++) {
            System.out.print(" __\t");
        }
        System.out.println();

        // Iterates through every row x
        for (int i = 0; i < printGrid.length; i++) {
            System.out.print("x" + i + "\t|");
            for (int j = 0; j < printGrid[i].length; j++) {
                if (printGrid[i][j].equals(-1)) {
                    System.out.print("*\t|");
                } else if (printGrid[i][j].equals(0)) {
                    System.out.print("\t|");
                } else {
                    System.out.print(printGrid[i][j] + "\t|");
                }
            }
            System.out.println();
            for (int s = 0; s <= printGrid.length; s++) {
                System.out.print(" __\t");
            }
            System.out.println();
        }
    }
}
