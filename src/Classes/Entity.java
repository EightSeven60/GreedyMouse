package Classes;

public class Entity {
    protected static int count = 0;
    protected int xCoord;
    protected int yCoord;
    protected int width;
    protected int height;

    public Entity(int xCoord, int yCoord, int width, int height) {
        if (xCoord >= 0) {
            this.xCoord = xCoord;
        }
        if (yCoord >= 0) {
            this.yCoord = yCoord;
        }
        this.width = width;
        this.height = height;
        ++count;
    }

    public int getxCoord() {
        return xCoord;
    }
    public int getyCoord() {
        return yCoord;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Entity{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
