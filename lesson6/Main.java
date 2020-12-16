package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", "зеленый", 1, 0, 0);
        Dog dog = new Dog("Псина","Бурая",1,0, 0);

        System.out.println(dog);
        System.out.println("dog.run: "+dog.isRun(350));
        System.out.println("dog.jump: "+dog.isJump(1));

        System.out.println(cat);
        System.out.println("cat.run: "+cat.isRun(150));
        System.out.printf("cat.jump: "+cat.isJump(1));
    }
}
