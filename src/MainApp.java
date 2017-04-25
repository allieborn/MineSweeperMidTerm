import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String userLetter;
        int userNumber;

        int gridSize;

        System.out.println("Welcome to Mine-Sweeper");

        System.out.println("Enter the size of your grid to play on: ");
        gridSize = scan.nextInt();
        scan.nextLine();

        HiddenGrid hiddenGrid = new HiddenGrid(gridSize);
        MirrorGrid mirrorGrid = new MirrorGrid(gridSize);

        mirrorGrid.printGridToConsole();

        System.out.println("Enter a letter row now: ");
        userLetter = scan.nextLine();

        System.out.println("Enter a number column: ");
        userNumber = scan.nextInt(); 




    }


}
