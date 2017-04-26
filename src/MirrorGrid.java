/**
 * Grid object that gets displayed to the console
 */
class MirrorGrid {
    private String [][] mirrorGrid;

    /**
     * Constructor initializes Mirror Array to height and width chosen by user
     * @param userGridRequest user entered rows and columns (will always be a square)
     */
    MirrorGrid(int userGridRequest) {
        mirrorGrid = new String[userGridRequest][userGridRequest];
    }

    /**
     * initializes the mirrorGrid object to default value passed
     * @param defaultValue string value to add to each cell
     */
    public void initializeGrid(String defaultValue) {
        for (int i = 0; i < mirrorGrid.length; i++) {
            for (int j = 0; j < mirrorGrid.length; j++) {
                setCell(i, j, defaultValue);
            }
        }
    }

    /**
     * Prints entire Mirror Grid to the console
     */
    public void printGrid() {
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
                System.out.print(mirrorGrid[i][j] + "\t|");
            }
            System.out.println();
            for (int s = 0; s <= mirrorGrid.length; s++) {
                System.out.print(" __\t");
            }
            System.out.println();
        }
    }

    /**
     * Sets the vakue of a specific cell
     * @param x the row to set
     * @param y the column to set
     * @param newCellValue the value the cell will be initialized with
     */
    void setCell (int x, int y, String newCellValue) {
        mirrorGrid[x][y] = newCellValue;
    }

    /**
     * Returns the value of a specific cell
     * @param x the row the value can be found in
     * @param y the column the value can be found in
     * @return [x][y] cell's value
     */
    // Returns the value of a specific cell
    public String getCell (int x, int y) {
        return mirrorGrid[x][y];
    }
}

