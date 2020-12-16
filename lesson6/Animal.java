package lesson6;

import java.text.DecimalFormat;
import java.util.Random;

public abstract class Animal {
    protected String name;
    private String color;
    protected int age;
    protected double jump;
    protected int run;

    protected int generateRun() {
        Random random = new Random();
        int run;
        do {
            run = random.nextInt(300);
        } while (run < 100);
        return run;
    }

    protected boolean isRun(int distance) {
        if (run > distance)
            return true;
        return false;
    }

    protected double generateJump() {
        Random random = new Random();
        double jump;
        do jump = random.nextDouble(); while (jump < 0.2);
        return jump;
    }


    protected boolean isJump(int distance) {
        if (jump > distance)
            return true;
        return false;
    }


    public Animal(String name, String color, int age, int run, double jump) {

        this.name = name;
        this.color = color;
        this.age = age;
        this.run = generateRun();
        this.jump = generateJump();
    }

    public Animal(String name) {
        this(name, "Серобуромалиновый", 0, 0, 0);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", run=" + run +
                ", jump=" + jump +
                '}';
    }
}
