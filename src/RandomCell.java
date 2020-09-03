import java.util.Random;

public class RandomCell extends Characters{

    @Override
    public void setAlive(testClass className) {
        Random random = new Random();
        className.setAlive(random.nextInt(className.width), random.nextInt(className.height));
        className.setAlive(random.nextInt(className.width), random.nextInt(className.height));
        className.setAlive(random.nextInt(className.width), random.nextInt(className.height));
    }
}
