package lesson3;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pole_Chudes {
    public static final int MASK_LENGTH = 15;
    public static final String[] WORDS = new String[]{
            "apple", "orange", "salad", "watermelon", "cherry", "carrot", "potato", "mushroom",
            "grape", "mango", "pumpkin", "onion", "melon", "pineapple", "chicken", "cake", "steak",
            "soup"};

    public static void main(String[] args) {
        System.out.println("Я загадал одно из этих слов. Какое именно?" + Arrays.toString(WORDS));

        Random random = new Random();
        int index = random.nextInt(WORDS.length);
        String targetWord = WORDS[index];
        String userWord = null;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите слово: ");
            userWord = scanner.nextLine();

            if (isWin(targetWord, userWord)) {
                System.out.println("Правильный ответ!");
                break;
            }
            System.out.println("Неверно! открытые буквы: ");
            printPrompt(targetWord,userWord);
            System.out.println();
        } while (true);
        System.out.println("Игра окончена");
    }

    private static void printPrompt(String targetWord, String userWord) {
        for (int i = 0; i < MASK_LENGTH; i++) {
            char chr = '#';
            if (i < userWord.length() && i < targetWord.length()
                    && userWord.charAt(i) == targetWord.charAt(i)) {
                chr = userWord.charAt(i);
            }
            System.out.print(chr);
        }
    }

    private static boolean isWin(String targetWord, String userWord) {
        return targetWord.equals(userWord);
    }
}
