import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Class description
 *
 * @author Sarah Guarino
 * @author Allie Born
 * @version 1.0
 */
public class MineSweepTest {

    HiddenGrid testHiddenGrid;
    MirrorGrid testMirrorGrid;

    public MineSweepTest() {
        // Test arrays set to 10 wide and 10 high
        testHiddenGrid = new HiddenGrid(10);
        testMirrorGrid = new MirrorGrid(10);
    }

    public static void testForUserFlag () {

        HiddenGrid testHiddenGrid;
        MirrorGrid testMirrorGrid;
        testHiddenGrid = new HiddenGrid(10);
        testMirrorGrid = new MirrorGrid(10);
        testMirrorGrid.initializeGrid(0);

        Scanner scan = new Scanner (System.in);

        int userXtoFlag;
        int userYtoFlag;

        //is this best way to take [][] in from user? can we do in one line?
        System.out.println("Enter an X value now: ");
        userXtoFlag = scan.nextInt();

        System.out.println("Enter a Y value now: ");
        userYtoFlag = scan.nextInt();

        testMirrorGrid.setCell(userXtoFlag, userYtoFlag, -2);
        testMirrorGrid.printGrid();
    }

    public static void testForEndofGame() {

        HiddenGrid testHiddenGrid;
        testHiddenGrid = new HiddenGrid(10);j
//initialized these just to avoid error message
//this is just a mock up - will be better once we see main
        int userXaxis = 0;
        int userYaxis = 0;

        testHiddenGrid.getCell(userXaxis, userYaxis);
        if (testHiddenGrid.getCell(userXaxis, userYaxis) == -1){
            System.out.println("Oh no! That was a bomb. Game over.");
            testHiddenGrid.printGrid();
        }



    }

    public static void allieTestRandomBombPlacer() {

        Scanner scan = new Scanner(System.in);

        int[][] hiddenGrid = new int[4][4];  //testing 2d array, 4x4, default value of '0' in each
        //disregard - I set this just for my experiment....
        System.out.println(Arrays.deepToString(hiddenGrid));

        //set something to change the 'bound' depending on how big user chooses the grid
        //maybe gridsize * 0.25?

        System.out.println("How big do you want grid to be?");
        int userSizeChoice = scan.nextInt();
        int boundValue = (int) (userSizeChoice * 0.25); //forced to cast to int since this will auto return double

        int x;
        Random ranGen = new Random();
        //   System.out.println(x);

        for (int i = 0; i < hiddenGrid.length; i++) {
            for(int j = 0; j < hiddenGrid[i].length; j++) {
                x = ranGen.nextInt(boundValue);
                if (x == 1){ //this could be changed, just depends...
                    hiddenGrid [i][j] = -1;
                }

            }
        }

        System.out.println();

        System.out.println(Arrays.deepToString(hiddenGrid));;



    }






}
