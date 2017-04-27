import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String goAgain;
        boolean gameOver;
        int gridSize;

        System.out.println("Welcome to Mine-Sweeper!\n");

        do {  // NEW GAME
            gridSize = Validator.getInt(scan,
                    "Please enter the size you'd like to play (2 through 10): ",
                    2,
                    10);                                       // 1: Get grid difficulty from the user
            HiddenGrid hiddenGrid = new HiddenGrid(gridSize);      // 2: Create our grid objects
            MirrorGrid mirrorGrid = new MirrorGrid(gridSize);
            hiddenGrid.initializeGrid();                           // 3: initializes the hiddenGrid with random bombs
            mirrorGrid.initializeGrid();                           // 4: initializes the mirrorGrid with 0s
            mirrorGrid.printGrid();                                // 5: prints it to the console for the user's first turn

            do { // NEW TURN
                // Gathers the user's guess, and operates from there
                gameOver = MenuHelper.userMove(scan, mirrorGrid, hiddenGrid, gridSize);

                // if the user did not guess a bomb this turn, this checks to see if they've won instead
                if (!gameOver) {
                    gameOver = MenuHelper.isGameWon(gridSize,mirrorGrid, hiddenGrid);
                }
            } while (!gameOver);

            goAgain = Validator.getFirstChar(scan, "Would you like to play again? (y/n): ", "y", "n");
        } while (goAgain.equals("y"));
    }

}
