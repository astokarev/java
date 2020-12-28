package lesson9.creatures;

import lesson9.creatures.interfaces.Actions;


public class Cat implements Actions {
    private final String name;

    public int catRun() {
        return doRun(100);
    }

    public Cat(String name) {
        this.name = name;
    }

    public double catJump() {
        double catJump = doJump(0.1)+0.5;
        return catJump;
    }

    @Override
    public String toString() {
        return "Кот " + name + " пробежал " + catRun() + "\n" + "Кот " + name + " прыгнул " + catJump();
    }
}
