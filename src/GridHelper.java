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
    public static void copyHiddenCellToMirror(int x, int y, HiddenGrid hiddenGrid, MirrorGrid mirrorGrid) {
        mirrorGrid.setMirrorCell(x, y, Integer.toString(hiddenGrid.getHiddenCell(x, y)));
    }

    public static int getMaxBombs (int cellCount) {
        int maxBombs = cellCount / 7;
        if (cellCount % 10 > 0) {
            maxBombs += 1;
        }
        return maxBombs;
    }
}
