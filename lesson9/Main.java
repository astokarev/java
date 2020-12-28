package lesson9;

import lesson9.creatures.Cat;
import lesson9.creatures.Human;
import lesson9.creatures.Robot;
import lesson9.obstacles.Treadmill;
import lesson9.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Терентьев Михал Палыч");
        Object[] objects = new Object[5];
        objects[0] = new Human("Зубенко Михаил Петрович");
        Cat cat1 = new Cat("Смоки");
        Robot bot1 = new Robot("Ведроид");
        //System.out.println(human1.toString());
        //System.out.println(cat1.toString());
        //System.out.println(Treadmill.isRun(human1.doRun(500)));
        Wall wall = new Wall();
        System.out.println(wall);
    }
}
