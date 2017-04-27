import java.util.Scanner;

/**
 * Contains methods for Main's menu functionality
 *
 * @author Sarah Guarino
 * @author Allie Born
 * @version 1.0
 */
class MenuHelper {

    /**
     * calculates whether game as been won or not
     * @param gridSize how many cells high and wide is the board
     * @param mirrorGrid mirrorGrid object
     * @param hiddenGrid hiddenGrid object
     * @return true or false, depending on it the game has been won
     */
    static boolean isGameWon (int gridSize, MirrorGrid mirrorGrid, HiddenGrid hiddenGrid) {
        int cellsGuessed = 0;
        int totalCells = (int)Math.pow(gridSize, 2);
        boolean gameOver = false;

        // computes how many cells have been gussed
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (mirrorGrid.getCell(i,j) != 0 && mirrorGrid.getCell(i, j) != -2) {
                    cellsGuessed++;
                }
            }
        }

        // Ends the game when all safe cells have been guessed
        if (cellsGuessed == (totalCells - hiddenGrid.getBombsPlaced())){
            System.out.println("You won the game! Congratulations!");
            gameOver = true;
        }

        return gameOver;
    }

    /**
     * Operates off of a user's move this turn
     */
    static boolean userMove(Scanner scan, MirrorGrid mirrorGrid, HiddenGrid hiddenGrid, int gridSize){
        int userX = Validator.getInt(scan, "Enter the x axis of your guess: ", 0, gridSize - 1);
        int userY = Validator.getInt(scan, "Enter the y axis of your guess: ", 0, gridSize - 1);
        String userMove = Validator.getFirstChar(scan, "Do you want to dig, or flag this spot? (dig/flag): ", "d", "f");
        boolean gameOver = false;

        if (userMove.equals("f")) {                           // A. Flag The Cell
            flagCell(userX, userY, mirrorGrid);
        } else if (hiddenGrid.getCell(userX, userY) == -1) {  // B. This is a bomb!
            gameOver = bombCell(hiddenGrid);
        } else if (hiddenGrid.getCell(userX, userY) == 0) {
            blankCell(userX, userY, mirrorGrid, hiddenGrid);
        } else if (hiddenGrid.getCell(userX, userY) > 0) {
            numCell(userX, userY, mirrorGrid, hiddenGrid);
        }

        return gameOver;
    }

    /**
     * user chose to flag this cell
     * @param x row
     * @param y column
     * @param mirrorGrid MirrorGrid object
     */
    private static void flagCell (int x, int y, MirrorGrid mirrorGrid) {
        mirrorGrid.setCell(x, y, -2);   // sets this to a flag
        mirrorGrid.printGrid();
    }

    /**
     * user's chosen cell was a bomb
     * @param hiddenGrid HiddenGrid object
     * @return returns to gameOver to end the game
     */
    private static boolean bombCell (HiddenGrid hiddenGrid) {
        System.out.println("Oh no! That was a bomb. Game over.");
        hiddenGrid.printGrid();
        return true;
    }

    /**
     * user's selected cell was blank!
     * @param x row
     * @param y column
     * @param mirrorGrid MirrorGrid object
     * @param hiddenGrid HiddenGrid object
     */
    private static void blankCell(int x, int y, MirrorGrid mirrorGrid, HiddenGrid hiddenGrid) {
        mirrorGrid.setCell(x, y, -3);          // sets the cell to a discovered blank
        GridHelper.revealCells(x, y, -3, mirrorGrid, hiddenGrid); // reveals other blanks around it
        mirrorGrid.printGrid();
    }

    /**
     * user's selected cell is touching bombs!
     * @param x row
     * @param y column
     * @param mirrorGrid MirrorGrid object
     * @param hiddenGrid HiddenGrid object
     */
    private static void numCell (int x, int y, MirrorGrid mirrorGrid, HiddenGrid hiddenGrid) {
        GridHelper.copyHiddenCellToMirror(x, y, hiddenGrid, mirrorGrid); // reveal the non-bomb, non-blank number value
        mirrorGrid.printGrid();      // print the grid
    }
}
