package Classes;

import java.util.Objects;

public class Mouse extends Entity{

    protected int health;

    public Mouse(int xCoord, int yCoord) {
        super(xCoord, yCoord, 50, 50);
        health = 1000;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //if pointing towards the same object, return true
        if (o == null || getClass() != o.getClass()) return false; //if o is null or the classes are different, return false
        Mouse mouse = (Mouse) o; //otherwise, store a copy of o's reference into a Mouse type reference
        return health == mouse.health; //if they are of the same class but are 2 different objects, compare their attributes and return the result
    }
    public void addHealth(int bonus) {
        this.health += bonus;
    }
    public int getHealth() {
        return health;
    }
    @Override
    public String toString() {
        return "Mouse{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", width=" + width +
                ", height=" + height +
                ", health=" + health +
                '}';
    }
}
