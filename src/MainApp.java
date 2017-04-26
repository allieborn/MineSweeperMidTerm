import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int userX;
        int userY;
        boolean gameOver = false;

        int gridSize;

        System.out.println("Welcome to Mine-Sweeper");

        gridSize = Validator.getInt(scan,
                "Enter the size of your grid to play on (2 through 10): ",
                2,
                10);

        HiddenGrid hiddenGrid = new HiddenGrid(gridSize);
        hiddenGrid.initializeGrid();
        MirrorGrid mirrorGrid = new MirrorGrid(gridSize);
        mirrorGrid.initializeGrid(0);
        mirrorGrid.printGrid();

        do {
            userX = Validator.getInt(scan, "Enter the x axis of your guess: ", 0, gridSize -1);
            userY = Validator.getInt(scan, "Enter the y axis of your guess: ", 0, gridSize -1);
            String userMove = Validator.getFirstChar(scan, "Do you want to dig, or flag this spot?: ", "d", "f");

            if (userMove.equals("f")) {
                mirrorGrid.setCell(userX,userY, -2);
                mirrorGrid.printGrid();
            } else if (hiddenGrid.getCell(userX, userY) == -1) {
                System.out.println("Oh no! That was a bomb. Game over.");
                hiddenGrid.printGrid();
                gameOver = true;
            } else if (hiddenGrid.getCell(userX, userY) == 0){
                mirrorGrid.setCell(userX, userY, -3);
                mirrorGrid.printGrid();
            } else if (hiddenGrid.getCell(userX, userY) > 0) {
                GridHelper.copyHiddenCellToMirror(userX, userY, hiddenGrid, mirrorGrid);
                mirrorGrid.printGrid();
            }
        } while (!gameOver);
    }
}
