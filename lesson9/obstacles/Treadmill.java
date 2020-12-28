package lesson9.obstacles;

import java.util.Random;

public class Treadmill {
    public static int treadmill(){
        int tread;
        Random rnd = new Random();
        tread = rnd.nextInt(700)+300;
        return tread;
    }
    public static boolean isRun(int run){
        return run>treadmill();
    }
}
