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

        Scanner scan = new Scanner (System.in);

        int userXtoFlag;
        int userYtoFlag;

        //is this best way to take [][] in from user? can we do in one line?
        System.out.println("Enter an X value now: ");
        userXtoFlag = scan.nextInt();

        System.out.println("Enter a Y value now: ");
        userYtoFlag = scan.nextInt();

        testMirrorGrid.setMirrorCell(userXtoFlag, userYtoFlag, "!");

        testMirrorGrid.printGridToConsole();


    }






    }


