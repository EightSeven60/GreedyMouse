package Classes;
import java.util.Random;

public class Cat extends Entity{
    protected int speedX;
    protected int speedY;
    public Cat(int xCoord, int yCoord) {
        super(xCoord, yCoord, 50, 50);
        Random random = new Random();
        speedX= (random.nextInt() % 5) + 5;
        speedY = (random.nextInt() % 5) + 5;
    }

    public int getSpeedX() {
        return speedX;
    }
    public int getSpeedY() {
        return speedY;
    }
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
