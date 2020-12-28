package lesson9.creatures.interfaces;

import java.util.Random;

public interface Actions {
    public default int doRun(int min){
        Random random = new Random();
        int length;
        do length = random.nextInt(1000); while (length<min);
        return length;
    }

    public default double doJump(double min){
        Random random = new Random();
        double height;
        do height = random.nextDouble(); while (height<min);
        return height;
    }
}
