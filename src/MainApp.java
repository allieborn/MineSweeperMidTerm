import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String userLetter;
        int userNumber;

        int gridSize;

        System.out.println("Welcome to Mine-Sweeper");

        HiddenGrid hiddenGrid = new HiddenGrid(10); // FIXME: SARAH, delete before pushing
        hiddenGrid.initializeHiddenGrid();
        hiddenGrid.printGrid();

//        gridSize = Validator.getInt(scan,
//                "Enter the size of your grid to play on (2 through 10): ",
//                2,
//                10);
//
//        HiddenGrid hiddenGrid = new HiddenGrid(gridSize);
//        MirrorGrid mirrorGrid = new MirrorGrid(gridSize);
//
//        mirrorGrid.printGridToConsole();
//
//        System.out.println("Enter a letter row now: ");
//        userLetter = scan.nextLine();
//
//        System.out.println("Enter a number column: ");
//        userNumber = scan.nextInt();

        //ALLIE'S TEST:

        MineSweepTest myTest = new MineSweepTest();
        MineSweepTest.testForUserFlag();

    }
}
