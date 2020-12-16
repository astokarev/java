package lesson6;

import java.util.Random;

public class Dog extends Animal {
    protected boolean isBark;

    private int dogRun(){
        return generateRun()+300;
    }
    public Dog(String name, String color, int age, int run, double jump) {
        super(name, color, age, run, jump);
        this.run = dogRun();
    }

    public Dog() {
        super(null);
    }

    @Override
    public String toString() {
        return "Dog" + super.toString() +
                "isBark=" + isBark +
                '}';
    }
}
