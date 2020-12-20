package lesson7.oop;

public class Test {

    public static void main(String[] args) {

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Мартин");
        cats[1] = new Cat("Мурка");
        cats[2] = new Cat("Смоки");
        cats[3] = new Cat("Пипа");
        cats[4] = new Cat("Гидеон");

        Plate plate = new Plate();

        plate.addFoot(20);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.toString());
        }
        plate.printInfo();
    }
}