import java.util.Scanner;

public class MirrorGrid {

    private int [][] mirrorGrid;

    MirrorGrid(int userGridRequest) {
        mirrorGrid = new int[userGridRequest][userGridRequest];
    }

    // Returns the value of a specific cell
    public int getMirrorCell (int x, int y) {
        return mirrorGrid[x][y];
    }

    // Sets the value of a specific cell from the mirrored cell in HiddenGrid
    public void copyHiddenCellToMirror(int x, int y) {
        // FIXME: copy value from hiddenGrid[x][y] to mirrorGrid [x][y]
    }

    public void printGridToConsole() {
        // creates first border
        for (int s = 0; s < mirrorGrid.length; s++) {
            System.out.print(" __\t");
        }
        System.out.print("\n");

        // Iterates through every row x
        for (int i = 0; i < mirrorGrid.length; i++) {
            System.out.print("|");
            for (int j = 0; j < mirrorGrid[i].length; j++) {
                System.out.print(getMirrorCell(i, j) + "\t|");
            }
            System.out.print("\n");
            for (int s = 0; s < mirrorGrid.length; s++) {
                System.out.print(" __\t");
            }
            System.out.print("\n");
        }
    }

    //

    //

    // THINGS THIS CLASS WILL DO
    // [finished] Hold an array object called hiddenGrid
    // [finished] "Get" a specific x by y box
    //    [unfinished] validate that input is within range of the index
    // [unfinished] "Get" or print the entire grid
    // [In Prograss] "Set" a specific x yb y box

}