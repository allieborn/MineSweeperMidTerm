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

            System.out.println("Enter the x/y axis for a box that you'd like to guess. ");

            System.out.println("Enter an X value now: ");
            userX = scan.nextInt();

            System.out.println("Enter a Y value now: ");
            userY = scan.nextInt();


            if (hiddenGrid.getCell(userX, userY) > 0) {
                GridHelper.copyHiddenCellToMirror(userX, userY, hiddenGrid, mirrorGrid);
                mirrorGrid.printGrid();
                System.out.println("here's the hidden grid:"); //DELETE ONCE FINAL
                hiddenGrid.printGrid(); //DELETE ONCE FINAL
            }
            else if (hiddenGrid.getCell(userX, userY) == 0){
                mirrorGrid.setCell(userX, userY, -3);
                hiddenGrid.printGrid(); //DELETE ONCE FINAL
            }

            if (hiddenGrid.getCell(userX, userY) == -1) {
                System.out.println("Oh no! That was a bomb. Game over.");
                hiddenGrid.printGrid();
                gameOver = true;
            }



        } while (!gameOver);
    }
}
