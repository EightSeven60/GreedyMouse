package Classes;

public class Cheese extends Entity{
    public Cheese(int xCoord, int yCoord) {
        super(xCoord, yCoord, 50, 50);
    }
    @Override
    public String toString() {
        return "Cheese{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
