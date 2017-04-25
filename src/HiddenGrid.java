import java.util.Random;

public class HiddenGrid {

    private int[][] hiddenGrid;

    public HiddenGrid(int userGridRequest) {
        hiddenGrid = new int[userGridRequest][userGridRequest];
    }

    public int getHiddenCell(int y, int x) {
        return hiddenGrid[x][y];
    }

    public void setHiddenGrid() {
        // calculates the max number of bombs this game CAN have
        int maxBombs = GridHelper.getMaxBombs(hiddenGrid.length * hiddenGrid.length);

        // creates a Random object bombGen, and an integer isBomb that stores a value between 0-9
        Random bombRandGen = new Random();
        int bombGenResult;


        for (int i = 0; i < hiddenGrid.length; i++) {
            for (int j = 0; j < hiddenGrid[i].length; j++) {
                bombGenResult = bombRandGen.nextInt(9);


            }
        }
    }


    // THINGS THIS CLASS WILL DO
    // [in progress] "Set" or initialize it's entire self (done with GridHelper)

}

