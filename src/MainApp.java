import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int gridSize;

        System.out.println("Welcome to Mine-Sweeper");

        System.out.println("Enter the size of your grid to play on: ");
        gridSize = scan.nextInt();

// getting user input, assumed input is "10"
        ActualGrid hiddenGrid = new ActualGrid(gridSize);


    }


}
