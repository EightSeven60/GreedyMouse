package Classes;

public class Cat extends Entity{
    public Cat(int xCoord, int yCoord) {
        super(xCoord, yCoord, 50, 50);
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
