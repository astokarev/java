package lesson9.creatures;


import lesson9.creatures.interfaces.Actions;

public class Robot implements Actions {
    private final String name;

    public Robot(String name) {
        this.name = name;
    }

    public int robotRun() {
        return doRun(700);
    }

    public double robotJump() {
        return doJump(0.2);
    }

    @Override
    public String toString() {
        return "Робот " + name + "  пробежал" + robotRun() + "\n" + "Робот " + name + " прыгнул" + robotJump();
    }
}
