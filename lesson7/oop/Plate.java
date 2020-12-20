package lesson7.oop;

public class Plate {

    private int food;

    public void addFoot(int food) {
        this.food += food;
    }

    public void printInfo() {
        System.out.println(this);
    }

    public int food(){
        return this.food;
    }
    @Override
    public String toString() {
        return "Plate: food = " + food;
    }

    public void decreaseFood(int food) {
        this.food -= food;
    }
}
