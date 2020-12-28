package lesson9.obstacles;

import java.util.Random;

public class Wall {

    public static double wall() {
        double wall;
        Random random = new Random();
        wall = random.nextDouble();
        return wall;
    }

    @Override
    public String toString() {
        return "Высота:" + wall();
    }
}
