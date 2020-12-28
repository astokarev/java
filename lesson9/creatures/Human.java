package lesson9.creatures;

import lesson9.creatures.interfaces.Actions;


public class Human implements Actions {
    private final String name;
    public int humanRun() {
        return doRun(500);
    }
    public Human(String name){
        this.name = name;
    }
    public double humanJump() {
        return doJump(0.5);
    }


    @Override
    public String toString() {
        return "Человек " + name +" пробежал " + humanRun() + "\n" + "Человек " + name + "  прыгнул " + humanJump();
    }
}
