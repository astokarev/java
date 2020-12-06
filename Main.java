package lesson3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int ATTEMPT_MAX = 3;
    private static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(MAX_VALUE + 1);
        System.out.println("Отгадайте число от 0 до 9!");
        Scanner scanner = new Scanner(System.in);
        int userAnswer;
        for (int attempt = 0; attempt < ATTEMPT_MAX; attempt++) {
            System.out.println("Попытка номер" + (attempt + 1));
            userAnswer = getUserAnswer(scanner);
            if (userAnswer == target) {
                System.out.println("Поздравляю! Вы угадали!");
                break;
            } else if (userAnswer < target) {
                System.out.println("Загаданное число больше");
            } else {
                System.out.println("Загаданное число меньше");
            }
        }
    }

    private static int getUserAnswer(Scanner scanner) {
        int result = MAX_VALUE + 1;
        do {
            try {
                System.out.println("Введите число");
                int value = scanner.nextInt();
                if (value < 0 || value > MAX_VALUE) {
                    System.out.println("Число вне диапазона");
                    continue;
                }
                result = value;
            } catch (InputMismatchException e) {
                System.out.println("Не является числом");
                break;
            }
        } while (result == MAX_VALUE + 1);
        return result;
    }
}
