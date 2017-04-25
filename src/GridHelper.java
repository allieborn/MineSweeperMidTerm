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

    // Sets the value of a specific cell in a mirrorGrid from the twin cell in hiddenGrid
    public static void copyHiddenCellToMirror(int x, int y, HiddenGrid hiddenGrid, MirrorGrid mirrorGrid) {
        mirrorGrid.setMirrorCell(x, y, hiddenGrid.getHiddenCell(x, y));
    }

}
