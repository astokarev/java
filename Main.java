package lesson1;

public class Main {
    public static void main(String[] args) {
        int a = 2;
        int b = 15;
        int c = 27;
        int d = 8;
        int year = 1904;
        String name = "Саша";

        testVars();
        solveTask(a, b, c, d);
        System.out.println(isPositive(53));
        System.out.println(isNegative(-4));
        System.out.println(moreOrLess(a,b));
        System.out.println(testString(name));
        checkYear(year);
    }

    private static void solveTask(int a, int b, int c, int d) {
        System.out.println(a * (b + ((double) c / d)));
    }
    
       private static String isPositive(int number) {
        if (number >= 0) {
            return "Число положительное";
        }
        return "Число отрицательное";
    }
    
        private static boolean isNegative(int number) {
        if (number < 0) {
            return true;
        }
        return false;
    }

    private static boolean moreOrLess(int a, int b) {
        return ((a + b) >= 10) & ((a + b) <= 20);
    }

    private static String testString(String name) {
        return ("Привет, " + name);
    }

    private static void testVars() {
        byte varByte = 127;
        short varShort = 359;
        int varInt = 2_000_000_000;
        long varLong = 3_000_000_000L;
        float varFloat = 45.13f;
        double varDouble = 490.3467;
        char varChar = 4586;
        boolean varBool = false;
        String varString = "Привет!";
        System.out.println(varByte + "; " + varShort + "; " + varInt + "; " + varLong + "; " +
                varFloat + "; " + varDouble + "; " + varChar + "; " + varBool
                + "; " + varString);
    }

    private static void checkYear(int year) {
        if (year % 400 == 0) {
            System.out.println("Год високосный");
        } else if (year % 100 == 0) {
            System.out.println("Год не високосный");
        } else if (year % 4 == 0) {
            System.out.println("Год високосный");
        } else System.out.println("Год не високосный");
    }
}
