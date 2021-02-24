import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;
    private String name;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
        name = fruit.getName();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public float getWeight() {
        float weight = 0.0f;
        for (Fruit fruit: fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public String getName() {
        return name;
    }

    public boolean compare(Box box){
        if (box.getWeight()== getWeight()){
            return true;
        } else return false;
    }

    public void join(Box box){
        if (getName().equals(box.getName())){
            fruits.addAll(box.getFruits());
        } else System.out.println("Нельзя смешивать фруткы!");


    }
}
