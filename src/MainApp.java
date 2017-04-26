import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean gameOver;
        int gridSize;
        int userX;
        int userY;
        int safeCells;
        int safeCellsGuessed;
        String goAgain = "n";
        String userMove;

        System.out.println("Welcome to Mine-Sweeper!\n");

        do {
            gridSize = Validator.getInt(scan,
                    "Enter the size of your grid to play on (2 through 10): ",
                    2,
                    10);
            HiddenGrid hiddenGrid = new HiddenGrid(gridSize);
            MirrorGrid mirrorGrid = new MirrorGrid(gridSize);
            gameOver = false;

            hiddenGrid.initializeGrid();
            mirrorGrid.initializeGrid(0);

            safeCells = hiddenGrid.getSafeCells(gridSize);
            safeCellsGuessed = 0;

            mirrorGrid.printGrid();

            do {
                userX = Validator.getInt(scan, "Enter the x axis of your guess: ", 0, gridSize - 1);
                userY = Validator.getInt(scan, "Enter the y axis of your guess: ", 0, gridSize - 1);
                userMove = Validator.getFirstChar(scan, "Do you want to dig, or flag this spot?: ", "d", "f");

                if (userMove.equals("f")) {
                    mirrorGrid.setCell(userX, userY, -2);
                    mirrorGrid.printGrid();
                } else if (hiddenGrid.getCell(userX, userY) == -1) {
                    System.out.println("Oh no! That was a bomb. Game over.");
                    hiddenGrid.printGrid();
                    gameOver = true;
                } else if (hiddenGrid.getCell(userX, userY) == 0) {
                    mirrorGrid.setCell(userX, userY, -3);
                    mirrorGrid.printGrid();
                } else if (hiddenGrid.getCell(userX, userY) > 0) {
                    GridHelper.copyHiddenCellToMirror(userX, userY, hiddenGrid, mirrorGrid);
                    mirrorGrid.printGrid();
                }
            } while (!gameOver);

        } while (goAgain.equals("y"));
    }
}
