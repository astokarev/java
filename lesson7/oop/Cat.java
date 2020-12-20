package lesson7.oop;

import java.util.Random;

public class Cat {

    private String name;
    private Random random = new Random();
    private boolean appetite;
    private int wellFed = 0;

    public Cat(String name) {
        this.name = name;
    }

    public void eat(Plate plate) {
        int food = plate.food();
        wellFed = random.nextInt(4) + 3;
        if (wellFed < food) {
            plate.decreaseFood(wellFed);
            appetite = true;
        } else System.out.println("В миске слишком мало еды!");
    }

    @Override
    public String toString() {
        String golod;
        if (appetite){
            golod = "Сыт";
        } else golod = "Голоден";
        return "Кот " + name +" "+ golod;
    }
}