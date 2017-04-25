/**
 * Grid object that gets displayed to the console
 */
class MirrorGrid {
    private int [][] mirrorGrid;

    /**
     * Constructor initializes Mirror Array to height and width chosen by user
     * @param userGridRequest user entered rows and columns (will always be a square)
     */
    MirrorGrid(int userGridRequest) {
        mirrorGrid = new int[userGridRequest][userGridRequest];
    }

    /**
     * Returns the value of a specific cell
     * @param x the row the value can be found in
     * @param y the column the value can be found in
     * @return [x][y] cell's value
     */
    // Returns the value of a specific cell
    public int getMirrorCell (int x, int y) {
        return mirrorGrid[x][y];
    }

    /**
     * Sets the vakue of a specific cell
     * @param x the row to set
     * @param y the column to set
     * @param hiddenCellValue the value the cell will be initialized with
     */
    public void setMirrorCell (int x, int y, int hiddenCellValue) {
        mirrorGrid[x][y] = hiddenCellValue;
    }

    /**
     * Prints entire Mirror Grid to the console
     */
    public void printGridToConsole() {
        // PRINTS TOP ROW OF COLUMN LABELS
        System.out.print("\t|");
        for (int s = 0; s < mirrorGrid.length; s++) {
            System.out.print("y" + s + "\t|");
        }
        System.out.println();

        // creates first border
        for (int s = 0; s <= mirrorGrid.length; s++) {
            System.out.print(" __\t");
        }
        System.out.println();

        // Iterates through every row x
        for (int i = 0; i < mirrorGrid.length; i++) {
            System.out.print("x" + i + "\t|");
            for (int j = 0; j < mirrorGrid[i].length; j++) {
                System.out.print(getMirrorCell(i, j) + "\t|");
            }
            System.out.println();
            for (int s = 0; s <= mirrorGrid.length; s++) {
                System.out.print(" __\t");
            }
            System.out.println();
        }
    }
}