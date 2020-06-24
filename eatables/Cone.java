package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable {

    public enum Flavor {

        STRAWBERRY, BANANA,
        CHOCOLATE, VANILLA,
        LEMON, STRACIATELLA,
        MOKKA, PISTACHE;
    }

    private Flavor[] balls;

    public Cone() { }

    public Cone(Flavor[] flavors) {
        this.balls = flavors;
    }

    @Override
    public void eat() {
        System.out.println("I'm eating a cone with this flavor: " + Arrays.toString(balls));

}

}
