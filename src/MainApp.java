import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String goAgain;
        String userMove;
        boolean gameOver;
        int gridSize;
        int userX;
        int userY;

        System.out.println("Welcome to Mine-Sweeper!\n");

        do {
            gameOver = false;

            // Gets grid size from user, then initializes the boards
            gridSize = Validator.getInt(scan,
                    "Please enter the size you'd like to play (2 through 10): ",
                    2,
                    10);
            HiddenGrid hiddenGrid = new HiddenGrid(gridSize);
            MirrorGrid mirrorGrid = new MirrorGrid(gridSize);
            hiddenGrid.initializeGrid();
            mirrorGrid.initializeGrid();

            // prints the user-visible grid
            mirrorGrid.printGrid();

            do {
                userX = Validator.getInt(scan, "Enter the x axis of your guess: ", 0, gridSize - 1);
                userY = Validator.getInt(scan, "Enter the y axis of your guess: ", 0, gridSize - 1);
                userMove = Validator.getFirstChar(scan, "Do you want to dig, or flag this spot? (dig/flag): ", "d", "f");

                if (userMove.equals("f")) {
                    mirrorGrid.setCell(userX, userY, -2);   // sets this to a flag
                    mirrorGrid.printGrid();                            // prints a grid
                } else if (hiddenGrid.getCell(userX, userY) == -1) {
                    System.out.println("Oh no! That was a bomb. Game over."); // woops!
                    hiddenGrid.printGrid();                                   // prints the hidden grid
                    gameOver = true;                                          // ends game
                } else if (hiddenGrid.getCell(userX, userY) == 0) {
                    mirrorGrid.setCell(userX, userY, -3);          // sets the cell to a discovered blank
                    GridHelper.revealCells(userX, userY, -3, mirrorGrid, hiddenGrid); // reveals other blanks around it
                    mirrorGrid.printGrid();                                   // print the grid
                } else if (hiddenGrid.getCell(userX, userY) > 0) {
                    GridHelper.copyHiddenCellToMirror(userX, userY, hiddenGrid, mirrorGrid); // reveal the non-bomb, non-blank number value
                    mirrorGrid.printGrid();                                                  // print the grid
                }

//                for () {
//                    for () {
//                        if () {
//                            // if cells guessed is equal to total cells minus bombs, and gameover is false, player wins
//                        }
//                    }
//                }
            } while (!gameOver);

            goAgain = Validator.getFirstChar(scan, "Would you like to play again? (y/n): ", "y", "n");
        } while (goAgain.equals("y"));
    }
}
