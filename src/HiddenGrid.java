public class HiddenGrid {

    private int[][] hiddenGrid;

    public HiddenGrid(int userGridRequest) {
        hiddenGrid = new int[userGridRequest][userGridRequest];
    }

    public int getHiddenCell(int y, int x) {
        return hiddenGrid[x][y];
    }


    // THINGS THIS CLASS WILL DO
    // Hold a hiddenGrid array
    // "Get" a specific x by y box
    // "Set" or initialize it's entire self (done with GridHelper)

}

