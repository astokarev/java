import java.util.stream.IntStream;

public class Test {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];
    static long b = 0;

    public static long method1() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] =
                    (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        return System.currentTimeMillis() - a;
    }

    public static long method2() {

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        var ref = new Object() {
            long b = 0;
        };

        Thread thread1 = new Thread(() -> {
            float a1[] = new float[HALF];
            System.arraycopy(arr, 0, a1, 0, HALF);
            for (int i = 0; i < HALF; i++) {
                a1[i] =
                        (float) (a1[i] * Math.sin(0.2f + i / 5) *
                                Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr, 0, HALF);
            System.out.println(System.currentTimeMillis() - a);
            b += System.currentTimeMillis();
            //System.out.println(b);
        });

        Thread thread2 = new Thread(() -> {
            float a2[] = new float[HALF];
            System.arraycopy(arr, HALF, a2, 0, HALF);
            for (int i = 0; i < HALF; i++) {
                a2[i] =
                        (float) (a2[i] * Math.sin(0.2f + i / 5) *
                                Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr, HALF, HALF);
            b+=System.currentTimeMillis();
            //System.out.println(b);
        });
        thread1.start();
        thread2.start();

        return b - a;
    }

    public static void main(String[] args) {
        Test test = new Test();
        method1();
        method2();
    }
}
