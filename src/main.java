public class main {
    public static void main(String[] args) {
        testClass game = new testClass(10,10);
//        Blinker blinker = new Blinker();
//        blinker.setAlive(game);
        Glider glider = new Glider();
        glider.setAlive(game);
//        RandomCell randomCell = new RandomCell();
//        randomCell.setAlive(game);

        game.printBoard();

        int generationsCount = 55;
        for (int i = 0; i < generationsCount; i++) {
            System.out.println("Generations: " + (i + 1));
            game.step();
            game.printBoard();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
