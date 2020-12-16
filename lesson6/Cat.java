package lesson6;

public class Cat extends Animal {
    protected String name;

    private double catJump(){
        return generateJump()+1.5;
    }

    public Cat(String name, String color, int age, int run, double jump) {
        super(name, color, age, run, jump);
        this.jump = catJump();
    }

    public Cat() {
        super(null);
    }

    @Override
    public String toString() {
        return "Cat" + super.toString();
    }
}
