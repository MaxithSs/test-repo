public class testClass {

    protected int width;
    protected int height;
    protected int[][] gameBoard;

    public testClass (int width, int height) {
        this.width = width;
        this.height = height;
        this.gameBoard = new int[width][height];
    }
    protected void printBoard () {
        System.out.println("___");
        for (int y = 0; y < height; y++) {
            String line = "|";
            for (int x = 0; x < width; x++) {
                if (this.gameBoard[x][y] == 0)
                    line += ". "; // cell dead
                else
                    line += "@ "; // cell alive
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("___\n");
    }
    protected void step() {
        int[][] newGameBoard = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int aliveNeighbours = countNeighbours(x ,y);

                if (getState(x, y) == 1) {
                    if (aliveNeighbours < 2) {
                        newGameBoard[x][y] = 0;
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        newGameBoard[x][y] = 1;
                    } else if (aliveNeighbours > 3) {
                        newGameBoard[x][y] = 0;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newGameBoard[x][y] = 1;
                    }
                }
            }
        }
        this.gameBoard = newGameBoard;
    }

    private int countNeighbours(int x, int y) {
        int count = 0;

        try {
            count += getState(x - 1, y - 1);
            count += getState(x, y - 1);
            count += getState(x + 1, y - 1);

            count += getState(x - 1, y);
            count += getState(x + 1, y);

            count += getState(x - 1,y + 1);
            count += getState(x,y + 1);
            count += getState(x + 1,y + 1);
        }catch (IndexOutOfBoundsException e) {
           //e.printStackTrace(); something bad hiding here
        }
        return count;
    }
    //checking positions of cells
    private int getState(int x, int y) {

//        int returnX = x;
//        int returnY = y;
//
//        if (x < 0) {
//            returnX = gameBoard[gameBoard.length - 1][y];
//        }
//
//        if (x > width)
//            returnX = gameBoard[0][y];
//
//        if (y < 0)
//            returnY = gameBoard[x][gameBoard[0].length -1];
//
//        if (y > 0)
//            returnY = gameBoard[x][0];

        if (x < 0 || (y < 0 || y > height))
            return this.gameBoard[gameBoard.length - 1][y];
        if (x >= width || (y < 0 || y >= height))
            return this.gameBoard[0][y];

        if (y < 0 || x > width || x < 0)
            return this.gameBoard[x][gameBoard[0].length - 1];

        if (y > height || x < 0 || x > width)
            return this.gameBoard[x][0];

        return this.gameBoard[x][y];
    }

    //setting cells alive
    protected void setAlive (int x, int y) {
        this.gameBoard[x][y] = 1;
    }

    //setting cells dead
    private void setDead (int x, int y) {
        this.gameBoard[x][y] = 0;
    }

}
